package net.twisted.fate.barbershop.service.impl;

import net.twisted.fate.barbershop.dto.SolutionAddDTO;
import net.twisted.fate.barbershop.entity.PK;
import net.twisted.fate.barbershop.entity.Solution;
import net.twisted.fate.barbershop.entity.SolutionVersion;
import net.twisted.fate.barbershop.entity.User;
import net.twisted.fate.barbershop.repository.SolutionRepository;
import net.twisted.fate.barbershop.service.ISolutionService;
import net.twisted.fate.barbershop.service.SolutionVersionSubscriber;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 解决方案服务
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2021/1/7
 */
@Service
@Transactional
public class SolutionServiceImpl extends BaseServiceImpl<Solution, PK, SolutionRepository> implements ISolutionService,
        SolutionVersionSubscriber {

    @Override
    public void removeById(PK pk) {
        repository.deleteById(pk);
    }

    @Override
    public List<Solution> listByProjectId(String projectId) {
        return repository.findByProjectId(projectId);
    }

    @Override
    public void save(SolutionAddDTO dto, User user) {
        Solution solution = new Solution();
        solution.setProjectId(dto.getProjectId());
        solution.setProjectName(dto.getProjectName());
        solution.setName(dto.getName());
        solution.setCode(dto.getCode());
        solution.setCreateBy(user.getName());
        solution.setUpdateBy(user.getName());
        repository.save(solution);
    }

    @Override
    public void onCreate(SolutionVersion solutionVersion) {
        List<Solution> solutions = repository.findByPkVersion(PK.VERSION_LATEST);
        List<Solution> copiedSolutions = solutions.stream().map(v -> {
            Solution solution = new Solution();
            BeanUtils.copyProperties(v, solution);
            solution.getPk().setVersion(solutionVersion.getPk().getId());
            return solution;
        }).collect(Collectors.toList());
        repository.saveAll(copiedSolutions);
    }

    @Override
    public void onRollback(SolutionVersion solutionVersion) {
        List<Solution> historicSolutions = repository.findByPkVersion(solutionVersion.getPk().getId());
        historicSolutions.forEach(v -> v.getPk().setVersion(PK.VERSION_LATEST));
        repository.saveAll(historicSolutions);
    }

}
