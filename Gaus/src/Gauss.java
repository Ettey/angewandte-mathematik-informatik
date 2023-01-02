
public class Gauss {
	//Eingabe Matrix A und b 
	
	static double[][] A = {{0,1,2}, {1,0,4}, {5,3,1}};
	static double [] x;
	static double [] b;
	
	public static void main(String args[]) {
		
		if (A.length < A[0]. length) {System.out.println("nicht lösbar");}
		getSolution();
		
		
	}

	private static void getSolution() {
		//Umschreiben so dass in Zeile bei aii eine Zahl != 0 steht

		for (int Zeile = 0; Zeile < A.length; Zeile++) {
					tauscheAb(Zeile, Zeile);
			}

		printMatrix();
//		bringe in Zeilenstufi
		Zeilenstufus();
		printMatrix();
	}

	private static void Zeilenstufus() {
		for (int Spalte = 0; Spalte < A[0].length; Spalte++) {
			System.out.println("spalte nummer: " + (Spalte+1));
			for (int Zeile = Spalte+1; Zeile < A.length; Zeile++) {
				double Wert = A[Zeile][Spalte] ;
				if(Wert != 0) {
					aktZeileDurchWert(Zeile, Wert);
					System.out.println("Teile " + (Zeile+1) + " durch: " + Wert);
					printMatrix();
					aktZeileMalaii(Zeile, Spalte);
					System.out.println("Multi " + (Zeile+1) + " mit: " + A[Spalte][Spalte]);
					printMatrix();
					ZeileMinusZeile(Zeile, Spalte);
					System.out.println("Zeile " + (Zeile+1) + " minus zeile " + (Spalte+1));
					printMatrix();
					System.out.println();
				}
			}
			
		}
	}

	private static void ZeileMinusZeile(int zeile, int spalte) {
		for (int i = 0; i < A.length; i ++) {
			A[zeile][i] = A[zeile][i] - A[spalte][i];
		}
	}

	private static void aktZeileMalaii(int Zeile, int Spalte) {
		for (int i = 0; i < A[0].length; i++) {
			A[Zeile][i] = A[Zeile][i] * A[Spalte][Spalte];
			
		}
	}

	private static void aktZeileDurchWert(int zeile,double Wert) {
		for (int i = 0; i < A[0].length; i++) {
			A[zeile][i] = A[zeile][i]/ Wert;
			
		}
		
	}

	private static void tauscheAb(int Zeile, int Spalte) {
		int temp = -1;
		
		for (int i = Zeile; i < A.length; i++) {
			if (A[i][Spalte] != 0) {
				temp = i;
				
			}
			
			
		}
		
		if (temp == -1) {System.out.println("NullSpalte bei index: " + Spalte);
		x[Spalte] = 0;
		
		} else if (temp != Zeile){
			vertauscheZeilen(Zeile, temp);
		}
	}

	private static void vertauscheZeilen(int zeile, int temp) {
		double[] tempA = new double[A[0].length];
		for (int i = 0; i < tempA.length; i++) {
			tempA[i] = A[zeile][i];
			A[zeile][i] = A[temp][i];
			A[temp][i] = tempA[i];
		}
		
		
	}

	private static void printMatrix() {
		for (int Zeile = 0; Zeile < A.length; Zeile++) {
			for (int Spalte = 0; Spalte < A[0].length; Spalte++) {
			System.out.print(A[Zeile][Spalte] + "\t");
			}
			System.out.println(" ");
		}
		
	}
	
	
}
