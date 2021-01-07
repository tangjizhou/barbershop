package net.twisted.fate.barbershop.entity;

import lombok.Getter;
import lombok.Setter;
import net.twisted.fate.barbershop.enumeration.DataState;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * TODO
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2021/1/7
 */
@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    @EmbeddedId
    protected PK pk;
    @Column(length = 32)
    protected String createBy;
    @Column(length = 32)
    protected String updateBy;
    @Column(length = 16)
    protected DataState state;
    @Column
    @CreationTimestamp
    protected LocalDateTime createTime;
    @Column
    @UpdateTimestamp
    protected LocalDateTime updateTime;

}
