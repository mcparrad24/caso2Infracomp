package caso2;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

	public static void main (String[] args) {
		FileReader fr = null;
		BufferedReader br = null;
		String cadena = "";
		String algoritmo = "";
		String[] lectura = new String[2];
		String linea;
		try {
			//fr = new FileReader("./data/casoDos.txt");
			//br = new BufferedReader(fr);
			//br.readLine();
			//while ((linea = br.readLine()) != null) {
				//lectura = linea.split(",");
				//cadena = lectura[0];
				//algoritmo = lectura[1];
				cadena = "ñññññññ";
				algoritmo = "MD5";
			//}
			byte[] rta = Prototipo.generarCodigo(cadena, algoritmo);
			if (cadena.length() == 1) {
				ThreadHash[] ta = new ThreadHash[27];
				for (int k = 0; k < 27; k++) {
					ta[k] = new ThreadHash("Thread" + (k+1), k, k, rta, algoritmo, cadena.length());
				}
				for (int k = 0; k < 27; k++) {
					ta[k].start();
				}
			}
			else if (cadena.length() > 1 && cadena.length() < 8) {
				ThreadHash[] ta = new ThreadHash[729];
				int a = 0;
				while (a < 729) {
					for (int i = 0; i < 27; i++) {
						for (int j = 0; j < 27; j++) {
							ta[a] = new ThreadHash("Thread" + (a+1), i, j, rta, algoritmo, cadena.length());
							a = a+1;
						
								
							
						}
					}
				}
				for (int b = 0; b < 729; b++) {
					ta[b].start();
				}
			}
			while (!Prototipo.darTerminado()) {
				System.out.println(Prototipo.darRta());		
			}
			System.out.println(Prototipo.darRta());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
