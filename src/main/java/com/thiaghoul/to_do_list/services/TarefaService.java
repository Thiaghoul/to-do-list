package com.thiaghoul.to_do_list.services;

import com.thiaghoul.to_do_list.entities.Tarefa;
import com.thiaghoul.to_do_list.entities.enums.Status;
import com.thiaghoul.to_do_list.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository repository;

    public Optional<Tarefa> insert(Tarefa tarefa){
        if(tarefa.getTitulo() == null || tarefa.getData() == null ){
            return Optional.empty();

        }
        if(tarefa.getStatus() == null){
            tarefa.setStatus(Status.afazer);
        }
        return Optional.of(repository.save(tarefa));
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

    public Optional<Tarefa> updateById(Long id, Tarefa newTarefa){
        Tarefa oldTarefa = repository.getReferenceById(id);
        updateDados(oldTarefa, newTarefa);

        return Optional.of(repository.save(oldTarefa));
    }

    private void updateDados(Tarefa antiga, Tarefa nova){
        if(nova.getTitulo() != null){
            antiga.setTitulo(nova.getTitulo());
        }
        if(nova.getDescricao() != null){
            antiga.setDescricao(nova.getDescricao());
        }
        if(nova.getData() != null){
            antiga.setData(nova.getData());
        }
        if(nova.getStatus() != null){
            antiga.setStatus(nova.getStatus());
        }
    }

}
