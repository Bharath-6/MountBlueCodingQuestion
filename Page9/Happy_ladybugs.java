import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'happyLadybugs' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING b as parameter.
     */

    public static String happyLadybugs(String b) {
    // Write your code here
        if(b.isEmpty()){
            return "NO";
        }
        char[] arr = b.toCharArray();
        //check if there is at lease one empty cell
        boolean hasempty = false;
        for(char c:arr){
            if(c=='_'){
                hasempty=true;
                break;
            }
        }
        if(!hasempty){
            for(int i=0;i<arr.length-1;i++){
                if(arr[i]!=arr[i+1]){
                    return "NO";
                }
            }
            return "YES";
        }
        //check if there are at least two ladybugs of the same color
        Map<Character, Integer> freq = new HashMap<>();
        for(char c : arr){
            if(c!='_'){
                if(freq.containsKey(c)){
                    freq.put(c,freq.get(c)+1);
                }
                else{
                    freq.put(c,1);
                }
            }
            
           
        }
        for(int count : freq.values()){
            if(count<2){
                return "NO";
            }
        }
        return "YES";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = Integer.parseInt(bufferedReader.readLine().trim());

        for (int gItr = 0; gItr < g; gItr++) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            String b = bufferedReader.readLine();

            String result = Result.happyLadybugs(b);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
