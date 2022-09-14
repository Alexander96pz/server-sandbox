package com.replShell.sandbox.controller;

import com.replShell.sandbox.model.Repl;
import com.replShell.sandbox.Interface.IcodeAnalisis;
import com.replShell.sandbox.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.stream.Stream;

@RestController
@RequestMapping("/script")
public class ScriptController {
    @Autowired
    private IcodeAnalisis code;

    @PostMapping
    public Response analizarScript(@RequestBody Repl repl) {
        return code.onCommandEntered(repl);
    }
}
