package net.twisted.fate.barbershop;

import net.twisted.fate.barbershop.entity.Harden;
import net.twisted.fate.barbershop.service.IHardenService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.UUID;

@SpringBootTest
class BarbershopApplicationTests {

    @Autowired
    private IHardenService hardenService;

    @Test
    void contextLoads() {
        Harden harden = new Harden();
        harden.setName("test1");
        harden.setWidth(BigDecimal.ONE);
        harden.setHeight(BigDecimal.ONE);
        hardenService.create(harden);
    }

}
