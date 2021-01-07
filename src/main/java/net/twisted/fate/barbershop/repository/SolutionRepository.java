package net.twisted.fate.barbershop.repository;

import net.twisted.fate.barbershop.entity.PK;
import net.twisted.fate.barbershop.entity.Solution;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * 解决方案
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2021/1/7
 */
public interface SolutionRepository extends CrudRepository<Solution, PK> {

    List<Solution> findByProjectId(Long projectId);

}
