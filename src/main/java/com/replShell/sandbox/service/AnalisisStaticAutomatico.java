package com.replShell.sandbox.service;

import com.replShell.sandbox.model.Repl;
import com.replShell.sandbox.model.Response;
import jdk.jshell.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Collectors;

public class AnalisisStaticAutomatico {
    private static AnalisisStaticAutomatico instancia;
    private AnalisisStaticAutomatico(){}
    public static AnalisisStaticAutomatico getinstancia(){
        if(instancia == null){
            return instancia = new AnalisisStaticAutomatico();
        }
        return instancia;
    }
    public Response CodeAnalisis(List<SnippetEvent> list, Repl repl){
        Response obj_resp = new Response();
//      Valid los fragmentos
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                continue;
            }else{
                return Reject2(obj_resp);
            }
        }
        SnippetEvent snippetEvent=list.get(0);
        String type=snippetEvent.snippet().kind().name();
        switch (type){
            case "METHOD":
                return AnalysisCase1(list,obj_resp,repl);
            case "STATEMENT":
                return AnalysisCase2(list,obj_resp,repl);
            case "VAR":
                return AnalysisCase3(list,obj_resp,repl);
            case "TYPE_DECL":
                return AnalysisCase4(list,obj_resp,repl);
            default:
                return Reject2(obj_resp);
        }
    }
    public Response AnalysisCase1(List<SnippetEvent> list,Response obj_resp,Repl repl) {
        List<MethodSnippet> listMethods = codeAnalisis.shell.methods().collect(Collectors.toList());
        PrintStream previousConsole = System.out;
        ByteArrayOutputStream newConsole = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newConsole));
        List<SnippetEvent> resultadoEjecucion=codeAnalisis.shell.eval(repl.getPosrequisites());
        previousConsole.println(newConsole.toString());
        System.setOut(previousConsole);
        String output=newConsole.toString();
        String typo ="int";
        if(resultadoEjecucion.get(0).status().name().equals("VALID")){
            String valor=repl.getValor();
            String console=repl.getConsole();
            if (!valor.isEmpty()){
                if(resultadoEjecucion.get(0).value().equals(valor)){
                    return Valid(obj_resp);
                }
                return Reject2(obj_resp);
            } else if (!console.isEmpty()) {
                if(output.equals(console+"\n")){
                    return Valid(obj_resp);
                }
                return Reject2(obj_resp);
            }
        }
        return Reject2(obj_resp);
    }
    public Response AnalysisCase2(List<SnippetEvent> list,Response obj_resp,Repl repl) {
        List<MethodSnippet> listMethods = codeAnalisis.shell.methods().collect(Collectors.toList());
        PrintStream previousConsole = System.out;
        ByteArrayOutputStream newConsole = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newConsole));
        List<SnippetEvent> resultadoEjecucion=codeAnalisis.shell.eval(repl.getCode());
        previousConsole.println(newConsole.toString());
        System.setOut(previousConsole);
        String output=newConsole.toString();
        if(resultadoEjecucion.get(0).status().name().equals("VALID")){
            String valor=repl.getValor();
            String console=repl.getConsole();
            if (!valor.isEmpty()){
                if(resultadoEjecucion.get(0).value().equals(valor)){
                    return Valid(obj_resp);
                }
                return Reject2(obj_resp);
            } else if (!console.isEmpty()) {
                if(output.equals(console+"\n")){
                    return Valid(obj_resp);
                }
                return Reject2(obj_resp);
            }
            return Valid(obj_resp);
        }
        return Reject2(obj_resp);
    }
    public Response AnalysisCase3(List<SnippetEvent> list,Response obj_resp,Repl repl) {
        List<MethodSnippet> listMethods = codeAnalisis.shell.methods().collect(Collectors.toList());
        PrintStream previousConsole = System.out;
        ByteArrayOutputStream newConsole = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newConsole));
        List<SnippetEvent> resultadoEjecucion=codeAnalisis.shell.eval(repl.getCode());
        previousConsole.println(newConsole.toString());
        System.setOut(previousConsole);
        String output=newConsole.toString();
        if(resultadoEjecucion.get(0).status().name().equals("VALID")){
            String valor=repl.getValor();
            String console=repl.getConsole();
            if (!valor.isEmpty()){
                if(resultadoEjecucion.get(0).value().equals(valor)){
                    return Valid(obj_resp);
                }
                return Reject2(obj_resp);
            } else if (!console.isEmpty()) {
                if(output.equals(console+"\n")){
                    return Valid(obj_resp);
                }
                return Reject2(obj_resp);
            }
            return Valid(obj_resp);
        }
        return Reject2(obj_resp);
    }
    public Response AnalysisCase4(List<SnippetEvent> list,Response obj_resp,Repl repl) {
        List<MethodSnippet> listMethods = codeAnalisis.shell.methods().collect(Collectors.toList());
        PrintStream previousConsole = System.out;
        ByteArrayOutputStream newConsole = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newConsole));
        List<SnippetEvent> resultadoEjecucion=codeAnalisis.shell.eval(repl.getCode());
        previousConsole.println(newConsole.toString());
        System.setOut(previousConsole);
        String output=newConsole.toString();
        if(resultadoEjecucion.get(0).status().name().equals("VALID")){
            String valor=repl.getValor();
            String console=repl.getConsole();
            if (!valor.isEmpty()){
                if(resultadoEjecucion.get(0).value()!=null){
                    if(resultadoEjecucion.get(0).value().equals(valor)){
                        return Valid(obj_resp);
                    }
                }
                return Reject2(obj_resp);
            } else if (!console.isEmpty()) {
                if(output.equals(console+"\n")){
                    return Valid(obj_resp);
                }
                return Reject2(obj_resp);
            }
            return Valid(obj_resp);
        }
        return Reject2(obj_resp);
    }

    public Response Reject2(Response obj_resp){
        obj_resp.setSource(null);
        obj_resp.setStatus("REJECTED");
        obj_resp.setValue(null);
        obj_resp.setTypeSnippet(null);
        obj_resp.setSubtypeSnippet(null);
        return obj_resp;
    }
    public Response Valid(Response obj_resp){
        obj_resp.setSource(null);
        obj_resp.setStatus("VALID");
        obj_resp.setValue(null);
        obj_resp.setTypeSnippet(null);
        obj_resp.setSubtypeSnippet(null);
        return obj_resp;
    }
}
