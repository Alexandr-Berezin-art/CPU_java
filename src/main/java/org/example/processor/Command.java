package org.example.processor;

public class Command {
    String instruction;
    String[] operands;
    int count_operands;
    public Command(String fullCommand) {
        String[] parts = fullCommand.split(" ");
        this.instruction = parts[0];
        this.operands = new String[parts.length - 1];
        System.arraycopy(parts, 1, this.operands, 0, parts.length - 1);
        count_operands = operands.length;
    }

    public Command(String instruction, String... operands) {
        this.instruction = instruction;
        this.operands = operands;
        count_operands = operands.length;
    }

    public String getInstruction() {
        return instruction;
    }

    public String getRegisterName() {
        return operands[0];
    }

    public String getValue() {
        return operands[0];
    }

    public String getAddress() {
        return operands[1];
    }


    public String getOperandIndex(int index) throws RuntimeException
    {
        if(index > count_operands || index < 0) throw new RuntimeException("Обращение по неправильному индексу");
        return operands[index];
    }

    public int getCountOperands(){
        return count_operands;
    }


    @Override
    public String toString() {
        return "Command{" +
                "instruction='" + instruction + '\'' +
                ", operands=" + java.util.Arrays.toString(operands) +
                '}';
    }
}
