package model;

public class Sedan implements Autos {

    private final int basico = 230000;
    private static  final String TIPO = "Sedan";
    private int id;


    public String getTipo(){
        return TIPO;
    }
    public int getId() {
        return id;
    }
    public int getBasico() {
        return basico;
    }
    public void setId(Integer id) {
        this.id = id;
    }

}
