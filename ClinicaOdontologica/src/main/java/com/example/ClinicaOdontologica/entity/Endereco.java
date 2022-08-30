package com.example.ClinicaOdontologica.entity;

import com.example.ClinicaOdontologica.entity.dto.EnderecoDTO;

public class Endereco {
    private Integer id;
    private String rua;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String cep;

    public Endereco(EnderecoDTO enderecoDTO) {
        this.rua = enderecoDTO.getRua();
        this.numero = enderecoDTO.getNumero();
        this.bairro = enderecoDTO.getBairro();
        this.cidade = enderecoDTO.getCidade();
        this.cep = enderecoDTO.getCep();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
