package Interviewproblems;

import java.util.Arrays;
import java.util.HashMap;

public class EqualRowColumnPairs {
	public static void main(String[] args) {
		int[][] grid = {{3,2,1},{1,7,6},{2,7,7}};
		System.out.println("res : "+equalPairs2(grid));
	}
	/*TC:O(n^2),SC:O(n)*/
	public static int equalPairs1(int[][] grid) {
		int n=grid.length,ans=0;
		HashMap<String, Integer> row=new HashMap<>();
		HashMap<String, Integer> col=new HashMap<>();
		for(int i=0;i<n;i++) {
			StringBuilder sb = new StringBuilder();
			for(int j=0;j<n;j++) {
				sb.append(grid[i][j]);
			}
			String str=sb.toString();
			row.put(str, row.getOrDefault(str, 0)+1);
		}
		
		for(int i=0;i<n;i++) {
			StringBuilder sb = new StringBuilder();
			for(int j=0;j<n;j++) {
				sb.append(grid[j][i]);
			}
			String str=sb.toString();
			col.put(str, col.getOrDefault(str, 0)+1);
		}
		for(String s:row.keySet()) {
			if(col.containsKey(s)) {
				ans+=col.get(s)*row.get(s);
			}
		}
		return ans;
	}
	/*TC:O(n^2),SC:O(n)*/
	public static int equalPairs(int[][] grid) {
        int n=grid.length;
        int[][] gt =new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++) {
                gt[j][i]=grid[i][j];
            }
        }
        int cnt=0;
        for(int[] row:grid){
            for(int[] col:gt){
                if(Arrays.equals(row,col)){
                    cnt++;
                }
            }
        }
        return cnt;
    }
	/*TC:O(n^3),SC:O(1)*/
	public static int equalPairs2(int[][] grid) {
		int n=grid.length,cnt=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				boolean flag=true;
				for(int k=0;k<n;k++) {
					if(grid[i][k]!=grid[k][j]) {
						flag=false;
					}
				}
				if(flag) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	
}
