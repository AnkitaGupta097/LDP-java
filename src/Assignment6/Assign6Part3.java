package Assignment6;

public class Assign6Part3 {
    Assign6Part3(String str)
    {
        System.out.println("argument passed is "+str);
    }

    public static void main(String[] args) {
        Assign6Part3 array[]=new Assign6Part3[3];

//if we dont assign objects to references then no message of initailization will be displayed

        array[0]=new Assign6Part3("string");
    }
}
