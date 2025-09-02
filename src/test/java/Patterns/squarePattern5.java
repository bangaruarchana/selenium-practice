package Patterns;

public class squarePattern5 {
public static void main(String[] args) {
	int n=4;int num=1;
	char ch='A';

	for(int i=0;i<n;i++) {//correct
		for(int j=0;j<n;j++) {
			if(i%2==0) {
				System.out.print(ch+" ");
				ch++;
			}
			else {
				System.out.print(num+" ");
				num++;
			}
		}
		System.out.println();
	}
	
	
}
}
