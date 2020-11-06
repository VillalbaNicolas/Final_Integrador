package dto;

public class OpcionalesDTO {

    private int precio;

    private String tipo;

    private int id;

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId (){
        return id;
    }

    public void setId (Integer id){

        this.id = id;
    }
}
