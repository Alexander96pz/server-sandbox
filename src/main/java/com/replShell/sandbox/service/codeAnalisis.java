package com.replShell.sandbox.service;

import com.replShell.sandbox.Interface.IcodeAnalisis;
import com.replShell.sandbox.model.Response;
import jdk.jshell.*;
import org.springframework.stereotype.Service;
import java.lang.Thread;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class codeAnalisis implements IcodeAnalisis {
    private JShell shell;
    private AnalisisStatic as;
    public codeAnalisis() {
        shell = JShell.create();
        this.as=AnalisisStatic.getinstancia();
    }

    @Override
    public Response onCommandEntered(String command,int idquestion) {
//        Desfragmento el codigo
        List<String> snippets = DesfragmentacionSnippet(command);
//        mapeo y evaluo el fragmento de codigo
        List<SnippetEvent> listEvent= getListEvent(snippets);
//        Listado de todas las variables creadas en el Entorno
        List<VarSnippet> listVar =shell.variables().collect(Collectors.toList());
//        Listado de todas las importaciones creadas en el Entorno
        List<MethodSnippet> listMethods = shell.methods().collect(Collectors.toList());
//        Listado de todas las importaciones creadas en el Entorno
        List<ImportSnippet> listImports = shell.imports().collect(Collectors.toList());
//        reseteo el entorno
        limpiarEntorno();
//        return as.CodeAnalisis(listEvent,listVar,idquestion,command,listMethods,listImports);
        return as.CodeAnalisis(listEvent,listVar,idquestion,command,listMethods,listImports);
    }
    public List<SnippetEvent> getListEvent(List<String> snippets){

        return snippets.stream().map(shell::eval)
                    .flatMap(List::stream)
                    .collect(Collectors.toList());
    }
    /*Metodo para dividir el codigo (String) en fragmentos de codigo y almacenarlos en el lista tipo String*/
    public List<String> DesfragmentacionSnippet(String codigo){
        String auxCommand=codigo;
        List<String> listSnippets = new ArrayList<>();
        SourceCodeAnalysis sca = shell.sourceCodeAnalysis();
        do {
            SourceCodeAnalysis.CompletionInfo info= sca.analyzeCompletion(auxCommand);
            listSnippets.add(info.source());
//            try {
//                Thread.sleep(5000);
//            } catch (Exception e){
//                System.out.println("error");
//            }
            //Command restante después del analisis del primer fragmento
            auxCommand = info.remaining();
        }while (auxCommand.length()>0);
        return listSnippets;
    }
    public void limpiarEntorno(){
        shell.stop();
        shell = JShell.create();
    }
}
