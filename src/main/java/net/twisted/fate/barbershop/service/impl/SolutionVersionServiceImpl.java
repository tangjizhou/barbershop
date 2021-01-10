package net.twisted.fate.barbershop.service.impl;

import net.twisted.fate.barbershop.dto.SolutionVersionCreateDTO;
import net.twisted.fate.barbershop.entity.PK;
import net.twisted.fate.barbershop.entity.SolutionVersion;
import net.twisted.fate.barbershop.entity.User;
import net.twisted.fate.barbershop.repository.SolutionVersionRepository;
import net.twisted.fate.barbershop.service.ISolutionVersionService;
import net.twisted.fate.barbershop.service.SolutionVersionSubscriber;
import net.twisted.fate.barbershop.vo.SolutionVersionVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 版本化服务
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2021/1/10
 */
@Service
@Transactional
public class SolutionVersionServiceImpl extends BaseServiceImpl<SolutionVersion, PK, SolutionVersionRepository>
        implements ISolutionVersionService {

    @Autowired
    private List<SolutionVersionSubscriber> subscribers;

    @Override
    public void create(SolutionVersionCreateDTO dto, User user) {
        repository.updateToNotInheritingBySolutionId(dto.getSolutionId());
        SolutionVersion solutionVersion = new SolutionVersion();
        solutionVersion.setSolutionId(dto.getSolutionId());
        solutionVersion.setName(dto.getName());
        solutionVersion.setDescription(dto.getDescription());
        solutionVersion.setIsInheriting(true);
        solutionVersion.fillOnCreate(user);
        solutionVersion = repository.save(solutionVersion);
        SolutionVersion savedSolution = solutionVersion;
        subscribers.forEach(v -> v.onCreate(savedSolution));
    }

    @Override
    public List<SolutionVersionVO> listBySolutionId(String solutionId) {
        if (StringUtils.isBlank(solutionId)) {
            return Collections.emptyList();
        }
        SolutionVersion solutionVersion = new SolutionVersion().setSolutionId(solutionId);
        Example<SolutionVersion> example = Example.of(solutionVersion);
        List<SolutionVersion> solutionVersions = repository.findAll(example);
        return solutionVersions.stream().map(SolutionVersionVO::of).collect(Collectors.toList());
    }

    @Override
    public void rollback(String solutionId, String id) {
        SolutionVersion solutionVersion = get(PK.of(id)).orElseThrow(() -> new IllegalArgumentException("版本不存在"));
        subscribers.forEach(v -> v.onRollback(solutionVersion));
        repository.updateToNotInheritingBySolutionId(solutionId);
        solutionVersion.setIsInheriting(true);
        update(solutionVersion);
    }

}
