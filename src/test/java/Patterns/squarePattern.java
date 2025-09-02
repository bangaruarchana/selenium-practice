package Patterns;

public class squarePattern {

	public static void main(String[] args) {
		
		int n=4;int sum=1;
		for(int i=0;i<n;i++) {//correct
			char ch='A';
			for(int j=0;j<n;j++) {
					
			System.out.print(ch+" ");
			ch++;
			}
			System.out.println();
			if(ch=='A') {
				ch++;
			}
			
		}
		
		}
	}

