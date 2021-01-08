package net.twisted.fate.barbershop.entity;

import lombok.Getter;
import lombok.Setter;
import net.twisted.fate.barbershop.enumeration.DataState;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.GeneratedValue;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * 公共父类
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2021/1/7
 */
@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    @EmbeddedId
    @GeneratedValue(generator = "snowFlake")
    @GenericGenerator(name = "snowFlake", strategy = "net.twisted.fate.barbershop.entity.generator.SnowFlakeGenerator")
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
