package java8;

public class Demo {
    public static void main(String[] args) {
       String str = "This.is.demo.text.and.demo.line!";
       String[] res = str.split("[.]", 0);
       String strev="";
       for(int i=res.length-1;i>=0;i--) {
    	   if(i==0) {
    		   strev+=res[i];
    	   } else {
    		   strev+=res[i]+".";
    	   }
       }
       System.out.println(strev);
       
//       for(String myStr: res) {
//    	   
//          System.out.println(myStr);
//       }
    }
}