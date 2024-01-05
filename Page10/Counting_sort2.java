import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'countingSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> countingSort(List<Integer> arr) {
    // Write your code here
        int max = Integer.MIN_VALUE;
        int min = 0;
        for(int num : arr){
            max=Math.max(max,num);
            min=Math.min(min,num);
        }
        int range = max-min+1;
        //auxilary array to store counts of each element
        int[] count = new int[range];
        //auxilary array to store the resultant sorted array
        int[] output = new int[arr.size()];
        
        //store count of each element
        for(int j : arr){
            count[j-min]++; 
        }
        //change count[i] so that count[i] now contains actual
        //postion of this character in output array
        for(int i=1;i<count.length;i++){
            count[i] += count[i-1];
        }
        //build the output character array
        for(int i=arr.size()-1;i>=0;i--){
            output[count[arr.get(i)-min]-1]=arr.get(i);
            count[arr.get(i)-min]--;
        }
        List<Integer> ar = new ArrayList<>();
        for(int i : output){
            ar.add(i);
        }
        return ar;
        
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        List<Integer> result = Result.countingSort(arr);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
