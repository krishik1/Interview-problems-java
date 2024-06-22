package leetcode;

import java.util.Arrays;

public class Island {
	
	public static void main(String[] args) {
		int[][] mat= {{1,2,3},{4,5,6},{7,8,9}};
		int ans=minFallingPathSum(mat);
		System.out.println("ans : "+ans);
//		int[][] res=findFarmland(mat);
//		for(int i=0;i<res.length;i++) {
//			for(int j=0;j<res[0].length;j++) {
//				System.out.print(res[i][j]+' ');
//			}
//			System.out.println();
//		}
		
	}
	
//	public static int[][] findFarmland(int[][] land) {
//        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
//        int m = land.length,n = land[0].length;
//        int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (land[i][j] == 1) {
//                    ArrayList<Integer> list=new ArrayList<>();
//                    list.add(i);
//                    list.add(j);
//                    int[] max = {i, j};
//                    dfs(land,i,j,list,dir,max);
//                    res.add(new ArrayList<>(list));
//                }
//            }
//        }
//
//        int rows = res.size();
//        
//
//        int[][] resultArray = new int[rows][4];
//
//        for (int i = 0; i < rows; i++) {
//            ArrayList<Integer> innerList = res.get(i);
//            for (int j = 0; j < 4; j++) {
//                resultArray[i][j] = innerList.get(j);
//            }
//        }
//        
//        return resultArray;
//
//    }
//
//    public static void dfs(int[][] land,int i,int j,ArrayList<Integer> list,int[][] dir,int[] max){
//            if(i<0 || i>=land.length || j<0 || j>=land[0].length || land[i][j]==0){
//                list.add(max[0]);
//                list.add(max[1]);
//                return;
//            }
//            land[i][j] = 0;
//            max[0] = Math.max(max[0], i);
//            max[1] = Math.max(max[1], j);
//            for (int k = 0; k < dir.length; k++) {
//                int rx = i + dir[k][0];
//                int cx = j + dir[k][1];
//                dfs(land, rx, cx, list, dir, max);
//            }
//        }
	
	static int[][] dp;
    public static int minFallingPathSum(int[][] grid) {
        int n=grid.length;
        int ans=Integer.MAX_VALUE;
        if(n==1){
            for(int i=0;i<grid[0].length;i++){
                ans=Math.min(ans,grid[0][i]);
            }
            return ans;
        }
       dp=new int[205][205];
      
       for(int[] row:dp){
            Arrays.fill(row,-1);
       }
       
       for(int i=0;i<n;i++){
            ans=Math.min(ans,getMinpath(grid,0,i));
       }
       return ans;
    }
    public static int getMinpath(int[][] grid,int i,int j){
        if(i==grid.length){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int min=Integer.MAX_VALUE;
        for(int k=0;k<grid[0].length;k++){
            if(k!=j) {
                min=Math.min(min,getMinpath(grid,i+1,k));   
            }
        }
        return dp[i][j]=min+grid[i][j];
    }


}
