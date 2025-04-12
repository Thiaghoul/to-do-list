package com.thiaghoul.to_do_list.repositories;

import com.thiaghoul.to_do_list.entities.Tarefa;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

}
