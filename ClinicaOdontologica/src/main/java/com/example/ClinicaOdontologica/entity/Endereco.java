package com.example.ClinicaOdontologica.entity;

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

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
