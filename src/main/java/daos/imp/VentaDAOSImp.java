package daos.imp;

import exception.DAOException;
import model.*;
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
    public void insert(Venta venta) throws DAOException{



        try {

            Statement statement = conn.createStatement();
            Statement statement1 = conn.createStatement();
            statement1.executeUpdate("SET FOREIGN_KEY_CHECKS=0");
            statement.executeUpdate("INSERT INTO intermediario ( id_auto, basico_auto, precio_final, tipo_auto, precio_opcionales, cant_opcionales) " +
                    "VALUES (" + venta.getIdAuto() + ","+ venta.getBasicoAuto() +"," + venta.getPrecioFinal() + ", '"+ venta.getTipoAuto() +"'," + venta.getTotal$Opcional()
                    +","+ venta.getCantOpcionales() + ")", Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();

            int id = 0;
            if (rs.next()){
                id = rs.getInt(1);
                venta.setId(id);
            }

            statement1.executeUpdate("SET FOREIGN_KEY_CHECKS=1");

        } catch (Exception ex) {
            throw new DAOException("Error: Clase OpcionalDAOImpl" + ex.getCause());

        }

    }


    /**
     *
     * @param id
     */

    @Override
    public void update( Integer id) throws DAOException{

        Venta venta = new Venta();

        String consulta = "update intermediario set id_auto= " + venta.getIdAuto() +", basico_auto =  "  + venta.getBasicoAuto() + ", precio_final =" + venta.getPrecioFinal()
                 + ", tipo_auto = '" + venta.getTipoAuto() + "', precio_opcionales = " + venta.getTotal$Opcional() + ", cant opcionales = " + venta.getCantOpcionales()
                + ", where id = " + id ;

        try{

            venta = new Venta();
            System.out.println(venta.getIdAuto());

            Statement statement = conn.createStatement();
            statement.executeUpdate("SET FOREIGN_KEY_CHECKS=0");
            ResultSet rs = statement.getResultSet();
            while (rs.next()) {

                statement.executeUpdate(consulta);
                System.out.println("Database updated successfully ");

            }
            statement.executeUpdate("SET FOREIGN_KEY_CHECKS=1");
        } catch (Exception ex) {
            throw new DAOException("Error: Clase OpcionalDAOImpl" + ex.getCause());
        }

    }

    /**
     *
     * @param id
     */

    @Override
    public void delete(Integer id) throws DAOException{
        try {
            Statement sentencia = conn.createStatement();
            Connection conn = AccesoConexion.getConnection();
            String consulta = "delete from intermediario where id = " + id;

            sentencia.executeUpdate(consulta);
            sentencia.close();
            conn.close();

        } catch (Exception ex) {
            throw new DAOException("Error: Clase OpcionalDAOImpl" + ex.getCause());
        }

    }

    /**
     *
     * @param id
     * @return
     */


    @Override
    public Venta getQuery(Integer id) throws DAOException{

        try {
            Statement sentencia = conn.createStatement();
            String query = "select * from intermediario where id = " + id;
            sentencia.executeQuery(query);
            ResultSet rs = sentencia.getResultSet();

            while (rs.next()) {

                Venta venta = new Venta();

                venta.setId(rs.getInt("id"));
                venta.setIdAuto(rs.getInt("id_auto"));
                venta.setPrecioFinal(rs.getInt("precio_final"));
                venta.setTipoAuto(rs.getString("tipo_auto"));
                venta.setTotal$Opcional(rs.getInt("precio_opcionales"));
                venta.setCantOpcionales(rs.getInt("cant_opcionales"));


            }


        } catch (Exception ex) {
            throw new DAOException("Error: Clase OpcionalDAOImpl" + ex.getCause());
        }
        return null;


    }
}
