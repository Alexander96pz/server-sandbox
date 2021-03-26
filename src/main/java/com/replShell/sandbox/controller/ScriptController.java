package com.replShell.sandbox.controller;

import com.replShell.sandbox.model.Repl;
import com.replShell.sandbox.service.servicio;
import com.replShell.sandbox.usecase.codeAnalisis;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/code")
public class ScriptController {

    @PostMapping("/scripts")
    public String analizar(@RequestBody Repl repl) {
        servicio objservicio= new codeAnalisis();
        return objservicio.onCommandEntered(repl.getCode());
    }

}
