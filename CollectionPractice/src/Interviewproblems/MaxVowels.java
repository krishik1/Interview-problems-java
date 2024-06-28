package Interviewproblems;

/*
 * Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
*/
public class MaxVowels {
	public static void main(String[] args) {
		System.out.println("res : "+maxVowels("abciiidef", 3));
	}
	public static int maxVowels(String s, int k) {
        int max=Integer.MIN_VALUE;
        int c=0;
        for(int i=0;i<k;i++){
            if(isVowel(s.charAt(i))){
                c++;
            }
        }
       
        max=Math.max(max,c);
        int st=0,e=k,n=s.length();
        while(e<n){
            if(isVowel(s.charAt(st))){
                c--;
            }
            if(isVowel(s.charAt(e))){
                c++;
            }
            max=Math.max(max,c);
            st++;e++;
        }
        return max;
    }
    private static boolean isVowel(char ch){
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' ||ch=='u') {
            return true;
        }
        return false;
    }

}
