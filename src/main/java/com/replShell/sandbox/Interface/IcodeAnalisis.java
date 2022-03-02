package com.replShell.sandbox.Interface;

import com.replShell.sandbox.model.Response;

import java.util.stream.Stream;

public interface IcodeAnalisis {
    Stream<Response> onCommandEntered(String command);

}
