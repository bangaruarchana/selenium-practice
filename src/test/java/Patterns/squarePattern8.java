package Patterns;

public class squarePattern8 {
public static void main(String[] args) {
	int n=4;int sum=1;char ch='A';
	for(int i=0;i<n;i++) {// not correct
		for(int j=0;j<n;j++) {
			if(j%2==0) {
				System.out.print(ch+" ");
				
			}
			else{
				System.out.print(sum+" ");
			}
			if(j==2) {
				ch++;
			}
		
		}
		System.out.println();
		
		



	}
}
}
