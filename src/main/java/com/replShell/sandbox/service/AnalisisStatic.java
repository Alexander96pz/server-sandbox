package com.replShell.sandbox.service;

import com.replShell.sandbox.model.Response;
import jdk.jshell.MethodSnippet;
import jdk.jshell.SnippetEvent;


import java.io.PrintStream;
import java.util.ArrayList;
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
    public Response CodeAnalisis(List<SnippetEvent> list, List<VarSnippet>listV, int idcode,String command,List<MethodSnippet>listMethods){
        switch (idcode){
            case 1:
                return AnalysisCase1(list);
            case 3:
                return AnalysisCase3(list,listV,command);
            case 4:
                return AnalysisCase4(list,listV,command);
            case 5:
                return AnalysisCase5(list,listV,command);
            case 6:
                return AnalysisCase6(list,listV,command);
            case 7:
                return AnalysisCase7(list,listV,command);
            case 8:
                return AnalysisCase8(list,listV,command);
            case 9:
                return AnalysisCase9(list,listV,command);
            case 10:
                return AnalysisCase10(list,listV,command);
            case 11:
                return AnalysisCase11(list,listV,command);
            case 12:
                return AnalysisCase12(list,listV,command);
            case 13:
                return AnalysisCase13(list,listV,command);
            case 14:
                return AnalysisCase14(list,listV,command);
            case 15:
                return AnalysisCase15(list,listV,command);
            case 16:
                return AnalysisCase16(list,listV,command);
            case 17:
                return AnalysisCase17(list,listV,command);
            case 18:
                return AnalysisCase18(list,listV,command);
            case 19:
                return AnalysisCase19(list,listV,command);
            case 20:
                return AnalysisCase20(list,listV,command);
            case 21:
                return AnalysisCase21(list,listV,command);
            case 22:
                return AnalysisCase22(list,listV,command);
            case 23:
                return AnalysisCase23(list,listV,command);
            case 24:
                return AnalysisCase24(list,listV,command);
            case 25:
                return AnalysisCase25(list,listV,command);
            case 26:
                return AnalysisCase26(list,listV,command);
            case 27:
                return AnalysisCase27(list,listV,command);
            case 28:
                return AnalysisCase28(list,listV,command);
            case 29:
                return AnalysisCase29(list,listV,command);
            case 30:
                return AnalysisCase30(list,listV,command);
            case 31:
                return AnalysisCase31(list,listV,command);
            case 32:
                return AnalysisCase32(list,listV,command);
            case 33:
                return AnalysisCase33(list,listV,command);
            case 34:
                return AnalysisCase34(list,listV,command);
            case 35:
                return AnalysisCase35(list,listV,command);
            case 36:
                return AnalysisCase36(list,listV,command);
            case 37:
                return AnalysisCase37(list,listV,command);
            case 38:
                return AnalysisCase38(list,listV,command);
            case 39:
                return AnalysisCase39(list,listV,command);
            case 40:
                return AnalysisCase40(list,listV,listMethods);
            case 41:
                return AnalysisCase41(list,listV,listMethods);
            case 42:
                return AnalysisCase42(list,listV,listMethods);
            case 43:
                return AnalysisCase43(list,listV,listMethods);
            case 44:
                return AnalysisCase44(list,listV,listMethods);
            case 45:
                return AnalysisCase45(list,listV,listMethods);
            case 46:
                return AnalysisCase46(list,listV,listMethods);
            case 47:
                return AnalysisCase47(list,listV,listMethods);
            case 48:
                return AnalysisCase48(list,listV,listMethods);
            case 49:
                return AnalysisCase49(list,listV,listMethods);
            case 50:
                return AnalysisCase50(list,listV,listMethods);
            case 51:
                return AnalysisCase51(list,listV,listMethods);
            case 52:
                return AnalysisCase52(list,listV,listMethods);
            case 53:
                return AnalysisCase53(list,listV,listMethods);
            case 54:
                return AnalysisCase54(list,listV,listMethods);
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
    public Response AnalysisCase3(List<SnippetEvent> list,List<VarSnippet> listV,String command){
        Response obj_resp = new Response();
        if(listV.size()==1){
            for (VarSnippet vs:listV){
                if ("VAR".equals(vs.kind().name()) && "String".equals(vs.typeName())){
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
    public Response AnalysisCase7(List<SnippetEvent> list,List<VarSnippet> listV,String command){
        Response obj_resp = new Response();
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                continue;
            }else{
                return Reject2(obj_resp);
            }
        }
        if(list.size() == 3){
            if (listV.size() == 3) {
                String typevariable=listV.get(0).typeName();
                for (VarSnippet varSnippet:listV){
                    if(varSnippet.typeName().equals(typevariable)){
                        continue;
                    }else {
                        return Reject2(obj_resp);
                    }
                }
                for (SnippetEvent snippetEvent:list){
                    if(snippetEvent.snippet().source().contains(",")){
                        continue;
                    }else {
                        return Reject2(obj_resp);
                    }
                }
                return Valid(obj_resp);
            }else{
                return Reject2(obj_resp);
            }
        }
        return Reject2(obj_resp);
    }
//    case 8
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
                Pattern pat = Pattern.compile("^\\s*(System.out.println)\\s*\\(\\s*\\d+\\s*\\/\\s*\\d+\\s*\\)\\s*\\;?\\s*$");
                Matcher mat = pat.matcher(snippet.snippet().source());
                if (mat.matches()) {
                    valid=true;
                }
            }
            if (valid){
                return Valid(obj_resp);
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
    }
    public Response AnalysisCase11(List<SnippetEvent> list,List<VarSnippet> listV,String command){
        Response obj_resp = new Response();
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                continue;
            }else{
                return Reject2(obj_resp);
            }
        }
        for(SnippetEvent snippet:list){
            if(snippet.value().equals("10")){
                continue;
            } else if (snippet.snippet().source().contains("+=") && snippet.snippet().source().contains("x")) {
                return Valid(obj_resp);
            } else {
                return Reject2(obj_resp);
            }
        }
        return Reject2(obj_resp);
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
    //case 13
    public Response AnalysisCase13(List<SnippetEvent> list,List<VarSnippet> listV,String command){
        Response obj_resp=new Response();
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                continue;
            }else{
                return Reject2(obj_resp);
            }
        }
        if(listV.size()==2){
            for (SnippetEvent snippetEvent:list){
                Pattern pat = Pattern.compile("^\\s*(System.out.println)\\s*\\(\\s*(firstName)\\s*\\+\\s*(lastName)\\s*\\)\\s*\\;?\\s*$");
                Matcher mat = pat.matcher(snippetEvent.snippet().source());
                if(mat.matches()){
                    return Valid(obj_resp);
                }
            }
        }else{
            return Reject2(obj_resp);
        }
        return Reject2(obj_resp);
    }
    public Response AnalysisCase14(List<SnippetEvent> list,List<VarSnippet> listV,String command){
        Response obj_resp=new Response();
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                continue;
            }else{
                return Reject2(obj_resp);
            }
        }
        if(listV.size()==2){
            for (SnippetEvent snippetEvent:list){
                Pattern pat = Pattern.compile("^\\s*(System.out.println)\\s*\\(\\s*(firstName.concat)\\s*\\(\\s*(lastName)\\s*\\)\\s*\\)\\s*;?\\s*$");
                Matcher mat = pat.matcher(snippetEvent.snippet().source());
                if(mat.matches()){
                    return Valid(obj_resp);
                }
            }
        }else{
            return Reject2(obj_resp);
        }
        return Reject2(obj_resp);
    }
    public Response AnalysisCase15(List<SnippetEvent> list,List<VarSnippet> listV,String command){
        Response obj_resp=new Response();
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                continue;
            }else{
                return Reject2(obj_resp);
            }
        }
        SnippetEvent snippetEvent=list.get(1);
        Pattern pat = Pattern.compile("^\\s*(System.out.println)?\\s*\\(?\\s*(txt.indexOf)\\s*\\(\\s*(\"e\")\\s*\\)\\s*\\)?\\s*;?\\s*$");
        Matcher mat = pat.matcher(snippetEvent.snippet().source());
        if(mat.matches()){
            return Valid(obj_resp);
        }
        return Reject2(obj_resp);
    }
    public Response AnalysisCase16(List<SnippetEvent> list,List<VarSnippet> listV,String command){
        Response obj_resp=new Response();
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                continue;
            }else{
                return Reject2(obj_resp);
            }
        }
        if(list.size()==3){
            SnippetEvent snippetEvent=list.get(2);
            Pattern pat = Pattern.compile("^\\s*(System.out.println)?\\s*\\(?\\s*(Math.max)\\s*\\(\\s*x\\s*,\\s*y\\s*\\)\\s*\\)?\\s*;?\\s*$");
            Pattern pat2 = Pattern.compile("^\\s*(System.out.println)?\\s*\\(?\\s*(Math.max)\\s*\\(\\s*y\\s*\\,\\s*x\\s*\\)\\s*\\)?\\s*;?\\s*$");
            Matcher mat = pat.matcher(snippetEvent.snippet().source());
            Matcher mat2 = pat2.matcher(snippetEvent.snippet().source());
            if(mat.matches() || mat2.matches()){
                return Valid(obj_resp);
            }
        }
        return Reject2(obj_resp);
    }
    public Response AnalysisCase17(List<SnippetEvent> list,List<VarSnippet> listV,String command){
        Response obj_resp=new Response();
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                continue;
            }else{
                return Reject2(obj_resp);
            }
        }
        if(list.size()==2){
            SnippetEvent snippetEvent=list.get(1);
            Pattern pat = Pattern.compile("^\\s*(System.out.println)?\\s*\\(?\\s*(Math.sqrt)\\s*\\(\\s*x\\s*\\)\\s*\\)?\\s*;?\\s*$");
            Matcher mat = pat.matcher(snippetEvent.snippet().source());
            if(mat.matches()){
                return Valid(obj_resp);
            }
        }
        return Reject2(obj_resp);
    }
    public Response AnalysisCase18(List<SnippetEvent> list,List<VarSnippet> listV,String command){
        Response obj_resp=new Response();
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                continue;
            }else{
                return Reject2(obj_resp);
            }
        }
        if(list.size()==1){
            SnippetEvent snippetEvent=list.get(0);
            Pattern pat = Pattern.compile("^\\s*(System.out.println)?\\s*\\(?\\s*(Math.random)\\s*\\(\\s*\\)\\s*\\)?\\s*;?\\s*$");
            Matcher mat = pat.matcher(snippetEvent.snippet().source());
            if(mat.matches()){
                return Valid(obj_resp);
            }
        }
        return Reject2(obj_resp);
    }
    public Response AnalysisCase19(List<SnippetEvent> list,List<VarSnippet> listV,String command){
        Response obj_resp=new Response();
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                continue;
            }else{
                return Reject2(obj_resp);
            }
        }
        if(listV.size()==2){
            for (VarSnippet varSnippet:listV){
                if(varSnippet.typeName().equals("boolean")){
                    continue;
                }else {
                    return Reject2(obj_resp);
                }
            }
            int cont=0;
            for (SnippetEvent snippetEvent:list){
                if(snippetEvent.value().equals("true")){
                    cont+=1;
                } else if (snippetEvent.value().equals("false")){
                    cont+=1;
                }
            }
            if (cont==2){return Valid(obj_resp);}
        }
        return Reject2(obj_resp);
    }
    public Response AnalysisCase20(List<SnippetEvent> list,List<VarSnippet> listV,String command){
        Response obj_resp=new Response();
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                continue;
            }else{
                return Reject2(obj_resp);
            }
        }
        if(list.size()==3){
            SnippetEvent snippetEvent=list.get(2);
            Pattern pat = Pattern.compile("^\\s*(System.out.println)?\\s*\\(?\\s*x\\s*>\\s*y\\s*\\)?\\s*;?\\s*$");
            Matcher mat = pat.matcher(snippetEvent.snippet().source());
            if(mat.matches()){
                return Valid(obj_resp);
            }
        }
        return Reject2(obj_resp);
    }
    public Response AnalysisCase21(List<SnippetEvent> list,List<VarSnippet> listV,String command){
        Response obj_resp=new Response();
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                continue;
            }else{
                return Reject2(obj_resp);
            }
        }
        if(listV.size()==2){
            SnippetEvent snippetEvent=list.get(2);
            Pattern pat = Pattern.compile("\\s*(System.out.println)\\s*\\(\\s*(\"Hello World\")\\s*\\)\\s*;\\s*");
            Matcher mat = pat.matcher(snippetEvent.snippet().source());
            Pattern pat2 = Pattern.compile("\\(\\s*x\\s*>\\s*y\\s*\\)");
            Matcher mat2 = pat2.matcher(snippetEvent.snippet().source());
            if(mat.find() && mat2.find() && snippetEvent.snippet().source().contains("if")){
                return Valid(obj_resp);
            }
        }
        return Reject2(obj_resp);
    }
    public Response AnalysisCase22(List<SnippetEvent> list,List<VarSnippet> listV,String command){
        Response obj_resp=new Response();
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                continue;
            }else{
                return Reject2(obj_resp);
            }
        }
        if(listV.size()==2){
            SnippetEvent snippetEvent=list.get(2);
            Pattern pat = Pattern.compile("\\s*(System.out.println)\\s*\\(\\s*(\"Hello World\")\\s*\\)\\s*;\\s*");
            Matcher mat = pat.matcher(snippetEvent.snippet().source());
            Pattern pat2 = Pattern.compile("\\(\\s*x\\s*==\\s*y\\s*\\)");
            Matcher mat2 = pat2.matcher(snippetEvent.snippet().source());
            if(mat.find() && mat2.find() && snippetEvent.snippet().source().contains("if")){
                return Valid(obj_resp);
            }
        }
        return Reject2(obj_resp);
    }
    public Response AnalysisCase23(List<SnippetEvent> list,List<VarSnippet> listV,String command){
        Response obj_resp=new Response();
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                continue;
            }else{
                return Reject2(obj_resp);
            }
        }
        if(listV.size()==2){
            SnippetEvent snippetEvent=list.get(2);
            Pattern pat = Pattern.compile("\\(\\s*x\\s*==\\s*y\\s*\\)\\s*\\{\\s*(System.out.println)\\s*\\(\\s*(\"Yes\")\\s*\\)\\s*;\\s*");
            Matcher mat = pat.matcher(snippetEvent.snippet().source());
            Pattern pat2 = Pattern.compile("(else)\\s*\\{\\s*(System.out.println)\\s*\\(\\s*(\"No\")\\s*\\)\\s*;\\s*");
            Matcher mat2 = pat2.matcher(snippetEvent.snippet().source());
            boolean validator1=mat.find();
            boolean validator2=mat2.find();
            if(validator1 && validator2 && snippetEvent.snippet().source().contains("if")){
                return Valid(obj_resp);
            }
        }
        return Reject2(obj_resp);
    }
    public Response AnalysisCase24(List<SnippetEvent> list,List<VarSnippet> listV,String command){
        Response obj_resp=new Response();
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                continue;
            }else{
                return Reject2(obj_resp);
            }
        }
        if(listV.size()==2){
            SnippetEvent snippetEvent=list.get(2);
            Pattern pat = Pattern.compile("\\(\\s*x\\s*==\\s*y\\s*\\)\\s*\\{\\s*(System.out.println)\\s*\\(\\s*(\"1\")\\s*\\)\\s*;\\s*");
            Matcher mat = pat.matcher(snippetEvent.snippet().source());
            Pattern pat2 = Pattern.compile("(else)\\s*(if)\\s*\\(\\s*x\\s*>\\s*y\\s*\\)\\s*\\{\\s*(System.out.println)\\s*\\(\\s*(\"2\")\\s*\\)\\s*;\\s*");
            Matcher mat2 = pat2.matcher(snippetEvent.snippet().source());
            Pattern pat3 = Pattern.compile("(else)\\s*\\{\\s*(System.out.println)\\s*\\(\\s*(\"3\")\\s*\\)\\s*;\\s*");
            Matcher mat3 = pat3.matcher(snippetEvent.snippet().source());
            boolean validator1=mat.find();
            boolean validator2=mat2.find();
            boolean validator3=mat3.find();
            if(validator1 && validator2 && validator3 && snippetEvent.snippet().source().contains("if")){
                return Valid(obj_resp);
            }
        }
        return Reject2(obj_resp);
    }
    public Response AnalysisCase25(List<SnippetEvent> list,List<VarSnippet> listV,String command){
        Response obj_resp=new Response();
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                continue;
            }else{
                return Reject2(obj_resp);
            }
        }
        if(listV.size()>0){
            if(list.size()<4){
                for (SnippetEvent snippetEvent:list){
                    Pattern pat = Pattern.compile("\\(\\s*time\\s*<\\s*\\d+\\s*\\)\\s*\\?\\s*(\"Good day\")\\s*\\:\\s*(\"Good evening\")\\s*;?");
                    Matcher mat = pat.matcher(snippetEvent.snippet().source());
                    boolean validator1=mat.find();
                    if(validator1){
                        return Valid(obj_resp);
                    }
                }
            }
        }
        return Reject2(obj_resp);
    }
    public Response AnalysisCase26(List<SnippetEvent> list,List<VarSnippet> listV,String command){
        Response obj_resp=new Response();
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                continue;
            }else{
                return Reject2(obj_resp);
            }
        }
        if(listV.size()==1){
            if(list.size()==2){
                for (SnippetEvent snippetEvent:list){
                    Pattern pat = Pattern.compile("\\{\\s*case\\s*1\\s*:\\s*(System.out.println)\\s*\\(\\s*(\"Saturday\")\\s*\\)");
                    Matcher mat = pat.matcher(snippetEvent.snippet().source());
                    Pattern pat2 = Pattern.compile("\\s*case\\s*2\\s*:\\s*(System.out.println)\\s*\\(\\s*(\"Sunday\")\\s*\\)");
                    Matcher mat2 = pat2.matcher(snippetEvent.snippet().source());
                    boolean validator1=mat.find();
                    boolean validator2=mat2.find();
                    if(validator1 && validator2 && snippetEvent.snippet().source().contains("switch")){
                        return Valid(obj_resp);
                    }
                }
            }
        }
        return Reject2(obj_resp);
    }
    public Response AnalysisCase27(List<SnippetEvent> list,List<VarSnippet> listV,String command){
        Response obj_resp=new Response();
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                continue;
            }else{
                return Reject2(obj_resp);
            }
        }
        if(listV.size()==1){
            if(list.size()==2){
                Pattern pat = Pattern.compile("\\{\\s*case\\s*1\\s*:\\s*(System.out.println)\\s*\\(\\s*(\"Saturday\")\\s*\\)");
                Pattern pat2 = Pattern.compile("\\s*case\\s*2\\s*:\\s*(System.out.println)\\s*\\(\\s*(\"Sunday\")\\s*\\)");
                Pattern pat3 = Pattern.compile("\\s*default\\s*:\\s*(System.out.println)\\s*\\(\\s*(\"Weekend\")\\s*\\)");
                for (SnippetEvent snippetEvent:list){
                    Matcher mat = pat.matcher(snippetEvent.snippet().source());
                    Matcher mat2 = pat2.matcher(snippetEvent.snippet().source());
                    Matcher mat3 = pat3.matcher(snippetEvent.snippet().source());
                    boolean validator1=mat.find();
                    boolean validator2=mat2.find();
                    boolean validator3=mat3.find();
                    if(validator1 && validator2 && validator3 && snippetEvent.snippet().source().contains("switch")){
                        return Valid(obj_resp);
                    }
                }
            }
        }
        return Reject2(obj_resp);
    }
    public Response AnalysisCase28(List<SnippetEvent> list,List<VarSnippet> listV,String command){
        Response obj_resp=new Response();
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                continue;
            }else{
                return Reject2(obj_resp);
            }
        }
        if(listV.size()==1){
            if(list.size()==2){
                SnippetEvent snippetEvent=list.get(1);
                Pattern pat = Pattern.compile("(while)\\s*\\(\\s*i\\s*<\\s*6\\s*\\)\\s*\\{\\s*(System.out.println)\\s*\\(\\s*(i)\\s*\\)\\s*;\\s*(i)");
                Matcher mat = pat.matcher(snippetEvent.snippet().source());
                Pattern pat1 = Pattern.compile("(i++)");
                Matcher mat1 = pat1.matcher(snippetEvent.snippet().source());
                Pattern pat2 = Pattern.compile("(i+=1)");
                Matcher mat2 = pat2.matcher(snippetEvent.snippet().source());
                Pattern pat3 = Pattern.compile("(i=i+1)");
                Matcher mat3 = pat3.matcher(snippetEvent.snippet().source());
                if(mat.find() && mat1.find() || mat.find() && mat2.find()||mat.find() && mat3.find()){
                    return Valid(obj_resp);
                }
            }
        }
        return Reject2(obj_resp);
    }
    public Response AnalysisCase29(List<SnippetEvent> list,List<VarSnippet> listV,String command){
        Response obj_resp=new Response();
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                continue;
            }else{
                return Reject2(obj_resp);
            }
        }
        if(listV.size()==1){
            if(list.size()==2){
                SnippetEvent snippetEvent=list.get(1);
                Pattern pat = Pattern.compile("(do)\\s*\\{\\s*(System.out.println)\\s*\\(\\s*(i)\\s*\\)\\s*;\\s*(i)");
                Matcher mat = pat.matcher(snippetEvent.snippet().source());
                Pattern pat1 = Pattern.compile("(i++)");
                Matcher mat1 = pat1.matcher(snippetEvent.snippet().source());
                Pattern pat2 = Pattern.compile("(i+=1)");
                Matcher mat2 = pat2.matcher(snippetEvent.snippet().source());
                Pattern pat3 = Pattern.compile("(i=i+1)");
                Matcher mat3 = pat3.matcher(snippetEvent.snippet().source());
                Pattern pat4 = Pattern.compile("(while)\\s*\\(\\s*i\\s*<\\s*6\\s*\\)");
                Matcher mat4 = pat4.matcher(snippetEvent.snippet().source());
                boolean m=mat4.find();
//                if(mat.find() && mat4.find() && mat1.find() || mat.find() && mat4.find() && mat2.find()||mat.find() && mat4.find() && mat3.find()){
                if((mat.find() && mat1.find() && m) || (mat.find() && mat2.find() && m)|| (mat.find() &&  mat3.find() && m)){
                    return Valid(obj_resp);
                }
            }
        }
        return Reject2(obj_resp);
    }
    public Response AnalysisCase30(List<SnippetEvent> list,List<VarSnippet> listV,String command){
        Response obj_resp=new Response();
//        try {
            for (SnippetEvent snippet : list) {
                if(snippet.status().name().equals("VALID")){
                    continue;
                }else{
                    return Reject2(obj_resp);
                }
            }
            if(list.size()==1){
                SnippetEvent snippetEvent=list.get(0);
                Pattern pat = Pattern.compile("(for)\\s*\\(\\s*(int)\\s*\\w+\\s*=\\s*\\d+\\s*;\\s*\\w+\\s*<\\s*\\d+\\s*;\\s*\\w+\\+\\+\\s*\\)\\s*\\{\\s*(System.out.println)\\s*\\(\\s*(\"Yes\")\\s*\\)\\s*;");
                Matcher mat = pat.matcher(snippetEvent.snippet().source());
                if (mat.find()){
                    String [] numberOnly = snippetEvent.snippet().source().replaceAll("[^0-9]+", ",").split(",");
                    ArrayList<Integer> num = new ArrayList<>();
                    for (String s:numberOnly){
                        if (s.matches("\\s*")){
                            continue;
                        }else{
                            try {
                                int a=Integer.parseInt(s);
                                num.add(a);
                            }catch (Exception e){
                                return Reject2(obj_resp);
                            }
                        }
                    }
                    if (num.get(1)-num.get(0)==5){
                        return Valid(obj_resp);
                    }
                }
            }
            return Reject2(obj_resp);
//        }catch (Exception e){
//            return Reject2(obj_resp);
//        }
    }
    public Response AnalysisCase31(List<SnippetEvent> list,List<VarSnippet> listV,String command){
        Response obj_resp=new Response();
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                continue;
            }else{
                return Reject2(obj_resp);
            }
        }
        if(list.size()==2){
            SnippetEvent snippetEvent=list.get(1);
            Pattern pat = Pattern.compile("(for)\\s*\\(\\s*(String)\\s*\\w+\\s*:\\s*cars\\s*\\)");
            Pattern pat1 = Pattern.compile("(for)\\s*\\(\\s*(int)\\s*\\w+\\s*=\\s*0\\s*;\\s*\\w+\\s*<\\s*(cars.length)\\s*;\\s*\\w+");
            Pattern pat2 = Pattern.compile("\\{\\s*(System.out.println)\\s*\\(\\s*\\w+");
            Matcher mat = pat.matcher(snippetEvent.snippet().source());
            Matcher mat1 = pat1.matcher(snippetEvent.snippet().source());
            Matcher mat2 = pat2.matcher(snippetEvent.snippet().source());
            if (mat.find() && mat2.find() || mat1.find() && mat2.find()){
                return Valid(obj_resp);
            }
        }
        return Reject2(obj_resp);
    }
    public Response AnalysisCase32(List<SnippetEvent> list,List<VarSnippet> listV,String command){
        Response obj_resp=new Response();
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                continue;
            }else{
                return Reject2(obj_resp);
            }
        }
        if(list.size()==1){
            SnippetEvent snippetEvent=list.get(0);
            Pattern pat1 = Pattern.compile("(for)\\s*\\(\\s*(int)\\s*i\\s*=\\s*0\\s*;\\s*i\\s*<\\s*10\\s*;\\s*(i\\+\\+)");
            Pattern pat2 = Pattern.compile("\\{\\s*(if)\\s*\\(\\s*(i)\\s*==\\s*5\\s*\\)\\s*\\{\\s*break\\s*;\\s*}");
            Matcher mat1 = pat1.matcher(snippetEvent.snippet().source());
            Matcher mat2 = pat2.matcher(snippetEvent.snippet().source());
            if (mat1.find() && mat2.find()){
                return Valid(obj_resp);
            }
        }
        return Reject2(obj_resp);
    }
    public Response AnalysisCase33(List<SnippetEvent> list,List<VarSnippet> listV,String command){
        Response obj_resp=new Response();
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                continue;
            }else{
                return Reject2(obj_resp);
            }
        }
        if(list.size()==1){
            SnippetEvent snippetEvent=list.get(0);
            Pattern pat1 = Pattern.compile("(for)\\s*\\(\\s*(int)\\s*i\\s*=\\s*0\\s*;\\s*i\\s*<\\s*10\\s*;\\s*(i\\+\\+)");
            Pattern pat2 = Pattern.compile("\\{\\s*(if)\\s*\\(\\s*(i)\\s*==\\s*4\\s*\\)\\s*\\{\\s*continue\\s*;\\s*}");
            Matcher mat1 = pat1.matcher(snippetEvent.snippet().source());
            Matcher mat2 = pat2.matcher(snippetEvent.snippet().source());
            if (mat1.find() && mat2.find()){
                return Valid(obj_resp);
            }
        }
        return Reject2(obj_resp);
    }
    public Response AnalysisCase34(List<SnippetEvent> list,List<VarSnippet> listV,String command){
        Response obj_resp=new Response();
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                continue;
            }else{
                return Reject2(obj_resp);
            }
        }
        if(listV.size()==1){
            VarSnippet varSnippet=listV.get(0);
            if(varSnippet.typeName().equals("String[]") && varSnippet.name().equals("cars")){
                return Valid(obj_resp);
            }
        }
        return Reject2(obj_resp);
    }
    public Response AnalysisCase35(List<SnippetEvent> list,List<VarSnippet> listV,String command){
        Response obj_resp=new Response();
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                continue;
            }else{
                return Reject2(obj_resp);
            }
        }
        if(listV.size()==1){
            VarSnippet varSnippet=listV.get(0);
            SnippetEvent snippetEvent = list.get(1);
            Pattern pat = Pattern.compile("(System.out.println)\\s*\\(\\s*cars\\s*\\[\\s*1\\s*]");
            Matcher mat = pat.matcher(snippetEvent.snippet().source());
            if((varSnippet.typeName().equals("String[]") && varSnippet.name().equals("cars")) && mat.find()){
                return Valid(obj_resp);
            }
        }
        return Reject2(obj_resp);
    }
    public Response AnalysisCase36(List<SnippetEvent> list,List<VarSnippet> listV,String command){
        Response obj_resp=new Response();
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                continue;
            }else{
                return Reject2(obj_resp);
            }
        }
        for (SnippetEvent snippetEvent : list){
            Pattern pat = Pattern.compile("cars\\s*\\[\\s*0\\s*]");
            Matcher mat = pat.matcher(snippetEvent.snippet().source());
            if (snippetEvent.value().equals("\"Opel\"") && mat.find()){
                return Valid(obj_resp);
            }
        }
        return Reject2(obj_resp);
    }
    public Response AnalysisCase37(List<SnippetEvent> list,List<VarSnippet> listV,String command){
        Response obj_resp=new Response();
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                continue;
            }else{
                return Reject2(obj_resp);
            }
        }
        if(list.size()==2){
            for (SnippetEvent snippetEvent : list){
                Pattern pat = Pattern.compile("cars\\s*\\.\\s*length\\s*");
                Matcher mat = pat.matcher(snippetEvent.snippet().source());
                if (mat.find()){
                    return Valid(obj_resp);
                }
            }
        }
        return Reject2(obj_resp);
    }
    public Response AnalysisCase38(List<SnippetEvent> list,List<VarSnippet> listV,String command){
        Response obj_resp=new Response();
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                continue;
            }else{
                return Reject2(obj_resp);
            }
        }
        if(list.size()==2){
            SnippetEvent snippetEvent=list.get(1);
            Pattern pat = Pattern.compile("(for)\\s*\\(\\s*(String)\\s*\\w+\\s*:\\s*cars\\s*\\)");
            Pattern pat1 = Pattern.compile("(for)\\s*\\(\\s*(int)\\s*\\w+\\s*=\\s*0\\s*;\\s*\\w+\\s*<\\s*(cars.length)\\s*;\\s*\\w+");
            Matcher mat = pat.matcher(snippetEvent.snippet().source());
            Matcher mat1 = pat1.matcher(snippetEvent.snippet().source());
            if (mat.find()|| mat1.find()){
                return Valid(obj_resp);
            }
        }
        return Reject2(obj_resp);
    }
    public Response AnalysisCase39(List<SnippetEvent> list,List<VarSnippet> listV,String command){
        Response obj_resp=new Response();
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                continue;
            }else{
                return Reject2(obj_resp);
            }
        }
        if(listV.size()==1){
            SnippetEvent snippetEvent=list.get(0);
            Pattern pat = Pattern.compile("int\\[2]\\[]\\s*\\{\\s*(int)\\s*\\[\\d+]");
            Matcher mat = pat.matcher(snippetEvent.value());
            Pattern pat1 = Pattern.compile(",\\s*int\\[\\d+]\\s*\\{");
            Matcher mat1 = pat1.matcher(snippetEvent.value());
            if(mat.find() && mat1.find()){
                return Valid(obj_resp);
            }
        }
        return Reject2(obj_resp);
    }
    public Response AnalysisCase40(List<SnippetEvent> list,List<VarSnippet> listV,List<MethodSnippet> listMethods){
        Response obj_resp=new Response();
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                continue;
            }else{
                return Reject2(obj_resp);
            }
        }
        if(list.size()==2){
            SnippetEvent snippetEvent=list.get(1);
            Pattern pat = Pattern.compile("myMethod\\s*\\(\\s*\\)\\s*;?");
            Matcher mat = pat.matcher(snippetEvent.snippet().source());
            if(mat.matches()){
                return Valid(obj_resp);
            }
        }
        return Reject2(obj_resp);
    }
    public Response AnalysisCase41(List<SnippetEvent> list,List<VarSnippet> listV,List<MethodSnippet> listMethods){
        Response obj_resp=new Response();
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                continue;
            }else{
                return Reject2(obj_resp);
            }
        }
        if(list.size()==3){
            SnippetEvent snippetEvent=list.get(1);
            SnippetEvent snippetEvent1=list.get(2);
            Pattern pat = Pattern.compile("myMethod\\s*\\(\\s*\\)\\s*;?");
            Matcher mat = pat.matcher(snippetEvent.snippet().source());
            Matcher mat1 = pat.matcher(snippetEvent1.snippet().source());
            if(mat.matches() && mat1.matches()){
                return Valid(obj_resp);
            }
        }
        return Reject2(obj_resp);
    }
    public Response AnalysisCase42(List<SnippetEvent> list,List<VarSnippet> listV,List<MethodSnippet> listMethods){
        Response obj_resp=new Response();
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                continue;
            }else{
                return Reject2(obj_resp);
            }
        }
        if(list.size()==2){
            MethodSnippet methodSnippet=listMethods.get(0);
            Pattern pat = Pattern.compile("System.out.println");
            Pattern pat1 = Pattern.compile("Doe");
            Matcher mat = pat.matcher(methodSnippet.source());
            Matcher mat1 = pat1.matcher(methodSnippet.source());
            if((methodSnippet.name().equals("myMethod") && methodSnippet.parameterTypes().equals("String")) && (mat.find() && mat1.find())){
                return Valid(obj_resp);
            }
        }
        return Reject2(obj_resp);
    }
    public Response AnalysisCase43(List<SnippetEvent> list,List<VarSnippet> listV,List<MethodSnippet> listMethods){
        Response obj_resp=new Response();
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                continue;
            }else{
                return Reject2(obj_resp);
            }
        }
        if(list.size()==2){
            for (VarSnippet v:listV){
                System.out.println(v.name());
            }
            MethodSnippet methodSnippet=listMethods.get(0);
            if(methodSnippet.name().equals("myMethod") && methodSnippet.parameterTypes().equals("int") && methodSnippet.signature().equals("(int)int")){
                return Valid(obj_resp);
            }
        }
        return Reject2(obj_resp);
    }
    public Response AnalysisCase44(List<SnippetEvent> list,List<VarSnippet> listV,List<MethodSnippet> listMethods){
        Response obj_resp=new Response();
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                continue;
            }else{
                return Reject2(obj_resp);
            }
        }
        if(list.size()==2){
            MethodSnippet methodSnippet=listMethods.get(0);
            Pattern pat = Pattern.compile("if\\s*\\(\\s*age\\s*<\\s*18\\s*\\)\\s*\\{\\s*(System.out.println)\\s*\\(\\s*(\"Access denied\")\\s*\\)\\s*;\\s*}");
            Pattern pat1 = Pattern.compile("if\\s*\\(\\s*age\\s*>=\\s*18\\s*\\)\\s*\\{\\s*(System.out.println)\\s*\\(\\s*(\"Access granted\")\\s*\\)\\s*;\\s*}");
            Matcher mat = pat.matcher(methodSnippet.source());
            Matcher mat1 = pat1.matcher(methodSnippet.source());
            if ((methodSnippet.name().equals("checkAge")&&methodSnippet.signature().equals("(int)void")) && methodSnippet.parameterTypes().equals("int") && (mat.find() && mat1.find())){
                return Valid(obj_resp);
            }
        }
        return Reject2(obj_resp);
    }
    public Response AnalysisCase45(List<SnippetEvent> list,List<VarSnippet> listV,List<MethodSnippet> listMethods){
        Response obj_resp=new Response();
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                continue;
            }else{
                return Reject2(obj_resp);
            }
        }
        if(list.size()==1){
            SnippetEvent snippetEvent=list.get(0);
            Pattern pat = Pattern.compile("class\\s*MyClass\\s*\\{\\s*}");
            Matcher mat = pat.matcher(snippetEvent.snippet().source());
            if (mat.find()){
                return Valid(obj_resp);
            }
        }
        return Reject2(obj_resp);
    }
    public Response AnalysisCase46(List<SnippetEvent> list,List<VarSnippet> listV,List<MethodSnippet> listMethods){
        Response obj_resp=new Response();
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                continue;
            }else{
                return Reject2(obj_resp);
            }
        }
        if(list.size()==2){
            if(listV.size()==1){
                VarSnippet varSnippet=listV.get(0);
                if (varSnippet.typeName().equals("MyClass")){
                    return Valid(obj_resp);
                }
            }
        }
        return Reject2(obj_resp);
    }
    public Response AnalysisCase47(List<SnippetEvent> list,List<VarSnippet> listV,List<MethodSnippet> listMethods){
        Response obj_resp=new Response();
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                continue;
            }else{
                return Reject2(obj_resp);
            }
        }
        if(list.size()==3){
            Pattern pat = Pattern.compile("myObj.x");
            for(SnippetEvent snippetEvent:list){
                Matcher mat = pat.matcher(snippetEvent.snippet().source());
                if(mat.find() && snippetEvent.snippet().source().contains("System.out.pri")){
                    return Valid(obj_resp);
                }
            }
//          }
        }
        return Reject2(obj_resp);
    }
    public Response AnalysisCase48(List<SnippetEvent> list,List<VarSnippet> listV,List<MethodSnippet> listMethods){
        Response obj_resp=new Response();
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                continue;
            }else{
                return Reject2(obj_resp);
            }
        }
        if(list.size()==3){
            Pattern pat = Pattern.compile(".myMethod\\(\\s*\\)");
            for(SnippetEvent snippetEvent:list){
                Matcher mat = pat.matcher(snippetEvent.snippet().source());
                if(mat.find()){
                    return Valid(obj_resp);
                }
            }
        }
        return Reject2(obj_resp);
    }
    public Response AnalysisCase49(List<SnippetEvent> list,List<VarSnippet> listV,List<MethodSnippet> listMethods){
        Response obj_resp=new Response();
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                continue;
            }else{
                return Reject2(obj_resp);
            }
        }
        SnippetEvent snippetEvent=list.get(0);
        SnippetEvent snippetEvent1=list.get(2);
        Pattern pat = Pattern.compile("MyClass\\s*\\(\\s*\\)\\s*\\{\\s*x\\s*=\\s*5\\s*;");
        Matcher mat = pat.matcher(snippetEvent.snippet().source());
        if(mat.find() && snippetEvent1.value().equals("5")){
                return Valid(obj_resp);
        }
        return Reject2(obj_resp);
    }
    public Response AnalysisCase50(List<SnippetEvent> list,List<VarSnippet> listV,List<MethodSnippet> listMethods){
        Response obj_resp=new Response();
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                continue;
            }else{
                return Reject2(obj_resp);
            }
        }
        if( list.size()==1){
            SnippetEvent snippetEvent=list.get(0);
            Pattern pat = Pattern.compile("final\\s*class");
            Matcher mat = pat.matcher(snippetEvent.snippet().source());
            if(mat.find()){
                return Valid(obj_resp);
            }
        }
        return Reject2(obj_resp);
    }
    public Response AnalysisCase51(List<SnippetEvent> list,List<VarSnippet> listV,List<MethodSnippet> listMethods){
        Response obj_resp=new Response();
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                continue;
            }else{
                return Reject2(obj_resp);
            }
        }
        if( list.size()==1){
            SnippetEvent snippetEvent=list.get(0);
            Pattern pat = Pattern.compile("import\\s*java.util.Scanner\\s*;?");
            Matcher mat = pat.matcher(snippetEvent.snippet().source());
            if(mat.find()){
                return Valid(obj_resp);
            }
        }
        return Reject2(obj_resp);
    }
    public Response AnalysisCase52(List<SnippetEvent> list,List<VarSnippet> listV,List<MethodSnippet> listMethods){
        Response obj_resp=new Response();
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                continue;
            }else{
                return Reject2(obj_resp);
            }
        }
        if( list.size()==2){
            SnippetEvent snippetEvent=list.get(1);
            Pattern pat = Pattern.compile("class\\s+\\w+\\s+extends\\s+Vehicle");
            Matcher mat = pat.matcher(snippetEvent.snippet().source());
            if(mat.find()){
                return Valid(obj_resp);
            }
        }
        return Reject2(obj_resp);
    }
    public Response AnalysisCase53(List<SnippetEvent> list,List<VarSnippet> listV,List<MethodSnippet> listMethods){
        Response obj_resp=new Response();
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                continue;
            }else{
                return Reject2(obj_resp);
            }
        }
        if( list.size()==1){
            SnippetEvent snippetEvent=list.get(0);
            Pattern pat = Pattern.compile("try\\s*\\{");
            Pattern pat2 = Pattern.compile("}\\s*catch\\s*\\(\\s*Exception\\s+\\w+\\s*\\)\\s*\\{");
            Matcher mat = pat.matcher(snippetEvent.snippet().source());
            Matcher mat2 = pat2.matcher(snippetEvent.snippet().source());
            if(mat.find() && mat2.find()){
                return Valid(obj_resp);
            }
        }
        return Reject2(obj_resp);
    }
    public Response AnalysisCase54(List<SnippetEvent> list,List<VarSnippet> listV,List<MethodSnippet> listMethods){
        Response obj_resp=new Response();
        for (SnippetEvent snippet : list) {
            if(snippet.status().name().equals("VALID")){
                continue;
            }else{
                return Reject2(obj_resp);
            }
        }
        if( list.size()==1){
            SnippetEvent snippetEvent=list.get(0);
            Pattern pat = Pattern.compile("try\\s*\\{");
            Pattern pat2 = Pattern.compile("}\\s*catch\\s*\\(\\s*Exception\\s+\\w+\\s*\\)\\s*\\{");
            Pattern pat3 = Pattern.compile("}\\s*finally\\s*\\{");
            Matcher mat = pat.matcher(snippetEvent.snippet().source());
            Matcher mat2 = pat2.matcher(snippetEvent.snippet().source());
            Matcher mat3 = pat3.matcher(snippetEvent.snippet().source());
            if(mat.find() && mat2.find() && mat3.find()){
                return Valid(obj_resp);
            }
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
