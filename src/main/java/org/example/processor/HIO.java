package org.example.processor;

public class HIO extends MyHandler {
    @Override
    void run(Command command, Cpu c) throws CpuException {
        if ("print".equals(command.getInstruction())) {
            System.out.println("Результат: " + c.getRegister("c"));
        } else {
            super.run(command, c);
        }
    }
}