package net.twisted.fate.barbershop.service;

import net.twisted.fate.barbershop.entity.BaseEntity;

import java.io.Serializable;
import java.util.Optional;

/**
 * 基本操作
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2021/1/10
 */
public interface IBaseService<T extends BaseEntity, ID extends Serializable> {

    void logicDelete(ID id);

    T save(T t);

    void delete(T t);

    T update(T t);

    Optional<T> get(ID id);

}
