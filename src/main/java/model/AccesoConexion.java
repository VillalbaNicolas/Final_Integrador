package model;
import exception.DAOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class  AccesoConexion   {
    private final static String url = "jdbc:mysql://localhost:3306/venta_autos";
    private final static String usuario = "root";
    private final static String clave ="";






    public static Connection getConnection()  {

        Connection conexion = null;

        try {
            if (conexion == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conexion = DriverManager.getConnection(url, usuario, clave);
                System.out.println("Conectado");
            }

        } catch (Exception e) {

            System.out.println("Error en conexion");


        }
        return conexion;
    }


    public static void closeConnection(Connection conexion){

        try {
            conexion.close();
        }catch (Exception e) {
            System.out.println("Conexion fallida");
            e.printStackTrace();
        }
    }
}