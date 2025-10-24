package org.example.processor;

class Cpu implements ICpu {
    private int a, b, c, d;
    private int[] memory = new int[1024];

    public void setMemory(String index, String value) throws CpuException {
        int ind;
        int val;
        try {
            ind = Integer.parseInt(index);
            val = Integer.parseInt(value);
        }
        catch (Exception e){
            throw new CpuException("неверные данные для адреса в памяти");
        }

        if(ind < 0 || ind >= 1024) throw new CpuException("неверный адрес памяти");
        memory[ind] = val;
    }

    public void setMemory(String index, int value) throws CpuException {
        int ind;
        try {
            ind = Integer.parseInt(index);
        }
        catch (Exception e){
            throw new CpuException("неверные данные для адреса в памяти");
        }

        if(ind < 0 || ind >= 1024) throw new CpuException("неверный адрес памяти");
        memory[ind] = value;
    }

    public int getMemory(String index) throws CpuException {
        int ind;
        try {
            ind = Integer.parseInt(index);
        }
        catch (Exception e){
            throw new CpuException("неверные данные для адреса в памяти");
        }
        if(ind < 0 || ind >= 1024) throw new CpuException("неверный адрес памяти");
        return memory[ind];
    }


    public int getMemory(int index) throws CpuException {
        if(index < 0 || index >= 1024) throw new CpuException("неверный адрес памяти");
        return memory[index];
    }

    private MyHandler handler = new MyHandler();
    public MyHandler getHandler() {
        return handler;
    }

    @Override
    public int getRegister(String register) throws CpuException{
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
                throw new CpuException("Неизвестный регистр: " + register);
        }
    }

    @Override
    public void setRegister(String register, String value) throws CpuException {
        int val;
        try {
            val = Integer.parseInt(value);
        }
        catch (Exception e){
            throw new CpuException("неверные данные для завписи в регистр");
        }


        switch (register) {
            case "a":
                a = val;
                break;
            case "b":
                b = val;
                break;
            case "c":
                c = val;
                break;
            case "d":
                d = val;
                break;
            default:
                throw new CpuException("Неизвестный регистр: " + register);
        }
    }

    @Override
    public void setRegister(String register, int value) throws CpuException {
        int val = value;
        switch (register) {
            case "a":
                a = val;
                break;
            case "b":
                b = val;
                break;
            case "c":
                c = val;
                break;
            case "d":
                d = val;
                break;
            default:
                throw new CpuException("Неизвестный регистр: " + register);
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