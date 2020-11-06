package Assignment1;
import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaAssignment1 {

    public static void main(String[] args) {
        System.out.println("Enter any regex or -1 to stop program");
       Scanner scanner= new Scanner(System.in);
       String inputEntered=scanner.next();
        String homeDirectory = System.getProperty("user.home");
        while (!inputEntered.equals("-1")) {
            String pattern=inputEntered;
            findAndPrintFiles(pattern, homeDirectory);
            System.out.println("\nEnter next Regex or -1 to quit");
            inputEntered = scanner.next();
        }
    }



        /**
         * This method search files recursively in directory and its sub-directories
         *
         * @param pattern       this is regex pattern to be matched with file names.
         * @param directoryAbsolutePath this is the current directory we're searching in.
         */
        static void findAndPrintFiles(String pattern, String directoryAbsolutePath) {

            Pattern regex=Pattern.compile(pattern);

            File directoryNode = new File(directoryAbsolutePath);

            File[] files = directoryNode.listFiles();
            if ( files==null) {

                return;
            }

            for (File file : files) {
                if (file.isFile()) {

                    Matcher matcher = regex.matcher(file.getName());

                    if (matcher.find()) {
                        System.out.println(file.getAbsolutePath());
                    }
                }

                //Search in the subdirectory
                else {
                    findAndPrintFiles(pattern, file.getAbsolutePath());
                }
            }



        }


}


