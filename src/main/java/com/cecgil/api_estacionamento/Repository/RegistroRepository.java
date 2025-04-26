package com.cecgil.api_estacionamento.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cecgil.api_estacionamento.Entities.Registro;

public interface RegistroRepository extends JpaRepository<Registro, Long> {

    Optional<Registro> findByPlacaAndSaidaIsNull(String placa);
    
}
