package com.replShell.sandbox.model;

import jdk.jshell.JShellException;
import jdk.jshell.Snippet.Status;

public class Response {
    private String source;
    private String status;
    private String value;
    private String exception;
    private String typeSnippet;
    private String subtypeSnippet;
    public Response(){}

    public Response(String source, String status, String value){
        this.source=source;
        this.status=status;
        this.value=value;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(Status s) {
        switch (s){
            case VALID:
                this.status="VALID";
                break;
            case REJECTED:
                this.status="REJECT";
                break;
            case OVERWRITTEN:
                this.status="OVERWRITTEN";
                break;
            case DROPPED:
                this.status="DROPPED";
                break;
            case NONEXISTENT:
                this.status="NONEXISTENT";
                break;
            case RECOVERABLE_DEFINED:
                this.status="RECOVERABLE_DEFINED";
                break;
            case RECOVERABLE_NOT_DEFINED:
                this.status="RECOVERABLE_NOT_DEFINED";
                break;
        }
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        System.out.println(value);
    }

    public String getException() {
        return exception;
    }

    public void setException(JShellException exception) {
        this.exception = "Excepcion code: "+exception;
    }

    public String getTypeSnippet() {
        return typeSnippet;
    }

    public void setTypeSnippet(String typeSnippet) {
        this.typeSnippet = typeSnippet;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubtypeSnippet() {
        return subtypeSnippet;
    }

    public void setSubtypeSnippet(String subtypeSnippet) {
        this.subtypeSnippet = subtypeSnippet;
    }
}
