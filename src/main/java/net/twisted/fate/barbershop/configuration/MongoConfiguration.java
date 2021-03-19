package net.twisted.fate.barbershop.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;

/**
 * mongo配置
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2021/3/19
 */
@Configuration
public class MongoConfiguration {

    @Bean
    MongoTransactionManager transactionManager(MongoDatabaseFactory factory) {
        return new MongoTransactionManager(factory);
    }


}
