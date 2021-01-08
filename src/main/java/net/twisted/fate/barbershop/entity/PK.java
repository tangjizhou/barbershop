package net.twisted.fate.barbershop.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

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

    @Column(nullable = false)
    private String id;
    @Column(nullable = false, length = 64)
    private String version = VERSION_LATEST;

}
