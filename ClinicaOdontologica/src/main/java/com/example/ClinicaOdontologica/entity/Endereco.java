package com.example.ClinicaOdontologica.entity;

import com.example.ClinicaOdontologica.entity.dto.EnderecoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String rua;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String cep;

    @OneToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    public Endereco(EnderecoDTO enderecoDTO) {
        this.rua = enderecoDTO.getRua();
        this.numero = enderecoDTO.getNumero();
        this.bairro = enderecoDTO.getBairro();
        this.cidade = enderecoDTO.getCidade();
        this.cep = enderecoDTO.getCep();
    }

    public Endereco() {
    }
}
