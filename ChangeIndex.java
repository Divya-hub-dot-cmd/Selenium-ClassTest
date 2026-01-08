package test.day1;

public class ChangeIndex {
	public static void changeindex(String name) {
		
		char[] charArray=name.toCharArray();
	
		for(int i=0;i<charArray.length;i++) {
			char c=charArray[i];
			if(i%2!=0) {
				System.out.println(Character.toUpperCase(c));
			}
			else {
				System.out.println(charArray[i]);
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChangeIndex.changeindex("changeme");

	}

}
