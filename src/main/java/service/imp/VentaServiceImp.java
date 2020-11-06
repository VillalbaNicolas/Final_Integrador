package service.imp;

import daos.imp.VentaDAOSImp;
import dto.AutoDTO;
import dto.OpcionalesDTO;
import dto.VentaDTO;
import exception.DAOException;
import exception.ServiceException;
import model.Venta;
import service.AutosService;
import service.OpcionalesService;
import service.VentaService;
import daos.*;
import model.*;


public class VentaServiceImp implements VentaService {

    private VentaDAOS ventaDAOS = new VentaDAOSImp();

    @Override
    public void ingresarVenta(VentaDTO ventaDTO)  {

        Venta venta = null;

        try {
            venta = convertertoModel(ventaDTO);
            ventaDAOS.insert(venta);
        } catch (Exception e) {
            System.out.println("VentaService fallida");
            e.printStackTrace();
        }




    }

    @Override
    public VentaDTO consultarVenta(Integer idVenta)throws DAOException {

        VentaDTO ventaDTO= null;

        try {

            ventaDTO = convertertoDTO(ventaDAOS.getQuery(idVenta));


        }catch (Exception e) {
            System.out.println("serviceAuto fallida");
            e.printStackTrace();
        }

        return  ventaDTO;

    }

    public Venta convertertoModel (VentaDTO ventaDTO)throws DAOException{
        Venta venta = null;

        venta.setId(ventaDTO.getId());
        venta.setPrecioFinal(ventaDTO.getPrecioFinal());
        venta.setIdAuto(ventaDTO.getIdAuto());
        venta.setCantOpcionales(ventaDTO.getCantOpcionales());
        venta.setTotal$Opcional(ventaDTO.getPrecioOpcionales());
        venta.setTipoAuto(ventaDTO.getModeloAuto());

        return venta;
    }

    public VentaDTO convertertoDTO (Venta venta)throws DAOException{

        VentaDTO ventaDTO = null;

        ventaDTO.setId(venta.getId());
        ventaDTO.setPrecioFinal(venta.getPrecioFinal());
        ventaDTO.setPrecioOpcionales(venta.getTotal$Opcional());
        ventaDTO.setBasicoAuto(venta.getBasicoAuto());
        ventaDTO.setCantOpcionales(venta.getCantOpcionales());
        ventaDTO.setIdAuto(venta.getIdAuto());
        ventaDTO.setModeloAuto(venta.getTipoAuto());
        ventaDTO.setPrecioOpcionales(venta.getTotal$Opcional());

        return ventaDTO ;
    }

    public int calculoPrecioFinal() throws DAOException {

        int preciofinal =0;
        VentaDTO ventaDTO = null;
        AutoDTO autoDTO = null;
        OpcionalesDTO opcionalesDTO = null;

        AutoServiceImp autoserv = new AutoServiceImp();
        OpcionalesServiceImp opcserv = new OpcionalesServiceImp();


        autoDTO = autoserv.consultarAuto(ventaDTO.getIdAuto());
        ventaDTO.setBasicoAuto(autoDTO.getPrecio());

        opcionalesDTO = opcserv.consultarOpcionales(ventaDTO.getIdOpcionales());
        ventaDTO.setPrecioOpcionales(opcionalesDTO.getPrecio());

        preciofinal = ventaDTO.getBasicoAuto() + opcionalesDTO.getPrecio();

        return preciofinal;
    }

    public int precioOpcionales() throws DAOException {
        int precioOpc = 0;
        VentaDTO ventaDTO = null;
        OpcionalesServiceImp opsvr = new OpcionalesServiceImp();
        OpcionalesDTO opcionalesDTO = null;

        for(int i = 0; i < ventaDTO.getOpcionalesList().size(); i++){

           opcionalesDTO =  opsvr.consultarOpcionales(ventaDTO.getOpcionalesList().indexOf(i));

           precioOpc += opcionalesDTO.getPrecio();

        }
        return precioOpc;
    }

    public int cantOpcionales ()throws ServiceException{
        int contador = 0;
        VentaDTO ventaDTO = null;
        OpcionalesServiceImp opsvr = new OpcionalesServiceImp();
        contador = ventaDTO.getOpcionalesList().size();

        return contador;

    }
}
