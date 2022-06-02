package com.replShell.sandbox.service;

import com.replShell.sandbox.model.Response;
import jdk.jshell.SnippetEvent;


import java.util.List;
import java.util.Objects;
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
                return AnalysisCase1(list);
            case 2:
//                caso 3
                return AnalysisCase2(list,listV,command);
            case 3:
//                caso 4:
                return AnalysisCase4(list,listV,command);
            case 4:
//                caso 5:
                return AnalysisCase5(list,listV,command);
            case 5:
//                caso 6:
                return AnalysisCase6(list,listV,command);
            case 7:
//                caso 8:
                return AnalysisCase8(list,listV,command);
            case 8:
//                caso 9:
                return AnalysisCase9(list,listV,command);
            case 9:
//                caso 10:
                return AnalysisCase10(list,listV,command);
//           id con su caso iguales
            case 12:
//                caso 12:
                return AnalysisCase12(list,listV,command);
            default:
                Response obj_resp=new Response();
                return Reject2(obj_resp);
        }
    }
    public Response AnalysisCase1(List<SnippetEvent> list){
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
    public Response AnalysisCase2(List<SnippetEvent> list,List<VarSnippet> listV,String command){
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
    public Response AnalysisCase4(List<SnippetEvent> list,List<VarSnippet> listV,String command){
        Response obj_resp = new Response();
        if(listV.size()==1){
            for (VarSnippet vs:listV){
                System.out.println(vs.typeName());
                if ("VAR".equals(vs.kind().name()) && "int".equals(vs.typeName())){
                    for (SnippetEvent snippet : list) {
                        Pattern pat = Pattern.compile("^\\s*(System.out.println)\\s*\\(\\s*"+vs.name()+"\\s*\\)\\s*\\;?\\s*$");
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
    public Response AnalysisCase5(List<SnippetEvent> list,List<VarSnippet> listV,String command){
        Response obj_resp = new Response();
        boolean valid=false;
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                continue;
            }else{
                return Reject2(obj_resp);
            }
        }
            if(listV.size()==2){
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
                        return Valid(obj_resp);
                    }else{
                        Reject2(obj_resp);
                    }

            } else {
                return Reject2(obj_resp);
            }
//        }
        return Reject2(obj_resp);
    }
//    case 6
    public Response AnalysisCase6(List<SnippetEvent> list,List<VarSnippet> listV,String command){
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
//    case 8
//    System.out.println(10 * 5);
    public Response AnalysisCase8(List<SnippetEvent> list,List<VarSnippet> listV,String command){
        Response obj_resp = new Response();
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                continue;
            }else{
                return Reject2(obj_resp);
            }
        }
        boolean valid = false;
        if(list.size()==1){
            for(SnippetEvent snippet : list){
                Pattern pat = Pattern.compile("^\\s*(System.out.println)\\s*\\(\\s*10\\s*\\*\\s*5\\s*\\)\\s*\\;?\\s*$");
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
            }else{
                return Reject2(obj_resp);
            }
        }else{
            return Reject2(obj_resp);
        }
    }
//    case 9
    public Response AnalysisCase9(List<SnippetEvent> list,List<VarSnippet> listV,String command){
        Response obj_resp = new Response();
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                continue;
            }else{
                return Reject2(obj_resp);
            }
        }
        boolean valid = false;
        if(list.size()==1){
            for(SnippetEvent snippet : list){
                Pattern pat = Pattern.compile("^\\s*(System.out.println)\\s*\\(\\s*10\\s*\\/\\s*5\\s*\\)\\s*\\;?\\s*$");
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
            }else{
                return Reject2(obj_resp);
            }
        }else{
            return Reject2(obj_resp);
        }
    }
    public Response AnalysisCase10(List<SnippetEvent> list,List<VarSnippet> listV,String command){
        Response obj_resp = new Response();
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                continue;
            }else{
                return Reject2(obj_resp);
            }
        }
        boolean valid=false;
        String i;
        if(listV.size()==2){
            for(VarSnippet varSnippet:listV){
                if("x".equals(varSnippet.name())){
                    valid=true;
                }
            }
            if(valid){
                for(SnippetEvent snippet:list){
                    if(snippet.value().equals("10")){
                        continue;
                    } else if (snippet.value().equals("11") && snippet.snippet().source().contains("++")) {
                        continue;
                    }else {
                        return Reject2(obj_resp);
                    }
                }
                return Valid(obj_resp);
            }
        }else{
            return Reject2(obj_resp);
        }
        return Reject2(obj_resp);
//        boolean valid = false;
//        if(list.size()==2){
//            for(SnippetEvent snippet : list){
//                Pattern pat = Pattern.compile("^\\s*(System.out.println)\\s*\\(\\s*10\\s*\\/\\s*5\\s*\\)\\s*\\;?\\s*$");
//                Matcher mat = pat.matcher(snippet.snippet().source());
//                if (mat.matches()) {
//                    valid=true;
//                }
//            }
//            if (valid){
//                obj_resp.setSource(command);
//                obj_resp.setStatus("VALID");
//                obj_resp.setValue(null);
//                obj_resp.setTypeSnippet(null);
//                obj_resp.setSubtypeSnippet(null);
//                return obj_resp;
//            }else{
//                return Reject2(obj_resp);
//            }
//        }else{
//            return Reject2(obj_resp);
//        }
    }
//    case 12
    public Response AnalysisCase12(List<SnippetEvent> list,List<VarSnippet> listV,String command){
        Response obj_resp=new Response();
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                continue;
            }else{
                return Reject2(obj_resp);
            }
        }
        String x=null;
        if(listV.size()==1){
            for (VarSnippet varSnippet:listV){
                if(varSnippet.typeName().equals("String")){
                    x=varSnippet.name();
                }else {Reject2(obj_resp);}

            }
            if(x!=null){
                boolean valid=false;
                for (SnippetEvent snippetEvent:list){
                    if(snippetEvent.snippet().source().contains(x+".toUpperCase()")){
                        valid=true;
                    }
                }
                if (valid){
                    return Valid(obj_resp);
                }
                return Reject2(obj_resp);
            }

        }else {
            return Reject2(obj_resp);
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
    public Response Valid(Response obj_resp){
        obj_resp.setSource(null);
        obj_resp.setStatus("VALID");
        obj_resp.setValue(null);
        obj_resp.setTypeSnippet(null);
        obj_resp.setSubtypeSnippet(null);
        return obj_resp;
    }

}
