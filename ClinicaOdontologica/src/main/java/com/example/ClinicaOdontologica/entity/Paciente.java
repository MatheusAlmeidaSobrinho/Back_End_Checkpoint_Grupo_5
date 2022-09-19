package com.example.ClinicaOdontologica.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "tb_paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    private String nome;

    private String sobrenome;

    @ManyToOne
    @JoinColumn(name="endereco_id")
    private Endereco endereco;

    @Column(unique = true)
    private String rg;

    @Column(name = "Data_de_Alta")
    private Date dataDeAlta;

}
