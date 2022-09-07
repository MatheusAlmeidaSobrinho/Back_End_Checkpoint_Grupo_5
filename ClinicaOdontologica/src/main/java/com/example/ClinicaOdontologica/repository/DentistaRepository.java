package com.example.ClinicaOdontologica.repository;

import com.example.ClinicaOdontologica.entity.Dentista;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public interface DentistaRepository extends JpaRepository<Dentista, Integer> {

}
