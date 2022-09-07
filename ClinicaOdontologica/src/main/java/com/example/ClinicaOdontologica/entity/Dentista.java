package com.example.ClinicaOdontologica.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_dentista")
public class Dentista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String sobrenome;

    private Integer matricula;

}
