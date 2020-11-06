package service;

import dto.AutoDTO;
import dto.VentaDTO;
import exception.ServiceException;
import exception.*;

public interface VentaService {

    public void ingresarVenta(VentaDTO ventaDTO)throws DAOException;
    public VentaDTO consultarVenta(Integer idVenta)throws DAOException;
}
