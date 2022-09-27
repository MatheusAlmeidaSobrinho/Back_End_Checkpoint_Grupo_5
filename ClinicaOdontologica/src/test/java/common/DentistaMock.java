package common;

import com.example.ClinicaOdontologica.entity.Dentista;
import com.example.ClinicaOdontologica.entity.dto.DentistaDTO;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import static com.example.ClinicaOdontologica.enums.Roles.ADMIN;

public class DentistaMock {

    public DentistaDTO getDentistaRequestDTO() {
        DentistaDTO requestDTO = new DentistaDTO();
        requestDTO.setNome("nomeTest" + LocalDateTime.now());
        requestDTO.setSobrenome("sobrenomeTest" + LocalDateTime.now());
        requestDTO.setCro("cro" + LocalDateTime.now());
        requestDTO.setMatricula((int) (1 + Math.floor(Math.random() * 100) + 1));
        requestDTO.setEmail("tawan@gmail.com");
        requestDTO.setSenha("12345678");
        requestDTO.setRoles(ADMIN);
        return requestDTO;
    }

    public Dentista getDentistaWithId() {
        Dentista dentista = new Dentista();
        dentista.setId(99999);
        dentista.setNome("nomeTeste"+ LocalDateTime.now());
        dentista.setSobrenome("sobrenomeTeste"+ LocalDateTime.now());
        dentista.setCro("CRO"+ LocalDateTime.now());
        dentista.setMatricula((int) (1 + Math.floor(Math.random() * 100) + 1));
        dentista.setEmail("tawan@gmail.com");
        dentista.setSenha("12345678");
        dentista.setRoles(ADMIN);

        return dentista;
    }

    public List<Dentista> getList() {
        List<Dentista> dentistaList = new LinkedList<>();
        for (int i = 1; i < 5; i++) {
            Dentista dentista = new Dentista();

            dentista.setId(i);
            dentista.setNome("nomeTeste"+ LocalDateTime.now());
            dentista.setSobrenome("sobrenomeTeste"+ LocalDateTime.now());
            dentista.setCro("CRO"+ LocalDateTime.now());
            dentista.setMatricula((int) (1 + Math.floor(Math.random() * 100) + 1));
            dentista.setEmail("tawan@gmail.com");
            dentista.setSenha("12345678");
            dentista.setRoles(ADMIN);

            dentistaList.add(dentista);
        }
        return dentistaList;
    }
}
