package simplex;
public class Main {
	

	public static void main(String[] args) {
		
		double[][] table = {{0,-5,5,1},
				{17,4,-4,34},
				{9,5, -5,12}};
		
		
		simplextable neu = new simplex.simplextable(table);
		neu.printSimplex();
		
		System.out.println();
		System.out.println();
		neu.printnextSimplex(); 
}
}
