package daos.imp;

import model.AccesoConexion;
import model.Autos;
import model.Opcional;
import model.Venta;
import daos.VentaDAOS;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class VentaDAOSImp implements VentaDAOS {



    Connection conn = AccesoConexion.getConnection();

    /**
     *
     * @param venta
     */

    @Override
    public void insert(Venta venta) {


        try {

            Statement statement = conn.createStatement();
            int rows = statement.executeUpdate("INSERT INTO venta (pago, description, cantidad_opcionales) VALUES (" + venta.getPago()
                    + ",'" + venta.getTipoAuto() +"'" +venta.getCantOpcionales() +")", Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()){
                venta.setId(rs.getInt(1));
            }
            System.out.println(venta.getId());


        } catch (Exception e) {
            System.out.println("Error: Clase AutoDaoImple, método insertar");
            e.printStackTrace();

        }


    }


    /**
     *
     * @param venta
     */

    @Override
    public void update(Venta venta) {
        String consulta = "update  venta set pago = " + venta.getPago() + "," + "description =  '"
                + venta.getTipoAuto() + ","+ "cantidad_opcionales = "+ venta.getCantOpcionales()+ "' where id =" + venta.getId();
        try {
            Statement statement = conn.createStatement();
            int rows = statement.executeUpdate(consulta, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()){
                venta.setId(rs.getInt(1));
            }
            System.out.println(venta.getId());



            statement.executeUpdate(consulta);
            System.out.println(consulta);




        } catch (Exception ex) {
            System.out.println("Error: Clase AutoDaoImple, método update");
            ex.printStackTrace();
        }
    }

    /**
     *
     * @param id
     */

    @Override
    public void delete(Integer id) {
        try {
            Statement sentencia = conn.createStatement();
            Connection conn = AccesoConexion.getConnection();
            String consulta = "delete from auto where id = " + id;

            sentencia.executeUpdate(consulta);
            sentencia.close();
            conn.close();

        } catch (Exception ex) {
            System.out.println("Error: Clase AutoDaoImple, método delete");
            ex.printStackTrace();
        }

    }

    /**
     *
     * @param id
     * @return
     */


    @Override
    public Venta getQuery(Integer id) {
        Venta venta = null;
        try {
            Statement sentencia = conn.createStatement();
            String query = "select * from auto where id = " + id;
            sentencia.executeQuery(query);
            ResultSet ps = sentencia.getResultSet();

            if (ps.next()) {
                venta = new Venta( );
                venta.setId(ps.getInt("id"));
                System.out.println("El id de la venta es: " + venta.getId() + ", su valor es de: "+ venta.getPago()
                        + "$ y se vendio un auti tipo : "+ venta.getTipoAuto());
            }


        } catch (Exception ex) {

            ex.printStackTrace();
        }
        return null;


    }
}
