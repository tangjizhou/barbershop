package net.twisted.fate.barbershop.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.twisted.fate.barbershop.entity.PK;

import java.time.LocalDateTime;

/**
 * TODO
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2021/1/9
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectSolutionVO {

    private PK pk;
    private String projectId;
    private String projectName;
    private String solutionId;
    private String solutionName;
    private String createBy;
    private LocalDateTime createTime;

}
