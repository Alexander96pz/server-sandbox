package com.replShell.sandbox.Interface;

import com.replShell.sandbox.model.Repl;
import com.replShell.sandbox.model.Response;

import java.util.stream.Stream;

public interface IcodeAnalisis {
    Response onCommandEntered(Repl repl);

}
