package net.twisted.fate.barbershop.service;

import net.twisted.fate.barbershop.dto.SolutionAddDTO;
import net.twisted.fate.barbershop.entity.PK;
import net.twisted.fate.barbershop.entity.Solution;
import net.twisted.fate.barbershop.entity.User;

import java.util.List;

/**
 * TODO
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2021/1/7
 */
public interface ISolutionService {

    void removeById(PK pk);

    List<Solution> listByProjectId(String projectId);

    void save(SolutionAddDTO dto, User user);

}
