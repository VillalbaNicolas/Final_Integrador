package model;

public class Familiar implements Autos {
    private final int basico = 245000;
    private static  final String TIPO = "Familiar";
    private int id;



    public static String getTIPO() {
        return TIPO;
    }

    public String getTipo()
    {
        return getTIPO();
    }

    @Override
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
