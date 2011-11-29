package dominio;

public class Partido {

    private Equipo equipoA;
    private Equipo equipoB;
    private int golesEquipoA;
    private int golesEquipoB;
    private int id;

    public Partido(final Equipo a, final Equipo b) {
        this.equipoA = a;
        this.equipoB = b;
        this.golesEquipoA = 0;
        this.golesEquipoB = 0;
    }

    public Partido() {
    }

    public Equipo getGanadorP() {
        if (this.golesEquipoA > this.golesEquipoB) {
            this.equipoA.setCantPartidosSimplesGanados(this.equipoA.getCantPartidosSimplesGanados() + 1);
            return this.equipoA;
        } else {
            if (this.golesEquipoA < this.golesEquipoB) {
                this.equipoB.setCantPartidosSimplesGanados(this.equipoB.getCantPartidosSimplesGanados() + 1);
                return this.equipoB;
            } else {
                return null;
            }
        }
    }

   //  ?? public void incrementarCantPartidosSimplesGanadosPor(Equipo equipo) {
	//	equipo.setCantPartidosSimplesGanados(equipo.getCantPartidosSimplesGanados()+1);
		
//	}

	public Equipo getEquipoA() {
        return this.equipoA;
    }

    public void setEquipoA(final Equipo equipoA) {
        this.equipoA = equipoA;
    }

    public Equipo getEquipoB() {
        return this.equipoB;
    }

    public void setEquipoB(final Equipo equipoB) {
        this.equipoB = equipoB;
    }

    public int getGolesEquipoA() {
        return this.golesEquipoA;
    }

    public void setGolesEquipoA(final int golesEquipoA) {
        this.golesEquipoA = golesEquipoA;
    }

    public int getGolesEquipoB() {
        return this.golesEquipoB;
    }

    public void setGolesEquipoB(final int golesEquipoB) {
        this.golesEquipoB = golesEquipoB;
    }

    public int getId() {
        return this.id;
    }

    public void setId(final int id) {
        this.id = id;
    }

}
