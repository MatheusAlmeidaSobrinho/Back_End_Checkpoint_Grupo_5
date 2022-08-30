package com.example.ClinicaOdontologica.entity.dto;

import com.example.ClinicaOdontologica.entity.Consulta;
import com.example.ClinicaOdontologica.entity.Dentista;
import com.example.ClinicaOdontologica.entity.Paciente;

import java.util.Date;

public class ConsultaDTO {

    private Paciente paciente;
    private Dentista dentista;
    private Date data;

    public ConsultaDTO(Consulta consulta) {
        this.paciente = consulta.getPaciente();
        this.dentista = consulta.getDentista();
        this.data = consulta.getData();
    }

    public ConsultaDTO() {

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
