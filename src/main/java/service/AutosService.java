package service;
import exception.ServiceException;
import dto.AutoDTO;
import model.Auto;
import exception.*;

import java.util.ArrayList;

public interface AutosService {

    public void ingresarAuto(AutoDTO autoDTO)throws DAOException;

    public AutoDTO consultarAuto(Integer idAuto)throws DAOException;

    public void actualizarAuto(Integer idAuto, AutoDTO autoDTO)throws DAOException;

    public void borrarAuto(Integer id)throws DAOException;

    public void consultarListaAutos()throws DAOException;

    public Integer precioxAuto (int id)throws DAOException;
}
