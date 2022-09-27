package common;

import com.example.ClinicaOdontologica.entity.Paciente;
import com.example.ClinicaOdontologica.entity.dto.PacienteDTO;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import static com.example.ClinicaOdontologica.enums.Roles.ADMIN;

public class PacienteMock {

    private final EnderecoMock enderecoMock = new EnderecoMock();

    public PacienteDTO getPacienteRequestDTO() {
        PacienteDTO requestDTO = new PacienteDTO();
        requestDTO.setNome("nomeTest" + LocalDateTime.now());
        requestDTO.setSobrenome("sobrenomeTest" + LocalDateTime.now());
        requestDTO.setRg("rgTest" + LocalDateTime.now());
        requestDTO.setRoles(ADMIN);
        requestDTO.setEmail("tawan" + LocalDateTime.now() + "@gmail.com");
        requestDTO.setSenha("1" + LocalDateTime.now());
        requestDTO.setEnderecoId(1);
        requestDTO.setDataDeAlta(Date.valueOf(LocalDate.now()));
        return requestDTO;
    }

    public Paciente getPacienteWithId() {
        Paciente paciente = new Paciente();
        paciente.setId(99999);
        paciente.setNome("nomeTest" + LocalDateTime.now());
        paciente.setSobrenome("sobrenomeTest" + LocalDateTime.now());
        paciente.setRg("rgTest" + LocalDateTime.now());
        paciente.setRoles(ADMIN);
        paciente.setEmail("tawan" + LocalDateTime.now() + "@gmail.com");
        paciente.setSenha("1" + LocalDateTime.now());
        paciente.setEndereco(enderecoMock.getEnderecoWithId());
        paciente.setDataDeAlta(Date.valueOf(LocalDate.now()));

        return paciente;
    }

    public List<Paciente> getList() {
        List<Paciente> pacientes = new LinkedList<>();
        for (int i = 1; i < 5; i++) {
            Paciente paciente = new Paciente();

            paciente.setId(i);
            paciente.setNome("nomeTest" + LocalDateTime.now());
            paciente.setSobrenome("sobrenomeTest" + LocalDateTime.now());
            paciente.setRg("rgTest" + LocalDateTime.now());
            paciente.setRoles(ADMIN);
            paciente.setEmail("tawan" + LocalDateTime.now() + "@gmail.com");
            paciente.setSenha("1" + LocalDateTime.now());
            paciente.setEndereco(enderecoMock.getEnderecoWithId());
            paciente.setDataDeAlta(Date.valueOf(LocalDate.now()));

            pacientes.add(paciente);
        }
        return pacientes;
    }
}
