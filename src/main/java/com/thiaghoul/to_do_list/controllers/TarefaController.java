package com.thiaghoul.to_do_list.controllers;

import com.thiaghoul.to_do_list.services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TarefaController {

    @Autowired
    TarefaService service;

}
