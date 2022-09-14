package com.replShell.sandbox.model;

public class Repl {
    private int id;
    private String code;
    private String prerequisites;
    private String posrequisites;
    private String valor;
    private String console;

    public Repl(int id, String code, String prerequisites, String posrequisites, String valor, String console) {
        this.id = id;
        this.code = code;
        this.prerequisites = prerequisites;
        this.posrequisites = posrequisites;
        this.valor = valor;
        this.console=console;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(String prerequisites) {
        this.prerequisites = prerequisites;
    }

    public String getPosrequisites() {
        return posrequisites;
    }

    public void setPosrequisites(String posrequisites) {
        this.posrequisites = posrequisites;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getConsole() {
        return console;
    }

    public void setConsole(String console) {
        this.console = console;
    }
}