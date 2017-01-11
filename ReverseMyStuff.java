import java.util.*;


public class ReverseMyStuff{
    public static String reverser(String orig){
        char charArray[] = new char[orig.length()];
        String reversedString = "";
        charArray = orig.toCharArray();

        for (int i = orig.length()-1,j=0;i >= 0 ;i--,j++ ) {
            reversedString = reversedString + charArray[i];
        }
        //System.out.println(tempArray.toString());
        return reversedString;
    }

    //testing purposes
    /*
    public static void main(String[] args) {
        reverser("hello");
    }
    */
}
