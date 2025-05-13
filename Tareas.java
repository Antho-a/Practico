import java.time.LocalDate;
import java.util.UUID;
@SuppressWarnings("static-access")
public class Tareas {
    private String id = null;
    private String nombre;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String estado;
    private boolean esAlta=true;

    //Constructres
    public Tareas(){
        this.fechaInicio = LocalDate.now();
    }

    public Tareas( String nombre, String descripcion, String fechafinal){
        
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = LocalDate.now();
        this.estado ="Pendiente" ;
        this.fechaFin= fechaFin.parse(fechafinal);
        
    }
    //Getters y Setters
    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void darId() {
        this.id = UUID.randomUUID().toString();
    }

    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public LocalDate getFechaCreacion() {
        return this.fechaInicio;
    }
    public void setFechaCreacion(String fechai) {
        this.fechaInicio = fechaInicio.parse(fechai);
    }
    public String getEstado() {
        return this.estado;
    }
    public void setEstado(int estado) {
        switch (estado) {
            case 1:
                this.estado="Pendiente";
                
                break;
            case 2:
                this.estado="En curso";
                
                break;
            default:
                this.estado="Terminada";
                break;
        }
        
    }
    public void setesAlta() {
        this.esAlta=!esAlta;
    }
    public boolean getesAlta(){
        return this.esAlta;
    }
    
    public void setFechaFinal (String fecha){
        this.fechaFin = fechaFin.parse(fecha);
    }
    public LocalDate getFechaFinal (){
        return this.fechaFin;
    }

    
    public String MostrarId(){
        return "ID "+ this.id;
    }


//Metodos
    @Override
    public String toString() {
    return """
    \t\t---Tarea---
    \nCodigo =""" + this.id +
    "\n Nombre='" + this.nombre + '\'' +
    "\n Descripción='" + this.descripcion + '\'' +
    "\n Estado=" + this.estado +
    "\n FechaInicio=" + this.fechaInicio +
    "\n FechaFin=" + this.fechaFin ;
    }



}