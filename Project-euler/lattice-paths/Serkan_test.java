
public class Serkan_test{

public static void main(String[] args){
	System.out.println("hello World!");

	printTriangle(5);
}

private static void printTriangle(int n){

	if(n < 1){
		System.exit(0);
	}
	printNstars(n);
	printTriangle(n-1);
}


private static void printNstars(int n) {
for (int i = 0; i < n; ++i) {
System.out.print("*") ;
}
System.out.println() ;
}


}