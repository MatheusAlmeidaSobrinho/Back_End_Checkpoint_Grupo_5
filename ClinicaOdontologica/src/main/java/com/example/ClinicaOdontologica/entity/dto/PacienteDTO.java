package com.example.ClinicaOdontologica.entity.dto;

import com.example.ClinicaOdontologica.enums.Roles;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class PacienteDTO {

    private Integer id;

    @NotEmpty(message = "{campo.endereco.obrigatorio}")
    private String nome;

    @NotEmpty(message = "{campo.sobrenome.obrigatorio}")
    private String sobrenome;

    @NotNull(message = "{campo.endereco.obrigatorio}")
    private Integer enderecoId;

    @NotEmpty(message = "{campo.rg.obrigatorio}")
    private String rg;
    private Date dataDeAlta;

    @NotNull(message = "{campo.roles.obrigatorio}")
    private Roles roles;
    private String email;
    private String senha;



    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private Integer id;
        private String nome;
        private String sobrenome;
        private Integer enderecoId;
        private String rg;
        private Date dataDeAlta;
        private Roles roles;
        private String email;
        private String senha;

        public PacienteDTO.Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public PacienteDTO.Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public PacienteDTO.Builder sobrenome(String sobrenome) {
            this.sobrenome = sobrenome;
            return this;
        }

        public PacienteDTO.Builder enderecoId(Integer enderecoId) {
            this.enderecoId = enderecoId;
            return this;
        }

        public PacienteDTO.Builder rg(String rg) {
            this.rg = rg;
            return this;
        }

        public PacienteDTO.Builder dataDeAlta(Date dataDeAlta) {
            this.dataDeAlta = dataDeAlta;
            return this;
        }

        public PacienteDTO.Builder roles(Roles roles) {
            this.roles = roles;
            return this;
        }

        public PacienteDTO.Builder email(String email) {
            this.email = email;
            return this;
        }

        public PacienteDTO.Builder senha(String senha) {
            this.senha = senha;
            return this;
        }

        public PacienteDTO build() {
            PacienteDTO builderDTO = new PacienteDTO();
            builderDTO.setId(this.id);
            builderDTO.setNome(this.nome);
            builderDTO.setSobrenome(this.sobrenome);
            builderDTO.setEnderecoId(this.enderecoId);
            builderDTO.setRg(this.rg);
            builderDTO.setDataDeAlta(this.dataDeAlta);
            builderDTO.setRoles(this.roles);
            builderDTO.setEmail(this.email);
            builderDTO.setSenha(this.senha);
            return builderDTO;
        }

    }

}
