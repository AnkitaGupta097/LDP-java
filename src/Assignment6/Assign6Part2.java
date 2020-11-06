package Assignment6;

public class Assign6Part2 {
        private   int a,b;


        //calling second constructor from first
        Assign6Part2(int one,int two)
        {
            this(one);
            b=two;
        }

        Assign6Part2(int one)
        {
            a=one;
        }
        void getNumbers()
        {
            System.out.println("one :"+a+" two: "+b);

        }

        public static void main(String[] args) {

            Assign6Part2 obj=new Assign6Part2(10,20);
            obj.getNumbers();
        }


}
