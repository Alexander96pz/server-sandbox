package com.replShell.sandbox.Interface;

import com.replShell.sandbox.model.Response;

import java.util.stream.Stream;

public interface IcodeAnalisis {
    Response onCommandEntered(String command,int id);

}
