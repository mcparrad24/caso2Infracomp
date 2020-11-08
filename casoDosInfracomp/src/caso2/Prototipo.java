package caso2;

import java.security.MessageDigest;
import java.util.Arrays;

public class Prototipo {

	private static boolean terminado = false;
	private static String respuesta = null;

	public static boolean darTerminado() {
		return terminado;
	}

	public static void cambiarRta(String r) {
		respuesta = r;
	}

	public static String darRta() {
		return respuesta;
	}

	public static byte[] generarCodigo(String cadena, String algoritmo) {
		byte[] buffer = cadena.getBytes();
		byte[] salida = getDigest(algoritmo, buffer);
		//imprimirHexa(salida);
		return salida;
	}

	public static byte[] getDigest(String algoritmo, byte[] buffer) {
		try {
			MessageDigest digest = MessageDigest.getInstance(algoritmo);
			digest.update(buffer);
			return digest.digest();
		}catch (Exception e) {
			return null;
		}
	}

	public static void imprimirHexa(byte[] array) {
		String salida = "";
		for (int i = 0; i < array.length; i++) {
			if ((array[i] & 0xff) <= 0xf) {
				salida = salida + "0";
			}
			salida = salida + Integer.toHexString(array[i] & 0xff).toLowerCase();
		}
	}

	public static String asciiToString(int ascii) {
		String rta = Character.toString((char)ascii);
		return rta;
	}

	public static String identificarE1(byte[] hash, String algoritmo, int i){
		String rta = null;
		int ascii = 97;
		String car = "";
		if (i == 26) {
			car = "ñ";
		}
		else {
			car = asciiToString(ascii+i);
		}
		byte[] local = generarCodigo(car, algoritmo);
		if (Arrays.equals(local, hash)) {
			terminado = true;
			rta = car;	
		}
		if (i == 26 && rta == null) {
			terminado = true;
		}
		return rta;
	}

	public static String identificarE2(byte[] hash, String algoritmo, int i, int j){
		boolean encontrado = false;
		String rta = null;
		int ascii = 97;
		String car = "";
		if (i == 26) {
			car = "ñ";
		}
		else {
			car = asciiToString(ascii+i);
		}
		String car2 = "";
		if (j == 26) {
			car2 = "ñ";
		}
		else {
			car2 = asciiToString(ascii+j);
		}
		byte[] local = generarCodigo(car+car2, algoritmo);
		if (Arrays.equals(local, hash)) {
			encontrado = true;
			terminado = true;
			rta = car+car2;
		}
		if (i == 26 && j == 26 && rta == null) {
			terminado = true;
		}
		return rta;
	}

	public static String identificarE3(byte[] hash, String algoritmo, int i, int j){
		boolean encontrado = false;
		String rta = null;
		int ascii = 97;
		String car = "";
		if (i == 26) {
			car = "ñ";
		}
		else {
			car = asciiToString(ascii+i);
		}
		String car2 = "";
		if (j == 26) {
			car2 = "ñ";
		}
		else {
			car2 = asciiToString(ascii+j);
		}
		for (int k = 0; k < 27 && !encontrado && !terminado; k++) {
			String car3 = "";
			if (k == 26) {
				car3 = "ñ";
			}
			else {
				car3 = asciiToString(ascii+k);
			}
			byte[] local = generarCodigo(car+car2+car3, algoritmo);
			if (Arrays.equals(local, hash)) {
				encontrado = true;
				terminado = true;
				rta = car+car2+car3;
			}
			if (i == 26 && j == 26 && k == 26 && rta == null) {
				terminado = true;
			}
		}
		return rta;
	}

	public static String identificarE4(byte[] hash, String algoritmo, int i, int j){
		boolean encontrado = false;
		String rta = null;
		int ascii = 97;
		String car = "";
		if (i == 26) {
			car = "ñ";
		}
		else {
			car = asciiToString(ascii+i);
		}
		String car2 = "";
		if (j == 26) {
			car2 = "ñ";
		}
		else {
			car2 = asciiToString(ascii+j);
		}
		for (int k = 0; k < 27 && !encontrado && !terminado; k++) {
			String car3 = "";
			if (k == 26) {
				car3 = "ñ";
			}
			else {
				car3 = asciiToString(ascii+k);
			}
			for (int l = 0; l < 27 && !encontrado && !terminado; l++) {
				String car4 = "";
				if (l == 26) {
					car4 = "ñ";
				}
				else {
					car4 = asciiToString(ascii+l);
				}
				byte[] local = generarCodigo(car+car2+car3+car4, algoritmo);
				if (Arrays.equals(local, hash)) {
					encontrado = true;
					terminado = true;
					rta = car+car2+car3+car4;
				}
				if (i == 26 && j == 26 && k == 26 && l == 26 && rta == null) {
					terminado = true;
				}
			}
		}
		return rta;
	}

	public static String identificarE5(byte[] hash, String algoritmo, int i, int j){
		boolean encontrado = false;
		String rta = null;
		int ascii = 97;
		String car = "";
		if (i == 26) {
			car = "ñ";
		}
		else {
			car = asciiToString(ascii+i);
		}
		String car2 = "";
		if (j == 26) {
			car2 = "ñ";
		}
		else {
			car2 = asciiToString(ascii+j);
		}
		for (int k = 0; k < 27 && !encontrado && !terminado; k++) {
			String car3 = "";
			if (k == 26) {
				car3 = "ñ";
			}
			else {
				car3 = asciiToString(ascii+k);
			}
			for (int l = 0; l < 27 && !encontrado && !terminado; l++) {
				String car4 = "";
				if (l == 26) {
					car4 = "ñ";
				}
				else {
					car4 = asciiToString(ascii+l);
				}
				for (int m = 0; m < 27 && !encontrado && !terminado; m++) {
					String car5 = "";
					if (m == 26) {
						car5 = "ñ";
					}
					else {
						car5 = asciiToString(ascii+m);
					}
					byte[] local = generarCodigo(car+car2+car3+car4+car5, algoritmo);
					if (Arrays.equals(local, hash)) {
						terminado = true;
						encontrado = true;
						rta = car+car2+car3+car4+car5;
						System.out.println(rta);
					}
					if (i == 26 && j == 26 && k == 26 && l == 26 && m == 26 && rta == null) {
						terminado = true;
					}
				}
			}
		}
		return rta;
	}

	public static String identificarE6(byte[] hash, String algoritmo, int i, int j){
		boolean encontrado = false;
		String rta = null;
		int ascii = 97;
		String car = "";
		if (i == 26) {
			car = "ñ";
		}
		else {
			car = asciiToString(ascii+i);
		}
		String car2 = "";
		if (j == 26) {
			car2 = "ñ";
		}
		else {
			car2 = asciiToString(ascii+j);
		}
		for (int k = 0; k < 27 && !encontrado && !terminado; k++) {
			String car3 = "";
			if (k == 26) {
				car3 = "ñ";
			}
			else {
				car3 = asciiToString(ascii+k);
			}
			for (int l = 0; l < 27 && !encontrado && !terminado; l++) {
				String car4 = "";
				if (l == 26) {
					car4 = "ñ";
				}
				else {
					car4 = asciiToString(ascii+l);
				}
				for (int m = 0; m < 27 && !encontrado && !terminado; m++) {
					String car5 = "";
					if (m == 26) {
						car5 = "ñ";
					}
					else {
						car5 = asciiToString(ascii+m);
					}
					for (int n = 0; n < 27 && !encontrado && !terminado; n++) {
						String car6 = "";
						if (n == 26) {
							car6 = "ñ";
						}
						else {
							car6 = asciiToString(ascii+n);
						}
						byte[] local = generarCodigo(car+car2+car3+car4+car5+car6, algoritmo);
						if (Arrays.equals(local, hash)) {
							encontrado = true;
							terminado = true;
							rta = car+car2+car3+car4+car5+car6;
							System.out.println(rta);
						}
						if (i == 26 && j == 26 && k == 26 && l == 26 && m == 26 && n == 26 && rta == null) {
							terminado = true;
						}
					}
				}
			}
		}
		return rta;
	}

	public static String identificarE7(byte[] hash, String algoritmo, int i, int j){
		boolean encontrado = false;
		String rta = null;
		int ascii = 97;
		String car = "";
		if (i == 26) {
			car = "ñ";
		}
		else {
			car = asciiToString(ascii+i);
		}
		String car2 = "";
		if (j == 26) {
			car2 = "ñ";
		}
		else {
			car2 = asciiToString(ascii+j);
		}
		for (int k = 0; k < 27 && !encontrado && !terminado; k++) {
			String car3 = "";
			if (k == 26) {
				car3 = "ñ";
			}
			else {
				car3 = asciiToString(ascii+k);
			}
			for (int l = 0; l < 27 && !encontrado && !terminado; l++) {
				String car4 = "";
				if (l == 26) {
					car4 = "ñ";
				}
				else {
					car4 = asciiToString(ascii+l);
				}
				for (int m = 0; m < 27 && !encontrado && !terminado; m++) {
					String car5 = "";
					if (m == 26) {
						car5 = "ñ";
					}
					else {
						car5 = asciiToString(ascii+m);
					}
					for (int n = 0; n < 27 && !encontrado && !terminado; n++) {
						String car6 = "";
						if (n == 26) {
							car6 = "ñ";
						}
						else {
							car6 = asciiToString(ascii+n);
						}
						for (int o = 0; o < 27 && !encontrado && !terminado; o++) {
							String car7 = "";
							if (o == 26) {
								car7 = "ñ";
							}
							else {
								car7 = asciiToString(ascii+o);
							}
						byte[] local = generarCodigo(car+car2+car3+car4+car5+car6+car7, algoritmo);
						if (Arrays.equals(local, hash)) {
							encontrado = true;
							terminado = true;
							rta = car+car2+car3+car4+car5+car6;
							System.out.println(rta);
						}
						if (i == 26 && j == 26 && k == 26 && l == 26 && m == 26 && n == 26 && o == 26 && rta == null) {
							terminado = true;
						}
						}
					}
				}
			}
		}
		return rta;
	}
}
