package com.example.ClinicaOdontologica.entity.dto;

import com.example.ClinicaOdontologica.entity.Endereco;
import com.example.ClinicaOdontologica.entity.Paciente;

import java.util.Date;

public class PacienteDTO {

    private String nome;
    private String sobrenome;
    private Endereco endereco;
    private Integer rg;
    private Date dataDeAlta;

    public PacienteDTO(Paciente paciente) {
        this.nome = paciente.getNome();
        this.sobrenome = paciente.getSobrenome();
        this.endereco = paciente.getEndereco();
        this.rg = paciente.getRg();
        this.dataDeAlta = paciente.getDataDeAlta();
    }

    public PacienteDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Integer getRg() {
        return rg;
    }

    public void setRg(Integer rg) {
        this.rg = rg;
    }

    public Date getDataDeAlta() {
        return dataDeAlta;
    }

    public void setDataDeAlta(Date dataDeAlta) {
        this.dataDeAlta = dataDeAlta;
    }
}
