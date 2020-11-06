package dto;

public class AutoDTO {

    private int precio;

    private String descripcion;

    private int id;

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId (){
        return id;
    }

    public void setId (Integer id){ this.id = id; }
}
