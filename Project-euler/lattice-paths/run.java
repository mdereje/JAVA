public class run{

	public static void main(String[] args){

		run rec1 = new run();
		long sol = 0;
		for(int i = 0; i <= 10; i++){
			switch (i){
				case 1: sol = 2;
						break;
				case 2: sol = 6;
						break;
				case 3: sol = 20;
						break;
				case 4: sol = 70;
						break;
				case 5: sol = 252;
						break;
				case 6: sol = 924;
						break;
				case 7: sol = 3432;
						break;
				case 8: sol = 12870;
						break;
				case 9: sol = 48620;
						break;
				case 10: sol = 184756;
						break;
			}
			long twentySolution = rec1.findAllPaths(i, i);
			if(twentySolution == sol){
				System.out.print(i +" x " + i + " = " + twentySolution);
				System.out.println("...test passed!");
			}else{
				System.out.print(i +" x " + i + " = " + twentySolution);
				System.out.println("...test failed");
			}
			
		}
		
		
	}
	public long findAllPaths(int x, int y){	
		return (x == 0 || y == 0) ? 1 : (findAllPaths(x-1, y) + findAllPaths(x, y-1));
	}

}