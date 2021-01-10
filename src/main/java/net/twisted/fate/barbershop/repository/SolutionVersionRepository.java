package net.twisted.fate.barbershop.repository;

import net.twisted.fate.barbershop.entity.PK;
import net.twisted.fate.barbershop.entity.SolutionVersion;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * 版本化
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2021/1/10
 */
public interface SolutionVersionRepository extends BaseRepository<SolutionVersion, PK> {

    @Modifying
    @Query("update SolutionVersion set isActive = false where solutionId = ?1")
    void logicDeleteBySolutionId(String solutionId);

    @Modifying
    @Query("update SolutionVersion set isInheriting = false where solutionId = ?1")
    void updateToNotInheritingBySolutionId(String solutionId);

}
