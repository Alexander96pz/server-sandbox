package com.replShell.sandbox.service;

import com.replShell.sandbox.Interface.IcodeAnalisis;
import com.replShell.sandbox.model.Response;
import jdk.jshell.JShell;
import jdk.jshell.SnippetEvent;
import jdk.jshell.SourceCodeAnalysis;
import jdk.jshell.VarSnippet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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
    public Response onCommandEntered(String command,int idquestion) {
        String command2=command;
        SourceCodeAnalysis sca = shell.sourceCodeAnalysis();
        //lista donde almacenaremos todos los fragmentos de codigo
        List<String> snippets = new ArrayList<>();
        //bucle para dividir el command (String) en fragmentos de codigo y almacenarlos en el lista snippets
        do {
            SourceCodeAnalysis.CompletionInfo info= sca.analyzeCompletion(command);
            snippets.add(info.source());
            //Command restante después del analisis del primer fragmento
            command = info.remaining();
        }while (command.length()>0);
        List<SnippetEvent> listEvent = snippets.stream().map(shell::eval)
                .flatMap(List::stream).collect(Collectors.toList());
        AnalisisStatic as=new AnalisisStatic();
        List<VarSnippet> listVar = shell.variables().collect(Collectors.toList());
        return as.CodeAnalisis(listEvent,listVar,idquestion,command2);
//        Stream <Response> obj = shell.eval(command).stream()
//                .map(snippetResolver::resolve);
//                .reduce((prev, current) -> prev + "\n" + current)
//                .orElse("Invalid command");
    }
}
