package model;

public class Coupe implements Autos {

    private final int basico = 270000;
    private static final String TIPO = "Coupe";
    private int id;


    public static String getTIPO() {
        return TIPO;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTipo()
    {
        return getTIPO();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getBasico() {
        return basico;
    }



}

