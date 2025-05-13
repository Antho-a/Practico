
import java.util.Scanner;

public class Hash {
//Atributos
    private final int m = 101;

    private int numElementos = 0;

    private double factorCarga = 0;

    private Tareas tabla [] = new Tareas[m];
//Constructor
    public Hash(){
        for ( int i = 0 ; i<m ; i++){//se inicializan las tareas
            tabla[i] = new Tareas();
        }
        
    }

//Metodos
    public boolean Insertar(int i, int colision,Tareas tarea){

        long clave;
        int indice;
        
        clave=TransformarId(tarea.getId().substring(0, 10));
        if(i==1){//Ve el metodo elegido por el usuario de hasheo
            indice=AritmeticaMod(clave);
        }else{
            indice=MetodoMul(clave);
        }

        if(this.tabla[indice].getId() != null){//si la tabla esta ocupada por alguna tarea en el indice=clave tranformada se empiezan a hacer colisiones

            if(colision == 1){//Ve el metodo elegido por el usuario de resolucion de colisiones
                indice = Colision.ColisionLineal(indice, this.tabla,"",1);

            }
            else{
                indice=Colision.ColisionCuadratica(indice, this.tabla,"",1);
            }
        }

        this.tabla[indice]=tarea;//guarda la tarea ingresada en un indice de la tabla
        numElementos=numElementos+1;//Cuenta las tareas ingresadas
        return tabla[indice].getesAlta();
    }

    private int AritmeticaMod(long clave){//privados porque solo los debe manejar la clase
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
                System.out.println(tabla[i].MostrarId());
            }
        } 
        System.out.println("---------------------------------------------------------------");
        System.out.println("\n");

    }
    public void getTarea(int indice){
        System.out.println(this.tabla[indice].toString());
    }
    public int Buscar(String clave , int hash, int colision ){ //metodo buscar

        int indice;

        long claveTransformada = TransformarId(clave); //Transforma la clave para buscarla en la tabla

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
            if(tabla[indice].getId().substring(0, 10).equals(clave)){//Si la tarea a buscar no ha tenido colisiones retorna la clave transformada
                return indice;
            }else{//Si no llega a hacer la clave transformada se realiza metodos de colision hasta encontrarla
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
     public String editarTarea(int indice,int op){
        Scanner letra = new Scanner(System.in);
        String fechaF,fechaI;
        switch(op){
            case 1:
                System.out.println("Ingrese el nombre nuevo para la tarea\n");
                String nombre =letra.nextLine();
                tabla[indice].setNombre(nombre);
            break;
            case 2:
                System.out.println("Ingrese la nueva descripcion para la tarea\n");
                String descripcion =letra.nextLine();
                tabla[indice].setDescripcion(descripcion);
            break;
            case 3:
                System.out.println("Ingrese la nueva fecha de creacion de la tarea(AAAA-MM-DD)");
                while(true){
                    try {
                        fechaI = letra.nextLine();
                        tabla[indice].setFechaFinal(fechaI);
                        break;
                    } 
                    catch (Exception e) {
                    System.out.println("Fecha inválida. Ingrese la fecha en el formato indicado (AA-MM-DD)");    
                    }
                }
            break;
            case 4:
                System.out.println("Ingrese la nueva fecha de finalizacion de la tarea(AAAA-MM-DD)");
                while(true){
                    try {
                        fechaF = letra.nextLine();
                        tabla[indice].setFechaFinal(fechaF);
                        break;
                    } 
                    catch (Exception e) {
                    System.out.println("Fecha inválida. Ingrese la fecha en el formato indicado (AA-MM-DD)");    
                    }
                }
            break;
            case 5:
                if(tabla[indice].getEstado().equals("Pendiente")){
                    tabla[indice].setEstado(2);
                }else if(tabla[indice].getEstado().equals("En curso")){
                    tabla[indice].setEstado(3);
                }
            break;
        }
        return "La tarea fue editada con exito";
    }
    public double  calcularFactor(){
        factorCarga=numElementos/m;
        return (factorCarga);
    }
}