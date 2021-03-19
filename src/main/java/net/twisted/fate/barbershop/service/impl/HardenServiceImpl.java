package net.twisted.fate.barbershop.service.impl;

import net.twisted.fate.barbershop.entity.Harden;
import net.twisted.fate.barbershop.repository.HardenRepository;
import net.twisted.fate.barbershop.service.IHardenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * harden服务
 *
 * @author tangjizhouchn@foxmail.com
 * @since 2021/3/19
 */
@Service
@Transactional
public class HardenServiceImpl implements IHardenService {

    @Autowired
    private HardenRepository hardenRepository;

    @Override
    public void create(Harden harden) {
        // hardenRepository.deleteAll();
        // hardenRepository.save(harden);
        // if (1 == 1) {
        //     throw new RuntimeException();
        // }
        System.out.println(hardenRepository.findAll().toString());
    }

}
