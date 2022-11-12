package com.igf.subsidiosv;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.igf.subsidiosv.rol.Rol;
import com.igf.subsidiosv.rol.RolRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RolRepositoryTest {
    
    @Autowired
    private RolRepository repo;

    @Test
    public void testCrearRol() {
        //Rol rolGuardado = repo.save(new Rol("Administrador"));
        //assertThat(rolGuardado.getId()).isGreaterThan(0);
    }
}
