package net.twisted.fate.barbershop.controller;

import net.twisted.fate.barbershop.dto.SolutionVersionCreateDTO;
import net.twisted.fate.barbershop.entity.User;
import net.twisted.fate.barbershop.service.ISolutionVersionService;
import net.twisted.fate.barbershop.vo.SolutionVersionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * TODO
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2021/1/10
 */
@RestController
@RequestMapping("/solution-version")
public class SolutionVersionController {

    @Autowired
    private ISolutionVersionService solutionVersionService;

    @PostMapping("/")
    public void create(SolutionVersionCreateDTO dto, @ApiIgnore User user) {
        solutionVersionService.create(dto, user);
    }

    @GetMapping("/list/{solutionId}")
    public List<SolutionVersionVO> queryAll(@PathVariable String solutionId) {
        return solutionVersionService.listBySolutionId(solutionId);
    }

    @PostMapping("/rollback/{solutionId}/{solutionVersionId}")
    public void rollback(@PathVariable String solutionId, @PathVariable String solutionVersionId) {
        solutionVersionService.rollback(solutionId, solutionVersionId);
    }

}
