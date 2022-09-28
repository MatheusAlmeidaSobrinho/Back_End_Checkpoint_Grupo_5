package com.example.ClinicaOdontologica.service.impl;

import com.example.ClinicaOdontologica.common.exception.NotFoundException;
import com.example.ClinicaOdontologica.entity.Consulta;
import com.example.ClinicaOdontologica.entity.Dentista;
import com.example.ClinicaOdontologica.entity.Paciente;
import com.example.ClinicaOdontologica.entity.dto.ConsultaDTO;
import com.example.ClinicaOdontologica.repository.ConsultaRepository;
import com.example.ClinicaOdontologica.service.IClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConsultaServiceImpl implements IClinicaService<ConsultaDTO> {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private PacienteServiceImpl pacienteService;

    @Autowired
    private DentistaServiceImpl dentistaService;

    @Override
    public ConsultaDTO cadastrar(ConsultaDTO consultaDTO) {
        pacienteService.consultarPorId(consultaDTO.getPacienteId());
        dentistaService.consultarPorId(consultaDTO.getDentistaId());
        Consulta consulta = consultaRepository.save(convertConsultaDTOIntoConsulta(consultaDTO));
        return convertConsultaIntoConsultaDTO(consulta);
    }

    @Override
    public ConsultaDTO consultarPorId(Integer id) {
        Optional<Consulta> consulta = consultaRepository.findById(id);
        if (consulta.isEmpty()) {
            throw new NotFoundException("Consulta não encontrada");
        }
        return convertConsultaIntoConsultaDTO(consulta.get());
    }

    @Override
    public List<ConsultaDTO> findAll() {
        return consultaRepository.findAll().stream()
                .map(this::convertConsultaIntoConsultaDTO).collect(Collectors.toList());
    }

    @Override
    public ConsultaDTO atualizar(Integer id, ConsultaDTO consultaDTO) {
        ConsultaDTO consultaById = consultarPorId(id);
        consultaDTO.setId(consultaById.getId());
        Consulta consulta = convertConsultaDTOIntoConsulta(consultaDTO);
        Consulta consultaSaved = consultaRepository.saveAndFlush(consulta);
        return convertConsultaIntoConsultaDTO(consultaSaved);
    }

    @Override
    public void excluirPorId(Integer id) {
        consultarPorId(id);
        consultaRepository.deleteById(id);
    }

    private Consulta convertConsultaDTOIntoConsulta(ConsultaDTO consultaDTO) {
        Dentista dentista = dentistaService.convertDentistaDTOIntoDentista(
                dentistaService.consultarPorId(consultaDTO.getDentistaId()));
        Paciente paciente = pacienteService.convertPacienteDTOIntoPaciente(
                pacienteService.consultarPorId(consultaDTO.getPacienteId()));

        return Consulta.builder()
                .id(consultaDTO.getId())
                .paciente(paciente)
                .dentista(dentista)
                .data(consultaDTO.getData())
                .build();
    }

    private ConsultaDTO convertConsultaIntoConsultaDTO(Consulta consulta) {
        return ConsultaDTO.builder()
                .id(consulta.getId())
                .pacienteId(consulta.getPaciente().getId())
                .dentistaId(consulta.getDentista().getId())
                .setData(consulta.getData())
                .build();
    }
}
