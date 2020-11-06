package Assignment6;

class VampireNumbers {
    int vampireNumbers[];
    private int numberToCheck=10;
    VampireNumbers(int count){
        vampireNumbers=new int[count];
    }

    public void findVampireNumbers(){
        int count=0;
        while (count<vampireNumbers.length){
            boolean isVampireNumber=checkVampire(numberToCheck);
            if(isVampireNumber){
                vampireNumbers[count++]=numberToCheck;
            }
            numberToCheck=getNextEvenDigitNumber(numberToCheck);
        }

    }
    private int getNextEvenDigitNumber(int number){
        number++;
        String num=String.valueOf(number);
        if (num.length() % 2 == 1) {
            num = num.concat("0");
        }
        return Integer.parseInt(num);
    }
    public void printVampireNumbers(){
        if (vampireNumbers.length>0){
            for (int vnumber:vampireNumbers){
                System.out.println(vnumber);
            }
        }
    }
    private boolean checkVampire(int number){
        String numInString=String.valueOf(number);
        return !isPrime(number)&& permutationAndCheckVampire(numInString, 0, numInString.length() - 1);
    }
    private String swap(String num, int index1, int index2) {
        char temp;
        char numArray[] = num.toCharArray();
        temp = numArray[index1];
        numArray[index1] = numArray[index2];
        numArray[index2] = temp;
        num = String.valueOf(numArray);
        return num;
    }

    private boolean permutationAndCheckVampire(String num, int startIndex, int endIndex) {
        if(startIndex==endIndex){
            boolean isVampire= checkFangsMultipication(num);
            return isVampire;
        }

        for (int i=startIndex;i<=endIndex;i++){

            num=swap(num,startIndex,i);
            boolean isVampireFound=permutationAndCheckVampire(num,startIndex+1,endIndex);
            if(isVampireFound){
                return true;
            }
            num=swap(num,startIndex,i);

        }
        return false;
    }

    //multiply two fangs to check whether they equal to number itself
    private boolean checkFangsMultipication(String permutedNum) {
        String one, two;
        char lastCharInFirstFang,lastCharInSecondFang;
        one = permutedNum.substring(0, permutedNum.length() / 2);
        two = permutedNum.substring(permutedNum.length() / 2);
        lastCharInFirstFang=one.charAt(one.length()-1);
        lastCharInSecondFang=one.charAt(two.length()-1);

        if(lastCharInFirstFang=='0' && lastCharInSecondFang=='0'){
            return false;
        }
        if ((Integer.parseInt(one) * Integer.parseInt(two)) == numberToCheck) {
            return true;
        }
        return false;
    }

    private boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;

        }
        return true;
    }

}

class DriverClass{
    public static void main(String[] args) {
        System.out.println("first 100 vampire numbers are:-");
        VampireNumbers v1=new VampireNumbers(100);
        v1.findVampireNumbers();
        v1.printVampireNumbers();
    }

}