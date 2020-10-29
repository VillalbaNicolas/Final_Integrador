package daos.imp;
import com.sun.org.apache.bcel.internal.generic.FADD;
import model.AccesoConexion;
import model.Autos;
import daos.FamiliarDAO;
import model.Familiar;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class FamiliarDAOimp implements FamiliarDAO {

    Connection conn = AccesoConexion.getConnection();


        /**
         *
         * @param familiar
         */

        @Override
        public void insert(Familiar familiar) {


            try {

                Statement statement = conn.createStatement();
                int rows = statement.executeUpdate("INSERT INTO auto (basico, description) VALUES (" + familiar.getBasico()
                        + ",'" + familiar.getTipo()+"')", Statement.RETURN_GENERATED_KEYS);
                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next()){
                    familiar.setId(rs.getInt(1));
                }
                System.out.println(familiar.getId());


            } catch (Exception e) {
                System.out.println("Error: Clase AutoDaoImple, método insertar");
                e.printStackTrace();

            }


        }


        /**
         *
         * @param familiar
         */

        @Override
        public void update(Familiar familiar) {
            String consulta = "update  familiar set basico = " + familiar.getBasico() + "," + "description =  '"
                    + familiar.getTipo() + "' where id =" + familiar.getId();
            try {
                Statement statement = conn.createStatement();
                int rows = statement.executeUpdate(consulta, Statement.RETURN_GENERATED_KEYS);
                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next()){
                    familiar.setId(rs.getInt(1));
                }
                System.out.println(familiar.getId());



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
            Familiar familiar = null;
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
        public Familiar getQuery(Integer id) {
            Familiar familiar = null;
            try {
                Statement sentencia = conn.createStatement();
                String query = "select * from auto where id = " + id;
                sentencia.executeQuery(query);
                ResultSet ps = sentencia.getResultSet();

                if (ps.next()) {
                    familiar = new Familiar();
                    familiar.setId(ps.getInt("id"));
                    System.out.println("El id de la seleccion es: " + familiar.getId() + ", su valor es de: "+ familiar.getBasico() + "$ y es del tipo: "+ familiar.getTipo());
                }


            } catch (Exception ex) {

                ex.printStackTrace();
            }
            return null;


        }
}
