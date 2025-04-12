package com.thiaghoul.to_do_list.entities;

import com.thiaghoul.to_do_list.entities.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Tarefa {

    @Id
    private long id;

    private String titulo;

    private String descricao;

    private Date data;

    private Status status;



}
