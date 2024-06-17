/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio2examenjavageorge;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author georib
 */
public class Ejercicio2examenJavaGeorge {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);

    try {
        FileReader leer = new FileReader("/home/georib/Escritorio/funko.txt");//fichero a importar                
        System.out.println("Elige la opcion");
        System.out.println("1)Añadir funko pop");
        System.out.println("2)Borrar funko pop");
        System.out.println("3)Mostrar funko pop y sus detalles");
        int op = reader.nextInt();
        switch (op) {
            case 1:
            System.out.println("Cuantos articulos va a añadir?");
            int num= reader.nextInt(); 
            for(int i=0;i<num;i++){
                try (FileWriter writer = new FileWriter("/home/georib/Escritorio/funko.txt")) {
                    System.out.println("Escribr en el fichero");
                    String escribir = reader.next();
                    writer.write(escribir);//escribe dentro del fichero funko.txt
                    writer.write(" "); //escribe dentro del fichero funko.txt
                    writer.close();//cierra el writer
                    }
                break;
            }
            case 2:
                break;
            case 3:
                try {
                    int data = leer.read();
                    System.out.println(data);
                        }catch(FileNotFoundException e){
                            e.printStackTrace();
                        }catch(IOException e){
                            e.printStackTrace();
                    }
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
    }catch(FileNotFoundException e){
        e.printStackTrace();
    }catch(IOException e){
        e.printStackTrace();
    }
    }
}