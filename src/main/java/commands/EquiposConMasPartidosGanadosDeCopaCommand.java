package commands;

import homes.EquipoHome;
import homes.PartidoDeCopaHome;
import homes.PartidoSimpleHome;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import dominio.Equipo;
import dominio.EquipoYVictoriasDeCopa;

public class EquiposConMasPartidosGanadosDeCopaCommand implements Runnable {

    @Override
    public void run() {
    	
    	SortedSet<EquipoYVictoriasDeCopa> listaEqCantPCG = new TreeSet<EquipoYVictoriasDeCopa>(new Comparator<EquipoYVictoriasDeCopa>() {
    		/**
    		 * Comparator modificado para que commpare por la cantidad de victorias de copa
    		 * */
    		public int compare(EquipoYVictoriasDeCopa eq1, EquipoYVictoriasDeCopa eq2) {
                 int result = eq2.getCantPC().compareTo(eq1.getCantPC());
                 if(result == 0)	//esto se modifica para que me guarde los elementos que tengan igual cantidad	
             	    result = -1;    // de victorias de copa, para luego imprimirlos en orden.
                 return result;
            }
});
    	ArrayList<Equipo> equipos = new EquipoHome().getEquipos();
    	for(Equipo eq: equipos){
    		listaEqCantPCG.add(new EquipoYVictoriasDeCopa(eq, new PartidoDeCopaHome().cantidadDePartidosDeCopaGanadosPor(eq)));
    	}
    	
    	for( Iterator<EquipoYVictoriasDeCopa> it = listaEqCantPCG.iterator(); it.hasNext();) {

    		EquipoYVictoriasDeCopa eq = (EquipoYVictoriasDeCopa)it.next();
    	    System.out.println(eq.getEquipo() + ": ha ganado " + eq.getCantPC() + "partidos de copa");
    	}
    	
    }
}
