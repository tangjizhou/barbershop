package net.twisted.fate.barbershop.controller;

import net.twisted.fate.barbershop.dto.SolutionAddDTO;
import net.twisted.fate.barbershop.entity.User;
import net.twisted.fate.barbershop.service.ISolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public void add(@RequestBody SolutionAddDTO dto, User user) {
        solutionService.save(dto, user);
    }


}
