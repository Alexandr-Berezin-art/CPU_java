package org.example.processor;

class MyHandler {
    MyHandler next;

    void run(Command command, Cpu c) throws CpuException {
        if (next != null) {
            next.run(command, c);
        } else {
            throw new CpuException("Неизвестная инструкция: " + command.getInstruction());
        }
    }

    MyHandler add(MyHandler next) {
        this.next = next;
        return next;
    }
}
