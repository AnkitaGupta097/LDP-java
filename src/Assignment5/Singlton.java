package Assignment5;

public class Singlton {
    String string;

    static Singlton getInstance(String str) {
        Singlton s = new Singlton();
        s.string = str;
        return s;
    }

    public void getString() {
        System.out.println(string);
    }
}
