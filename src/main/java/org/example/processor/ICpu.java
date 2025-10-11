package org.example.processor;

public interface ICpu {
    void executeCommand(Command command) throws CpuException;
    int getRegister(String register);
    void setRegister(String register, int value);
}
