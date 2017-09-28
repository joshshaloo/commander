package io.shaloo.commander.exceptions;

public class CommandNotImplementedException extends Exception {
    public CommandNotImplementedException(String s, Throwable e) {
        super(s, e);
    }

    public CommandNotImplementedException(String s) {
        super(s);
    }
}
