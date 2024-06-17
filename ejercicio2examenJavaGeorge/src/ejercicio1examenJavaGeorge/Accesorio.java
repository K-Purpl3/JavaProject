package ejercicio1examenJavaGeorge;

public class Accesorio {
    private String nombre;
    private String material;
    private String descripcion;

    //constructor
    public Accesorio(String name, String mat, String desc) {
        this.nombre = name;
        this.material = mat;
        this.descripcion = desc;
    }


    //setters y getters
    //get obtiene nombre y lo devuelve
    //set establece el nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}