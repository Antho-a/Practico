public class Colision {
    
public static int ColisionLineal(int indice, Tareas arreglo[],String cosa,int x){
        indice+=x; 
        if(indice >= 100){
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