package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.MetodosCliente;
import vista.FRM_Principal;


public class ControladorBotones implements ActionListener
{
    private FRM_Principal ventana;
    private MetodosCliente metodos;
    
    public ControladorBotones(FRM_Principal ventana)
    {
        this.ventana = ventana;
        metodos = new MetodosCliente();
    }//Fin del constructor.
    
    public void mostrarMensajeConsola(String mensaje)
    {
        System.out.println(mensaje);
    }
    
    public void mensajeAdvertencia(String mensaje)
    {
        JOptionPane.showMessageDialog(null, mensaje, "", JOptionPane.WARNING_MESSAGE);
    }//Fin del metodo mensajeAdvertencia.
    
    public void mensajeError(String mensaje)
    {
        JOptionPane.showMessageDialog(null, mensaje, "", JOptionPane.ERROR_MESSAGE);
    }//Fin del metodo mensajeError.
    
    public void actionPerformed(ActionEvent evento)
    {
        String cmd = evento.getActionCommand();
        
        if(cmd.equals("Entregar Cita"))
        {
            mostrarMensajeConsola(cmd);
            String datos[] = ventana.obtenerDatos();
            
            if(comprobarDatos(datos))
            {
                mensajeAdvertencia("Todos los datos deben estar completos");
            }
            else
            {
                try
                {
                    Cliente nuevo = new Cliente( datos[0],datos[1], Integer.parseInt(datos[2]),datos[3]);
                    metodos.insertar(nuevo);
                    
                    ventana.resetearPanelEntregar();
                    //agregar el nuevo cliente al JTextArea de llamarCliente
                    ventana.mostrarLista(metodos.devolver_lista_clientes());
                }
                catch(Exception ex)
                {
                    mensajeError("La edad no es correcta.\nExcepcion: " + ex);
                }
            }
            
        }
        if(cmd.equals("Atender a Siguiente"))
        {
            mostrarMensajeConsola(cmd);
            Cliente aux = metodos.eliminarPrimero();
            
            if(aux != null)
            {
                ventana.mostrarAtendido("Cita: " + aux.getNumeroCita()+", Cedula: " + aux.getCedula() + ", Nombre: " + aux.getNombre());
                ventana.mostrarLista(metodos.devolver_lista_clientes());
            }
            else
            {
                mensajeAdvertencia("No hay mas personas en la cola");
            }
        }
        if(cmd.equals("Menor a Mayor"))
        {
            mostrarMensajeConsola(cmd);
            metodos.ordenar_menor_a_mayor();
            ventana.mostrarLista(metodos.devolver_lista_clientes());
        }
        if(cmd.equals("Mayor a Menor"))
        {
            mostrarMensajeConsola(cmd);
            metodos.ordenar_mayor_a_menor();
            ventana.mostrarLista(metodos.devolver_lista_clientes());
        }
         if(cmd.equals("Buscar"))
        {
            mostrarMensajeConsola(cmd);
            metodos.buscarCliente(cmd);
            ventana.mostrarLista(metodos.devolver_lista_clientes());
        }
          if(cmd.equals("Cancelar"))
        {
            mostrarMensajeConsola(cmd);
            metodos.ordenar_mayor_a_menor();
            ventana.mostrarLista(metodos.devolver_lista_clientes());
        }
          
           if(cmd.equals("Modificar"))
        {
            mostrarMensajeConsola(cmd);
            metodos.ordenar_mayor_a_menor();
            ventana.mostrarLista(metodos.devolver_lista_clientes());
        }
    }
    
    public boolean comprobarDatos(String[] arreglo)
    {        
        if(arreglo[0].equals("") || arreglo[1].equals("")  || arreglo[2].equals("Elija una prioridad"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }//Fin del metodo comprobarDatos.
    
}//Fin de la clase ControladorBotones.
