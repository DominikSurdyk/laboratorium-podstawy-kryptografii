package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.bbs.check.pockeradditionals;

public class NumberBlock {
    public static int LENGTH = 4;
    public static int LAST_DIGIT_INDEX = 3;


    private Boolean digit8;
    private Boolean digit4;
    private Boolean digit2;
    private Boolean digit1;

    public void saveDigit(final int index, final boolean value){
        if (index % LENGTH == 0){
            digit8 = value;
        } else if (index % LENGTH == 1){
            digit4 = value;
        } else if (index % LENGTH == 2){
            digit2 = value;
        }else if (index % LENGTH == 3){
            digit1 = value;
        }
    }




    public int toDecimal(){
        int result = 0;
        if (digit8){
            result+=8;
        }
        if (digit4){
            result+=4;
        }
        if (digit2){
            result+=2;
        }
        if (digit1){
            result+=1;
        }
        return result;
    }
}
