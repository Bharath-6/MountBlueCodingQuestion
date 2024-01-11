import java.util.ArrayList;
import java.util.List;

public class Cracity_map {
    public static List<String> cavityMap(List<String> grid) {
    // Write your code here
        int n=grid.size();
        char[][] matrix = new char[n][n];
        for(int i=0;i<n;i++){
            matrix[i]=grid.get(i).toCharArray();
            
        }
        //check the for the cavity to mark x;
        for(int i=1;i<n-1;i++){
            for(int j=1;j<n-1;j++){
                int currentdepth = Character.getNumericValue(matrix[i][j]);
                int top = Character.getNumericValue(matrix[i-1][j]);
                int bottom = Character.getNumericValue(matrix[i+1][j]);
                int left = Character.getNumericValue(matrix[i][j-1]);
                int right = Character.getNumericValue(matrix[i][j+1]);
                
                if(currentdepth>top && currentdepth>bottom && currentdepth>left && currentdepth>right){
                    matrix[i][j]='X';
                }
            }
        }
        //convert the character arrays to back string
        List<String> result = new ArrayList<>();
        for(int i=0;i<n;i++){
            result.add(String.valueOf(matrix[i]));
        }
        return result;
}
