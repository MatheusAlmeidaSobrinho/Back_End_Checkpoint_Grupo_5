package com.example.ClinicaOdontologica.entity.dto;

import com.example.ClinicaOdontologica.entity.Endereco;
import com.example.ClinicaOdontologica.repository.EnderecoRepository;
import lombok.Data;

import java.util.Optional;

@Data
public class EnderecoDTO {

    private String rua;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String cep;

   /*
    public Optional<Endereco> atualizar(Integer id, EnderecoRepository enderecoRepository) {
        Optional<Endereco> endereco = enderecoRepository.findById(id);

        endereco.get().setRua(this.rua);
        endereco.get().setNumero(this.numero);
        endereco.get().setBairro(this.bairro);
        endereco.get().setCidade(this.cidade);
        endereco.get().setCep(this.cep);

        return endereco;

    }*/

}
