package com.replShell.sandbox.service;

import com.replShell.sandbox.Interface.IcodeAnalisis;
import com.replShell.sandbox.model.Repl;
import com.replShell.sandbox.model.Response;
import jdk.jshell.*;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class codeAnalisis implements IcodeAnalisis {
    public static JShell shell;
//    private AnalisisStatic as;
    private AnalisisStaticAutomatico as;
    public codeAnalisis() {
    /*crea la instancia de Jshell y
    executionEngine imprime los mensajes del entorno de Jshell a la consola local
    mas adelante sera util para obtener los mensajes de impresion de Jshell*/
        shell = JShell.builder().executionEngine("local").build();
//        this.as=AnalisisStatic.getinstancia();
        this.as=AnalisisStaticAutomatico.getinstancia();
    }

    @Override
    public Response onCommandEntered(Repl repl) {
//        Desfragmento del prerrequisito
        List<String> snippetsPre = repl.getPrerequisites().isEmpty() ? null:DesfragmentacionSnippet(repl.getPrerequisites());
//        Desfragmento el codigo
        List<String> snippets = DesfragmentacionSnippet(repl.getCode());
//        mapeo y evaluo el fragmento de codigo
        List<SnippetEvent> listEvent= getListEvent(snippets,snippetsPre);
//      Mando hacer Analisis
        Response as1= as.CodeAnalisis(listEvent,repl);
//        reseteo el entorno para limpiar datos
        limpiarEntorno();
        return as1;
//        return as.CodeAnalisis(listEvent,listVar,idquestion,command,listMethods,listImports);
    }
    public List<SnippetEvent> getListEvent(List<String> snippetsCode,List<String> snippetsPre){
        //ejeucion de codigo en caso de existir prerrequisitos
        if(snippetsPre!=null){
            snippetsPre.stream().map(shell::eval).flatMap(List::stream).collect(Collectors.toList());
        }
        return snippetsCode.stream().map(shell::eval)
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
            //Command restante después del analisis del primer fragmento
            auxCommand = info.remaining();
        }while (auxCommand.length()>0);
        return listSnippets;
    }
    public void limpiarEntorno(){
        shell.stop();
        shell = JShell.builder().executionEngine("local").build();
    }
}
