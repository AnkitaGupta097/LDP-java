package Assignment4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

class DateRange {
    private Date firstDate, lastDate, signUpDate, currDate,minDate;


    DateRange(Date signUpDate, Date currDate) {

        this.signUpDate = signUpDate;
        this.currDate = currDate;
    }


    public Date getSignUpDate() {
        return signUpDate;
    }

    public Date getFirstDate() {
        return firstDate;
    }

    public Date getLastDate() {
        return lastDate;
    }
    private void setWindowDates(){
        Calendar currDateCalanderInstance = Calendar.getInstance();
        currDateCalanderInstance.setTime(currDate);

        Calendar anniversaryDate = Calendar.getInstance();
        anniversaryDate.setTime(signUpDate);
       int signUpYear = anniversaryDate.get(Calendar.YEAR);

        anniversaryDate.set(Calendar.YEAR,currDateCalanderInstance.get(Calendar.YEAR));
        anniversaryDate.add(Calendar.DATE, -30);
        firstDate = anniversaryDate.getTime();

        //getting lastDate of range
        anniversaryDate.add(Calendar.DATE, +60);
        lastDate = anniversaryDate.getTime();

        Calendar minFormDate = Calendar.getInstance();


        minFormDate.setTime(firstDate);
        minFormDate.set(Calendar.YEAR, signUpYear+1);
        minDate=minFormDate.getTime();

    }

    public void calculateRange(){

        setWindowDates();
        //if current date before lastdate of range
        if (currDate.compareTo(lastDate) < 0 && currDate.compareTo(firstDate) > 0) {
            lastDate = currDate;


        }
        //if current date equal or before first date of range then there is no range formed
        else if (currDate.compareTo(firstDate) <= 0) {
            firstDate = null;
            lastDate = null;


        }
        //form filling range starts one year after signUpYear before that no range formed
        else if (firstDate.compareTo(minDate) < 0) {
            firstDate = null;
            lastDate = null;
        }
    }
}


public class Assignment4 {


    public static void main(String[] args) {
        String signUpDate, currDate;
        Date signUpParsedDate, currParsedDate;

        Scanner sc = new Scanner(System.in);
        int noOftestCases = sc.nextInt();


        ArrayList<DateRange> dateRangeArray = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        //inputting the signUp date and currDate for each testcase

        for (int i = 0; i < noOftestCases; i++) {
            signUpDate = sc.next();
            currDate = sc.next();

            try {
                signUpParsedDate = dateFormat.parse(signUpDate);
                currParsedDate = dateFormat.parse(currDate);

            } catch (ParseException e) {
                signUpParsedDate = null;
                currParsedDate = null;
            }

            //class of store range of date
            DateRange dr = new DateRange(signUpParsedDate, currParsedDate);
            dateRangeArray.add(dr);

        }
        for (int i = 0; i < noOftestCases; i++) {
            DateRange dr = dateRangeArray.get(i);
            if (dr.getSignUpDate() == null) {
                System.out.println("Invalid date format found");
                continue;
            }
            dr.calculateRange();
            if (dr.getFirstDate() == null) {
                System.out.println("No range");
            } else {
                //changing date into string
                System.out.println(dateFormat.format(dr.getFirstDate()) + " " + dateFormat.format(dr.getLastDate()));
            }


        }

    }
}
