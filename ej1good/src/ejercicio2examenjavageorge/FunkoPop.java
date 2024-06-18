/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2examenjavageorge;

import ej1_good.Figura;

/**
 *
 * @author georib
 */
public class FunkoPop extends Figura {
    //booleano para saber si es edicion limitada o no, esto afecta
    private boolean esEdicionLimitada;

    //constructor de la clase FunkoPop
    public FunkoPop(String nombre, int anioLanzamiento, boolean esEdicionLimitada, double precioBase, String estado) {
        super(nombre, anioLanzamiento, precioBase, estado);//lamada al constructor de la superclase Figura, con esto no tenemos que hacer el this.A = a2; p.ej
        this.esEdicionLimitada = esEdicionLimitada;//inicializacion de atributo propio
    }

    public boolean isEsEdicionLimitada() {
        return esEdicionLimitada;
    }

    public void setEsEdicionLimitada(boolean esEdicionLimitada) {
        this.esEdicionLimitada = esEdicionLimitada;
    }

    //este es el metodo que se importa desde la clase figura
    //calcula el precio real
    //tiene el override porque el metodo es diferente entre figura de accion, estatua y funko
    @Override
    public double calcularPrecioReal() {
        int añoActual = java.time.Year.now().getValue();//obtiene el anio actual, tambien podriamos poner 2024 pero si ponemos esto no hara falta que cambiemos el anio manualmente
        return getPrecioBase() + ((añoActual - getAnioLanzamiento()) * 10);
    }
}
