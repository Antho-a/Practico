public class Colision {
    
public static int ColisionLineal(int indice, Tareas arreglo[],String cosa,int x){//Cosa puede ser posicion vacia (en caso de insertar) o clave que se desea encontrar
        indice+=x; 
        if(indice >= 100){//cuando el indice supera al tamaño de la tabla solo tomamos los que le siguen haciendo de cuenta que es circular
            indice = indice%101;
        }                                               
       if(arreglo[indice].getId().equalsIgnoreCase(cosa)){
            return indice;
            
        }else{
            return ColisionLineal(indice, arreglo, cosa,(x++));
        }
    }

   public static int ColisionCuadratica(int indice, Tareas arreglo[],String cosa,int x){
        indice+=(x^2); 
        if(indice >= 100){
            indice = indice%101;
        }                                               
       if(arreglo[indice].getId().equalsIgnoreCase(cosa)){
            return indice;
            
        }else{
            return ColisionCuadratica(indice, arreglo, cosa,(x++));
        }
    }
}