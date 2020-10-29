package daos.imp;
import model.Coupe;
import java.sql.*;
import model.AccesoConexion;
import daos.CoupeDAO;
import model.Sedan;


public class CoupeDAOimp implements CoupeDAO {

    Connection conn = AccesoConexion.getConnection();
    /**
     *
     * @param coupe
     */

    @Override
    public void insert(Coupe coupe) {


        try {

            Statement statement = conn.createStatement();
            int rows = statement.executeUpdate("INSERT INTO auto (basico, description) VALUES (" + coupe.getBasico()
                    + ",'" + coupe.getTipo()+"')", Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()){
                coupe.setId(rs.getInt(1));
            }
            System.out.println(coupe.getId());


        } catch (Exception e) {
            System.out.println("Error: Clase AutoDaoImple, método insertar");
            e.printStackTrace();

        }


    }


    /**
     *
     * @param coupe
     */

    @Override
    public void update(Coupe coupe) {
        String consulta = "update  coupe set basico = " + coupe.getBasico() + "," + "description =  '"
                + coupe.getTipo() + "' where id =" + coupe.getId();
        try {
            Statement statement = conn.createStatement();
            int rows = statement.executeUpdate(consulta, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()){
                coupe.setId(rs.getInt(1));
            }
            System.out.println(coupe.getId());



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
        Coupe coupe = null;
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
    public Coupe getQuery(Integer id) {
        Coupe coupe = null;
        try {
            Statement sentencia = conn.createStatement();
            String query = "select * from auto where id = " + id;
            sentencia.executeQuery(query);
            ResultSet ps = sentencia.getResultSet();

            if (ps.next()) {
                coupe = new Coupe();
                coupe.setId(ps.getInt("id"));
                System.out.println("El id de la seleccion es: " + coupe.getId() + ", su valor es de: "+ coupe.getBasico() + "$ y es del tipo: "+ coupe.getTipo());
            }


        } catch (Exception ex) {

            ex.printStackTrace();
        }
        return null;


    }
}