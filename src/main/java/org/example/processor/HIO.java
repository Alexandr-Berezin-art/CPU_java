package org.example.processor;

public class HIO extends MyHandler {
    @Override
    void run(Command command, Cpu cpu) throws CpuException {
        if ("print".equals(command.getInstruction())) {
            System.out.println("Результат (a, b, c, d): " + cpu.getRegister("a") + " " + cpu.getRegister("b") + " " + cpu.getRegister("c") + " " + cpu.getRegister("d"));
        } else {
            super.run(command, cpu);
        }
    }
}