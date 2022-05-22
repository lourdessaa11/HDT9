/**
 * UVG
 * Algoritmos y Estructura de Datos: HDT9
 * @author Lourdes Saavedra
 * 
 */

import java.io.*;

public class Archivos {
    
    File archivo;
    FileWriter filewriter;
    PrintWriter printwriter;
    FileReader filereader;
    BufferedReader bufferedreader;
    InterfazGrafo grafo = new Grafo<>();

    /**
     * Método para leer el achivo
     * @param direccion
     * @throws FileNotFoundException
     */
    public void leerArchivo(String direccion) throws FileNotFoundException{
        archivo = new File(direccion);
    }

    /**
     * Método para guardar datos en el archivo
     * @param mensaje
     * @throws IOException
     */
    public void escribir(String mensaje) throws IOException{
        filewriter = new FileWriter(archivo);
        printwriter = new PrintWriter(archivo);
        printwriter.println(mensaje);
    }

    /**
     * Método para asignar nombres de los nodos 
     * @return el grafo
     * @throws IOException
     */
    public InterfazGrafo nombresNodos() throws IOException{
        filereader = new FileReader(archivo);
        bufferedreader = new BufferedReader(filereader);
        String cadena;
        while ((cadena = bufferedreader.readLine()) != null){
            String[] temp;
            temp = cadena.split(" ");
            grafo.add(temp[0]);
            grafo.add(temp[1]);
        }
        return grafo;
    }

    /**
     * Método para obtener los costos entre los nodos
     * @return el grafo
     * @throws IOException
     */
    public InterfazGrafo costos() throws IOException{
        filereader = new FileReader(archivo);
        bufferedreader = new BufferedReader(filereader);
        String cadena;
        while ((cadena = bufferedreader.readLine()) != null){
            String[] temp;
            temp = cadena.split(" ");
            grafo.addEdge(temp[0], temp[1],temp[2]);
        }
        return grafo;
    }
}
