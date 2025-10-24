package org.example.processor;

class MyHandler {
    MyHandler next;

    void run(Command command, Cpu cpu) throws CpuException {
        if (next != null) {
            next.run(command, cpu);
        } else {
            throw new CpuException("Неизвестная инструкция: " + command.getInstruction());
        }
    }

    MyHandler add(MyHandler next) {
        this.next = next;
        return next;
    }
}
