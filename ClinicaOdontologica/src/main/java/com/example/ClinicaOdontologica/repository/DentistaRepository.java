package com.example.ClinicaOdontologica.repository;

import com.example.ClinicaOdontologica.entity.Dentista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface DentistaRepository extends JpaRepository<Dentista, Integer> {

    Optional<Dentista> findByEmail(String email);
}
