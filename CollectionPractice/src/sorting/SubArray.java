package sorting;

public class SubArray {
	public static void main(String[] args) {
		int[] arr = { 6, 8, -1, 7 };
		String str="alive";
		int k=subStringCount(str);
		int l=subStringCountOptimise(str);
		System.out.println("count : "+k);
		System.out.println("countOpti : "+l);
		printSubArr(arr);
	}

	private static int subStringCountOptimise(String str) {
		int count=0,n=str.length(),mod=10003;
		for(int i=0;i<n;i++) {
			if(str.charAt(i) == 'a'|| str.charAt(i) == 'e'|| 
			          str.charAt(i) == 'i' || str.charAt(i) == 'o' || 
			          str.charAt(i) == 'u') {
				count+=n-i;
			}
			count=count%mod;
		}
		return count;
	}

	private static int subStringCount(String str) {
		int count=0,mod=10003,n=str.length();
		for(int i=0;i<n;i++) {
			String s="";
			for(int j=i;j<n;j++) {
				s=s+str.charAt(j);
				System.out.println(s);
				if(s.charAt(0) == 'a'|| s.charAt(0) == 'e'|| 
				          s.charAt(0) == 'i' || s.charAt(0) == 'o' || 
				          s.charAt(0) == 'u') {
					count+=1;
				}
			}
			
			count=count%mod;
		}
		return count;
	}

	private static void printSubArr(int[] arr) {
		int n = arr.length;
		int ans=0;
		for (int i = 0; i < n; i++) {
			int sum=0;
			for (int j = i; j < n; j++) {
//				for (int k = i; k <= j; k++) {
//					System.out.print(arr[k] + " ");
//				}
				sum+=arr[j];
				ans+=sum;
				System.out.print(sum + " ");
				
			}
			System.out.println();
		}

	}

}
