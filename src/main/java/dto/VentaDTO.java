package dto;

import exception.DAOException;
import exception.ServiceException;
import model.Auto;
import model.Opcional;
import service.imp.AutoServiceImp;
import service.imp.OpcionalesServiceImp;
import service.imp.VentaServiceImp;

import java.util.ArrayList;

public class VentaDTO {

    private int id;
    private int precioFinal;

    private int idAuto;
    private int idOpcionales;

    private String modeloAuto;
    private int basicoAuto;
    private int cantOpcionales;
    private int precioOpcionales;

    private ArrayList opcionalesList;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrecioFinal() throws DAOException {
        VentaServiceImp ventaServ;
        int pf = 0;
        if (this.precioFinal == 0) {
            ventaServ = new VentaServiceImp();
            pf = ventaServ.calculoPrecioFinal();
        }else;

        this.precioFinal = pf;
        return precioFinal;
    }

    public void setPrecioFinal(int precioFinal) { this.precioFinal = precioFinal; }

    public int getIdAuto() {
        return idAuto;
    }

    public void setIdAuto(int idAuto) { this.idAuto = idAuto; }

    public int getIdOpcionales() {
        return idOpcionales;
    }

    public void setIdOpcionales(int idOpcionales) {
        this.idOpcionales = idOpcionales;
    }


    public String getModeloAuto() {
        return modeloAuto;
    }

    public void setModeloAuto(String modeloAuto) {
        this.modeloAuto = modeloAuto;
    }

    public int getBasicoAuto() {
        return basicoAuto;
    }

    public void setBasicoAuto(int basicoAuto) {
        this.basicoAuto = basicoAuto;
    }

    public int getCantOpcionales() throws ServiceException {
        int cont = 0;
        VentaServiceImp ventaser = new VentaServiceImp();
        if (this.cantOpcionales == 0)
            cont = ventaser.cantOpcionales();
        else;
        this.cantOpcionales = cont;
        return cantOpcionales;
    }

    public void setCantOpcionales(int cantOpcionales) {
        this.cantOpcionales = cantOpcionales;
    }

    public int getPrecioOpcionales() throws DAOException {
        int poc = 0;
        VentaServiceImp ventaser = new VentaServiceImp();
        if (this.precioOpcionales == 0){
            poc = ventaser.precioOpcionales();
        }else;
        this.precioOpcionales = poc;
        return precioOpcionales;
    }



    public void setPrecioOpcionales(int precioOpcionales) {
        this.precioOpcionales = precioOpcionales;
    }

    public ArrayList<OpcionalesDTO> getOpcionalesList(){

        this.opcionalesList.add(this.idOpcionales);
        return opcionalesList;

    }
}
