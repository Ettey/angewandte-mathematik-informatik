
public class Dezimalzahl {

	private final static int Länge = 64;
	private int Mantissenlänge = 52;
	private int Exponentenlänge = 11;

	// Form v; exp; Mant
	public int[] ZahlInBin = new int[64];

	public double ZahlInDez = 0;

	public Dezimalzahl(double ZahlInDez) {
		this.ZahlInDez = ZahlInDez;
		this.ZahlInBin = DezToBin(ZahlInDez);
	}

	public Dezimalzahl(int[] ZahlInBin) {
		this.ZahlInBin = ZahlInBin;
		this.ZahlInDez = BinToDez(ZahlInBin);
	}

	public static int[] DezToBin(double Dez) {
		int[] back = new int[Länge];
		if (Dez > 0) {
			back[0] = 1;
		} else {
			back[0] = -1;
		}

		int Exponent = 1;

		while (Dez < 0) {
			Exponent *= 10;
			Dez /= 10;

		}
		while (Dez > 1) {
			Exponent /= 10;
			Exponent *= 10;
		}

		for (int i = 1; i < 11; i++) {

		}

		return back;
	}

	public static double BinToDez(int[] Bin) {
		int v = 0;

		if (Bin[0] == 1) {
			v = -1;
		} else if (Bin[0] == 0) {
			v = 1;
		}

		double Exponent = 0;
		for (int i = 1; i < 12; i++) {
			Exponent +=  Bin[i] * Zweihoch(i-1);
		}

		double m = 0;
		for (int i = 12; i < 64; i++) {
			m += Bin[i] * (1 / Zweihoch(i - 53));
		}

		double x = v * m * Exponent ;
		return x;
	}

	public static int Zweihoch(int i) {
		int Zwei = 1;

		for (int l = 0; l < i; l++) {
			Zwei *= 2;
		}
		return Zwei;
	}

	public String toString() {
		String back = "";

		for (int i = 0; i < this.ZahlInBin.length; i++) {
			back += ZahlInBin[i];

			if (i == 0 || i == 11) {
				back += "	";
			}
		}

		return back;

	}

}
