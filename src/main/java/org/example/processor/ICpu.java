package org.example.processor;

public interface ICpu {
    void executeCommand(Command command) throws CpuException;
    int getRegister(String register) throws CpuException;
    void setRegister(String register, String value) throws CpuException;
    void setMemory(String index, String value) throws CpuException;
    int getMemory(String index) throws CpuException;
    void setRegister(String register, int value) throws CpuException;
    void setMemory(String index, int value) throws CpuException;
    int getMemory(int index) throws CpuException;
}
