package lexiksimplex;

public class lexisimplex {

	private double[][] table;
	private double[][] nexttable;

	private int l = -1;
	private int k = -1;

	public lexisimplex(double[][] table, int k) {
		this.table = table;
		this.k = k;
		nexttable = new double[table.length][table[0].length];
		berechnenexttable();
	}
	
	
	public double[][] getnexttable() {
			return nexttable;
	}
	
	public int getk() {
		return k;
	}
	public void setk(int k) {
		this.k = k;
	}

	private void berechnenexttable() {
		if (table[0].length == 0)
			System.out.println("table scheint quatsch");
		findeprivSpalte();
		findeprivZeile();

		berechnenext();
	}

	private void berechnenext() {
		System.out.println("berechni " + k+ " " + l);
		for (int Zeile = 0; Zeile < table.length; Zeile++) {
			for (int Spalte = 0; Spalte < table[0].length; Spalte++)
				if (Zeile == k) {

					nexttable[Zeile][Spalte] = (1 / table[k][l]) * table[Zeile][Spalte];
				} else {
					nexttable[Zeile][Spalte] = table[Zeile][Spalte]
							- ((table[k][Spalte] * table[Zeile][l]) / table[k][l]);
				}

		}
	}

	private void findeprivZeile() {
		findeKleinsteLexiOrdnung();
	
	}

	private void findeKleinsteLexiOrdnung() {
		
		
		
		double[][] checktable = new double[table.length][table[0].length];
		
		
		if (k > 0) {
		for (int Zeile = 0; Zeile < checktable.length; Zeile++) {
			for (int Spalte = 0; Spalte < checktable[0].length; Spalte++) {

				checktable[Zeile][Spalte] = table[Zeile][Spalte];
				checktable[Zeile][Spalte] = table[Zeile][Spalte] * table[k][l];
			}
		}

		// finde kleinste lexi ordnung
		// Zeile x > y, wenn x-y > 0 (lex ordnung

		int lexiIndex = 1;
		for (int i = 2; i < checktable.length; i++) {
//			berechne differenz
			double differenz[] = new double[checktable[0].length];
			for (int j = 0; j < differenz.length; j++) {
				differenz[j] = checktable[lexiIndex][j] - checktable[i][j];
				// check ob lexiposi
			}
			for (int t = 0; t < differenz.length; t++) {
					if (differenz[t] > 0) {
						lexiIndex = i;
						break;
					}
					else if (differenz[t] < 0) {
						
						break;
					}
				}
			

		}
		
		k = lexiIndex;
		}
		else if (k == -1) {
			for (int Zeile = 0; Zeile < checktable.length; Zeile++) {
				for (int Spalte = 0; Spalte < checktable[0].length; Spalte++) {

					checktable[Zeile][Spalte] = table[Zeile][Spalte];
					checktable[Zeile][Spalte] = table[Zeile][Spalte];
				}
			}

			// finde kleinste lexi ordnung
			// Zeile x > y, wenn x-y > 0 (lex ordnung

			int lexiIndex = 1;
			for (int i = 2; i < checktable.length; i++) {
//				berechne differenz
				double differenz[] = new double[checktable[0].length];
				for (int j = 0; j < differenz.length; j++) {
					differenz[j] = checktable[lexiIndex][j] - checktable[i][j];
					// check ob lexiposi
				}	for (int t = 0; t < differenz.length; t++) {
						if (differenz[t] > 0) {
							
							break;
						}
						else if (differenz[t] < 0) {
							lexiIndex = i;
							break;
						}
					}
				

			}
			
			k = lexiIndex;
			}
		
		
		
		}

	private void findeprivSpalte() {
		for (int i = 0; i < table[0].length; i++) {

			if (table[0][i] < 0) {
				l = i;
				break;
			}

		}
	}

	public void printSimplex() {

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

	public void printnextSimplex() {

		System.out.println("Privot Zeile: " + k + " PivotSpalte: " + l);

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
