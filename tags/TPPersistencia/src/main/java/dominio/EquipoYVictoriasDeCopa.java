package dominio;

public class EquipoYVictoriasDeCopa {
	private Equipo equipo;
	private Integer cantPC;
	
	public EquipoYVictoriasDeCopa(Equipo eq, Integer cant){
		this.setEquipo(eq);
		this.setCantPC(cant);
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setCantPC(int cantPC) {
		this.cantPC = cantPC;
	}

	public Integer getCantPC() {
		return cantPC;
	}
	
	

}
