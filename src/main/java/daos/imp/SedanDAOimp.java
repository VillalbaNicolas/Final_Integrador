package daos.imp;

import model.AccesoConexion;
import model.Autos;
import model.Sedan;
import  daos.SedanDAO;

import java.sql.*;

public class SedanDAOimp  implements SedanDAO{


    Connection conn = AccesoConexion.getConnection();

    /**
     *
     * @param sedan
     */

    @Override
    public void insert(Sedan sedan) {


        try {

            Statement statement = conn.createStatement();
            int rows = statement.executeUpdate("INSERT INTO auto (basico, description) VALUES (" + sedan.getBasico()
                    + ",'" + sedan.getTipo()+"')", Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()){
                sedan.setId(rs.getInt(1));
            }
            System.out.println(sedan.getId());


        } catch (Exception e) {
            System.out.println("Error: Clase AutoDaoImple, método insertar");
            e.printStackTrace();

        }


    }


    /**
     *
     * @param sedan
     */

    @Override
    public void update(Sedan sedan) {
        String consulta = "update  sedan set basico = " + sedan.getBasico() + "," + "description =  '"
                + sedan.getTipo() + "' where id =" + sedan.getId();
        try {
            Statement statement = conn.createStatement();
            int rows = statement.executeUpdate(consulta, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()){
                sedan.setId(rs.getInt(1));
            }
            System.out.println(sedan.getId());



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
        Sedan sedan = null;
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
    public Sedan getQuery(Integer id) {
        Sedan sedan = null;
        try {
            Statement sentencia = conn.createStatement();
            String query = "select * from auto where id = " + id;
            sentencia.executeQuery(query);
            ResultSet ps = sentencia.getResultSet();

            if (ps.next()) {
                sedan = new Sedan();
                sedan.setId(ps.getInt("id"));
                System.out.println("El id de la seleccion es: " + sedan.getId() + ", su valor es de: "+ sedan.getBasico() + "$ y es del tipo: "+ sedan.getTipo());
            }


        } catch (Exception ex) {

            ex.printStackTrace();
        }
        return null;


    }
}
