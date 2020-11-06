package daos;

import exception.DAOException;
import model.Venta;

public interface VentaDAOS {

    public void insert(Venta venta)throws DAOException;
    public void update(Integer id)throws DAOException;
    public void delete(Integer id)throws DAOException;
    public Venta getQuery(Integer id) throws DAOException;
}
