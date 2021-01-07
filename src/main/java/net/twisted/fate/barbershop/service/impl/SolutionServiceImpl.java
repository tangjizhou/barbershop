package net.twisted.fate.barbershop.service.impl;

import net.twisted.fate.barbershop.dto.SolutionAddDTO;
import net.twisted.fate.barbershop.entity.PK;
import net.twisted.fate.barbershop.entity.Solution;
import net.twisted.fate.barbershop.entity.User;
import net.twisted.fate.barbershop.repository.SolutionRepository;
import net.twisted.fate.barbershop.service.ISolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 解决方案服务
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2021/1/7
 */
@Service
public class SolutionServiceImpl implements ISolutionService {

    @Autowired
    private SolutionRepository repository;

    @Override
    public void removeById(PK pk) {
        repository.deleteById(pk);
    }

    @Override
    public List<Solution> listByProjectId(Long projectId) {
        return repository.findByProjectId(projectId);
    }

    @Override
    public void save(SolutionAddDTO dto, User user) {
        Solution solution = new Solution();
        solution.setName(dto.getName());
        solution.setCode(dto.getCode());
        solution.setCreateBy(user.getName());
        solution.setUpdateBy(user.getName());
        repository.save(solution);
    }

}
