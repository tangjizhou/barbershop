package net.twisted.fate.barbershop.service.impl;

import lombok.extern.slf4j.Slf4j;
import net.twisted.fate.barbershop.entity.BaseEntity;
import net.twisted.fate.barbershop.repository.BaseRepository;
import net.twisted.fate.barbershop.service.IBaseService;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Optional;

/**
 * 基本操作
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2021/1/10
 */
@Slf4j
public class BaseServiceImpl<T extends BaseEntity, ID extends Serializable, S extends BaseRepository<T, ID>>
        implements IBaseService<T, ID> {

    protected S repository;

    @Resource
    public void setRepository(S repository) {
        this.repository = repository;
    }

    @Override
    public void logicDelete(ID id) {
        repository.logicDelete(id);
    }

    @Override
    public T save(T t) {
        return repository.save(t);
    }

    @Override
    public void delete(T t) {
        repository.delete(t);
    }

    @Override
    public T update(T t) {
        return repository.saveAndFlush(t);
    }

    @Override
    public Optional<T> get(ID id) {
        try {
            return Optional.of(repository.getOne(id));
        } catch (Exception e) {
            log.error("entity not found", e);
            return Optional.empty();
        }
    }


}
