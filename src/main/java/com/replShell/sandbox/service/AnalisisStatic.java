package com.replShell.sandbox.service;

import com.replShell.sandbox.model.Response;
import jdk.jshell.SnippetEvent;
import java.util.List;
import jdk.jshell.JShell;
import jdk.jshell.VarSnippet;

public class AnalisisStatic {


    public Response CodeAnalisis(List<SnippetEvent> list, List<VarSnippet>listV, int idcode,String command){
        switch (idcode){
            case 1:
                return AnalisisCode1(list);
            case 3:
                return AnalisisCode3(list,listV,command);
            default:
                throw new IllegalStateException("Analisis de Codigo no existente: " + idcode);
        }
    }
    public Response AnalisisCode1(List<SnippetEvent> list){
        Response obj_resp = new Response();
            for (SnippetEvent snippet:list) {
                if (snippet.status().name() == "VALID"){
                    if( snippet.snippet().kind().name()=="STATEMENT"){
                        if(list.size()==1) {
                            if (snippet.snippet().source().contains("System.out.print") && snippet.snippet().source().contains("\"Hola Mundo\"")) {
                                obj_resp.setSource(snippet.snippet().source());
                                obj_resp.setStatus("VALID");
                                obj_resp.setValue(snippet.value());
                                obj_resp.setTypeSnippet(snippet.snippet().kind().name());
                                obj_resp.setSubtypeSnippet(snippet.snippet().subKind().name());
                            }else{
                                obj_resp=Reject(obj_resp,snippet);
                            }
                        }else{
                            obj_resp=Reject(obj_resp,snippet);
                        }
                    }else{
                        obj_resp=Reject(obj_resp,snippet);
                    }
                }else{
                    obj_resp=Reject(obj_resp,snippet);
                }
            }
        return obj_resp;
    }
    public Response AnalisisCode3(List<SnippetEvent> list,List<VarSnippet> listV,String command){
        Response obj_resp = new Response();
        boolean validatorVariables=false;
        String nameVariable=null;
        if(listV.size()==1){
            for (VarSnippet vs:listV){
                if ("VAR".equals(vs.kind().name()) && "String".equals(vs.typeName())){
                    validatorVariables=true;
                    nameVariable=vs.name();
                }
            }
        }
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID") && snippet.snippet().source().contains("System.out.println") && snippet.snippet().source().contains(nameVariable) && validatorVariables == true){
                obj_resp.setSource(command);
                obj_resp.setStatus("VALID");
                obj_resp.setValue(snippet.value());
                obj_resp.setTypeSnippet(snippet.snippet().kind().name());
                obj_resp.setSubtypeSnippet(snippet.snippet().subKind().name());
                return obj_resp;
            }else if(snippet.status().name().equals("REJECTED")){
                return Reject(obj_resp,snippet);
            }
        }
//        boolean S = listV.stream().filter(x-> "name")
        return obj_resp;
    }

    public Response Reject(Response obj_resp,SnippetEvent snippet){
        obj_resp.setSource(snippet.snippet().source());
        obj_resp.setStatus("REJECT");
        obj_resp.setValue(snippet.value());
        obj_resp.setTypeSnippet(snippet.snippet().kind().name());
        obj_resp.setSubtypeSnippet(snippet.snippet().subKind().name());
        return obj_resp;
    }
}
