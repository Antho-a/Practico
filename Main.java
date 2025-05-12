import java.util.Scanner;

public class Main {

 
    public static Tareas ingresar(){//Asigna valores a los atributos

        Tareas aux = new Tareas();
        Scanner letra = new Scanner(System.in);
        Scanner num = new Scanner(System.in);
        String fechaf,nombre,descripcion;
        int estado;

        System.out.println("Ingrese el nombre de la tarea");
        nombre = letra.nextLine();
        aux.setNombre(nombre);//Coloca el nombre ingresado

        System.out.println("Ingrese la descripcion de la tarea");
        descripcion = letra.nextLine();
        aux.setDescripcion(descripcion);//Coloca la descripcion ingresada

         

            System.out.println("Ingrese la fecha de creacion de la tarea(AAAA-MM-DD)");
            fechaf = letra.nextLine();
        
            try {
            aux.setFechaFinal(fechaf);
            } 
            catch (Exception e) {
            System.out.println("Fecha inválida. Ingrese la fecha en el formato indicado (AA-MM-DD)");
            fechaf = letra.nextLine();
            aux.setFechaFinal(fechaf);
            }
            

       

        System.out.println("Ingrese el estado:\n[1].Pendiente\n[2].En curso");   
        estado=num.nextInt();
        aux.setEstado(estado);//Asigna estado de la tarea

        return aux;
    }



    public static int menu(){ // menu que se ejecutara 

        Scanner teclado = new Scanner(System.in);
        int op;
            System.out.println("[1].Ingresar tarea");
            System.out.println("[2].Mostrar tarea");
            System.out.println("[3].Editar Tarea");
            System.out.println("[4].Eliminar Tarea");
            System.out.println("[5].Salir");
            op = teclado.nextInt();
            while(op<1||op>5){
                System.out.println("Ingrese una opcion valida");
                op = teclado.nextInt();
            }
        return op;
    }


    public static void main(String[]args){


        Scanner letra = new Scanner(System.in);//Variable de entrada para letras
        Scanner num = new Scanner(System.in);//Variable de entrada para numeros
        int hash,colision,opcion; //variables opciones, guardan la opcion del usuario en un determinado tiempo
        String clave;
        int indice;
        Hash tabla = new Hash();

        System.out.println("Ingrese el metodo de asignacion de indice deseado");
        System.out.println("1.Arismetica modular");
        System.out.println("2.Metodo de la multiplicacion");

        hash = num.nextInt();

        while(hash <1 || hash > 2){
            System.out.println("Ingrese un metodo valido");
            hash = num.nextInt();
        }

        System.out.println("Ingrese el metodo de colision deseado");
        System.out.println("1.Lineal");
        System.out.println("2.Cuadratica");
        colision = num.nextInt();

        while(colision <1 || colision > 2){
            System.out.println("Ingrese un metodo valido");
            colision = num.nextInt();
        }

        do{
            opcion=menu();
            switch(opcion){
                case 1:

                    Tareas tarea = new Tareas();
                    tarea=ingresar();

                    tarea.darId();
                     
                    if (tabla.Insertar(hash,colision,tarea) == true){

                        System.out.println("La tarea con id " + tarea.getId() + "se ha ingresado correctamente");
                    }
                     else{
                        System.out.println("La tarea que ha creado no se ha ingresado correctamente");
                    }

                break;
                case 2:

                    tabla.MostrarId();

                    System.out.println("Porfavor ingrese los primeros 10 caracteres del ID de la tarea que desea buscar");
                    clave=letra.nextLine();

                    indice=tabla.Buscar(clave, hash, colision);
                    if(indice!=101){
                        tabla.getTarea(indice);
                    }
                    
                    
                break;
                case 3:

                
                break;
                case 4:
                    tabla.MostrarId();
                    System.out.println("Porfavor ingrese los 10 primeros id de la tarea que desea borrar");
                    clave=letra.nextLine();

                    indice=tabla.Buscar(clave, hash, colision);
                    if(indice!=101){
                        System.out.println(tabla.eliminarTarea(indice));
                    }
                break;
                case 5:
                    System.out.println("Saliendo....");
                break;
            }

        }while(opcion!=5);


    }    
}