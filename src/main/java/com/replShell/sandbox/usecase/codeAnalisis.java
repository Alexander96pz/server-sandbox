package com.replShell.sandbox.usecase;

import com.replShell.sandbox.service.servicio;
import jdk.jshell.JShell;
import jdk.jshell.SnippetEvent;

import java.util.List;
import java.util.Scanner;

public class codeAnalisis implements servicio {
    private JShell shell;
    private SnippetResolver snippetResolver;

    public codeAnalisis() {
        snippetResolver = new SnippetResolver();
        shell = JShell.create();
    }

    @Override
    public String onCommandEntered(String command) {
        return
            shell.eval(command).stream()
                .map(snippetResolver::resolve)
                .reduce((prev, current) -> prev + "\n" + current)
                .orElse("Invalid command");
//                shell.eval(command);

    }
}
