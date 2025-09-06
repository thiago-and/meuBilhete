package com.meubilhete.MeuBilhete;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BilheteService {

    private BilheteRepository repository;

    public BilheteService(BilheteRepository repository){
        this.repository = repository;
    }
    
    @Transactional
    public Bilhete salvarBilhete(BilheteRequest bilhete){

        Bilhete novoBilhete = new Bilhete();
        novoBilhete.setConcurso(bilhete.concurso());
        novoBilhete.setDezenas(bilhete.dezenas());
        return repository.save(novoBilhete);

    }

    public List<Bilhete> listarBilhetes(){
        return repository.findAll();
    }
    
    public Bilhete detalharBilhete(Long id){
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public Boolean deletarBilhete(Long id){
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Transactional
    public Boolean atualizarBilhete(Long id, BilheteRequest dto){
        
        Bilhete bilhete = repository.findById(id).orElse(null);

        if (bilhete == null) {
            return false;
        }

        if(dto.concurso() != null) { bilhete.setConcurso(dto.concurso()); }
        if(dto.dezenas() != null) { bilhete.setDezenas(dto.dezenas()); }

        return true;
    }
}
