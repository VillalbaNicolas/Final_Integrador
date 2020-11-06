/*
Tomando como referencia los ejercicios Integradores 2 y 3 y lo visto en clase, exponer los  siguientes recursos y operaciones con sus respectivos manejos de excepciones

Automóvil:

Alta
Baja
Modificación
Consulta de Automóviles ( listado )
Consulta de Precio por automóvil
Adicionales:

Alta
Baja
Modificación
Consulta.
 */



import com.mysql.cj.x.protobuf.MysqlxCrud;
import model.*;
import daos.imp.*;

public class Main {
    public static void main(String[] args) {


        /**************************************************************************************************
         *
         * Agrega los tipos de autos a la tabla
         *
         **************************************************************************************************/
/*
        //instancio cada modelo

        Sedan sed1 = new Sedan();
        Coupe cou1 = new Coupe();
        Familiar fam1 = new Familiar();

        //          xxx.insert  xxx.delete  xxx.update  xxx.getQuery

        SedanDAOimp SED =  new SedanDAOimp();
        //SED.insert(sed1);

        //SED.getQuery(sed1.getId());

        //SED.delete(sed1.getId());
        //System.out.println(sed1.getId());

        CoupeDAOimp COU = new CoupeDAOimp();
        //COU.insert(cou1);

        FamiliarDAOimp FAM = new FamiliarDAOimp();
        //FAM.insert(fam1);

*/
        /*************************************************************************************************
           Vamos a implementar las opciones
         *************************************************************************************************/
/*

        Opcional ruedas = new Opcional();
        Opcional techo = new Opcional();
        Opcional aireA = new Opcional();
        Opcional airbag = new Opcional();
        Opcional freno = new Opcional();

        ruedas.add_opcional("ruedas");
        techo.add_opcional("techo");
        aireA.add_opcional("aire");
        airbag.add_opcional("airbag");
        freno.add_opcional("frenos");

        /************************************************************************************************

         la implementacion de las opciones a la tabla "opciones" de cada una de los opcionales

         ***********************************************************************************************/

        //OpcionalDAOimp impl = new OpcionalDAOimp();
        //impl.insert(ruedas);
        //impl.insert(techo);
        //impl.insert(aireA);
        //impl.insert(airbag);
        //impl.insert(freno);

        /**********************************************************************************************
         *
         * Realizar venta
         *
         ***********************************************************************************************/
/*
        Opcional opc1 = new Opcional();
        opc1.add_opcional("ruedas");
        opc1.add_opcional("techo");
        opc1.add_opcional("aire");
        opc1.add_opcional("airbag");

        Opcional opc2 = new Opcional();
        opc1.add_opcional("ruedas");
        opc1.add_opcional("techo");

        Opcional opc3 = new Opcional();
        opc1.add_opcional("ruedas");
        opc1.add_opcional("aire");
        opc1.add_opcional("airbag");





        Venta venta1 = new Venta();
        venta1.pago_final(sed1,opc1);

        Venta venta2 = new Venta();
        venta2.pago_final(cou1,opc2);

        Venta venta3 = new Venta();
        venta3.pago_final(fam1,opc3);

*/
        /***********************************************************************************************************
         *
         *  implementacion a Sql
         *
         **********************************************************************************************************/
/*

        VentaDAOSImp venta_imp= new VentaDAOSImp();
        venta_imp.insert(venta1);
        venta_imp.insert(venta2);
        venta_imp.insert(venta3);

*/
        /*
AutosDAOim autoDao = new AutosDAOim();
Auto auto1 = new Auto();
Opcional opcional = new Opcional();
opcional.add_opcional("techo");
opcional.add_opcional("airbag");

OpcionalDAOimp opDAO = new OpcionalDAOimp();

//autoDao.getQuery(1);
//opDAO.getQuery(1);

Venta venta1 = new Venta(auto1,opcional);
        VentaDAOSImp ventaDAO = new VentaDAOSImp();


        ventaDAO.update(8);
       // System.out.println(venta1.getId());


*/
    }

}

