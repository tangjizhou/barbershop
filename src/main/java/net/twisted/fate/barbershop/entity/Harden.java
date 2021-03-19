package net.twisted.fate.barbershop.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * harden
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2021/3/19
 */
@Data
@Document
public class Harden {

    @Id
    private String id;
    private String name;
    private BigDecimal width;
    private BigDecimal height;

}
