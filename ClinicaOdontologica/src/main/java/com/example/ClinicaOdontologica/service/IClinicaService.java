package com.example.ClinicaOdontologica.service;


import java.util.List;

public interface IClinicaService<T> {
    T consultarPorId(Integer id) throws Exception;
    T cadastrar (T t);
    T atualizar (Integer id, T t);
    void excluirPorId (Integer id);
    List<T> findAll();
}
