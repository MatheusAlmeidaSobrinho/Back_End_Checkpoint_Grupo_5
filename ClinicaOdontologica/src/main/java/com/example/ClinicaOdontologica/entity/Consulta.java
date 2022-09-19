package com.example.ClinicaOdontologica.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "tb_consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @OneToOne
    @JoinColumn(name="paciente_id")
    private Paciente paciente;

    @OneToOne
    @JoinColumn(name="dentista_id")
    private Dentista dentista;

    @Column(name = "data")
    private Date data;

}
