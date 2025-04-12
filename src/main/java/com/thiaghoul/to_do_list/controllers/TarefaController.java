package com.thiaghoul.to_do_list.controllers;

import com.thiaghoul.to_do_list.entities.Tarefa;
import com.thiaghoul.to_do_list.services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

    @Autowired
    private TarefaService service;

    @PostMapping()
    public Tarefa insert(@RequestBody Tarefa tarefa){
        return service.insert(tarefa);
    }

    @GetMapping
    public List<Tarefa> findAll(){
         return service.getAllTarefa();
    }

    @GetMapping(value = "/{id}")
    public Optional<Tarefa> findById(@PathVariable Long id){
        return service.getById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }

    @PutMapping(value = "/{id}")
    public Tarefa update(@PathVariable Long id, @RequestBody Tarefa tarefa){
        tarefa = service.updateById(id, tarefa);
        return tarefa;
    }




}
