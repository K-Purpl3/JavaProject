package ej1_good;


import java.util.ArrayList;
import java.util.List;

public class FiguraAccion extends Figura {
    //lista privada de accesorios que petenecen a la figura
    private List<Accesorio> accesorios;

    //constructor
    public FiguraAccion(String nombre, int añoLanzamiento, double precioBase, String estado) {
        super(nombre, añoLanzamiento, precioBase, estado);
        this.accesorios = new ArrayList<>();
    }
    //obitene la lista de accesorios
    //devuelve los accesrios
    public List<Accesorio> getAccesorios() {
        return accesorios;
    }
    //metodo que aniade el accesorio que queramos
    public void aniadirAccesorio(Accesorio accesorio) {
        accesorios.add(accesorio);
    }

    //este es el metodo que se importa desde la clase figura
    //calcula el precio real
    //tiene el override porque el metodo es diferente entre figura de accion, estatua y funko
    //para este tipo de "proyectos" usa si o si el @Override
    @Override
    public double calcularPrecioReal() {
        switch (getEstado().toLowerCase()) {
            case "precintada":
                return getPrecioBase() * 2;
            case "con embalaje original":
                return getPrecioBase();
            case "sin embalaje original":
                return getPrecioBase() / 2;
            default:
                return getPrecioBase();
        }
    }
}
