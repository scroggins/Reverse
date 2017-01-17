/**
* @Author: Randy Scroggins <scroggir>
* @Date:   09-01-2017
* @Email:  scroggins@csus.edu
* @Project: Reverser
* @Filename: ReverseMyStuff.java
* @Last modified by:   scroggir
* @Last modified time: 16-01-2017
*/

class ReverseMyStuff{
    //in class tester for the different methods
/*
    public static void main(String[] args) {
        String test = "this is a test of our reverser _ - = = +_ .     . . . . . .  hello.";
        System.out.println("reverser: "+reverser(test)
        +"\nword reverser: "+wordReverser(test));
    }
*/
    //takes a string and reverses the order of the chars
    static String reverser(String orig){
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
    static String wordReverser(String orig){
        //todo to get punctuation to stay put
        String splitter[] = orig.split(" ");
        String complete = "";
        for(int i = 0 ; i < splitter.length-1; i++){
            complete = complete + reverser(splitter[i])+" ";
        }
        //so the last word wont have a space after it
        complete = complete + reverser(splitter[splitter.length-1]);
        return complete;
    }
}
