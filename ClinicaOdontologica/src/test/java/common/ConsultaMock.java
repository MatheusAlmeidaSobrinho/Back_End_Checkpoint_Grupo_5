package common;

import com.example.ClinicaOdontologica.entity.Consulta;
import com.example.ClinicaOdontologica.entity.dto.ConsultaDTO;

import java.sql.Date;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class ConsultaMock {

    private final PacienteMock pacienteMock = new PacienteMock();
    private final DentistaMock dentistaMock = new DentistaMock();

    public ConsultaDTO getConsultaRequestDTO() {
        ConsultaDTO requestDTO = new ConsultaDTO();
        requestDTO.setPacienteId(1);
        requestDTO.setDentistaId(1);
        requestDTO.setData(Date.valueOf(LocalDate.now()));
        return requestDTO;
    }

    public Consulta getConsultaWithId() {
        Consulta consulta = new Consulta();
        consulta.setId(99999);
        consulta.setDentista(dentistaMock.getDentistaWithId());
        consulta.setPaciente(pacienteMock.getPacienteWithId());
        consulta.setData(Date.valueOf(LocalDate.now()));
        return consulta;
    }

    public List<Consulta> getList() {
        List<Consulta> consultas = new LinkedList<>();
        for (int i = 1; i < 5; i++) {
            Consulta consulta = new Consulta();
            consulta.setId(i);
            consulta.setDentista(dentistaMock.getDentistaWithId());
            consulta.setPaciente(pacienteMock.getPacienteWithId());
            consulta.setData(Date.valueOf(LocalDate.now()));
        }
        return consultas;
    }
}
