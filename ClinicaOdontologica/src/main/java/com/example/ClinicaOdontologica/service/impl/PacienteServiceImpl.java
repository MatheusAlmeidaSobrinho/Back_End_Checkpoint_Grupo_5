package com.example.ClinicaOdontologica.service.impl;

import com.example.ClinicaOdontologica.entity.Endereco;
import com.example.ClinicaOdontologica.entity.Paciente;
import com.example.ClinicaOdontologica.entity.dto.EnderecoDTO;
import com.example.ClinicaOdontologica.entity.dto.PacienteDTO;
import com.example.ClinicaOdontologica.repository.PacienteRepository;
import com.example.ClinicaOdontologica.service.IClinicaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteServiceImpl implements IClinicaService<PacienteDTO> {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private EnderecoServiceImpl enderecoService;

    @Autowired
    private ModelMapper mapper;

    @Override
    public PacienteDTO cadastrar(PacienteDTO pacienteDTO) {
        Paciente paciente = mapperDTOParaPaciente(pacienteDTO);
        EnderecoDTO enderecoDTO;
        int idEndereco = paciente.getEndereco().getId();

        if(enderecoService.ifEnderecoExists(idEndereco)){
            enderecoDTO = enderecoService.consultarPorId(idEndereco);
            Endereco endereco = new Endereco(enderecoDTO);
            paciente.setEndereco(endereco);
            paciente = pacienteRepository.save(paciente);
        }
        pacienteDTO = mapperPacienteParaDTO(paciente);
        return pacienteDTO;
    }

    @Override
    public PacienteDTO consultarPorId(Integer id) {
        Paciente paciente = pacienteRepository.findById(id).get();
        return mapperPacienteParaDTO(paciente);
    }

    @Override
    public PacienteDTO atualizar(Integer id, PacienteDTO pacienteDTO) {
        PacienteDTO entity = this.consultarPorId(id);
        pacienteDTO.setId(entity.getId());
        pacienteRepository.saveAndFlush(mapper.map(pacienteDTO,Paciente.class));
        return pacienteDTO;
    }

    @Override
    public void excluirPorId(Integer id) {
        this.consultarPorId(id);
        this.pacienteRepository.deleteById(id);
    }

    private Paciente mapperDTOParaPaciente(PacienteDTO pacienteDTO) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(pacienteDTO, Paciente.class);
    }

    private PacienteDTO mapperPacienteParaDTO(Paciente paciente) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(paciente, PacienteDTO.class);
    }
}
