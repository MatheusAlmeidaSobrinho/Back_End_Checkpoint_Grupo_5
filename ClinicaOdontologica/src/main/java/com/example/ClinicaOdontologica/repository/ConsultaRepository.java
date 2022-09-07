package com.example.ClinicaOdontologica.repository;

import com.example.ClinicaOdontologica.entity.Consulta;
import com.example.ClinicaOdontologica.entity.dto.ConsultaDTO;
import org.jetbrains.annotations.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {

}
