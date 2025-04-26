package com.cecgil.api_estacionamento.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Registro> entrada(@RequestBody String placa) {
        var result =  this.registroService.registrarEntrada(placa);
        return ResponseEntity.ok().body(result);


    }

    @PostMapping("/saida")
    public ResponseEntity<Registro> saida(@RequestBody String placa) {
        var result = this.registroService.registrarSaida(placa);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping
    public List<Registro> listar() {
        return registroService.listarTodos();
    }
    
    


    
}
