package DemoUserMVC;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class UserView {

    public void printUserDetails(User user){
        String message = "\nDetalles del usuario:" + "\nNombre: del usuario " + user.getUsername() + "/nContraseña " + user.getPassword() + "/nDireccion de correo electronico: " + user.getEmail();
        JOptionPane.showMessageDialog(null, message);
    }
    public String getInput(String message){
        Scanner input = new Scanner(System.in);
        input.close();
        return JOptionPane.showInputDialog(null, message);
    }

    public void ShowMessage(String message){
        System.out.println(message);
    }

    public void displayMenu(){
        JOptionPane.showMessageDialog(null, "\n Menu" + "\n Seleccione una opcion: " + "\n 1. Crear usuario" + "\n 2. Consultar Usuario" + "\n 3. Modificar usuario " + "\n 4. Eliminar usuario" + "\n 5. Salir");
    }
    
}
