package com.backend.infra.seed;

import com.backend.entidades.PassagemAerea;
import com.backend.entidades.Usuario;
import com.backend.entidades.Voo;
import com.backend.entidades.enums.ClassePassagemEnum;
import com.backend.entidades.enums.StatusReservaEnum;
import com.backend.repositorios.PassagemAereaRepositorio;
import com.backend.repositorios.UsuarioRepositorio;
import com.backend.repositorios.VooRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class DataSeed implements CommandLineRunner {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private VooRepositorio vooRepositorio;

    @Autowired
    private PassagemAereaRepositorio passagemAereaRepositorio;

    @Override
    public void run(String... args) throws Exception {
        Usuario usuario1 = new Usuario("Gustavo", "gustavo@email.test", "123456789");
        Usuario usuario2 = new Usuario("Daniel", "daniel@email.test", "987654321");
        Usuario usuario3 = new Usuario("Alex", "alex@email.test", "675849483");
        usuarioRepositorio.saveAll(List.of(usuario1,usuario2,usuario3));

        LocalDateTime data = LocalDateTime.of(2023, 11, 25, 12, 20);
        LocalDateTime dataChegada = data.plusHours(4);
        Voo voo1 = new Voo("Rio de Janeiro",  "São Paulo", data, dataChegada);
        Voo voo2 = new Voo("Rio de Janeiro",  "São Paulo", data.plusDays(3), dataChegada.plusDays(3).plusHours(2));
        vooRepositorio.saveAll(List.of(voo1, voo2));


        PassagemAerea passagem1 = new PassagemAerea("9A", ClassePassagemEnum.ECONOMICA, 1809.0, LocalDateTime.now(), StatusReservaEnum.CONFIRMADA);
        PassagemAerea passagem2 = new PassagemAerea("9C", ClassePassagemEnum.EXECUTIVA, 1809.0, LocalDateTime.now().minusDays(1), StatusReservaEnum.PENDENTE);
        passagem1.setVoo(voo1);
        passagem2.setVoo(voo2);
        passagemAereaRepositorio.saveAll(List.of(passagem1, passagem2));
    }
}
