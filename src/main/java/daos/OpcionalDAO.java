package daos;
import exception.DAOException;
import model.*;

public interface OpcionalDAO
{

    public void insert(Opcional opcional)throws DAOException;
    public void update(Integer id, Opcional opcional)throws DAOException;
    public void delete(Integer id)throws DAOException;
    public Opcional getQuery(Integer integer)throws DAOException;
}
