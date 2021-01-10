package net.twisted.fate.barbershop.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
@NoArgsConstructor
@EqualsAndHashCode
public class PK implements Serializable {

    public static final String VERSION_LATEST = "latest";

    @Column(nullable = false, length = 64)
    private String id;

    @Column(nullable = false, length = 64)
    private String version;

    private PK(String id, String version) {
        this.id = id;
        this.version = version;
    }

    public static PK of(String id) {
        return new PK(id, VERSION_LATEST);
    }

    public static PK of(String id, String version) {
        return new PK(id, version);
    }

}
