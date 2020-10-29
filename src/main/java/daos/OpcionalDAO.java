package daos;
import model.*;

public interface OpcionalDAO
{

    public void insert(Opcional opcional);
    public void update(Opcional opcional);
    public void delete(Opcional opcional);
    public Opcional getQuery(Opcional opcional);
}
