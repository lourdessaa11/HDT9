/**
 * UVG
 * Algoritmos y Estructura de Datos: HDT9
 * @author Lourdes Saavedra
 */

import java.io.IOException;

public class Floyd {

    Archivos archivo = new Archivos();
    InterfazGrafo grafo;
    int[][] P;
    int [] max;
    int centro;
    int min = 10000;

    /**
     * Constructor
     */
    public Floyd(){

        try {
            archivo.leerArchivo("C:/Users/Lourdes Saavedra/Documents/GitHub/HDT9/HDT9/src");
            archivo.nombresNodos();
            grafo = archivo.costos();
            P = new int[25][25];
            max = new int[25];
        } catch (IOException ex){
            ex.printStackTrace();
        }
        for(int n = 0; n < archivo.grafo.size();n++){
            for(int m = 0; m < archivo.grafo.size(); m++){
                P[n][m]= 10000;
            }
        }
    }

    /**
     * Método para encontrar el camino más corto
     */
    public void caminoMasCorto(){
        for(int k=0;k<grafo.size();k++){
            for(int i=0;i<grafo.size();i++){
                for(int j=0;j<grafo.size();j++){
                    if(grafo.getEdge(grafo.get(i),grafo.get(j))>(grafo.getEdge(grafo.get(i), grafo.get(k))+grafo.getEdge(grafo.get(k), grafo.get(j)))){
                        grafo.addEdge(grafo.get(i), grafo.get(j), (grafo.getEdge(grafo.get(i), grafo.get(k))+grafo.getEdge(grafo.get(k), grafo.get(j))));
                        P[i][j]=k;
                    }
                }
            }
        }
    }

    /**
     * Método para encontrar el centro del grafo
     */
    public void centroDelGrafo(){
        caminoMasCorto();
        int n = 0;
        
        for(int i = 0; i < grafo.size();i++){
            for(int j = 0; j < grafo.size();i++){
                int num1 = grafo.getEdge(grafo.get(j),grafo.get(i));
                n = j;
                n ++;
                int num2 = grafo.getEdge(grafo.get(n), grafo.get(i));
                if(num1 > num2){
                    max[i] = num1;
                }else{
                    max[i] = num2;
                }
            }
            n++;
        }

        for(int i = 0; i < grafo.size();i++){
            int num1 = max[i];
            if(num1 < min){
                centro = i;
                min = num1;
            }
        }

        System.out.println("\nEl centro es: "+ grafo.get(centro)+"\n");
    }

    /**
     * Método para encontrar las ciudades intermedias
     * @param num1
     * @param num2
     */
    public void ciudadesIntermedias(int num1, int num2){
        if(P[num1][num2] != 10000){
            ciudadesIntermedias(num1, P[num1][num2]);
            System.out.println(", " + grafo.get(P[num1][num1]));
            ciudadesIntermedias(P[num1][num2], num2);
            return;
        }
        else return;
    }

    
}
