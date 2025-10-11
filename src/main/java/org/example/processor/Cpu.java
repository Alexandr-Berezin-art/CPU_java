package org.example.processor;

class Cpu implements ICpu {
    private int a, b, c, d;
    private MyHandler handler = new MyHandler();

    public MyHandler getHandler() {
        return handler;
    }

    @Override
    public int getRegister(String register) {
        switch (register) {
            case "a":
                return a;
            case "b":
                return b;
            case "c":
                return c;
            case "d":
                return d;
            default:
                throw new RuntimeException("Неизвестный регистр: " + register);
        }
    }

    @Override
    public void setRegister(String register, int value) {
        switch (register) {
            case "a":
                a = value;
                break;
            case "b":
                b = value;
                break;
            case "c":
                c = value;
                break;
            case "d":
                d = value;
                break;
            default:
                throw new RuntimeException("Неизвестный регистр: " + register);
        }
    }

    @Override
    public void executeCommand(Command command) throws CpuException {
        handler.run(command, this);
    }

    @Override
    public String toString() {
        return "Cpu{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                '}';
    }
}