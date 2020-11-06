package service;

import exception.*;

import dto.OpcionalesDTO;
import exception.ServiceException;

public interface OpcionalesService {

    public void ingresarOpcionales(OpcionalesDTO opcionalesDTO)throws DAOException;

    public OpcionalesDTO consultarOpcionales(Integer id)throws DAOException;

    public void actualizarOpcionales(Integer id, OpcionalesDTO opcionalesDTO)throws DAOException;

    public void borrarOpcionales(Integer id)throws DAOException;


}
