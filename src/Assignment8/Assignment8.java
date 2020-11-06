package Assignment8;

public class Assignment8 {
    public static void main(String[] args) {

        ThrowExceptionClass e=new ThrowExceptionClass();
        try {
            e.method1("throw exception one");
        }
        catch (Exception exception)
        {
            System.out.println(exception.getMessage());
        }
        finally
        {
            System.out.println("finally block excecuted");
        }
    }

}

class ThrowExceptionClass{
    void method1(String exception) throws NewExceptionOne, NewExceptionTwo, NewExceptionThree {
        if (exception.equalsIgnoreCase("throw exception one")) {
            throw new NewExceptionOne("customized exception one");
        } else if (exception.equalsIgnoreCase("throw exception two")) {
            throw new NewExceptionTwo("customized exception two");
        } else if (exception.equalsIgnoreCase("throw exception three")) {
            throw new NewExceptionThree("customized exception three");
        }

    }
}

class NewExceptionOne extends Exception{

    NewExceptionOne(String str)
    {
        super(str);

    }
    NewExceptionOne()
    {

    }

}
class NewExceptionTwo extends Exception{

    NewExceptionTwo(String str)
    {
        super(str);

    }
    NewExceptionTwo()
    {

    }

}
class NewExceptionThree extends Exception{

    NewExceptionThree(String str)
    {
        super(str);

    }
    NewExceptionThree()
    {

    }

}