package tech.mahinda;

public class Client {
	public static void main(String[] args) {
		int[] ip= {6, 4, 2, 4, 3, 20, 1};
		int inday=-1,endday=0;
		int max = Integer.MIN_VALUE;
		int st=0;
		for(int i=1;i<ip.length;i++){
			if(ip[st]<=ip[i]){
				if(max<ip[i]-ip[st]) {
					max=ip[i]-ip[st] ;
					endday=i;
					inday=st;
				}
			} else{
				st=i;
			}
		}
		
		System.out.println(max);
		System.out.println("start day :"+inday+" end day : "+endday);
		
	}

}
