package Exception;

public class Handle {
	
	public int handler(int num) {
		int x = 0;
		try {
			//int i=num/0;
			int[] arr=new int[2];
			Integer i=null;
			//System.out.println(i+1);
			 x=5;
		}catch (ArithmeticException e) {
			System.out.println("Arithmetic Exception");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBounds Exception");
		} catch (NullPointerException e) {
			System.out.println("NullPointer Exception");
		} catch (Exception e) {
			System.out.println("Exception");
		}
		finally {
			System.out.println("Completed Finally");
		}
		return x;
	}

}
