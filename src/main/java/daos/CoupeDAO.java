package daos;
import model.*;

import java.sql.SQLException;

public interface CoupeDAO {

    public void insert(Coupe coupe);
    public void update(Coupe coupe);
    public void delete(Integer id);
    public Coupe getQuery(Integer id);
}
