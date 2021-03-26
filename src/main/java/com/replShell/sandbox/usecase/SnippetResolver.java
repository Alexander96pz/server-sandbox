package com.replShell.sandbox.usecase;

import jdk.jshell.Snippet.Status;
import jdk.jshell.SnippetEvent;


public class SnippetResolver {

    public String resolve(SnippetEvent snippet) {
        boolean isValidSnippet = snippet.value() != null && snippet.status() == Status.VALID;
        if(isValidSnippet) {
            return String.format("'%s' : %s",snippet.snippet().source(),snippet.status());
        }
        boolean snippetThrownException = snippet.exception() != null;
        if (snippetThrownException) {
            System.out.println("entro");
            return "Exception occured : " + snippet.exception();
        }
        return String.format("'%s' : %s",snippet.snippet().source(),snippet.status());
    }
}
