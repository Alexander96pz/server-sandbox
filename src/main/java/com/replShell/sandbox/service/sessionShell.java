package com.replShell.sandbox.service;

import jdk.jshell.JShell;

public class sessionShell {
    private JShell shell;
    public sessionShell(){
    }

    public JShell getShell() {
        return shell;
    }

    public void setShell() {
        this.shell = JShell.create();
    }
    public void guardarShell(JShell shell) {
        this.shell = shell;
    }
}