package org.example;

import org.example.processor.*;

public class Main {
    public static void main(String[] args) {
        Command[] prog = {
                new Command("init", "a", "20"),     // a = 20
                new Command("init", "b", "25"),     // b = 25
                new Command("add"),                 // result = a + b
                new Command("print"),               // вывод результата
                new Command("mv", "c", "d"), // temp = result
                new Command("init", "a", "10"),     // a = 10
                new Command("init", "b", "5"),      // b = 5
                new Command("sub"),                 // result = a - b
                new Command("print")                // вывод результата
        };

        ICpu cpu = BCpu.build();
        Executer exec = new Executer(cpu);
        exec.run(prog);
    }
}
