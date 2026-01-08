package test.day1;

public class OddNumbers {
	public void printOddNumbers() {
		
		for(int i=1;i<=10;i++) {
			if(i%2==1) {
				System.out.println(i);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OddNumbers obj=new OddNumbers();
		obj.printOddNumbers();

	}

}
