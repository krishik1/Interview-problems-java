package Greedy;

import java.util.ArrayList;

public class DP {
	 static ArrayList<ArrayList<Integer>> dp=new ArrayList<>();
	public static void main(String[] args) {
		int[][] input = {{0, 0}, {0, 0}, {0, 0}, {1, 0}, {0, 0}};
		 ArrayList<ArrayList<Integer>> result=new ArrayList<>();
		 for (int[] row : input) {
	            ArrayList<Integer> newRow = new ArrayList<>();
	            for (int value : row) {
	                newRow.add(value);
	            }
	            result.add(newRow);
	        }
		 int res=uniquePathsWithObstacles(result);
		 System.out.println("res :"+res);
	}
	
	public static int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> B) {
		int x=B.size();
        int y=B.get(0).size();
        System.out.println("x :"+x+"y: "+y);
        for (int i = 0; i <= x; i++) {
            dp.add(new ArrayList<>());
            for (int j = 0; j <= y; j++) {
            	dp.get(i).add(-1);
            }
        }
        
         return getPath(B,x-1,y-1);
		
	}
	public static int getPath(ArrayList<ArrayList<Integer>> B, int x, int y) {
		if(B.get(x).get(y)==1){
            return 0;
        }
        System.out.println("i :"+x+" j :"+y);
        if(x==0&&y==0){
        	return 1;
        }
        
        if(dp.get(x).get(y)!=-1) return dp.get(x).get(y);
        int top=(x>0)?getPath(B,x-1,y):0;
        int left=(y>0)?getPath(B,x,y-1):0;
        dp.get(x).set(y,top+left);
        return dp.get(x).get(y);
    }

	

}
