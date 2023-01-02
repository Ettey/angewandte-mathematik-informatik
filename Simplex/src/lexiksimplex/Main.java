package lexiksimplex;


public class Main {
	public static void main(String[] args) {

		double[][] table = { { 3,0,0,0, 1,2,3}, {0,1,0,2,1,-3,-1},{0,0,1,-7,-3,7,2}};

		lexisimplex neu = new lexisimplex(table, -1);
		neu.printSimplex();
		System.out.println();
		System.out.println();
		neu.printnextSimplex();
		
		lexisimplex next = new lexisimplex(neu.getnexttable(),neu.getk());
		System.out.println();
		
		next.printnextSimplex();
		
	}
}
