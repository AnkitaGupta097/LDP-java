package Assignment2;

import java.util.Scanner;

public class Assignment2 {

    public static void main(String args[])
    {
        System.out.println("Enter any string");

        Scanner sc=new Scanner(System.in);
        String inputString=sc.nextLine();
        int numberOfCharacters=inputString.length();
        if(numberOfCharacters>=26 && isContainsAllAlphabet(inputString))
        {
            System.out.println("Yes input string have all alphabets");
        }
        else
        {
            System.out.println("no");
        }
    }


    static boolean isContainsAllAlphabet(String inputString) {


        int countFrequency[] = new int[26];

        // Traverse all characters of input string

        for (char character : inputString.toCharArray()) {

            if (character >= 'a' && character <= 'z') {
                countFrequency[character - 97]++;
            } else if (character >= 'A' && character <= 'Z') {
                countFrequency[character - 65]++;

            }


        }
        // Return false if any character has frequency 0
        for (int alphabetFrequency:countFrequency) {
            if (alphabetFrequency== 0) {
                return false;
            }
        }

        // If all characters were present return true
        return true;
    }

}
