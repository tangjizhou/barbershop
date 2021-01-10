package net.twisted.fate.barbershop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 版本化
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2021/1/10
 */
@Entity
@Table
@Getter
@Setter
@Accessors(chain = true)
public class SolutionVersion extends BaseEntity {

    @Column(length = 64, nullable = false)
    private String solutionId;

    @Column(length = 32, nullable = false)
    private String name;

    @Column
    private Boolean isInheriting;

    @Column
    private String description;

}
