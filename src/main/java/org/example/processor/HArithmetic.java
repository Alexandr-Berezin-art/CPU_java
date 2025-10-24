package org.example.processor;

public class HArithmetic extends MyHandler {
    @Override
    void run(Command command, Cpu cpu) throws CpuException {
        String instruction = command.getInstruction();
        switch (instruction) {
            case "add": {
                int d = cpu.getRegister("a") + cpu.getRegister("b");
                cpu.setRegister("d", d);
                System.out.println("Сложение: " + cpu.getRegister("a") + " + " + cpu.getRegister("b") + " = " + d);
                break;
            }
            case "sub": {
                int d = cpu.getRegister("a") - cpu.getRegister("b");
                cpu.setRegister("d", d);
                System.out.println("Вычитание: " + cpu.getRegister("a") + " - " + cpu.getRegister("b") + " = " + d);
                break;
            }
            case "mult": {
                int d = cpu.getRegister("a") * cpu.getRegister("b");
                cpu.setRegister("d", d);
                System.out.println("Умножение: " + cpu.getRegister("a") + " * " + cpu.getRegister("b") + " = " + d);
                break;
            }
            case "div": {
                int d = cpu.getRegister("a") / cpu.getRegister("b");
                cpu.setRegister("d", d);
                System.out.println("Умножение: " + cpu.getRegister("a") + " / " + cpu.getRegister("b") + " = " + d);
                break;
            }
            default:
                super.run(command, cpu);
        }
    }
}
