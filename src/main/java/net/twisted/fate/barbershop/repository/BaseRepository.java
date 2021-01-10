package net.twisted.fate.barbershop.repository;

import net.twisted.fate.barbershop.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import javax.transaction.Transactional;
import java.io.Serializable;

/**
 * 数据库基本操作
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2021/1/10
 */
@Transactional
@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity, ID extends Serializable> extends JpaRepository<T, ID> {

    @Modifying
    @Query("update #{#entityName} set state = 0 where pk = ?1")
    void logicDelete(ID id);

}
