package daos;

import model.Venta;

public interface VentaDAOS {

    public void insert(Venta venta);
    public void update(Venta venta);
    public void delete(Integer id);
    public Venta getQuery(Integer id);
}
