public class Hash {

    private final int m = 101;

    private int numElementos = 0;

    private double factorCarga = 0;

    Tareas tabla [] = new Tareas[m];

    public Hash(){
        for ( int i = 0 ; i<m ; i++)
        tabla[i] = new Tareas();
    }


    public boolean Insertar(int i, int colision,Tareas tarea){

        long clave;
        int indice;
        
        clave=TransformarId(tarea.getId().substring(0, 10));
        if(i==1){
            indice=AritmeticaMod(clave);
        }else{
            indice=MetodoMul(clave);
        }

        if(this.tabla[indice].getId() != null){

            if(colision == 1){
                indice = Colision.ColisionLineal(indice, this.tabla,"",1);

            }
            else{
                indice=Colision.ColisionCuadratica(indice, this.tabla,"",1);
            }
        }

        this.tabla[indice]=tarea;

        return tabla[indice].getesAlta();
    }

    private int AritmeticaMod(long clave){
        return (int)(clave % m);
    }

    private int MetodoMul(long clave){
        final double R = 0.618034;
        double aux;
        aux=(R*clave)-Math.floor(R*clave);
        return (int) (aux*m);
    }

    private int TransformarId (String id ){ 
        int clave = 0 ;

        for (int j = 0; j < Math.min(id.length(),10); j++){
         clave = clave * 5 + id.charAt(j);
        }
        return clave;
    } 


    public void MostrarId(){ // metodo que muestra los id existentes 
        
        System.out.println("---------------------------------------------------------------");

        for (int i = 0 ; i<m ; i++){
            if (this.tabla[i].getId()!=null){
                System.out.println(i+")"+tabla[i].MostrarId());
            }
        } 
        System.out.println("---------------------------------------------------------------");
        System.out.println("\n");

    }
    public void getTarea(int indice){
        System.out.println(this.tabla[indice].toString());
    }
    public int Buscar(String clave , int hash, int colision ){ //metodo buscar

        int indice; // su nombre da su funcionalidad xd

        long claveTransformada = TransformarId(clave); // Ya que la funcion hash tanforma el indice en un numero cualquiera, necesito hacer lo mismo con lo que ingrese el usuario
                                                       // y guardar ese cambio para poder usarlo en los metodos 

        if (hash==1){
            indice=AritmeticaMod(claveTransformada);

        }
        else{
            indice=MetodoMul(claveTransformada);
        }

        if(tabla[indice].getId() == null || tabla[indice].getesAlta() == false){
            System.out.println("El articulo que desea buscar no exite o ha sido eliminado ");
            return 101;
        }
        else{
            if(tabla[indice].getId().substring(0, 10).equals(clave)){
                return indice;
            }else{
                if(colision==1){
                    indice=Colision.ColisionLineal(indice, tabla, clave, 1);
                    return indice; 
                }else{
                    indice=Colision.ColisionCuadratica(indice, tabla, clave, 1);
                    return indice; 
                }
                
            }
        }  
        
    }
    public String eliminarTarea(int indice){
        tabla[indice].setId("");
        tabla[indice].setesAlta();
        return "La tarea fue eliminada con exito";
    }
}