/**
   A test program for the stack class
   Written by: Guy J. Brown, modified T. Cohn
   First written: 29/9/98
 */

import sheffield.*;

public class StackTest
{
    public static void main(String args[])
    {
        try {
            method1();
        } catch (Exception e) {
            System.out.println("Top level exception: " + e);
        }
    }

    public static void method1() throws Exception
    {
        // variable declarations
        EasyWriter screen = new EasyWriter();
        EasyReader keyboard = new EasyReader();
        Stack myStack = new Stack(3);
        int num;

        // read some integers and push each one onto the stack
        try
        {
            for (int i = 0; i < 4; i++)
            {
                num = keyboard.readInt("Enter number " + (i + 1) + ": ");
                myStack.push(new Integer(num));
            }
        } catch (StackFullException e) {
            System.out.println("Stack full!");
        }

        // display contents using pop() and size()
        try
        {
            while (myStack.size() > 0)
                screen.println(myStack.pop());
            screen.println(myStack.pop()); // throws exception
        } catch (EmptyStackException e) {
            System.out.println("Empty stack!");
        }
    }
}
