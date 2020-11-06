package Assignment7;


    interface ICycle {
        void balance();

    }

    class UnicycleClass implements ICycle {
        public void balance() {

            System.out.println("Unicycle balance");
        }

    }

    class BicycleClass implements ICycle {
        public void balance() {

            System.out.println("Bicycle balance");
        }

    }

    class TricycleClass implements ICycle {
        public void balance() {

            System.out.println("Tricycle balance");
        }
    }

    //factory class producing unicycle,bicycle,tricycle
    class CycleFactory {
        ICycle getCycle(String cycleType) {
            if (cycleType != null) {
                if (cycleType.equalsIgnoreCase("UNICYCLE")) {
                    return new UnicycleClass();
                } else if (cycleType.equalsIgnoreCase("BICYCLE")) {
                    return new BicycleClass();
                } else if (cycleType.equalsIgnoreCase("TRICYCLE")) {
                    return new TricycleClass();
                }
            }
            return null;


        }
    }

public class Assign7Part4 {

        public static void main(String[] args) {
            ICycle cycle;


            CycleFactory factory = new CycleFactory();


            cycle = factory.getCycle("unicycle");

            //calling balance method of unicycleClass

            cycle.balance();
            cycle = factory.getCycle("bicycle");

            //calling balance method of biicycleClass

            cycle.balance();
            cycle = factory.getCycle("tricycle");

            //calling balance method of tricycleClass
            cycle.balance();

        }
    }

