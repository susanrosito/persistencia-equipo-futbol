package Clases;

public class Partido {
	
	private Equipo equipoA;
	private Equipo equipoB;
	
	private int golesEquipoA;
	private int golesEquipoB;
	
	
	Partido(Equipo a, Equipo b){
		
		this.equipoA  = a;
		this.equipoB = b;
		this.golesEquipoA = 0;
		this.golesEquipoB = 0;
		
	}
	
	
	protected Equipo getGanador(){
		
		if(this.golesEquipoA > this.golesEquipoB)
		{
			return this.equipoA;
		}
		else { if(this.golesEquipoA < this.golesEquipoB)
				  { 
			        return this.equipoB;
				  }
		else { return null;}}
		
	}
	
	
	
	public Equipo getEquipoA() {
		return equipoA;
	}
	
	public void setEquipoA(Equipo equipoA) {
		this.equipoA = equipoA;
	}
	
	public Equipo getEquipoB() {
		return equipoB;
	}
	
	public void setEquipoB(Equipo equipoB) {
		this.equipoB = equipoB;
	}
	
	public int getGolesEquipoA() {
		return golesEquipoA;
	}
	
	public void setGolesEquipoA(int golesEquipoA) {
		this.golesEquipoA = golesEquipoA;
	}
	
	public int getGolesEquipoB() {
		return golesEquipoB;
	}
	
	public void setGolesEquipoB(int golesEquipoB) {
		this.golesEquipoB = golesEquipoB;
	}
	
	

}
