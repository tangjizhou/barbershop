package net.twisted.fate.barbershop.service;

import net.twisted.fate.barbershop.dto.SolutionVersionCreateDTO;
import net.twisted.fate.barbershop.entity.PK;
import net.twisted.fate.barbershop.entity.SolutionVersion;
import net.twisted.fate.barbershop.entity.User;
import net.twisted.fate.barbershop.vo.SolutionVersionVO;

import java.util.List;

/**
 * 版本化接口
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2021/1/10
 */
public interface ISolutionVersionService extends IBaseService<SolutionVersion, PK> {

    void create(SolutionVersionCreateDTO dto, User user);

    List<SolutionVersionVO> listBySolutionId(String solutionId);

    void rollback(String solutionId, String id);

}
