class ExceptionTest
{

    public static void main(String[] args)
    {
        System.out.println("Entering main");

        try
        {
            System.out.println("Calling method1");
            method1();
        } catch (ExceptionA eA)
        {
            System.out.println("Catching ExceptionA");
        } finally
        {
            System.out.println("In finally main");
        }
        System.out.println("Proceeding to complete main");
    }

    private static void method1() throws ExceptionA
    {
        System.out.println("Entering method1");

        try
        {
            System.out.println("Calling method2");
            method2();
        } catch (ExceptionB eB)
        {
            System.out.println("Catching ExceptionB");
        } finally
        {
            System.out.println("In finally method1");
        }
        System.out.println("Proceeding to complete method1");
    }

    private static void method2() throws ExceptionA, ExceptionB
    {
        System.out.println("Entering method2");

        try
        {
            System.out.println("Calling method3");
            method3();
        } catch (ExceptionC eC)
        {
            System.out.println("Catching ExceptionC");
        } finally
        {
            System.out.println("In finally method2");
        }
        System.out.println("Proceeding to complete method2");
    }

    private static void method3() throws ExceptionA, ExceptionB, ExceptionC
    {
        System.out.println("Entering method3");

        double x = Math.random();
        if (x > 0.75)
        {
            System.out.println("Throwing ExceptionA");
            throw new ExceptionA();
        } else if (x > 0.50)
        {
            System.out.println("Throwing ExceptionB");
            throw new ExceptionB();
        } else if (x > 0.25)
        {
            System.out.println("Throwing ExceptionC");
            throw new ExceptionC();
        }
        System.out.println("No exceptions");
        System.out.println("Proceeding to complete method3");
    }
}

// Define some exception classes

class ExceptionA extends Exception
{
    // Constructors
    ExceptionA()
    {
        super();
    }
    ExceptionA(String desc)
    {
        super(desc);
    }
}

class ExceptionB extends Exception
{
    // Constructors
    ExceptionB()
    {
        super();
    }
    ExceptionB(String desc)
    {
        super(desc);
    }
}

class ExceptionC extends Exception
{
    // Constructors
    ExceptionC()
    {
        super();
    }
    ExceptionC(String desc)
    {
        super(desc);
    }
}
