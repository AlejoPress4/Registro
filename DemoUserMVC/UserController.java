package DemoUserMVC;

public class UserController {
    private UserModel model;
    private UserView view;

    public UserController(UserModel model, UserView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        boolean KeepRunning = true;

        while (KeepRunning) {
            view.displayMenu();
            String option = view.getInput(null);
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
                    DeleteUser();
                    break;
                case "5":
                    KeepRunning = false;
                    break;
                default:
                    view.ShowMessage("Opcion invalida");
                    break;
            }
        }
        view.ShowMessage("Hasta pronto");
    }

    private void createUser() {
        String username = view.getInput("Ingrese el nombre de usuario: ");
        String password = view.getInput("Ingrese la contraseña: ");
        String email = view.getInput("Ingrese la direccion de correo electronico: ");
        User user = new User(username, password, email);
        model.addUser(user);
        view.ShowMessage("Usuario creado con exito");
    }

    private void consultUser() {
        String username = view.getInput("Ingrese el nombre de usuario: ");
        User user = model.getUserByUsername(username);
        if (user != null) {
            view.printUserDetails(user);
        } else {
            view.ShowMessage("El usuario no existe");
        }
    }

    private void modifyUser() {
        String username = view.getInput("Ingrese el nombre de usuario: ");
        User user = model.getUserByUsername(username);
        if (user != null) {
            String password = view.getInput("Ingrese la nueva contraseña: ");
            String email = view.getInput("Ingrese la nueva direccion de correo electronico: ");
            user.setPassword(password);
            user.setEmail(email);
            view.ShowMessage("Usuario modificado con exito");
        } else {
            view.ShowMessage("El usuario no existe");
        }
    }

    private void DeleteUser() {
        String username = view.getInput("Ingrese el nombre de usuario: ");
        User user = model.getUserByUsername(username);
        if (user != null) {
            model.DeleteUser(user);
            view.ShowMessage("Usuario eliminado con exito");
        } else {
            view.ShowMessage("El usuario no existe");
        }
    }
}
