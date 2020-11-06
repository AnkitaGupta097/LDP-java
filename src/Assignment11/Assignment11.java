package Assignment11;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Assignment11 {
    public static void main(String[] args) throws IOException {
        FrequencyCounter fc = new FrequencyCounter();
        if (args[0] != null) {
            fc.printFrequencyCharFrequency(args[0], "outputFile");
        } else {
            System.out.println("You have not passed input file name to read");
        }
    }
}

class FrequencyCounter {

    public void printFrequencyCharFrequency(String inputFile,String outputFile) throws IOException {
        Map<Character,Integer> map=new HashMap<Character,Integer>();


        FileReader textFileToRead =new FileReader(inputFile);

        int character;
        while((character=textFileToRead.read()) != -1)
        {
            char readedChar=(char) character;
            if(map.containsKey(readedChar))
            {
                int frequency= map.get(readedChar)+1;
                map.put(readedChar,frequency);
            }
            //if character is not a space and new line and occured first time then set its frequency by 1
            else
            {
                map.put(readedChar,1);
            }

        }

        textFileToRead.close();

        //write  on output file every character(key) present in map with frequency as its value
        FileWriter file =new FileWriter("OutputFile");

        file.write("characters :frequency\n");

        for(char key :map.keySet())
        {
            file.write(key+"  "+map.get( key));
            file.write("\n");

        }

        file.close();


    }
}

