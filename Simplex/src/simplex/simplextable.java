package simplex;

public class simplextable {

	private double[][] table;
	private double[][] nexttable;

	private int l = -1;
	private int k = -1;

	public simplextable(double[][] table) {
		this.table = table;
		berechnenexttable();
	}

	
	
	private void berechnenexttable() {
		if (table[0].length == 0)
			System.out.println("table schein quatsch");
		findeprivSpalte();
		findeprivZeile();
		
		berechnenext();
		
	}

	private void berechnenext() {
		
		nexttable = new double[table.length][table[0].length];
		for (int Zeile = 0; Zeile < nexttable.length; Zeile++) {
			for (int Spalte = 0; Spalte < nexttable[0].length; Spalte++) {
				
				if (Zeile == k && Spalte == l) {
					nexttable[Zeile][Spalte] = 1/table[k][l];
					
				}
				else if (Zeile != k && Spalte == l) {
					nexttable[Zeile][Spalte] = -1 * table[Zeile][Spalte]/table[k][l];
					
				}
				else if (Zeile != k && Spalte == 0) {
					nexttable[Zeile][Spalte] = table[Zeile][Spalte] - ((table[Zeile][l] * table[k][Spalte])/table[k][l]);
				}
				else if (Zeile == k && Spalte != l) {
					nexttable[Zeile][Spalte] = table[k][Spalte]/table[k][l];
					
				}
				else {
					nexttable[Zeile][Spalte] = table[Zeile][Spalte] - ((table[k][Spalte]*table[Zeile][l])/table[k][l]);
				}
			}
		}
		
		
		
	}



	private void findeprivZeile() {
		//finde pos min
		
		
		for (int i = 1; i < table.length; i++) {
			
			if( k == -1) {
				if (table[i][l] > 0) {
					k = i;
				
				
				}
			} else {
				if ((table[i][l] > 0) && ((table[i][0]/table[i][l]) < (table[k][0]/table[k][l]))) {
					k = i;
				}
			}
			
		}
		if (k == -1) System.out.println("keine privZeile gefudnen");
		
	}

	private void findeprivSpalte() {
		for (int i = 0; i < table[0].length; i++) {

			if (table[0][i] < 0) {
				l = i;
			}

		}
	}

	public void printSimplex(){
		
		System.out.println("Privot Zeile: " + k + " PivotSpalte: " + l);
		
		for (int Zeile = 0; Zeile < table.length; Zeile++) {
			for (int Spalte = 0; Spalte < table[0].length; Spalte++) {
				
					System.out.print(table[Zeile][Spalte] + "\t");
					if (Spalte == 0) {
						System.out.print("|\t");
					}
			
			}
			System.out.println("\n");
		}
		
		
	}
	
public void printnextSimplex(){
	
		for (int Zeile = 0; Zeile < nexttable.length; Zeile++) {
			for (int Spalte = 0; Spalte < nexttable[0].length; Spalte++) {
				
					System.out.print(nexttable[Zeile][Spalte] + "\t");
					if (Spalte == 0) {
						System.out.print("|\t");
					}
			
			}
			System.out.println("\n");
		}
		
		
	}
	
	
}
