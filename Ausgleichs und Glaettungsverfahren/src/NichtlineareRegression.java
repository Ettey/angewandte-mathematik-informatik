
public class NichtlineareRegression {
//	Betrahten nur kubische Funktionen
//	s(t) = Summe(O(i)*(t^i)) + Summe(v(i) *((t-t(i))^3+)
//			0 bis 3				1 bis n
	
	
static	double[] Y = {2,0,0,2,6};
static	double[] X =  {-2,-1,0,1,2};
static double[][] X_matrix_basisfunk = new double[X.length][X.length+4];
static double Gamma = 0;
static double[][] G;
static double[] Beta = new double[X.length+4];;

/*Basisfunktionen:
 *  1
 *  t
 *  t²
 *  t³
 * 	(t-X_1)³
 * 	(t-X_2)³
 * 	(t-X_3)³
 * 	.
 * 	.
 * 	.
 */
	
public static void main(String[] arg) {
	
	berechneX_matrix_basisfunk();
	if (Gamma != 0) {
		berechneG_matrix();
		berechneBetamitG();
}
	else {
		berechneBetaohneG();
	}
	
	
	
	
}

private static void berechneBetaohneG() {
	System.out.print("{");
	for (int Zeile = 0; Zeile < Y.length; Zeile++) {
		for (int Spalte = 0; Spalte < Y.length+4; Spalte++) {
			if (Spalte == 0) System.out.print("{");
			System.out.print(X_matrix_basisfunk[Zeile][Spalte] );
			if (Spalte < Y.length+3) System.out.print( ",	");
			else  System.out.print("},");
			}
		System.out.print("\n");
	}
	System.out.print("}");
}

private static void berechneBetamitG() {
	// TODO Auto-generated method stub
	
}

private static void berechneG_matrix() {
	
	
	for(int Zeile = 0; Zeile < X.length; Zeile++) {
		for (int Spalte = 0; Spalte < X.length+4; Spalte++) {
			
			if ( Zeile == Spalte+4)
				G[Zeile][Spalte] = 1;
			else 
				G[Zeile][Spalte] = 0;	
				
			
		}
		
	}
}

private static void berechneX_matrix_basisfunk() {
		for(int Zeile = 0; Zeile < X.length; Zeile++) {
			for (int Spalte = 0; Spalte < X.length+4; Spalte++) {
				if (Spalte == 0)
					X_matrix_basisfunk[Zeile][Spalte] = 1;
				else if (Spalte == 1) {
					X_matrix_basisfunk[Zeile][Spalte] = X[Zeile];;
					
				} else if (Spalte == 2) {
					
					X_matrix_basisfunk[Zeile][Spalte] = X[Zeile] * X[Zeile];
					
				} else  if (Spalte == 3) {
					X_matrix_basisfunk[Zeile][Spalte] = X[Zeile] * X[Zeile] *  X[Zeile];
					
				} else  if (Spalte == 4) {
					X_matrix_basisfunk[Zeile][Spalte] = ((X[Zeile]-X[0] )* (X[Zeile]-X[0])  *   (X[Zeile]-X[0]));
					
				} else  if (Spalte == 5) {
					X_matrix_basisfunk[Zeile][Spalte] = ((X[Zeile]-X[1] )* (X[Zeile]-X[1])  *   (X[Zeile]-X[1]));
					
				} else if (Spalte == 6) {
					
					X_matrix_basisfunk[Zeile][Spalte] = ((X[Zeile]-X[2] )* (X[Zeile]-X[2])  *   (X[Zeile]-X[2]));
					
				} else if (Spalte == 7) {
				
				X_matrix_basisfunk[Zeile][Spalte] = ((X[Zeile]-X[3] )* (X[Zeile]-X[3])  *   (X[Zeile]-X[3]));
				
			} else if (Spalte == 8) {
				
				X_matrix_basisfunk[Zeile][Spalte] = ((X[Zeile]-X[4] )* (X[Zeile]-X[4])  *   (X[Zeile]-X[4]));
				
			}
					
			}//ende Spaltenschleife
		}
}



}
