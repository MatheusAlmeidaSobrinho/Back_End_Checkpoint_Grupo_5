package com.example.ClinicaOdontologica.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class EnderecoDTO {

    private Integer id;

    @NotEmpty(message = "{campo.rua.obrigatorio}")
    private String rua;

    @NotNull(message = "{campo.numero.obrigatorio}")
    private Integer numero;

    @NotEmpty(message = "{campo.bairro.obrigatorio}")
    private String bairro;

    @NotEmpty(message = "{campo.cidade.obrigatorio}")
    private String cidade;

    @NotEmpty(message = "{campo.cep.obrigatorio}")
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

        public EnderecoDTO.Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public EnderecoDTO.Builder rua(String rua) {
            this.rua = rua;
            return this;
        }

        public EnderecoDTO.Builder numero(Integer numero) {
            this.numero = numero;
            return this;
        }

        public EnderecoDTO.Builder bairro(String bairro) {
            this.bairro = bairro;
            return this;
        }

        public EnderecoDTO.Builder cidade(String cidade) {
            this.cidade = cidade;
            return this;
        }

        public EnderecoDTO.Builder cep(String cep) {
            this.cep = cep;
            return this;
        }

        public EnderecoDTO build() {
            EnderecoDTO builderDTO = new EnderecoDTO();
            builderDTO.setId(this.id);
            builderDTO.setRua(this.rua);
            builderDTO.setNumero(this.numero);
            builderDTO.setBairro(this.bairro);
            builderDTO.setCep(this.cep);
            builderDTO.setCidade(this.cidade);
            return builderDTO;
        }

    }


}
