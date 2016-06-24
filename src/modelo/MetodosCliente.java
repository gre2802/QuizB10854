package modelo;


public class MetodosCliente 
{
    private Cliente primero;
    private Cliente ultimo;
    private int ficha;
    
    public MetodosCliente()
    {
        primero = ultimo = null;
        ficha = 1;
    }//Fin del constructor sin parametros.
    
     public String  buscarCliente(String cedula)
    {
        String informacion = "";
        Cliente auxiliar=primero;
        while(auxiliar.getCedula()!=cedula)
        {
             informacion = auxiliar.getInformacion();
             auxiliar=auxiliar.getEnlaceSiguiente();
        }
        return informacion;
    }
    
    
    
    public void insertar(Cliente cliente)
    {
        //Si el primer nodo es igual a null, es porque no existen elementos en
        //la lista enlazada.
        if(primero == null)
        {
            cliente.setNumeroCita(generarCodigo(cliente));
            primero = ultimo = cliente;
        }
        else
        {
            //Si la prioridad del cliente es de 7600
            if(cliente.getPrioridad().equals("7600"))
            {
                Cliente auxiliar = primero;
                Cliente anterior = null;
                
                while(auxiliar.getPrioridad().equals("7600"))
                {
                    anterior = auxiliar;
                    auxiliar = auxiliar.getEnlaceSiguiente();
                }
                
                if(auxiliar == primero)
                {
                    cliente.setNumeroCita(generarCodigo(cliente));
                    cliente.setEnlaceSiguiente(primero);
                    primero = cliente;
                }
                else
                {
                    cliente.setNumeroCita(generarCodigo(cliente));
                    cliente.setEnlaceSiguiente(anterior.getEnlaceSiguiente());
                    anterior.setEnlaceSiguiente(cliente);
                }
            }
            else
            {
                cliente.setNumeroCita(generarCodigo(cliente));
                ultimo.setEnlaceSiguiente(cliente);
                ultimo = cliente;
            }
        }
    }//Fin del metodo insertar_al_final.
    
    public Cliente eliminarPrimero()
    {
        Cliente aux = primero;
        
        if(primero != null)
        {
            primero = primero.getEnlaceSiguiente();
        }
        
        return aux;
    }//Fin del metodo eliminar.
    
    public int tamanio_de_lista()
    {
        Cliente auxiliar = primero;
        int contador = 0;
        
        while(auxiliar != null)
        {
            auxiliar = auxiliar.getEnlaceSiguiente();
            contador++;
        }
        
        return contador;
    }//Fin del metodo tamanio_de_lista
    
    public String devolver_lista_clientes()
    {
        String info = "";
        
        Cliente aux = primero;
        
        //Mientras el cliente auxiliar sea distinto de null
        while(aux != null)
        {
            info += aux.getInformacion();
            aux = aux.getEnlaceSiguiente();
        }
        
        return info;
    }//Fin del metodo devolver_lista_clientes.
    
    public String generarCodigo(Cliente cliente)
    {
        if(cliente.getNumeroCita().equals(""))
        {
            return "/Enero /2017/ " + ficha++; 
        }
        else
        {
            return "Febrero/2017/" + ficha++;
        }
    }//Fin del metodo generarCodigo.
    
    public void ordenar_mayor_a_menor()
    {
        int tamanioLista = tamanio_de_lista();
        
        String citaTemporal;
        String cedulaTemporal;
        String nombreTemporal;
        int edadTemporal;
        String tipoTemporal;
        String prioridadTemporal;
        
        Cliente temporal;
        
        for(int contador=0; contador<tamanioLista; contador++)
        {
            temporal = primero;
            
            while(temporal.getEnlaceSiguiente() != null)
            {
                if(temporal.getEdad() < temporal.getEnlaceSiguiente().getEdad())
                {
                    //Almacena los datos del objeto en un lugar temporal
                    citaTemporal = temporal.getNumeroCita();
                    cedulaTemporal= temporal.getCedula();
                    nombreTemporal = temporal.getNombre();
                    edadTemporal = temporal.getEdad();
                    prioridadTemporal = temporal.getPrioridad();
                    
                    //Intercambia los datos
                    temporal.setNumeroCita(temporal.getEnlaceSiguiente().getNumeroCita());
                    temporal.setCedula(temporal.getEnlaceSiguiente().getCedula());
                    temporal.setNombre(temporal.getEnlaceSiguiente().getNombre());
                    temporal.setEdad(temporal.getEnlaceSiguiente().getEdad());
                    temporal.setPrioridad(temporal.getEnlaceSiguiente().getPrioridad());
                    
                    //Cambia los datos temporales en el objeto siguiente.
                    temporal.getEnlaceSiguiente().setNumeroCita(citaTemporal);
                    temporal.getEnlaceSiguiente().setCedula(cedulaTemporal);
                    temporal.getEnlaceSiguiente().setNombre(nombreTemporal);
                    temporal.getEnlaceSiguiente().setEdad(edadTemporal);
                    temporal.getEnlaceSiguiente().setPrioridad(prioridadTemporal);
                    
                }
                temporal = temporal.getEnlaceSiguiente();
            }
        }
    }//Fin del metodo ordenar_mayor_a_menor.
    
    public void ordenar_menor_a_mayor()
    {
        int tamanioLista = tamanio_de_lista();
        
        String citaTemporal;
        String cedulaTemporal;
        String nombreTemporal;
        int edadTemporal;
        String prioridadTemporal;
        
        Cliente temporal;
        
        for(int contador=0; contador<tamanioLista; contador++)
        {
            temporal = primero;
            
            while(temporal.getEnlaceSiguiente() != null)
            {
                if(temporal.getEdad() > temporal.getEnlaceSiguiente().getEdad())
                {
                 
                     //Almacena los datos del objeto en un lugar temporal
                    citaTemporal = temporal.getNumeroCita();
                    cedulaTemporal= temporal.getCedula();
                    nombreTemporal = temporal.getNombre();
                    edadTemporal = temporal.getEdad();
                    prioridadTemporal = temporal.getPrioridad();
                    
                    //Intercambia los datos
                    temporal.setNumeroCita(temporal.getEnlaceSiguiente().getNumeroCita());
                    temporal.setCedula(temporal.getEnlaceSiguiente().getCedula());
                    temporal.setNombre(temporal.getEnlaceSiguiente().getNombre());
                    temporal.setEdad(temporal.getEnlaceSiguiente().getEdad());
                    temporal.setPrioridad(temporal.getEnlaceSiguiente().getPrioridad());
                    
                    //Cambia los datos temporales en el objeto siguiente.
                    temporal.getEnlaceSiguiente().setNumeroCita(citaTemporal);
                    temporal.getEnlaceSiguiente().setCedula(cedulaTemporal);
                    temporal.getEnlaceSiguiente().setNombre(nombreTemporal);
                    temporal.getEnlaceSiguiente().setEdad(edadTemporal);
                    temporal.getEnlaceSiguiente().setPrioridad(prioridadTemporal);
                    
                    
                }
                temporal = temporal.getEnlaceSiguiente();
            }
        }
    }//Fin del metodo ordenar_menor_a_mayor.
}//Fin de la clase MetodosCliente.
