public class UserNum
{
    public UserNum(String aString) throws Exception
    {
        aString = aString.replaceAll("\\s", "");
        numInString = aString;

        for(int i = 0; i < aString.length(); i++)
        {
            if(!(arabic.contains(String.valueOf(aString.charAt(i)))))
            {
                isArabic = false;
                break;
            }
        }

        for(int i = 0; i < aString.length(); i++)
        {
            if(!(roman.contains(String.valueOf(aString.charAt(i)))))
            {
                isRoman = false;
                break;
            }
        }
        if(isArabic||isRoman)
        {
            converter(aString);
        }
        else
        {
            throw new Exception("строка не является числом");
        }



    }
    void converter(String numString) throws Exception
    {
        if(isArabic)
        {
            if (0 < Integer.valueOf(numString) && Integer.valueOf(numString) <= 10) {
                valueOfNum = Integer.valueOf(numString);
            }
            else
                throw new Exception("Было введено число вне диапазона от 1  до 10");

        }
        if(isRoman)
        {
            switch (numString)
            {
                case "I":
                    valueOfNum = 1;
                    break;
                case "II":
                    valueOfNum = 2;
                    break;
                case "III":
                    valueOfNum = 3;
                    break;
                case "IV":
                    valueOfNum = 4;
                    break;
                case "V":
                    valueOfNum = 5;
                    break;
                case "VI":
                    valueOfNum = 6;
                    break;
                case "VII":
                    valueOfNum = 7;
                    break;
                case "VIII":
                    valueOfNum = 8;
                    break;
                case "IX":
                    valueOfNum = 9;
                    break;
                case "X":
                    valueOfNum = 10;
                    break;
                default:
                    throw new Exception("Было введено число вне диапазона от I до X");
            }


        }
    }


    String numInString;
    String arabic = "1234567890";
    String roman = "IVXLCDM";
    boolean isArabic = true;
    boolean isRoman = true;

    int valueOfNum;

}
