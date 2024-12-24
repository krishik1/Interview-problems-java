package Interviewproblems;

public class DImplement implements FirstI,SecondI{
	public static void main(String[] args) {
		DImplement obj = new DImplement();
		obj.print();
	}

	@Override
	public void print() {
		System.out.println("Roger Fedrer.");
	}

}
