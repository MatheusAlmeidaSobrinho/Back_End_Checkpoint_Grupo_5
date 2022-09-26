package com.example.ClinicaOdontologica.entity.dto;

import com.example.ClinicaOdontologica.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class DentistaDTO {

    private Integer id;

    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private String nome;
    @NotEmpty(message = "{campo.sobrenome.obrigatorio}")
    private String sobrenome;
    @NotEmpty(message = "{campo.cro.obrigatorio}")
    private String cro;
    @NotNull(message = "{campo.matricula.obrigatorio}")
    private Integer matricula;
    private String email;
    private String senha;
    @NotNull(message = "{campo.roles.obrigatorio}")
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
