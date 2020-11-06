package daos.imp;

import exception.DAOException;
import model.*;
import daos.OpcionalDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class OpcionalDAOimp implements OpcionalDAO {


    Connection conn = AccesoConexion.getConnection();

    @Override
    public void insert(Opcional opcional)throws DAOException {
        try {

            // create a Statement from the connection
            Statement statement = conn.createStatement();

            // insert the data
            statement.executeUpdate("INSERT INTO opcionales (basico, description) VALUES (" + opcional.getPrecio() + ", '" + opcional.getTipo() + "')");
            //System.out.println(opcional.getBasico() + opcional.getTipo()());


            String query = "select * from auto";

            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                opcional.setId(rs.getInt("id"));
            }


        } catch (Exception ex) {
            throw new DAOException("Error: Clase OpcionalDAOImpl" + ex.getCause());

        }


    }


    @Override
    public void update(Integer id, Opcional opcional)throws DAOException {
        String consulta = "update opcionales set basico = " + opcional.getPrecio() + "," + "description =  '"
                + opcional.getTipo() + "' where id =" + id;

        try {
            Statement sentencia = conn.createStatement();
            ResultSet rs = sentencia.getResultSet();

            while (rs.next()) {

                Statement statement = conn.createStatement();
                statement.executeUpdate(consulta);
                System.out.println("Database updated successfully ");

            }

        } catch (Exception ex) {
            throw new DAOException("Error: Clase OpcionalDAOImpl" + ex.getCause());
        }
    }


    @Override
    public void delete(Integer id)throws DAOException {

        try {
            Statement sentencia = conn.createStatement();
            Connection conn = AccesoConexion.getConnection();
            String consulta = "delete from opcionales where id = " + id;

            sentencia.executeUpdate(consulta);
            sentencia.close();
            conn.close();

        } catch (Exception ex) {
            throw new DAOException("Error: Clase OpcionalDAOImpl" + ex.getCause());
        }

    }

    @Override
    public Opcional getQuery(Integer id) throws DAOException{
        Opcional opcional = null;
        try {
            Statement sentencia = conn.createStatement();
            String query = "select * from opcionales where id = " + id;
            sentencia.executeQuery(query);
            ResultSet rs = sentencia.getResultSet();
            while (rs.next()) {
                opcional = new Opcional();
                opcional.setId(rs.getInt("id"));
                opcional.setPrecio(rs.getInt("basico"));
                opcional.setTipo(rs.getString("description"));
                System.out.println("El id de la seleccion es: " + opcional.getId() + opcional.getPrecio() + ", su valor es de: " + opcional.getTipo()
                        + "$ y es del tipo: ");

            }


        } catch (Exception ex) {
            throw new DAOException("Error: Clase OpcionalDAOImpl" + ex.getCause());
        }
        return null;
    }
}





