package Patterns;

public class squarePattern6 {
public static void main(String[] args) {
	int n=4; int sum=1; 	char ch='A';
for(int i=0;i<n;i++) {//correct

	for(int j=0;j<n;j++) {
		if(i%2!=0) {
			System.out.print(sum+" ");
			sum++;
		}
		else {
			System.out.print(ch+" ");
		}
	
	
	}
	System.out.println();
	if(ch=='A') {
		ch++;
	}



}
}
}