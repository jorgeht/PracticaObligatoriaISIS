package data;

import java.util.Comparator;

public class Mensaje {

	public static final String PROVISIONAL = "PROVISIONAL";
	public static final String DEFINITIVO = "DEFINITIVO";
	
	private  String contenido;
	private  String id;
	private  String orden;
	private  int numPropuestas;
	private  String estado;

	public Mensaje(String id,  int idProceso, int numMensaje) {
		this.contenido = String.format("P%02d %03d", idProceso, numMensaje);
		this.id = id;
		this.orden = numMensaje + "." + idProceso;
	}

	public Mensaje(String contenido, String id, String orden, int numPeticiones, String estado) {
		this.contenido = contenido;
		this.id = id;
		this.orden = orden;
		this.numPropuestas = numPeticiones;
		this.estado = estado;
	}
	
	public String getContenido() {
		return contenido;
	}
	
	public String getId() {
		return id;
	}

	public String getOrden() {
		return orden;
	}
	
	public int getNumPropuestas() {
		return numPropuestas;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setOrden(String orden) {
		this.orden = orden;
	}
	public void setNumPropuestas(int numPropuestas) {
		this.numPropuestas = numPropuestas;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	/*
	 * Clase comparadores de objetos Mensaje.
	 */
	public static class ComparatorMensaje implements Comparator<Mensaje>{
		@Override
		public int compare(Mensaje m1, Mensaje m2) {
			String orden1 = m1.getOrden();
			String orden2 = m2.getOrden();
			
			return compareOrden(orden1, orden2);
			
		}
		
		/*
		 * Compara 2 ordenes recibudos por parámetro. En caso de empate, se toma como menor
		 * el de menor identificador de proceso.
		 */
		public static int compareOrden(String o1, String o2) {
			String[] camposM1 = o1.split("\\.");
			String[] camposM2 = o2.split("\\.");
			
			int ordenM1 = Integer.parseInt(camposM1[0]);
			int ordenM2 = Integer.parseInt(camposM2[0]);
			
			if (ordenM1 < ordenM2) {
				return -1;
			}
			else if (ordenM1 > ordenM2) {
				return 1;
			}
			else {
				int idProcesoM1 = Integer.parseInt(camposM1[1]);
				int idProcesoM2 = Integer.parseInt(camposM2[1]);
				
				if (idProcesoM1 < idProcesoM2) {
					return -1;
				}
				else if (idProcesoM1 > idProcesoM2) {
					return 1;
				}
				else {
					return 0;
				}
			}
		}
	}
}
