package model;

public class Opcional implements OpcionalInterface{


    /*****************************************************************************************
     * Decidi hacer todos en la misma clase ya que no tenian muchos atributos por separado
     **************************************************************************************/

    private boolean frenos;
    private final int frPrice = 14000;


    private boolean techo;
    private final int tcPrice = 12000 ;

    private boolean aire;
    private final int aaPrice = 20000;


    private boolean airbag;
    private final int abPrice = 7000;


    private boolean ruedas;
    private final int  raPrice = 18000;


    private int contador_opcional;

    private String Tipo= "";
    private int id;
    private int price;





    @Override
    public String getTipo() {
        setTipo();
        if (techo)
            this.Tipo = "techo";
        else;
        if (airbag)
            this.Tipo = "airbag";
        else;
        if (frenos)
            this.Tipo = "frenos";
        else;
        if (aire)
            this.Tipo = "aire";
        else;
        if (ruedas)
            this.Tipo = "ruedas";
        else;
        return this.Tipo;
    }

    @Override
    public int getPrice()
    {
        setPrice();
        return price;
    }

    @Override
    public int getContadorOpcionales()
    {

        return contador_opcional;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public void setTipo ()
    {

        if (frenos)
            this.Tipo = "Frenos";
        else;
        if (airbag)
            this.Tipo="Airbag";
        else;
        if (aire)
            this.Tipo="Aire acondicionado";
        else;
        if (ruedas)
            this.Tipo="Ruedas Aleacion";
        else;
        if (techo)
            this.Tipo="Techo";
        else;

    }

    public void add_opcional(String opcional){

        if (opcional == "techo")
            this.techo = true;
        else;
        if (opcional == "aire")
            this.aire = true;
        else;
        if (opcional == "airbag")
            this.airbag = true;
        else;
        if (opcional == "ruedas")
            this.ruedas = true;
        else;
        if (opcional == "frenos")
            this.frenos = true;
        else;

        total();

    }

    public void setPrice(){

        if (techo)
            this.price = tcPrice;
        else;
        if (airbag)
            this.price = abPrice;
        else;
        if (aire)
            this.price = aaPrice;
        else;
        if (frenos)
            this.price = frPrice;
        else;
        if (ruedas)
            this.price = raPrice;
        else;
    }



    public int total(){

        int contador = 0;
        int sumatoria = 0;
        if (techo) {
            sumatoria += this.tcPrice;
            contador++;

        }else;
        if (airbag) {
            sumatoria += this.abPrice;
            contador++;

        }else;
        if (aire) {
            sumatoria += this.abPrice;
            contador++;

        }
        else;
        if (frenos) {
            sumatoria += this.frPrice;
            contador++;

        }
        else;
        if (ruedas) {
            sumatoria += this.raPrice;
            contador++;

        }
        else;

        this.contador_opcional = contador;
        return sumatoria;


    }


/*


    public void Tipo (){

        if (frenos)
            this.Tipo = "Frenos";
        else{}
        if (airbag)
            this.Tipo="Airbag";
        else{}
        if (aire)
            this.Tipo="Aire acondicionado";
        else{}
        if (ruedas)
            this.Tipo="Ruedas Aleacion";
        else{}
        if (techo)
            this.Tipo="Techo";
        else{}

    }

    public String getTipo(){
        return this.Tipo;
    }


    public Opcional(){

    }

    public boolean getFrenos() { return this.frenos; }
    public boolean getTecho() { return this.techo; }
    public boolean getAirbag() { return this.airbag; }
    public boolean getRuedas() { return this.ruedas; }


    public void add_Frenos(String Freno) {

        if (Freno == "si")
            this.frenos=true;
        else
            this.frenos=false;

    }

    public void add_Techo(String Techo) {
        if (Techo == "si")
            this.techo=true;
        else
            this.techo=false;
    }

    public void add_Aire(String Aire) {
        if (Aire == "si")
            this.aire = true;
        else
            this.aire = false;
    }

    public void add_Airbag(String Airbag) {
        if (Airbag == "si")
            this.airbag = true;
        else
            this.airbag =false;
    }

    public void add_Ruedas(String Ruedas) {
        if (Ruedas == "si")
            this.ruedas = true;
        else
            this.ruedas = false;
    }


    public int getTotal_opcional() {
        int sumatoria = 0;
        if (this.ruedas)
            sumatoria += getRaPrice();
        else {}
        if (this.frenos)
            sumatoria += getFrPrice();
        else{}
        if (this.airbag)
            sumatoria += getAbPrice();
        else{}
        if (this.aire)
            sumatoria += getAaPrice();
        else{}
        if (this.techo)
            sumatoria += getTcPrice();
        else{}

        return sumatoria;
    }


    public int pago_final() {
        return 0;
    }


    public String mensaje() {
        String mensaje = "";
        if (this.ruedas)
            mensaje += "\nLL ";
        else {}
        if (this.airbag)
            mensaje += "\nAB";
        else{}
        if (this.aire)
            mensaje += "\nAA";
        else{}
        if (this.techo)
            mensaje += "\nTC";
        else{}
        if(this.frenos)
            mensaje += "\nABS";

        return mensaje;

    }

    public int contador_opcionales(){
        int contador = 0;
        if (this.ruedas)
            contador++;
        else {}
        if (this.airbag)
            contador++;
        else{}
        if (this.aire)
            contador++;
        else{}
        if (this.techo)
            contador++;
        else{}
        if(this.frenos)
            contador++;

        return contador;

    }

    public int getFrPrice() {
        return frPrice;
    }

    public int getTcPrice() {
        return tcPrice;
    }

    public int getAaPrice() {
        return aaPrice;
    }

    public int getAbPrice() {
        return abPrice;
    }

    public int getRaPrice() {
        return raPrice;
    }


    public int getPrice() {
        return Price;
    }

    public void setPrice() {
        if (airbag)
            this.Price = this.abPrice;
        else{}
        if (ruedas)
            this.Price = this.raPrice;
        else{}
        if (aire)
            this.Price = this.aaPrice;
        else{}
        if (techo)
            this.Price = this.tcPrice;
        else{}
        if (frenos)
            this.Price = this.frPrice;
        else{}
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

 */
}


