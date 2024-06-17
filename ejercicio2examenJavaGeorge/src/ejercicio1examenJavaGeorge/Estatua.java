/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1examenJavaGeorge;

/**
 *
 * @author georib
 */
public class Estatua extends Figura {
    private String franquicia;

    //constructor de la clase Estatua
    public Estatua(String nombre, int añoLanzamiento, String franquicia, double precioBase, String estado) {
        super(nombre, añoLanzamiento, precioBase, estado);//lamada al constructor de la superclase Figura
        this.franquicia = franquicia;//inicializacion de atributo propio
    }
    //setters y getters
    public String getFranquicia() {
        return franquicia;
    }

    public void setFranquicia(String franquicia) {
        this.franquicia = franquicia;
    }

    //este es el metodo que se importa desde la clase figura
    //calcula el precio real
    //tiene el override porque el metodo es diferente entre figura de accion, estatua y funko y bueno, simplemente para que sobreescriba el precio real
    @Override
    public double calcularPrecioReal() {
        switch (getEstado().toLowerCase()) {
            case "precintada":
                return getPrecioBase() * 2;
            case "en su embalaje original":
                return getPrecioBase();
            case "sin embalaje original":
                return getPrecioBase() / 2;
            default:
                return getPrecioBase();
        }
    }
}
