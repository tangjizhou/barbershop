package net.twisted.fate.barbershop.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * 公共父类
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2021/1/7
 */
@Getter
@Setter
@MappedSuperclass
@Where(clause = "is_active = true")
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @EmbeddedId
    @GeneratedValue(generator = "snowFlake")
    @GenericGenerator(name = "snowFlake", strategy = "net.twisted.fate.barbershop.entity.generator.SnowFlakeGenerator")
    protected PK pk;
    @Column(length = 32)
    protected String createBy;
    @Column(length = 32)
    protected String updateBy;
    @Column
    protected Boolean isActive = true;
    @Column
    @CreatedDate
    protected LocalDateTime createTime;
    @Column
    @LastModifiedDate
    protected LocalDateTime updateTime;

    public PK getPk() {
        return Optional.ofNullable(pk).orElseGet(PK::new);
    }

    public void fillOnCreate(User user) {
        this.createBy = user.getName();
        this.updateBy = user.getName();
    }

    public void fillOnUpdate(User user) {
        this.updateBy = user.getName();
    }

}
