package com.example.ClinicaOdontologica.entity.dto;

import com.example.ClinicaOdontologica.entity.Endereco;
import lombok.Data;

@Data
public class EnderecoDTO {


    private Integer id;
    private String rua;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String cep;


//    public EnderecoDTO(Endereco endereco) {
//        this.rua = endereco.getRua();
//        this.numero = endereco.getNumero();
//        this.bairro = endereco.getBairro();
//        this.cidade = endereco.getCidade();
//        this.cep = endereco.getCep();
//    }
//
//    public EnderecoDTO() {
//    }
}
