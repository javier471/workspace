package blocNotas;

import java.time.LocalDateTime;

public class NotaAlarma extends Nota {

	private LocalDateTime fechaAlarma;
	private int minutosRepetir;
	private boolean activado;
	private static final int MINUTOS_REPETIR_POR_DEFECTO = 5;

	public NotaAlarma(String texto, LocalDateTime fecha, boolean activado) throws Exception {
		super(texto);
		setFechaAlarma(fecha);
		this.activado = activado;
		this.minutosRepetir = MINUTOS_REPETIR_POR_DEFECTO;
	}

	public NotaAlarma(String texto, LocalDateTime fecha, int minutos) throws Exception {
		super(texto);
		setFechaAlarma(fecha);
		this.minutosRepetir = minutos;
	}

	public void setFechaAlarma(LocalDateTime fechaAlarma) throws Exception {
		if(fechaAlarma==null) {
			throw new Exception("Error.Fecha nula");
		}
		if (fechaAlarma.isAfter(getFechaCreacion())) {
			this.fechaAlarma = fechaAlarma;
		} 
		else {
			throw new NotaAlarmaException("No se puede modificar la fecha de la alarma");
		}

	}

	public static int getMinutosRepetirPorDefecto() {
		return MINUTOS_REPETIR_POR_DEFECTO;
	}

	public void activar() {
		this.activado = true;
	}

	public void desactivar() {
		this.activado = false;
	}

	public boolean isActivado() {
		return activado;
	}

	@Override
	public String toString() {
		return "NotaAlarma [fechaAlarma=" + fechaAlarma + ", minutosRepetir=" + minutosRepetir + ", activado="
				+ activado + "]";
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	
}
