package KolekcjaLIFO;

public class Main {
    public static void main(String[] args) {

        Stack<Integer> integerStack = new Stack();
        integerStack.push(10);
        integerStack.push(15);
        integerStack.push(20);
        integerStack.printStack();
        System.out.println();

        integerStack.remove(20);
        integerStack.printStack();
        System.out.println();

        integerStack.addBottom(50);
        integerStack.printStack();
        System.out.println();

        try{
            integerStack.pop();
        }catch (Exception e){
            System.err.println("Stos jest pusty");
        }




    }
}
