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
    public ResponseEntity<List<Tarefa>> findAll(){
        List<Tarefa> list = service.getAllTarefa();
        if(list.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok().body(list);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Tarefa>> findById(@PathVariable Long id){
        Optional<Tarefa> tarefa = service.getById(id);
        if(tarefa.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok().body(tarefa);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public Tarefa update(@PathVariable Long id, @RequestBody Tarefa tarefa){
        tarefa = service.updateById(id, tarefa);
        return tarefa;
    }




}
