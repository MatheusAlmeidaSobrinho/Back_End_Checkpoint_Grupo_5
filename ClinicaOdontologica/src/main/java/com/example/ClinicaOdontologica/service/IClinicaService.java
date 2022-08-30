package com.example.ClinicaOdontologica.service;

// serve para paciente, dentista e consulta (para login acredito que vai ser criado uma nova interface)
public interface IClinicaService<T> {
    T consultarPorId(int id); // possiveis variações por nome, endereço, consulta ...
    T cadastrar (T t);
    T atualizar (T t);
    T excluirPorId (int id); // possiveis variações...
}
