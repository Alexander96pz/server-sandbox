package com.replShell.sandbox.service;

import com.replShell.sandbox.model.Response;
import jdk.jshell.JShellException;
import jdk.jshell.Snippet;
import jdk.jshell.Snippet.Status;
import jdk.jshell.SnippetEvent;

import java.nio.charset.StandardCharsets;


public class SnippetResolver {

    public Response resolve(SnippetEvent snippet) {
        Snippet.Kind k= snippet.snippet().kind();
        System.out.println(k.toString());
        Response obj_repl=new Response();
        boolean isValidSnippet = snippet.value() != null && snippet.status() == Status.VALID;
        if(isValidSnippet) {
            obj_repl.setSource(snippet.snippet().source());
            obj_repl.setStatus(snippet.status());
            obj_repl.setValue(snippet.value());
            obj_repl.setTypeSnippet(k.name());
            return obj_repl;
        }
        boolean snippetThrownException = snippet.exception() != null;
        if (snippetThrownException) {
            obj_repl.setException(snippet.exception());
            return obj_repl;
        }
        obj_repl.setSource(snippet.snippet().source());
        obj_repl.setStatus(snippet.status());
        obj_repl.setValue(snippet.value());
        obj_repl.setTypeSnippet(k.name());
        return obj_repl;
    }
}