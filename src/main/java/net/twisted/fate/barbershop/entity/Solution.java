package net.twisted.fate.barbershop.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

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
public class Solution extends BaseEntity {

    @Column(length = 32)
    private String projectId;
    @Column(length = 32)
    private String projectName;
    @Column(length = 32)
    private String name;
    @Column(length = 32)
    private String code;

}
