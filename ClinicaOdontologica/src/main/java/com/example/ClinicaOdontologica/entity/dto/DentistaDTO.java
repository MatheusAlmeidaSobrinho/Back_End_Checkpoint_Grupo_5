package com.example.ClinicaOdontologica.entity.dto;

import com.example.ClinicaOdontologica.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@NoArgsConstructor
public class DentistaDTO {

    private Integer id;
    private String nome;
    private String sobrenome;
    private String cro;
    private Integer matricula;
    private String email;
    private String senha;
    private Roles roles;

    public DentistaDTO(String nome, String sobrenome, String cro,
                       Integer matricula, String email, String senha, Roles roles) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cro = cro;
        this.matricula = matricula;
        this.email = email;
        this.senha = senha;
        this.roles = roles;
    }
}
