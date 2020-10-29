package daos.imp;

import model.AccesoConexion;
import model.Opcional;
import daos.OpcionalDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class OpcionalDAOimp implements OpcionalDAO{


    Connection conn = AccesoConexion.getConnection();

    @Override
    public void insert(Opcional opcional) {
        try {

            // create a Statement from the connection
            Statement statement = conn.createStatement();

            // insert the data
            statement.executeUpdate("INSERT INTO opcionales(basico, description) VALUES (" + opcional.getPrice() + ", '" + opcional.getTipo() + "')");
            //System.out.println(opcional.getBasico() + opcional.getTipo());


            String query = "select * from auto";

            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                opcional.setId(rs.getInt("id"));
            }


        } catch (Exception e) {
            System.out.println("Error: Clase AutoDaoImple, método insertar");
            e.printStackTrace();

        }


    }


    @Override
    public void update(Opcional opcional) {
        try {
            Statement sentencia = conn.createStatement();


            String query = "select * from auto";

            ResultSet rs = sentencia.executeQuery(query);
            while (rs.next()) {
                opcional.setId(rs.getInt("id"));
            }


            String consulta = "update  auto set basico = " + opcional.getPrice() + "," + "description =  '" + opcional.getTipo()
                    + "' where id =" + opcional.getId();
            sentencia.executeUpdate(consulta);


        }
        catch (Exception ex)
        {
            System.out.println("Error: Clase AutoDaoImple, método update");
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(Opcional opcional) {
        try {
            Statement sentencia = conn.createStatement();
            String query = "select * from auto";

            ResultSet rs = sentencia.executeQuery(query);
            while (rs.next()) {
                opcional.setId(rs.getInt("id"));
            }

            Connection conn = AccesoConexion.getConnection();
            String consulta = "delete from auto  where id = " + opcional.getId();

            sentencia.executeUpdate(consulta);
            sentencia.close();
            conn.close();

        } catch (Exception ex) {
            System.out.println("Error: Clase AutoDaoImple, método delete");
            ex.printStackTrace();
        }

    }

    @Override
    public Opcional getQuery(Opcional opcional) {
        Opcional opcion = null;
        String consulta = "SELECT * FROM Opcion WHERE Id = " + opcional;
        try {

            PreparedStatement sentencia = this.conn.prepareStatement(consulta);
            ResultSet rs = sentencia.executeQuery(consulta);

            if (rs.next()) {
                opcion = new Opcional();
                opcion.setId(rs.getInt("Id"));
                //opcion.setTipo(rs.getString("Descripcion"));
                //opcion.setPrecio(rs.getInt("Precio"));






            /*
            Statement sentencia = conn.createStatement();
            String query = "select * from auto";

            ResultSet rs = sentencia.executeQuery(query);
            while (rs.next()) {
                opcional.setId(rs.getInt("id"));
            }

            sentencia.executeQuery(query);
            ResultSet ps = sentencia.getResultSet();

            if (ps.next()) {
                opcional = new Opcional();
                auto.setId(ps.getInt("Id"));
                System.out.println("El id de la seleccion es: " + opcional.getId() + ", su valor es de: " + opcional.getPrice()
                        + "$ y es del tipo: " + opcional.getTipo());


            }*/


            }
        }catch (Exception ex) {

            ex.printStackTrace();
        }
        return opcion;

    }
    /*************************************************************************************
     *
     * Implementacion de sql para tabla intermediaria lado opciones
     *
    *****************************************************************************************/


    public void insertIntermedio(Opcional opcional) {
        try {

            // create a Statement from the connection
            Statement statement = conn.createStatement();

            // insert the data
            statement.executeUpdate("INSERT INTO intermedia(basico, description) VALUES (" + opcional.getPrice() + ", '" + opcional.getTipo() + "')");



            String query = "select * from auto";

            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                opcional.setId(rs.getInt("id"));
            }


        } catch (Exception e) {
            System.out.println("Error: Clase AutoDaoImple, método insertar");
            e.printStackTrace();

        }


    }



    public void updateIntermedio(Opcional opcional) {
        try {
            Statement sentencia = conn.createStatement();


            String query = "select * from auto";

            ResultSet rs = sentencia.executeQuery(query);
            while (rs.next()) {
                opcional.setId(rs.getInt("id"));
            }


            String consulta = "update  auto set basico = " + opcional.getPrice() + "," + "description =  '" + opcional.getTipo()
                    + "' where id =" + opcional.getId();
            sentencia.executeUpdate(consulta);


        }
        catch (Exception ex)
        {
            System.out.println("Error: Clase AutoDaoImple, método update");
            ex.printStackTrace();
        }
    }


    public void deleteIntermedio(Opcional opcional) {
        try {
            Statement sentencia = conn.createStatement();
            String query = "select * from auto";

            ResultSet rs = sentencia.executeQuery(query);
            while (rs.next()) {
                opcional.setId(rs.getInt("id"));
            }

            Connection conn = AccesoConexion.getConnection();
            String consulta = "delete from auto  where id = " + opcional.getId();

            sentencia.executeUpdate(consulta);
            sentencia.close();
            conn.close();

        } catch (Exception ex) {
            System.out.println("Error: Clase AutoDaoImple, método delete");
            ex.printStackTrace();
        }

    }

    public Opcional getQueryIntermedio(Opcional opcional) {
        Opcional opcion = null;
        String consulta = "SELECT * FROM Opcion WHERE Id = " + opcional;
        try {

            PreparedStatement sentencia = this.conn.prepareStatement(consulta);
            ResultSet rs = sentencia.executeQuery(consulta);

            if (rs.next()) {
                opcion = new Opcional();
                opcion.setId(rs.getInt("Id"));
                //opcion.setTipo(rs.getString("Descripcion"));
                //opcion.setPrecio(rs.getInt("Precio"));



            }
        }catch (Exception ex) {

            ex.printStackTrace();
        }
        return opcion;

    }
}





