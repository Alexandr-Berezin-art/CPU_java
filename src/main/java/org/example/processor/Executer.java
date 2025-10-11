package org.example.processor;

public class Executer {
    private ICpu cpu;

    public Executer(ICpu cpu) {
        this.cpu = cpu;
    }

    public void run(Command[] program) {
        for (Command command : program) {
            try {
                cpu.executeCommand(command);
            } catch (CpuException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
