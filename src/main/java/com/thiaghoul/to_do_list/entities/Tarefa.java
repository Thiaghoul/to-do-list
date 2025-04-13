package com.thiaghoul.to_do_list.entities;

import com.thiaghoul.to_do_list.entities.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Getter
@Setter
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = true)
    private String descricao;

    @Column(nullable = false)
    private Date data;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    public Tarefa(){}



}
