package daos;
import model.*;

public interface SedanDAO {

    public void insert(Sedan sedan);
    public void update(Sedan sedan);
    public void delete(Integer id);
    public Sedan getQuery(Integer id);

}
