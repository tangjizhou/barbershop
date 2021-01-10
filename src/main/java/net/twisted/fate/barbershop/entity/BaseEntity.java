package net.twisted.fate.barbershop.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.GeneratedValue;
import javax.persistence.MappedSuperclass;
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
    @CreationTimestamp
    protected LocalDateTime createTime;
    @Column
    @UpdateTimestamp
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
