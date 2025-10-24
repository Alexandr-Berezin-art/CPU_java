package org.example.processor;

public class HMemory extends MyHandler {
    @Override
    void run(Command command, Cpu cpu) throws CpuException {
        String instruction = command.getInstruction();
        String address;
        String value;
        String register;
        int int_value;
        switch (instruction) {
            case "init":
                if (command.getCountOperands() != 2) throw new CpuException("init требует 2 операнда");

                address = command.getAddress();
                value = command.getValue();
                cpu.setMemory(address, value);
                System.out.println("Инициализирован адреса " + address + " значением " + value);
                break;


            case "ld":
                if (command.getCountOperands() != 2) throw new CpuException("ld требует 2 операнда");

                register = command.getRegisterName();
                address = command.getAddress();

                int_value = cpu.getMemory(address);
                cpu.setRegister(register, int_value);

                System.out.println("Загружено значение из адреса " + address + " в регистр " + register);
                break;


            case "st":
                if (command.getCountOperands() != 2) throw new CpuException("st требует 2 операнда");

                register = command.getRegisterName();
                address = command.getAddress();
                int_value = cpu.getRegister(register);
                cpu.setMemory(address, int_value );
                System.out.println("Сохранено значение из регистра " + register + " в адрес памяти " + address);
                break;


            case "mv":
                if (command.getCountOperands() != 2) throw new CpuException("mv требует 2 операнда");

                String register1 = command.getOperandIndex(0);
                String register2 = command.getOperandIndex(1);
                cpu.setRegister(register1, cpu.getRegister(register2));
                System.out.println("Перемещено значение из регистра " + register2 + " в регистр  " + register1);
                break;


            default:
                super.run(command, cpu);
        }
    }
}
