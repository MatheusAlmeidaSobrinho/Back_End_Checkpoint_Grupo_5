package com.example.ClinicaOdontologica.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@NoArgsConstructor
@Table(name = "tb_endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;


    private String rua;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String cep;

    public static Builder builder() {
        return new Builder();
    }


    public static class Builder {

        private Integer id;
        private String rua;
        private Integer numero;
        private String bairro;
        private String cidade;
        private String cep;

        public Endereco.Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Endereco.Builder rua(String rua) {
            this.rua = rua;
            return this;
        }

        public Endereco.Builder numero(Integer numero) {
            this.numero = numero;
            return this;
        }

        public Endereco.Builder bairro(String bairro) {
            this.bairro = bairro;
            return this;
        }

        public Endereco.Builder cidade(String cidade) {
            this.cidade = cidade;
            return this;
        }

        public Endereco.Builder cep(String cep) {
            this.cep = cep;
            return this;
        }

        public Endereco build() {
            Endereco builder = new Endereco();
            builder.setId(this.id);
            builder.setRua(this.rua);
            builder.setNumero(this.numero);
            builder.setBairro(this.bairro);
            builder.setCidade(this.cidade);
            builder.setCep(this.cep);
            return builder;
        }
    }
}
