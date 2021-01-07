package net.twisted.fate.barbershop.entity.generator;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.UUID;

/**
 * TODO
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2021/1/7
 */
public class SnowFlakeGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o)
            throws HibernateException {
        return UUID.randomUUID().toString();
    }

}
