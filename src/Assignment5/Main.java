package Assignment5;

public class Main {
    public static void main(String[] args) {
        Data d = new Data();
        d.printMember1();
        d.printMember2();
        d.printLocalVariable();

        Singlton s = Singlton.getInstance("Ankita");
        s.getString();
    }
}
