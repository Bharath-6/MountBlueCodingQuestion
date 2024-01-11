import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'anagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int anagram(String s) {
    // Write your code here
        if(s.length()%2!=0){
            return -1;
        }
        int mid = s.length()/2;
        String s1 = s.substring(0,mid);
        String s2 = s.substring(mid);
        
        int[] charCount = new int[26];
        //count character in the first substring
        for(char ch: s1.toCharArray()){
            charCount[ch-'a']++;
        }
        //subtract the count in second substring
        for(char ch: s2.toCharArray()){
            charCount[ch-'a']--;
        }
        int changesneed = 0;
        for(int count: charCount){
            changesneed+=Math.abs(count);
        }
        return changesneed/2;
        
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            String s = bufferedReader.readLine();

            int result = Result.anagram(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
