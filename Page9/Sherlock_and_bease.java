import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'decentNumber' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void decentNumber(int n) {
    // Write your code here
        int z=n;
        while(z%3!=0){
            z-=5;
        }
        if(z<0){
            System.out.println("-1");
        }
        else{
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<z;i++){
                sb.append(5);
            }
            for(int i=0;i<n-z;i++){
                sb.append(3);
            }
            System.out.println(sb.toString());
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            Result.decentNumber(n);
        }

        bufferedReader.close();
    }
}
