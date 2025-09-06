package com.meubilhete.MeuBilhete;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bilhete")
public class BilheteController {

    private BilheteService service;

    public BilheteController(BilheteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Bilhete> cadastrar(@Valid @RequestBody BilheteRequest dto) {
        Bilhete retorno = service.salvarBilhete(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(retorno);
    }

    @GetMapping
    public ResponseEntity<List<Bilhete>> listar() {
        List<Bilhete> lista = service.listarBilhetes();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bilhete> detalhar(@PathVariable("id") Long id) {
        Bilhete bilhete = service.detalharBilhete(id);
        if (bilhete == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bilhete);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        Boolean deletado = service.deletarBilhete(id);
        if (!deletado){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable("id") Long id,
                                @Valid @RequestBody BilheteRequest dto ) {
        Boolean atualizado = service.atualizarBilhete(id,dto);
        if (!atualizado){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

   
}
