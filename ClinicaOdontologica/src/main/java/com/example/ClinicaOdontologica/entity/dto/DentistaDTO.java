package com.example.ClinicaOdontologica.entity.dto;

import com.example.ClinicaOdontologica.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

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

    public static Builder builder() {
        return new Builder();
    }


    public static class Builder {

        private Integer id;
        private String nome;
        private String sobrenome;
        private String cro;
        private Integer matricula;
        private String email;
        private String senha;
        private Roles roles;

        public Integer getId() {
            return id;
        }

        public DentistaDTO.Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public String getNome() {
            return nome;
        }

        public DentistaDTO.Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public String getSobrenome() {
            return sobrenome;
        }

        public DentistaDTO.Builder sobrenome(String sobrenome) {
            this.sobrenome = sobrenome;
            return this;
        }

        public String getCro() {
            return cro;
        }

        public DentistaDTO.Builder cro(String cro) {
            this.cro = cro;
            return this;
        }

        public Integer getMatricula() {
            return matricula;
        }

        public DentistaDTO.Builder matricula(Integer matricula) {
            this.matricula = matricula;
            return this;
        }

        public String getEmail() {
            return email;
        }

        public DentistaDTO.Builder email(String email) {
            this.email = email;
            return this;
        }

        public String getSenha() {
            return senha;
        }

        public DentistaDTO.Builder senha(String senha) {
            this.senha = senha;
            return this;
        }

        public Roles getRoles() {
            return roles;
        }

        public DentistaDTO.Builder roles(Roles roles) {
            this.roles = roles;
            return this;
        }

        public DentistaDTO build() {
            DentistaDTO builderDTO = new DentistaDTO();
            builderDTO.setId(this.id);
            builderDTO.setNome(this.nome);
            builderDTO.setSobrenome(this.sobrenome);
            builderDTO.setEmail(this.email);
            builderDTO.setSenha(this.senha);
            builderDTO.setRoles(this.roles);
            builderDTO.setCro(this.cro);
            builderDTO.setMatricula(this.matricula);
            return builderDTO;
        }

    }
}
