/**
 * UVG
 * Algoritmos y Estructura de Datos: HDT9
 * @author Lourdes Saavedra
 */

import java.util.Vector;

public class Grafo<V,E> implements InterfazGrafo<V,E> {

    private int[][] matrizAdy = new int[25][25];
    private Vector vertices = new Vector<>();

    /**
     * Constructor
     */
    public Grafo() {

        for(int i = 0; i < 25; i++){
            for (int j = 0; j < 25; j++){
                if (i == j){
                    matrizAdy[i][j] = 0;
                }
                else{
                    matrizAdy[i][j] = 9999;
                }
            }
        }

    
    }

    @Override
    public int getIndex(V label){
        return vertices.indexOf(label);
    }

    @Override
    public void add(V label) {
        if(!vertices.contains(label)){
            vertices.add(label);
        }
    }

    @Override
    public void addEdge(V vtx1, V vtx2, E label) {
        int i = vertices.indexOf(vtx1);
        int j = vertices.indexOf(vtx2);        
        String tmp = ""+label;
        int peso = Integer.parseInt(tmp);
        matrizAdy[i][j]=peso;  
    }

    @Override
    public void show() {
        System.out.println(matrizAdy);   
    }

    @Override
    public int getEdge(V label1, V label2) {
        return matrizAdy[vertices.indexOf(label2)][vertices.indexOf(label2)];
    }

    @Override
    public int size(){
        return vertices.size();
    }

    public boolean contains(V label) {
        return vertices.contains(label);
    }

    @Override
    public V get(int label) {
        return (V)vertices.get(label); 
    }

}

