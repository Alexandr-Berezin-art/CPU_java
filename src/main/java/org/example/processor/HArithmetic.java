package org.example.processor;

public class HArithmetic extends MyHandler {
    @Override
    void run(Command command, Cpu cpu) throws CpuException {
        String instruction = command.getInstruction();
        switch (instruction) {
            case "add": {
                int c = cpu.getRegister("a") + cpu.getRegister("b");
                cpu.setRegister("c", c);
                System.out.println("Сложение: " + cpu.getRegister("a") + " + " + cpu.getRegister("b") + " = " + c);
                break;
            }
            case "sub": {
                int c = cpu.getRegister("a") - cpu.getRegister("b");
                cpu.setRegister("c", c);
                System.out.println("Вычитание: " + cpu.getRegister("a") + " - " + cpu.getRegister("b") + " = " + c);
                break;
            }
            case "mult": {
                int c = cpu.getRegister("a") * cpu.getRegister("b");
                cpu.setRegister("c", c);
                System.out.println("Умножение: " + cpu.getRegister("a") + " * " + cpu.getRegister("b") + " = " + c);
                break;
            }
            default:
                super.run(command, cpu);
        }
    }
}
