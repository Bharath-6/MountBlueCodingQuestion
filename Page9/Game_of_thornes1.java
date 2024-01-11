import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'gameOfThrones' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String gameOfThrones(String s) {
    // Write your code here
        if(s==null || s.isEmpty()){
            return "NO";
        }
        Map<Character, Integer> freqmap = new HashMap<>();
        for(char c : s.toCharArray()){
            if(freqmap.containsKey(c)){
                freqmap.put(c,freqmap.get(c)+1);
            }
            else{
                freqmap.put(c,1);
            }
        }
        //check the frequency characters
        int oddcount=0;
        for(int count : freqmap.values()){
            if(count%2==1){
                oddcount++;
            }
        }
        if(oddcount<=1){
            return "YES";
        }
        else{
            return "NO";
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.gameOfThrones(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
