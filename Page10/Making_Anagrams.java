import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'makingAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

    public static int makingAnagrams(String s1, String s2) {
    // Write your code here
        int[] c = new int[26];
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        
        //increasing the frequency of certain element in the array;
        for(int i=0;i<s1.length();i++){
            c[s1.charAt(i)-'a']++;
        }
        //decreasing the frequency of certain element in the array;
        for(int i=0;i<s2.length();i++){
            c[s2.charAt(i)-'a']--;
        }
        int total=0;
        for(int i:c){
            total+=Math.abs(i);
        }
        return total;
        
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = bufferedReader.readLine();

        String s2 = bufferedReader.readLine();

        int result = Result.makingAnagrams(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
