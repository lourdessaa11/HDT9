
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GrafoTest {
    
    @Test
    public void addEdge(){

        Floyd matriz = new Floyd(); 

        matriz.grafo.addEdge("Guatemala", "Antigua",1);
        matriz.grafo.addEdge("VillaNueva", "SanJose", 4);
        matriz.grafo.addEdge("Coban", "Flores", 8);
        assertEquals(matriz.grafo.getEdge("VillaNueva","SanJose"),4);
        assertEquals(matriz.grafo.getEdge("Coban","Flores"),8);
    }

}    
