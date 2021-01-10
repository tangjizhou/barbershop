package net.twisted.fate.barbershop.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 新建版本参数
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2021/1/10
 */
@Getter
@Setter
public class SolutionVersionCreateDTO {

    private String solutionId;
    private String name;
    private String description;

}
