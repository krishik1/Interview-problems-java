package regular.expression;

public class regExpImpl {
	public static void main(String[] args) {
		String name = "krishikmahatho";
		String name1="";
		String regex = "[a-zA-Z0-9]{4,8}|";
		String dobRegex = "\\d{2}(/|-)\\d{2}\\1\\d{4}";
		String mobile = "^\\+\\d{2}(-| )?\\d{3}\\1\\d{3}\\1\\d{4}$";
		String email = "[a-z0-9]+@[a-z]+\\.[a-z]{2,}$";
		
		
		/*it return true for both epmty String and a-z*/
		System.out.println(name.matches("[a-z]*"));
		/*it return true only if string lies in a-z*/
		System.out.println(name.matches("[a-z]+"));
		/*accepts 4-8 char or digits*/
		System.out.println(checkRegex(regex));
		
		/*accepts both 29/05/1998 and 29-05-98*/
		System.out.println(checkRegexDob(dobRegex));
		/*accepts both "+91 810 694 4924" and "+91+810+694+4924"*/
		System.out.println(chaeckMobileNo(mobile));
		/*accepts email addess eg:rajukrishna741@gmail.com*/
		System.out.println(checkemail(email));
	}
	
	private static boolean chaeckMobileNo(String mobile) {
		String mob = "+91 810 694 4924";
		return mob.matches(mobile);
	}

	public static boolean checkRegex(String reg) {
		String str = "krish12";
		return str.matches(reg);
	}
	
	public static boolean checkemail(String email) {
		String str = "rajukrishna741@gmail.com";
		return str.matches(email);
	}
	
	public static boolean checkRegexDob(String dobRegex) {
		String str = "29/05/1998";
		return str.matches(dobRegex);
	}
	
	
}
