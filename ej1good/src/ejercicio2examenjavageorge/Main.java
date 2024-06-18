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


import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final String FICHERO = "funkopops.txt";
    private static List<FunkoPop> funkoPops = new ArrayList<>();

    public static void main(String[] args) {
        cargarFunkoPopsDesdeFichero();

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Añadir Funko Pop");
            System.out.println("2. Borrar Funko Pop");
            System.out.println("3. Mostrar estadísticas");
            System.out.println("4. Salir");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    añadirFunkoPop(scanner);
                    break;
                case 2:
                    borrarFunkoPop(scanner);
                    break;
                case 3:
                    mostrarEstadisticas();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void cargarFunkoPopsDesdeFichero() {
        try (BufferedReader br = new BufferedReader(new FileReader(FICHERO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("#");
                String nombre = partes[0];
                int añoLanzamiento = Integer.parseInt(partes[1]);
                boolean esEdicionLimitada = partes[2].equalsIgnoreCase("SÍ");
                double precioBase = Double.parseDouble(partes[3]);
                String estado = partes[4];

                funkoPops.add(new FunkoPop(nombre, añoLanzamiento, esEdicionLimitada, precioBase, estado));
            }
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }
    }

    private static void guardarFunkoPopsEnFichero() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FICHERO))) {
            for (FunkoPop funkoPop : funkoPops) {
                bw.write(String.format("%s#%d#%s#%.2f#%s",
                        funkoPop.getNombre(),
                        funkoPop.getAnioLanzamiento(),
                        funkoPop.isEsEdicionLimitada() ? "SÍ" : "NO",
                        funkoPop.getPrecioBase(),
                        funkoPop.getEstado()));
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero: " + e.getMessage());
        }
    }

    private static void añadirFunkoPop(Scanner scanner) {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Año de lanzamiento: ");
        int año = scanner.nextInt();
        System.out.print("¿Es edición limitada? (true/false): ");
        boolean esEdicionLimitada = scanner.nextBoolean();
        System.out.print("Precio base: ");
        double precioBase = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Estado (precintada/en su embalaje original/sin embalaje original): ");
        String estado = scanner.nextLine();

        funkoPops.add(new FunkoPop(nombre, año, esEdicionLimitada, precioBase, estado));
        guardarFunkoPopsEnFichero();
    }

    private static void borrarFunkoPop(Scanner scanner) {
        System.out.print("Nombre del Funko Pop a borrar: ");
        String nombre = scanner.nextLine();
        List<FunkoPop> funkoPopsABorrar = funkoPops.stream()
                .filter(fp -> fp.getNombre().equalsIgnoreCase(nombre))
                .collect(Collectors.toList());

        if (!funkoPopsABorrar.isEmpty()) {
            funkoPops.removeAll(funkoPopsABorrar);
            guardarFunkoPopsEnFichero();
            System.out.println("Funko Pop borrado.");
        } else {
            System.out.println("Funko Pop no encontrado.");
        }
    }

    private static void mostrarEstadisticas() {
        if (funkoPops.isEmpty()) {
            System.out.println("No hay Funko Pops en el listado.");
            return;
        }

        int total = funkoPops.size();
        int añoMasNuevo = funkoPops.stream().mapToInt(FunkoPop::getAnioLanzamiento).max().orElse(0);
        int añoMasAntiguo = funkoPops.stream().mapToInt(FunkoPop::getAnioLanzamiento).min().orElse(0);
        double precioPromedio = funkoPops.stream().mapToDouble(FunkoPop::getPrecioBase).average().orElse(0.0);

        System.out.println("Número total de Funko Pops: " + total);
        System.out.println("Año del Funko Pop más nuevo: " + añoMasNuevo);
        System.out.println("Año del Funko Pop más antiguo: " + añoMasAntiguo);
        System.out.println("Precio base promedio de los Funko Pops: " + precioPromedio);
    }
}
