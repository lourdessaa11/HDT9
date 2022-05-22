/**
 * UVG
 * Algoritmos y Estructura de Datos: HDT9
 * @author Lourdes Saavedra
 */

public interface InterfazGrafo<V,E> {

    /**
     * Metodo para agregar un nodo
     * @param label
     */
    public void add(V label);

    /**
     * Mpetodo para agregar una arista
     * @param vtx1
     * @param vtx2
     * @param label
     */
    public void addEdge(V vtx1, V vtx2, E label);
    
    /**
     * Método para mostrar el grafo
     */
    public void show();
    
    /**
     * Método para obtener la posicion
     * @param label
     * @return
     */
    public int getIndex(V label);
    
    /**
     * Métodod para obtener el nodo
     * @param label
     * @return
     */
    public V get(int label);
    
    /**
     * Método para obtener el costo/peso
     * @param label1
     * @param label2
     * @return
     */
    public int getEdge(V label1, V label2);
    
    /**
     * Método determinar si el nodo se encuentra en el grafo
     * @param label
     * @return
     */
    public boolean contains(V label);
    
    /**
     * Método para obtener el tamaño del grafo
     * @return
     */
    public int size();
    
}