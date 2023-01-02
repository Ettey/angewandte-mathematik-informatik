
public class LineareRegression {

	//Y(i) = O(0) + O(1)*X(i)+e(i)		
	//e(i)~(0,o²)			o: Varianz
	
	//Summe der Quadrate der Streckenabschnitte minimieren und Funktion finden zur Darstellung (linear)
	
	
	/* 
	 * Loese:	min			Summe[1,...,n] (( Y(i)-O(0)-O(1)*X(i))²)
	 * 			O(0),O(1)
	 * 
	 * 	Ableiten ergibt Gleichung:
	 * 		I) O(0) = 1/n(Summe(Y[i]) - O(1)*(1/n)*Summe(X(i))
	 * 	
	 * 		II)	0 = Summe(Y[i]) - O(1)*Summe(X[i]) - O(0)*n 
	 * 	
	 * 		Input (X[i], Y[i])
	 * 		Output(O(0) und O(1)
	 * 
	 */
	
	
	static double[] X = {-2, -1, 0, 1, 2};
	static double[] Y = {2, 0, 0, 2, 6};
									
	public static void main (String[] arg) {
		double O_1 = berechne_O_1();
		double O_0 = berechne_O_0(O_1);
		
		System.out.println("O_1=	" + O_1 + "	O_0:=	" + O_0);
	}

	private static double berechne_O_0(double O_1) {
//		I) O(0) = 1/n(Summe(Y[i]) - O(1)*(1/n)*Summe(X(i))
		int n = X.length;
		return ((1.0/n)*summe(Y)) - (O_1*(1.0/n)*summe(X) );
	}

	private static double berechne_O_1() {
		double back =0;
		double SummeX = summe(X);
		double SummeY = summe(Y);
		double produktXY = SummeAusProdukt(X,Y);
		int n = X.length;
		back = (SummeAusProdukt(X,Y) - ((1.0/n)*SummeY*SummeX   )) / (SummeAusProdukt(X,X)- ((1.0/n) *SummeX*SummeX));
		
		return back;
	}

	private static double SummeAusProdukt(double[] X, double[] Y) {
		double SummeAusProdukt = 0;
		for (int i = 0; i < X.length; i++)  
			SummeAusProdukt += X[i]*Y[i];
			
			
			
		return SummeAusProdukt;
	}

	private static double summe(double[] Data) {
		double summe = 0;
		
		for (int i = 0; i < Data.length; i++) {
			
			summe+= Data[i];
			
		}
		
		return summe;
	}
	
	
	
	
}
