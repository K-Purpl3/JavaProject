
package ejercicio1examenJavaGeorge;

/**
 *
 * @author georib
 */

//esta es la superclase figura
public abstract class Figura {
    // Atributos privados de la clase Figura
    private String nombre;
    private int anioLanzamiento;
    private double precioBase;
    private String estado;
     // Constructor de la clase Figura que inicializa los atributos.
    public Figura(String name, int release, double basePrice, String status) {
        this.nombre = name;
        this.anioLanzamiento = release;
        this.precioBase = basePrice;
        this.estado = status;
    }

    //obitene y establece el nombre de la figura y lo devuelve
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    ///////////////////////////////////
    //obtiene y establece el anio de lanzamiento
    public int getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public void setAnioLanzamiento(int anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }
    ///////////////////////////////////
    //obtiene y establece el precio base
    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }
    ///////////////////////////////////
    //obtiene y establece el estado de la figura
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    //este metodo abstracto sirve para calcular el precio real de las figuras, este metodo es implementado por las subclases
    public abstract double calcularPrecioReal();
}


    //constructor
    /* figuras(String name, int year, String accesories, double base_price, String status, double real_price){
        
        //name = reader.next();
        this.setNombre(name);
        //year = reader.nextInt();
        this.setAnioLanzamiento(year);
        this.accesorios = accesories;
        //base_price = reader.nextDouble();
        this.setPrecio_b(base_price);
        //estado = reader.next();
        this.setEstado(status);
        this.precioR = real_price;
    }
    
    /* public String toString(){
        String myString = nombre +" "+precio_b +" "+ precioR;
        return myString;
        
        //otra opcion es:
        //retrun make + model + year + color + price;
        
    }*/
    
    /* void precio_real() {
        System.out.println("Cual es el estado de la figura?");
        System.out.println("precinada");
        System.out.println("embalaje original");
        System.out.println("sin embalaje original");
        setEstado(reader.next());
        if (getEstado() == "precintada") {
            precioR = getPrecio_b() * 2;
            System.out.println(precioR);
        } else if (getEstado() == "embalaje original") {
            precioR = getPrecio_b();
            System.out.println(precioR);
        } else if (getEstado() == "sin embalaje original") {
            precioR = getPrecio_b() / 2;
            System.out.println(precioR);
        }
    } */

