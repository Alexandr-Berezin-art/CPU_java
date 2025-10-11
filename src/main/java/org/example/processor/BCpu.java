package org.example.processor;

public class BCpu {
    static Cpu cpu;

    public static ICpu build() {
        if (cpu == null) {
            cpu = new Cpu();
            cpu.getHandler()
                    .add(new HMemory())
                    .add(new HArithmetic())
                    .add(new HIO());
        }
        return cpu;
    }
}
