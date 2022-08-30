package com.example.ClinicaOdontologica.entity;

import com.example.ClinicaOdontologica.entity.dto.ConsultaDTO;

import java.util.Date;

public class Consulta {
    private Integer id;
    private Paciente paciente;
    private Dentista dentista;
    private Date data;

    public Consulta(ConsultaDTO consultaDTO) {
        this.paciente = consultaDTO.getPaciente();
        this.dentista = consultaDTO.getDentista();
        this.data = consultaDTO.getData();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Dentista getDentista() {
        return dentista;
    }

    public void setDentista(Dentista dentista) {
        this.dentista = dentista;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
