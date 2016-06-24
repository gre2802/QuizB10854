package modelo;


public class Cliente 
{
    private String numeroCita;
    private String cedula;
    private String nombre;
    private int edad;
    private String prioridad;
    private Cliente enlaceSiguiente;
    
    public Cliente()
    {
    }//Fin del constructor sin parametros.

    public Cliente(String cedula, String nombre, int edad, String prioridad) 
    {
        this.numeroCita = "";
        this.cedula=cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.prioridad = prioridad;
        this.enlaceSiguiente = null;
    }//Fin del constructor con parametros.

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNumeroCita() {
        return numeroCita;
    }

    public void setNumeroCita(String numeroCita) {
        this.numeroCita = numeroCita;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

   
    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public Cliente getEnlaceSiguiente() {
        return enlaceSiguiente;
    }

    public void setEnlaceSiguiente(Cliente enlaceSiguiente) {
        this.enlaceSiguiente = enlaceSiguiente;
    }
    
    public String getInformacion() {
        return "Fecha Cita"+  numeroCita + "\n Cedula"+cedula + "\n Nombre: " + nombre + ", Edad: " + edad +  ", Prioridad: " + prioridad  ;
    }
}//Fin de la clase Cliente
