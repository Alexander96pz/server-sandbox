package com.replShell.sandbox.service;

import com.replShell.sandbox.model.Response;
import jdk.jshell.SnippetEvent;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jdk.jshell.VarSnippet;

public class AnalisisStatic {

    private static AnalisisStatic instancia;
    private AnalisisStatic(){}
    public static AnalisisStatic getinstancia(){
        if(instancia == null){
            return instancia = new AnalisisStatic();
        }
        return instancia;
    }
    public Response CodeAnalisis(List<SnippetEvent> list, List<VarSnippet>listV, int idcode,String command){
        switch (idcode){
            case 1:
//                caso 1
                return AnalisisCode1(list);
            case 2:
//                caso 3
                return AnalisisCode2(list,listV,command);
            case 3:
//                caso 4:
                return AnalisisCode4(list,listV,command);
            case 4:
//                caso 5:
                return AnalisisCode5(list,listV,command);
            case 5:
//                caso 6:
                return AnalisisCode6(list,listV,command);
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
                            Pattern pat = Pattern.compile("^\\s*(System.out.println)\\s*\\(\\s*(\"Hello World\")\\s*\\)\\s*\\;?\\s*$");
                            Matcher mat = pat.matcher(snippet.snippet().source());
                            if (mat.matches()) {
                                obj_resp.setSource(snippet.snippet().source());
                                obj_resp.setStatus("VALID");
                                obj_resp.setValue(snippet.value());
                                obj_resp.setTypeSnippet(snippet.snippet().kind().name());
                                obj_resp.setSubtypeSnippet(snippet.snippet().subKind().name());
                                return obj_resp;
                            } else{
                                return Reject(obj_resp,snippet);
                            }
                        }else{
                            return Reject(obj_resp,snippet);
                        }
                    }else{
                        return Reject(obj_resp,snippet);
                    }
                }else{
                    return Reject(obj_resp,snippet);
                }
        }
        return obj_resp;
    }
    public Response AnalisisCode2(List<SnippetEvent> list,List<VarSnippet> listV,String command){
        Response obj_resp = new Response();
        if(listV.size()==1){
            for (VarSnippet vs:listV){
                if ("VAR".equals(vs.kind().name()) && "String".equals(vs.typeName())){
                    for (SnippetEvent snippet : list) {
                        Pattern pat = Pattern.compile("^\\s*(System.out.println)\\s*\\(\\s*"+vs.name()+"\\s*\\)\\s*\\;?\\s*$");
                        Matcher mat = pat.matcher(snippet.snippet().source());
                        System.out.println(mat.find());
                        if(mat.matches()){
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
                }else{
                    return Reject2(obj_resp);
                }
            }
        }
        return Reject2(obj_resp);
    }
    public Response AnalisisCode4(List<SnippetEvent> list,List<VarSnippet> listV,String command){
        Response obj_resp = new Response();
        if(listV.size()==1){
            for (VarSnippet vs:listV){
                if ("VAR".equals(vs.kind().name()) && "int".equals(vs.typeName())){
                    for (SnippetEvent snippet : list) {
                        Pattern pat = Pattern.compile("^\\s*(System.out.println)\\s*\\(\\s*"+vs.name()+"\\s*\\)\\s*\\;\\s*?$");
                        Matcher mat = pat.matcher(snippet.snippet().source());
                        if(mat.matches()){
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
                }else{
                    return Reject2(obj_resp);
                }
            }
        }
//        boolean S = listV.stream().filter(x-> "name")
        return Reject2(obj_resp);

    }
    public Response AnalisisCode5(List<SnippetEvent> list,List<VarSnippet> listV,String command){
        Response obj_resp = new Response();
        boolean valid=false;
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                valid=true;
            }else{
                return Reject2(obj_resp);
            }
        }
        if(valid){
            if(listV.size()==2){
//                int cont=0;
                for (VarSnippet vs:listV){
                    if ("VAR".equals(vs.kind().name()) && "int".equals(vs.typeName())){
                        continue;
                    }else{
                        return Reject2(obj_resp);
                    }
                }

                    int suma=0;
                    boolean valid1 =false;
                    boolean valid2 =false;
                    for (SnippetEvent snippet : list) {
                        Pattern pat = Pattern.compile("^\\s*(System.out.println)\\s*\\(\\s*[xy]\\s*\\+\\s*[yx]\\s*\\)\\s*\\;?\\s*$");
                        Matcher mat = pat.matcher(snippet.snippet().source());
                        if(mat.matches() && snippet.snippet().source().contains("x") && snippet.snippet().source().contains("y")){
                            System.out.println(snippet.snippet().source());
                            System.out.println(snippet.snippet().source().contains("y"));
                            System.out.println(snippet.snippet().source().contains("x"));
                            System.out.println(mat.matches());
                            valid2=true;
                        } else  if(snippet.value()==""){
                            continue;
                        } else {
                            suma=suma+Integer.parseInt(snippet.value()) ;
                        }
                    }
                    if(suma == 15){
                        valid1=true;
                    }else {
                        Reject2(obj_resp);
                    }
                    if(valid1 && valid2){
                        obj_resp.setSource(command);
                        obj_resp.setStatus("VALID");
                        obj_resp.setValue(null);
                        obj_resp.setTypeSnippet(null);
                        obj_resp.setSubtypeSnippet(null);
                        return obj_resp;
                    }else{
                        Reject2(obj_resp);
                    }

            } else {
                return Reject2(obj_resp);
            }
        }
        return Reject2(obj_resp);
    }
//    case 6
    public Response AnalisisCode6(List<SnippetEvent> list,List<VarSnippet> listV,String command){
        Response obj_resp = new Response();
        boolean valid=false;
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                valid=true;
            }else{
                return Reject2(obj_resp);
            }
        }
        if(valid){
            if(listV.size() == 3){
                for(VarSnippet var:listV){
                    if ( var.name().equals("x")){
                        continue;
                    }else if(var.name().equals("y")){
                        continue;
                    } else if (var.name().equals("z")) {
                        if(var.source().contains("=") && var.source().contains("x") && var.source().contains("+") && var.source().contains("y")){
                            continue;
                        }else{
                            return Reject2(obj_resp);
                        }
                    }else {
                        return Reject2(obj_resp);
                    }
                }
                valid=false;
                for (SnippetEvent snippet : list) {
//                    Patron para la impresion
                    Pattern pat = Pattern.compile("^\\s*(System.out.println)\\s*\\(\\s*z\\s*\\)\\s*\\;?\\s*$");
                    Matcher mat = pat.matcher(snippet.snippet().source());
                    if (mat.matches()) {
                        valid=true;
                    }
                }
                if (valid){
                    obj_resp.setSource(command);
                    obj_resp.setStatus("VALID");
                    obj_resp.setValue(null);
                    obj_resp.setTypeSnippet(null);
                    obj_resp.setSubtypeSnippet(null);
                    return obj_resp;
                }
                return Reject2(obj_resp);
            }else{
                Reject2(obj_resp);
            }
        }else {
            Reject2(obj_resp);
        }
        return Reject2(obj_resp);
    }
    public Response Reject(Response obj_resp,SnippetEvent snippet){
        obj_resp.setSource(snippet.snippet().source());
        obj_resp.setStatus("REJECTED");
        obj_resp.setValue(snippet.value());
        obj_resp.setTypeSnippet(snippet.snippet().kind().name());
        obj_resp.setSubtypeSnippet(snippet.snippet().subKind().name());
        return obj_resp;
    }
    public Response Reject2(Response obj_resp){
        obj_resp.setSource(null);
        obj_resp.setStatus("REJECTED");
        obj_resp.setValue(null);
        obj_resp.setTypeSnippet(null);
        obj_resp.setSubtypeSnippet(null);
        return obj_resp;
    }

}
