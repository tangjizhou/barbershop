package net.twisted.fate.barbershop.entity.generator;

import net.twisted.fate.barbershop.entity.PK;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.UUID;

/**
 * 主键生成器
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2021/1/7
 */
public class SnowFlakeGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o)
            throws HibernateException {
        PK pk = new PK();
        pk.setId(UUID.randomUUID().toString());
        return pk;
    }

}
