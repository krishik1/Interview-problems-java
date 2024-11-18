package temp;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxOnesInMAtrix {
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> mat = new ArrayList<>(); mat.add(new ArrayList<>(Arrays.asList(0,0,1,1))); mat.add(new ArrayList<>(Arrays.asList(0, 0, 0,1))); mat.add(new ArrayList<>(Arrays.asList(1,1,1,1)));
		int n = 3; int m = 4;
		System.out.println("Row with maximum ones: " + rowMaxOnes(mat, n, m));
		
	}
public static int rowMaxOnes(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        
        int i=0,j=m-1;
        int ans=-1;
        if (mat == null || mat.size() < n) {
            return ans;
        }
        for (ArrayList<Integer> row : mat) { 
            if (row == null || row.size() != m) {
                 return ans; 
            } 
        }
        while(i<n && j>=0){
            if(mat.get(i).get(j)==1){
                while(j>=0 && mat.get(i).get(j)==1){
                    j--;
                }
                ans=i;
            } else{
                i++;
            }
        }
        
        return ans;
    }

}
