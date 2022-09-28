package com.example.ClinicaOdontologica.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class ConsultaDTO {

    private Integer id;

    @NotNull(message = "{campo.id-paciente.obrigatorio}")
    private Integer pacienteId;

    @NotNull(message = "{campo.id-dentista.obrigatorio}")
    private Integer dentistaId;

    @NotNull(message = "{campo.data-consulta.obrigatorio}")
    private Date data;


    public static Builder builder() {
        return new Builder();
    }


    public static class Builder {

        private Integer id;
        private Integer pacienteId;
        private Integer dentistaId;
        private Date data;

        public ConsultaDTO.Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public ConsultaDTO.Builder pacienteId(Integer pacienteId) {
            this.pacienteId = pacienteId;
            return this;
        }

        public ConsultaDTO.Builder dentistaId(Integer dentistaId) {
            this.dentistaId = dentistaId;
            return this;
        }

        public ConsultaDTO.Builder setData(Date data) {
            this.data = data;
            return this;
        }

        public ConsultaDTO build() {
            ConsultaDTO builderDTO = new ConsultaDTO();
            builderDTO.setId(this.id);
            builderDTO.setPacienteId(this.pacienteId);
            builderDTO.setDentistaId(this.dentistaId);
            builderDTO.setData(this.data);
            return builderDTO;
        }

    }


}
