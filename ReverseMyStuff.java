/**
* @Author: Randy Scroggins <scroggir>
* @Date:   01-09-2017
* @Email:  scroggins@csus.edu
* @Project: Reverser
* @Filename: ReverseMyStuff.java
* @Last modified by:   scroggir
* @Last modified time: 15-01-2017
*/


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReverseMyStuff{
    //in class tester for the different methods

    public static void main(String[] args) {
        String test = "this is a test of our reverser _ - = = +_ .     . . . . . .  hello.";
        System.out.println("reverser: "+reverser(test)
        +"\nword reverser: "+wordReverser(test));
    }

    //takes a string and reverses the order of the chars
    public static String reverser(String orig){
        char charArray[] = new char[orig.length()];
        String reversedString = "";
        charArray = orig.toCharArray();
        for (int i = orig.length()-1,j=0;i >= 0 ;i--,j++ ) {
            //if(charArray[i]!=
            reversedString = reversedString + charArray[i];
        }
        return reversedString;
    }
    //takes a string and sends the words to get reveresed
    public static String wordReverser(String orig){
        //todo to get punctuation to stay put and keep the spaces between words
        String splitter[] = orig.split(" ");
        String complete = "";
        for(int i = 0 ; i < splitter.length; i++){
            complete = complete + reverser(splitter[i]+" ");
        }
        return complete;
    }
}
