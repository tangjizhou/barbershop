package net.twisted.fate.barbershop.repository;

import net.twisted.fate.barbershop.entity.Harden;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * TODO
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2021/3/19
 */
public interface HardenRepository extends MongoRepository<Harden, String> {

}
