package net.twisted.fate.barbershop.controller;

import net.twisted.fate.barbershop.dto.SolutionAddDTO;
import net.twisted.fate.barbershop.entity.PK;
import net.twisted.fate.barbershop.entity.Solution;
import net.twisted.fate.barbershop.entity.User;
import net.twisted.fate.barbershop.service.ISolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * TODO
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2021/1/7
 */
@RestController
@RequestMapping("/solution")
public class SolutionController {

    @Autowired
    private ISolutionService solutionService;

    @PostMapping("/")
    public void add(@RequestBody SolutionAddDTO dto, @ApiIgnore User user) {
        solutionService.save(dto, user);
    }

    @DeleteMapping("/{id}")
    public void add(@PathVariable String id) {
        solutionService.logicDelete(PK.of(id));
    }

    @GetMapping("{projectId}/solutions")
    public List<Solution> queryByProjectId(@PathVariable String projectId) {
        return solutionService.listByProjectId(projectId);
    }


}
