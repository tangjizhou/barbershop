package net.twisted.fate.barbershop.repository;

import net.twisted.fate.barbershop.entity.PK;
import net.twisted.fate.barbershop.entity.Solution;
import net.twisted.fate.barbershop.vo.ProjectSolutionVO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 解决方案
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2021/1/7
 */
public interface SolutionRepository extends CrudRepository<Solution, PK> {

    List<Solution> findByProjectId(String projectId);

    @Query(name = "Solution.findVOBySolutionId")
    ProjectSolutionVO findVOBySolutionId(@Param("solutionId") String solutionId);

}
