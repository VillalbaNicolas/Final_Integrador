package daos;
import model.*;

import java.sql.SQLException;

public interface FamiliarDAO {

    public void insert(Familiar familiar);
    public void update(Familiar familiar);
    public void delete(Integer id);
    public Familiar getQuery(Integer id);
}
