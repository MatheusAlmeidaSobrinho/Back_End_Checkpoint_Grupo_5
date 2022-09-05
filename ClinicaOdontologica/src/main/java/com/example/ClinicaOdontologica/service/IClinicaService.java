package com.example.ClinicaOdontologica.service;

import java.util.Optional;

// serve para paciente, dentista e consulta (para login acredito que vai ser criado uma nova interface)
public interface IClinicaService<T> {
    T consultarPorId(Integer id); // possiveis variações por nome, endereço, consulta ...
    T cadastrar (T t);
    T atualizar (Integer id, T t);
    void excluirPorId (Integer id); // possiveis variações...
}
