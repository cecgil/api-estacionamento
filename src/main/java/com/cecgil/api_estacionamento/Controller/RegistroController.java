package com.cecgil.api_estacionamento.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cecgil.api_estacionamento.Entities.Registro;
import com.cecgil.api_estacionamento.Services.RegistroService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/estacionamento")
public class RegistroController {

    @Autowired
    private RegistroService registroService;

    @PostMapping("/entrada")
    public Registro entrada(@RequestBody String placa) {
        return registroService.registrarEntrada(placa);
    }

    @PostMapping("/saida")
    public Registro saida(@RequestBody String placa) {
        return registroService.registrarSaida(placa);
    }

    @GetMapping
    public List<Registro> listar() {
        return registroService.listarTodos();
    }
    
    


    
}
