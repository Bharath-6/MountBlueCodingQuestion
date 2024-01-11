import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'kaprekarNumbers' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER p
     *  2. INTEGER q
     */

    public static void kaprekarNumbers(int p, int q) {
    // Write your code here
        boolean found=false;
        for(int i=p;i<=q;i++){
            long sq = (long)i*i;//2025 for 45
            long count_digit = (""+i).length();//calculate the digit is 2 for 45
            long pow = (long) Math.pow(10,count_digit);//10^2=100; for two digits
            
            if((sq%pow+sq/pow)==i){// 2025%100+2025/100==45   25+20==45
                System.out.print(i+" ");
                found = true;
            }
        }
        if(!found){
            System.out.print("INVALID RANGE");
        }
        System.out.println();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int q = Integer.parseInt(bufferedReader.readLine().trim());
        

        Result.kaprekarNumbers(p, q);

        bufferedReader.close();
    }
}
