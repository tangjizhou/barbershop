package net.twisted.fate.barbershop.repository;

import net.twisted.fate.barbershop.entity.PK;
import net.twisted.fate.barbershop.entity.Solution;

import java.util.List;

/**
 * 解决方案
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2021/1/7
 */
public interface SolutionRepository extends BaseRepository<Solution, PK> {

    List<Solution> findByProjectId(String projectId);

    List<Solution> findByPkVersion(String version);

}
