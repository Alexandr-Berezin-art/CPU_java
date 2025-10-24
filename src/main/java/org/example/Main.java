package org.example;

import org.example.processor.*;

public class Main {
    public static void main(String[] args) {
        Command[] prog = {

                new Command("init 20 10"),
                new Command("init", "25", "11"),
                new Command("init", "5", "12"),

                new Command("ld", "a", "10"),
                new Command("ld", "b", "11"),
                new Command("ld", "c", "12"),

                new Command("add"),
                new Command("print"),


                new Command("st", "d", "13"),
                new Command("mv a d"),
                new Command("mv b c"),
                new Command("div"),
                new Command("print")
        };

        ICpu cpu = BCpu.build();
        Executer exec = new Executer(cpu);
        exec.run(prog);
    }
}
