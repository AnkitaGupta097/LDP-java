package Assignment7;



    class OuterClassOne {
        int outerVar;

        //inner class with non default constructor

        class InnerClassOne {
            int innerVar;

            //non default constructor

            InnerClassOne(int innerVarVal, int outerVarValue) {
                //accessing instance variables of outer class

                innerVar = innerVarVal;
                outerVar = outerVarValue;
                System.out.println("inside Inner Class One constructer");
            }

            public void getValues() {
                System.out.println("outerVar " + outerVar + " innerVar " + innerVar);
            }

        }

    }


//second outer class having inner class inherites  inner class of first outer class

    class OuterClassTwo {

        class InnerClassTwo extends OuterClassOne.InnerClassOne {
            InnerClassTwo(int a, int b) {

                new OuterClassOne().super(a, b);
                System.out.println("inside Inner Class Two constructer");
            }
        }


    }

//driver class

    public class Assign7Part5 {

        public static void main(String args[]) {
            OuterClassTwo o1 = new OuterClassTwo();
            OuterClassTwo.InnerClassTwo i1 = o1.new InnerClassTwo(1, 2);
            i1.getValues();
        }

    }

