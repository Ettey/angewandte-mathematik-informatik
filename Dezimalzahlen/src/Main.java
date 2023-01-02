
public class Main {

	public static void main(String[] ars) {
		int[] array = new int[64];
		
		for (int i = 0; i < 64; i ++) {
			if (i < 11) array[i] = 0;
			else array[i] = 1;
			if (i == 0) array[i] = 0;
		}
		
		double x = Zweihoch(30) + Zweihoch(4);
		
		System.out.println(x);
	}

	public static int Zweihoch(int i) {
		int Zwei = 1;

		for (int l = 0; l < i; l++) {
			Zwei *= 2;
		}
		return Zwei;
	}
	
}
