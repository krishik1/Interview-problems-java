package java8;
//Functional interface is interface with only one abtract method
public class Lamda {

	 int get = 0;
	public static void main(String[] args) {
		
		lamexeWithoutparam();
		lamexeWithoneparam();
		mathematical();
		Lamda l = new Lamda();
		l.mul();
		
	}
	public static void lamexeWithoutparam() {
		
		LamdaInterface m1=() ->{
			System.out.println("Welcome to Lamda");
		};
		LamdaInterface m=()->System.out.println("Welcome friend");
	
		m1.printHello();
		m.printHello();
	}
	public static void lamexeWithoneparam() {
		LamdaIntefaceexe1 m =(i)->System.out.println(i);
		m.printInput("Welcome Jagadeesh");
	}
	public static void mathematical() {
		Add x=(a,b)->{int res=a+b;
		System.out.println(res);
		return res;};
		Add mul = (a,b) -> {
			int multi = a*b;
			System.out.println(multi);
			return multi;
		};
		Add d = (a,b) -> {
			int res = a/b;
			return res;
		};
		Add z = (a,b) -> a-b;
		System.out.println(z.sum(72, 19));
		System.out.println(d.sum(39, 6));
		x.sum(10, 20);
		mul.sum(10,20);
		
	}
	public  void mul() {
		int tem=10;
		ArthematicDiv div = (a,b) -> {
			int get =1;
			this.get+=10;
			int res = a-(b+this.get
					);
			//System.out.println(res);
			return res;
		};
    System.out.println("just "+div.divi(100, 12));		
	}
	
}

