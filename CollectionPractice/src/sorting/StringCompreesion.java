package sorting;

public class StringCompreesion {
	public static void main(String[] args) {
		String str="aaabbbccccccddfffff";
		//String ans=getRes(str);
		int ans=getRes(str);
		System.out.println("ans :"+ans);
	}
	public static int getRes(String str) {
		//int[] freq=new int[26];
		char[] chars=str.toCharArray();
		int cnt=1;
        String s=chars[0]+""; 
        for(int i=1;i<chars.length;i++){
            char curr=chars[i];
            char prev=chars[i-1];
            if(curr==prev){
                cnt++;
            } else{
                if(cnt>1){
                    s+=cnt;
                    cnt=1;
                }
                s+=curr;
            }
        }
        if(cnt>1){
            s+=cnt;
        }
        return s.length();
    }
	}

