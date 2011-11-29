package commands;

import homes.PartidoDeCopaHome;
import java.util.Iterator;

public class EquiposConMasPartidosDeCopaGanadosCommandPerformante implements Runnable{

	@Override
	public void run() {
	
		Iterator it = new PartidoDeCopaHome().getPartidosDeCopaGanadosPorEquipoPerformante().iterator();
        while(it.hasNext()){
        	Object[] l = (Object[]) it.next();
        	System.out.println("El equipo: " + l[0] + "tiene " + l[1] + "victorias de copa");
        }
	}

}
