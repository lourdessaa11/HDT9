/**
 * UVG
 * Algoritmos y Estructura de Datos: HDT9
 * @author Lourdes Saavedra
 * 
 */

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        
        Floyd matriz = new Floyd(); 			 					
        int eleccion; 							
        int opcion; 							
        Scanner scan = new Scanner(System.in);

        //Menu
        System.out.println("(1) Encontrar la ruta más corta entre dos ciudades");
        System.out.println("(2) Encontrar el centro del grafo");
        System.out.println("(3) Modificar el grafo");
        System.out.println("(4) Finalizar programa");
        eleccion = scan.nextInt(); 
        
      
        while(eleccion != 4){
            
            System.out.println("\nMatriz de adyacencia");
            matriz.grafo.show();
            
           //Encontrar la ruta más corta
            if(eleccion == 1){
                matriz.caminoMasCorto(); 			
                System.out.println("Ingrese el nombre de la ciudad de origen");
                String ciudad1 = scan.next(); 
                System.out.println("Ingrese el nombre de la ciudad de destino");
                String ciudad2 = scan.next();
                
                if(matriz.grafo.contains(ciudad1) && matriz.grafo.contains(ciudad2)){
                    System.out.println("\nLa distancia es: "+matriz.grafo.getEdge(ciudad1, ciudad2)+".");
                    if(matriz.grafo.getEdge(ciudad1, ciudad2)!=10000){
                        System.out.print("Pasa por las ciudades: "+ciudad1);
                        matriz.ciudadesIntermedias(matriz.grafo.getIndex(ciudad1), matriz.grafo.getIndex(ciudad2));
                        System.out.println(", "+ciudad2);
                    }
                }
            }
            
            //Encontrar el centro del grafo
            else if(eleccion == 2){
                matriz.centroDelGrafo();
            }
            
            //Modificar el grafo
            else if(eleccion == 3){
                System.out.println("1. Interrupción de tráfico");
                System.out.println("2. Establecer nueva conexión");
                opcion = scan.nextInt();
                
                //Interrupción de tráfico
                if(opcion==1){
                    System.out.println("Ingrese el nombre de la ciudad de origen");
                    String ciudad1 = scan.next();
                    System.out.println("Ingrese el nombre de la ciudad de destino");
                    String ciudad2 = scan.next();
                    if(matriz.grafo.contains(ciudad1) && matriz.grafo.contains(ciudad2)){
                        matriz.grafo.addEdge(ciudad1, ciudad2, 10000);
                        // Guarda los cambios en el archivo
                        try {
                            matriz.archivo.escribir(ciudad1+" "+ciudad2+" 10000");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
                
                //Nueva conexión
                else if(opcion == 2){
                    System.out.println("Ingrese el nombre de la ciudad de origen");
                    String ciudad1 = scan.next();
                    System.out.println("Ingrese el nombre de la ciudad de destino");
                    String ciudad2 = scan.next();
                    System.out.println("Ingrese la distancia entre las ciudades");
                    int distancia = scan.nextInt();
                    
                    if(matriz.grafo.contains(ciudad1) && matriz.grafo.contains(ciudad2)){
                        matriz.grafo.addEdge(ciudad1, ciudad2, distancia);
                    }
                    
                    else{
                        matriz.grafo.add(ciudad1);
                        matriz.grafo.add(ciudad2);
                        matriz.grafo.addEdge(ciudad1, ciudad2, distancia);
                    }
                    
                    try {
                        matriz.archivo.escribir(ciudad1+" "+ciudad2+" "+distancia);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                
                matriz.caminoMasCorto();
            }
       
            System.out.println("(1) Encontrar la ruta más corta entre dos ciudades");
            System.out.println("(2) Encontrar el centro del grafo");
            System.out.println("(3) Modificar el grafo");
            System.out.println("(4) Finalizar programa");
            eleccion = scan.nextInt();
        }
        
    }
}    