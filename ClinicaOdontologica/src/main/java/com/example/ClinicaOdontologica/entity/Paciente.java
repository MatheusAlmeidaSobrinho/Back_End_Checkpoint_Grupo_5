package com.example.ClinicaOdontologica.entity;

import com.example.ClinicaOdontologica.entity.dto.PacienteDTO;

import java.util.Date;

public class Paciente {
    private Integer id;
    private String nome;
    private String sobrenome;
    private Endereco endereco;
    private Integer rg;
    private Date dataDeAlta;

    public Paciente(PacienteDTO pacienteDTO) {
        this.nome = pacienteDTO.getNome();
        this.sobrenome = pacienteDTO.getSobrenome();
        this.endereco = pacienteDTO.getEndereco();
        this.rg = pacienteDTO.getRg();
        this.dataDeAlta = pacienteDTO.getDataDeAlta();
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
