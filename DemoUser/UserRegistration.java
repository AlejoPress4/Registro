package DemoUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserRegistration {
    private List<String> usernames = new ArrayList<>();
    private List<String> passwords = new ArrayList<>();
    private List<String> emails = new ArrayList<>();

    private Scanner input = new Scanner(System.in);

    public void displayMenu() {
        boolean KeepRunning = true;

        while (KeepRunning) {
            System.out
                    .println("/n Menu" + "/n 1. Crear usuario" + "/n 2. Consultar Usuario" + "/n 3. Modificar usuario "
                            + "/n 4. Eliminar usuario" + "/n 5. Salir" + "/n Seleccione una opcion: ");

            String option = input.nextLine();
            switch (option) {
                case "1":
                    createUser();
                    break;
                case "2":
                    consultUser();
                    break;
                case "3":
                    modifyUser();
                    break; 
                case "4":
                    deleteUser();
                    break;
                case"5":
                    KeepRunning = false;
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }
    }
    private void createUser(){
        System.out.println("Ingrese el nombre de usuario: ");
        usernames.add(input.nextLine());

        System.out.println("Ingrese la contraseña: ");
        passwords.add(input.nextLine());   
        
        System.out.println("Ingrese el correo electronico: ");
        emails.add(input.nextLine());   
        System.out.println("Usuario creado con exito");
    }
    private int getUserIndexByUsername(String username){
        return usernames.indexOf(username);
    }
    private void consultUser(){
        System.out.println("Ingrese el nombre de usuario a consultar: ");
        int index = getUserIndexByUsername(input.nextLine());

        if(index == -1){
            System.out.println("El usuario no existe");
        }else{
            System.out.println("Usuario: " + usernames.get(index) + "Correo electronico: " + emails.get(index));
        }
    }

    private void modifyUser(){
        System.out.println("Ingrese el nombre de usuario a modificar: ");
        int index = getUserIndexByUsername(input.nextLine());

        if(index == -1){
            System.out.println("El usuario no existe");
        }
        else{
            System.out.println("Ingrese el nuevo email: ");
            emails.set(index, input.nextLine());
            // System.out.println("Ingrese el nuevo nombre de usuario: ");
            // usernames.set(index, input.nextLine());

            // System.out.println("Ingrese la nueva contraseña: ");
            // passwords.set(index, input.nextLine());

            // System.out.println("Ingrese el nuevo correo electronico: ");
            // emails.set(index, input.nextLine());

            System.out.println("Usuario modificado con exito");
        }
    }
    private void deleteUser(){
        System.out.println("Ingrese el nombre de usuario a eliminar: ");
        int index = getUserIndexByUsername(input.nextLine());

        if(index == -1){
            System.out.println("El usuario no existe");
        }
        else{
            usernames.remove(index);
            passwords.remove(index);
            emails.remove(index);
            System.out.println("Usuario eliminado con exito");
        }
    }
    public  static void main(String[] args){
        new UserRegistration().displayMenu();
    }
}