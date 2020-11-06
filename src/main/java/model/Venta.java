package model;

public class Venta {

    private int id;
    private int precioFinal;

    private Auto auto;
    private int idAuto;
    private int basicoAuto;
    private String tipoAuto;

    private Opcional opcional;
    private int cantOpcionales;
    private int total$Opcional;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(int precioFinal) {
        this.precioFinal = precioFinal;
    }

    /**
     *
     * @return
     */

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public int getIdAuto() {
        return idAuto;
    }

    public void setIdAuto(int idAuto) {
        this.idAuto = idAuto;
    }

    public int getBasicoAuto() {
        return basicoAuto;
    }

    public void setBasicoAuto(Auto auto) {
        this.basicoAuto = basicoAuto;
    }

    public String getTipoAuto() {
        return tipoAuto;
    }

    public void setTipoAuto(String tipoAuto) {
        this.tipoAuto = tipoAuto;
    }

    /**
     *
     * @return
     */

    public Opcional getOpcional() {
        return opcional;
    }

    public void setOpcional(Opcional opcional) {
        this.opcional = opcional;
    }

    public int getCantOpcionales() {
        return cantOpcionales;
    }

    public void setCantOpcionales(int cantOpcionales) {
        this.cantOpcionales = cantOpcionales;
    }

    public int getTotal$Opcional() {
        return total$Opcional;
    }

    public void setTotal$Opcional(int total$Opcional) {
        this.total$Opcional = total$Opcional;
    }
}
