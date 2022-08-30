package com.example.ClinicaOdontologica.entity.dto;

import com.example.ClinicaOdontologica.entity.Dentista;

public class DentistaDTO {
    private String nome;
    private String sobrenome;
    private Integer matricula;

    public DentistaDTO(Dentista dentista) {
        this.nome = dentista.getNome();
        this.sobrenome = dentista.getSobrenome();
        this.matricula = dentista.getMatricula();
    }

    public DentistaDTO() {
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
