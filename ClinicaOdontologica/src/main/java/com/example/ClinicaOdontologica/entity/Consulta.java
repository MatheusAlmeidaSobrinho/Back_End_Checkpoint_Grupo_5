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
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @OneToOne
    @JoinColumn(name = "dentista_id")
    private Dentista dentista;

    @Column(name = "data")
    private Date data;


    public static Builder builder() {
        return new Builder();
    }


    public static class Builder {

        private Integer id;
        private Paciente paciente;
        private Dentista dentista;
        private Date data;

        public Consulta.Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Consulta.Builder paciente(Paciente paciente) {
            this.paciente = paciente;
            return this;
        }

        public Consulta.Builder dentista(Dentista dentista) {
            this.dentista = dentista;
            return this;
        }

        public Consulta.Builder data(Date data) {
            this.data = data;
            return this;
        }

        public Consulta build() {
            Consulta builder = new Consulta();
            builder.setId(this.id);
            builder.setPaciente(this.paciente);
            builder.setDentista(this.dentista);
            builder.setData(this.data);
            return builder;
        }
    }

}
