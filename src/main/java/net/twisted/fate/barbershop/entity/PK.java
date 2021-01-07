package net.twisted.fate.barbershop.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

/**
 * 主键
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2021/1/7
 */
@Data
@Embeddable
@EqualsAndHashCode
public class PK implements Serializable {

    public static final String VERSION_LATEST = "latest";

    @Id
    @GeneratedValue(generator = "snowFlake")
    @GenericGenerator(name = "snowFlake", strategy = "net.twisted.fate.barbershop.entity.generator.SnowFlakeGenerator")
    @Column(nullable = false)
    private String id = UUID.randomUUID().toString();
    @Column(nullable = false, length = 64)
    private String version = VERSION_LATEST;

}
