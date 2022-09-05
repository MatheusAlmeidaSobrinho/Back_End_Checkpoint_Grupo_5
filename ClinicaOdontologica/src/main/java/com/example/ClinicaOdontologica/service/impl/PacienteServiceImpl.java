package com.example.ClinicaOdontologica.service.impl;

import com.example.ClinicaOdontologica.entity.Paciente;
import com.example.ClinicaOdontologica.repository.PacienteRepository;
import com.example.ClinicaOdontologica.service.IClinicaService;
import com.example.ClinicaOdontologica.service.exceptions.ConstraintViolationException;
import com.example.ClinicaOdontologica.service.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PacienteServiceImpl implements IClinicaService<Paciente> {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Paciente consultarPorId(Integer id) {
        Optional<Paciente> obj = this.pacienteRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Paciente não encontrado"));
    }

    @Override
    public Paciente cadastrar(Paciente paciente) {
        try {
            Paciente obj = this.pacienteRepository.save(paciente);
            obj.getEndereco().setPaciente(obj);
            this.pacienteRepository.save(obj);

            return obj;
        } catch (Exception err) {
            throw new ConstraintViolationException(err.getMessage());
        }
    }

    @Override
    public Paciente atualizar(Integer id, Paciente paciente) {
        Paciente entity = this.consultarPorId(id);
        return pacienteRepository.save(this.updateData(entity, paciente));
    }

    @Override
    public void excluirPorId(Integer id) {
        this.consultarPorId(id);
        this.pacienteRepository.deleteById(id);
    }

    private Paciente updateData(Paciente entity, Paciente obj) {
        entity.setNome(obj.getNome());
        entity.setSobrenome(obj.getSobrenome());

        entity.getEndereco().setRua(obj.getEndereco().getRua());
        entity.getEndereco().setNumero(obj.getEndereco().getNumero());
        entity.getEndereco().setBairro(obj.getEndereco().getBairro());
        entity.getEndereco().setCep(obj.getEndereco().getCep());

        entity.setRg(obj.getRg());
        entity.setDataDeAlta(obj.getDataDeAlta());
        
        return entity;
    }
}
