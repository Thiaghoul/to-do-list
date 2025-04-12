package com.thiaghoul.to_do_list.services;

import com.thiaghoul.to_do_list.entities.Tarefa;
import com.thiaghoul.to_do_list.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository repository;

    public Tarefa insert(Tarefa tarefa){
        return repository.save(tarefa);
    }

    public List<Tarefa> getAllTarefa(){
        return repository.findAll();
    }

    public Optional<Tarefa> getById(Long id){
        return repository.findById(id);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public Tarefa updateById(Long id, Tarefa newTarefa){
        Tarefa oldTarefa = repository.getReferenceById(id);
        updateDados(oldTarefa, newTarefa);
        return repository.save(oldTarefa);
    }

    private void updateDados(Tarefa antiga, Tarefa nova){
        antiga.setTitulo(nova.getTitulo());
        antiga.setDescricao(nova.getDescricao());
        antiga.setData(nova.getData());
        antiga.setStatus(nova.getStatus());
    }

}
