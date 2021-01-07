package net.twisted.fate.barbershop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 解决方案
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2021/1/7
 */
@Entity
@Getter
@Setter
@Table
public class Project extends BaseEntity {

    @Column(length = 32)
    private String name;
    @Column(length = 32)
    private String description;

}
