package com.example.ClinicaOdontologica.entity;

import com.example.ClinicaOdontologica.entity.dto.DentistaDTO;

public class Dentista {
    private Integer id;
    private String nome;
    private String sobrenome;
    private Integer matricula;

    public Dentista(DentistaDTO dentistaDTO) {
        this.nome = dentistaDTO.getNome();
        this.sobrenome = dentistaDTO.getSobrenome();
        this.matricula = dentistaDTO.getMatricula();
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

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }
}
