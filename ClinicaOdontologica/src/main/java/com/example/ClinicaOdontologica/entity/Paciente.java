package com.example.ClinicaOdontologica.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "tb_paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String sobrenome;

    @OneToOne(mappedBy = "paciente", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private Endereco endereco;

    @Column(unique = true)
    private String rg;
    private Date dataDeAlta;

    public Paciente() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDataDeAlta() {
        return dataDeAlta;
    }

    public void setDataDeAlta(Date dataDeAlta) {
        this.dataDeAlta = dataDeAlta;
    }
}
