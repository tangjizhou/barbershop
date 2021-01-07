package net.twisted.fate.barbershop.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.twisted.fate.barbershop.enumeration.Sex;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 用户
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2021/1/7
 */
@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

    @Column(length = 32)
    private String name;
    @Column
    private Integer age;
    @Column(length = 8)
    private Sex sex;

}
