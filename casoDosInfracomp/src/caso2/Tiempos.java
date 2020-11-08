package caso2;

public class Tiempos {
	
	public long conteo() {
		long tiempoInicio = System.nanoTime();
		long tiempoFin = System.nanoTime();
		long tiempoTotal = tiempoFin - tiempoInicio;
		return tiempoTotal;
	}

}
