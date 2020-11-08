package caso2;

public class ThreadHash extends Thread{
	
	int i;
	int j;
	byte[] hash;
	String id;
	Prototipo pro;
	String a;
	int tam;

	public ThreadHash(String string, int i, int j, byte[] hashR, String algoritmo, int t) {
		this.id = string;
		this.i = i;
		this.j = j;
		this.hash = hashR;
		this.a = algoritmo;
		this.tam = t;
	}
	
	public boolean darTerminado() {
		return Prototipo.darTerminado();
	}
	
	public void cambiarRta(String r) {
		if (r != null) {
			Prototipo.cambiarRta(r);
		}
	}
	
	public void run() {
		String rta = "";
		while (!darTerminado()) {
			if (tam == 1) {
				rta = Prototipo.identificarE1(hash, a, i);
				if (rta != null) {
					cambiarRta(rta);
				}
			}
			else if (tam == 2) {
				rta = Prototipo.identificarE2(hash, a, i, j);
				if (rta != null) {
					cambiarRta(rta);
				}
			}
			else if (tam == 3) {
				rta = Prototipo.identificarE3(hash, a, i, j);
				if (rta != null) {
					cambiarRta(rta);
				}
			}
			else if (tam == 4) {
				rta = Prototipo.identificarE4(hash, a, i, j);
				if (rta != null) {
					cambiarRta(rta);
				}
			}
			else if (tam == 5) {
				rta = Prototipo.identificarE5(hash, a, i, j);
				if (rta != null) {
					cambiarRta(rta);
				}
			}
			else if (tam == 6) {
				rta = Prototipo.identificarE6(hash, a, i, j);
				if (rta != null) {
					cambiarRta(rta);
				}
			}
			else if (tam == 7) {
				rta = Prototipo.identificarE7(hash, a, i, j);
				if (rta != null) {
					cambiarRta(rta);
				}
			}
		}
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
