package com.replShell.sandbox.service;

import com.replShell.sandbox.Interface.IcodeAnalisis;
import com.replShell.sandbox.model.Response;
import jdk.jshell.JShell;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class codeAnalisis implements IcodeAnalisis {
    private JShell shell;
    private SnippetResolver snippetResolver;

    public codeAnalisis() {
        snippetResolver = new SnippetResolver();
        shell = JShell.create();
    }

    @Override
    public Stream<Response> onCommandEntered(String command) {
        Stream <Response> obj = shell.eval(command).stream()
                .map(snippetResolver::resolve);
//                .reduce((prev, current) -> prev + "\n" + current)
//                .orElse("Invalid command");
        return obj;
    }
}
