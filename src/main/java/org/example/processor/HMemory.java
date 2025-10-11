package org.example.processor;

public class HMemory extends MyHandler {
    @Override
    void run(Command command, Cpu c) throws CpuException {
        String instruction = command.getInstruction();
        switch (instruction) {
            case "init":
                if (command.getCountOperands() != 2) throw new CpuException("init требует 2 операнда");
                String register = command.getOperandIndex(0);
                int value = Integer.parseInt(command.getOperandIndex(1));
                c.setRegister(register, value);
                System.out.println("Инициализирован регистр " + register + " значением " + value);
                break;
            case "ld":
                if (command.getCountOperands() != 2) throw new CpuException("ld требует 2 операнда");
                String destReg = command.getOperandIndex(0);
                String srcReg = command.getOperandIndex(1);
                // Если srcReg - число, то загружаем непосредственно, иначе из регистра
                int valueLd;
                try {
                    valueLd = Integer.parseInt(srcReg);
                } catch (NumberFormatException e) {
                    valueLd = c.getRegister(srcReg);
                }
                c.setRegister(destReg, valueLd);
                System.out.println("Загружено значение " + valueLd + " в " + destReg);
                break;
            case "st":
                if (command.getCountOperands() != 2) throw new CpuException("st требует 2 операнда");
                String srcRegSt = command.getOperandIndex(0);
                String destRegSt = command.getOperandIndex(1);
                int valueSt = c.getRegister(srcRegSt);
                c.setRegister(destRegSt, valueSt);
                System.out.println("Сохранено значение " + valueSt + " из " + srcRegSt + " в " + destRegSt);
                break;
            case "mv":
                if (command.getCountOperands() != 2) throw new CpuException("mv требует 2 операнда");
                String srcRegMv = command.getOperandIndex(0);
                String destRegMv = command.getOperandIndex(1);
                int valueMv = c.getRegister(srcRegMv);
                c.setRegister(destRegMv, valueMv);
                System.out.println("Перемещено значение " + valueMv + " из " + srcRegMv + " в " + destRegMv);
                break;
            default:
                super.run(command, c);
        }
    }
}
