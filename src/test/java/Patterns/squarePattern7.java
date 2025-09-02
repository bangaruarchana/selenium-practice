package Patterns;

public class squarePattern7 {
public static void main(String[] args) {
	int n=4;int sum=1;char ch='A';
	for(int i=0;i<n;i++) {// correct
		for(int j=0;j<n;j++) {
			if(i%2==0) {
				System.out.print(ch+" ");
			}
			else {
				System.out.print(sum+" ");	
			}
		
		}
		System.out.println();
		if(ch=='A') {
			ch++;
		
		}
		else if(sum==1) {
			sum++;
		}



	}
}
}
