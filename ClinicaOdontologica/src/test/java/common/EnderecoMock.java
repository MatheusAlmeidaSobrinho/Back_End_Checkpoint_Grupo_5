package common;

import com.example.ClinicaOdontologica.entity.Endereco;
import com.example.ClinicaOdontologica.entity.dto.EnderecoDTO;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class EnderecoMock {

    public EnderecoDTO getEnderecoRequestDTO() {
        EnderecoDTO requestDTO = new EnderecoDTO();
        requestDTO.setRua("ruaTest" + LocalDateTime.now());
        requestDTO.setNumero((int) (1 + Math.floor(Math.random() * 100) + 1));
        requestDTO.setBairro("bairroTest" + LocalDateTime.now());
        requestDTO.setCidade("cidadeTest" + LocalDateTime.now());
        requestDTO.setCep("cepTest" + LocalDateTime.now());
        return requestDTO;
    }

    public Endereco getEnderecoWithId() {
        Endereco endereco = new Endereco();
        endereco.setId(99999);
        endereco.setRua("ruaTest" + LocalDateTime.now());
        endereco.setNumero((int) (1 + Math.floor(Math.random() * 100) + 1));
        endereco.setBairro("bairroTest" + LocalDateTime.now());
        endereco.setCidade("cidadeTest" + LocalDateTime.now());
        endereco.setCep("cepTest" + LocalDateTime.now());
        return endereco;
    }

    public List<Endereco> getList() {
        List<Endereco> enderecos = new LinkedList<>();
        for (int i = 1; i < 5; i++) {
            Endereco endereco = new Endereco();

            endereco.setId(i);
            endereco.setRua("ruaTest" + LocalDateTime.now());
            endereco.setNumero((int) (1 + Math.floor(Math.random() * 100) + 1));
            endereco.setBairro("bairroTest" + LocalDateTime.now());
            endereco.setCidade("cidadeTest" + LocalDateTime.now());
            endereco.setCep("cepTest" + LocalDateTime.now());

            enderecos.add(endereco);
        }
        return enderecos;
    }
}
