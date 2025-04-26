package com.cecgil.api_estacionamento.Services;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cecgil.api_estacionamento.Entities.Registro;
import com.cecgil.api_estacionamento.Repository.RegistroRepository;

@Service
public class RegistroService {

    @Autowired
    private RegistroRepository registroRepository;

    public Registro registrarEntrada(String placa) {
        Registro registro = new Registro();
        registro.setEntrada(LocalDateTime.now());
        registro.setPlaca(placa);
        return registroRepository.save(registro);
    }

    public Registro registrarSaida(String placa) {
        Optional<Registro> opt = registroRepository.findByPlacaAndSaidaIsNull(placa);
        if(opt.isPresent()) {
            Registro registro = opt.get();
            registro.setSaida(LocalDateTime.now());
            long minutos = Duration.between(registro.getEntrada(), registro.getSaida()).toMinutes();
            double valor = Math.ceil(minutos / 15.0) * 2.0; // Ex: R$2 a cada 15 min
            registro.setValor(valor);
            return registroRepository.save(registro);
        }

        throw new RuntimeException("Registro de entrada não encontrado.");
    }

    public List<Registro> listarTodos() {
        return registroRepository.findAll();
    } 
    
}
