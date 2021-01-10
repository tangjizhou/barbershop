package net.twisted.fate.barbershop.vo;

import lombok.Getter;
import lombok.Setter;
import net.twisted.fate.barbershop.entity.PK;
import net.twisted.fate.barbershop.entity.SolutionVersion;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

/**
 * 版本展示字段
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2021/1/10
 */
@Getter
@Setter
public class SolutionVersionVO extends BaseVO {

    private PK pk;
    private String name;
    private String description;
    private LocalDateTime createTime;

    public static SolutionVersionVO of(SolutionVersion solutionVersion) {
        SolutionVersionVO vo = new SolutionVersionVO();
        BeanUtils.copyProperties(solutionVersion, vo);
        return vo;
    }

}
