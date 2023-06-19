import java.util.Scanner;
import java.util.regex.Pattern;

public class Main
{

    static String opSplit(String someString) throws Exception
    {
        int counter = 0;
        String sybmol = "";
        String symbols = "\\+-\\*/";
        for(int i = 0; i<someString.length(); i++)
        {
            if(symbols.contains(String.valueOf(someString.charAt(i))))
            {
                counter++;
                sybmol = String.valueOf(someString.charAt(i));
            }
        }
        if (counter == 0)
        {
            throw new Exception("в строке нет знака операции");

        }
        else if (counter > 1)
        {
            throw new Exception("в строке больше одного оператора(+ - * /)");

        }
        else
            return sybmol;
    }




    static void oneOperation() throws Exception
    {
        Scanner userCheck = new Scanner(System.in);

        System.out.println("Enter operation");
        String userString = userCheck.nextLine();

        System.out.println("You entered: "+userString);

        String symbol;
        symbol = opSplit(userString);

        String[] twoNums;
        twoNums = userString.split(Pattern.quote(symbol));

        UserNum userNum1 = new UserNum(twoNums[0]);
        UserNum userNum2 = new UserNum(twoNums[1]);

        int resoult = 0;
        if((userNum1.isArabic == userNum2.isArabic) && (userNum1.isRoman == userNum2.isRoman))
        {
            switch (symbol)
            {
                case "+":
                    resoult = userNum1.valueOfNum + userNum2.valueOfNum;
                    break;
                case "-":
                    resoult = userNum1.valueOfNum - userNum2.valueOfNum;
                    break;
                case "*":
                    resoult = userNum1.valueOfNum * userNum2.valueOfNum;
                    break;
                case "/":
                    resoult = userNum1.valueOfNum / userNum2.valueOfNum;
            }
        }
        else throw new Exception("используются одновременно разные системы счисления");

        if(userNum1.isArabic)
        {
            System.out.println("Resoult: " + resoult);
        }
        if(userNum1.isRoman)
        {
            if (resoult>0)
            {
            System.out.println("Resoult: " + romanConverter(resoult));
            }
            else throw new Exception("В римской системе нет отрицательных чисел");
        }


    }

    static String romanConverter (int num)
    {
        int tens;
        int ones;
        String romanTen = "";
        String romanOne = "";

        ones = num % 10;
        tens = num / 10;


        switch (ones)
        {
            case 0: romanOne = "";
                break;
            case 1: romanOne = "I";
                break;
            case 2: romanOne = "II";
                break;
            case 3: romanOne = "III";
                break;
            case 4: romanOne = "IV";
                break;
            case 5: romanOne = "V";
                break;
            case 6: romanOne = "VI";
                break;
            case 7: romanOne = "VII";
                break;
            case 8: romanOne = "VIII";
                break;
            case 9: romanOne = "IX";
                break;
        }
        switch (tens)
        {
            case 0: romanTen = "";
                break;
            case 1: romanTen = "X";
                break;
            case 2: romanTen = "XX";
                break;
            case 3: romanTen = "XXX";
                break;
            case 4: romanTen = "XL";
                break;
            case 5: romanTen = "L";
                break;
            case 6: romanTen = "LX";
                break;
            case 7: romanTen = "LXX";
                break;
            case 8: romanTen = "LXXX";
                break;
            case 9: romanTen = "XC";
                break;
            case 10: romanTen = "C";
                break;
        }

        return romanTen+romanOne;
    }

    public static void main(String[] args)
    {

        try {
            oneOperation();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }




    }
}
