package model;
import  model.*;


import java.security.PrivateKey;
import java.util.ArrayList;

public class Venta {

    private int id;
    private int idAuto;
    private Autos autos;
    private int precioFinal;
    private String opcionales;
    private int cantOpcionales;
    private String tipoAuto;
    private Opcional opcional;
    //private ArrayList IdOpcionales;

    public Venta(){
        this.autos = autos;
        this.opcional = opcional;
    }

    public String getTipoAuto(){
        this.tipoAuto = autos.getTipo();
        return this.tipoAuto;
    }


    public void setIdAuto(Autos autos){
        this.idAuto = autos.getId();

    }

    public int getIdAuto(){

        return idAuto;
    }

    public void setOpcionales(Opcional opcional){
        if (opcional.getContadorOpcionales() > 0)
            this.opcionales = "si";
        else
            this.opcionales = "no";
    }

    public String getOpcionales(){
        return opcionales;
    }

    public void setCantOpcionales(Opcional opcional){
        this.cantOpcionales = opcional.getContadorOpcionales();
    }

    public int getCantOpcionales(){

        return cantOpcionales;
    }

    public void pago_final(Autos autos, Opcional opcional)
    {
        int sumatoria = 0;
        sumatoria = autos.getBasico() + opcional.total();
        this.precioFinal = sumatoria;

    }

    public int getPago()
    {
        return precioFinal;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
