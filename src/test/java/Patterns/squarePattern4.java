package Patterns;

public class squarePattern4 {
	public static void main(String[] args) {
		int n=4;
		char ch='A';
		for(int i=0;i<n;i++) {//not correct
			for(int j=0;j<n;j++) {
				System.out.print(ch+" ");
			}
			System.out.println();
			ch++;
		}
	}

}
