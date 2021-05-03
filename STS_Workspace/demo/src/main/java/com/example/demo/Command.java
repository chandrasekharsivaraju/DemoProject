package com.example.demo;

public interface Command {
    boolean canProcess(String command);
    void process(String command);


}
