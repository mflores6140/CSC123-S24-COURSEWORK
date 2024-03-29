import java.util.Stack;

public class decimalToBinary {
    // Method converts decimal to binary using a stack
    public static String decimalToBinary(int decimal) {
        if (decimal == 0) return "0";
        
        Stack<Integer> stack = new Stack<>();
        while (decimal != 0) {
            int remainder = decimal % 2;
            stack.push(remainder);
            decimal /= 2;
        }

        StringBuilder binary = new StringBuilder();
        while (!stack.isEmpty()) {
            binary.append(stack.pop());
        }
        return binary.toString();
    }

    public static void main(String[] args) {
        
        int[] decimalNumbers = {0, 1, 2, 50, 150, 250, 500}; 
        for (int decimal : decimalNumbers) {
            System.out.println("Decimal: " + decimal + ", Binary: " + decimalToBinary(decimal));
        }
    }
}