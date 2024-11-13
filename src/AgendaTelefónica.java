import java.awt.*;
import java.util.HashMap;
import java.util.Scanner;

public class AgendaTelefónica {

    private HashMap<String, Long> agenda = new HashMap<String, Long>();
    //la clave es un String (nombre) y el valor es un Long (teléfono).

    private Scanner scanner = new Scanner(System.in);
    //se declara el scaner para poder recibir la entrada del usuario

    public static void main(String[] args){
    //se crea una instancia de AgendaTelefonica y se llama al metodo para mostrar el menú.
        AgendaTelefónica agendaTelefónica = new AgendaTelefónica();

        agendaTelefónica.mostrarMenu();
    }

    public void mostrarMenu(){
        int opcion;

        // Bucle que se ejecuta hasta que el usuario seleccione la opción de salir (opción 4).
        do {
            System.out.println("\n--- Menú de la Agenda Telefónica ---");
            System.out.println("1 - Cargar Datos en la Agenda");
            System.out.println("2 - Buscar Teléfono por Nombre");
            System.out.println("3 - Listar Agenda");
            System.out.println("4 - Salir");
            System.out.print("Seleccione una opción: ");
            // Se lee la opción seleccionada por el usuario.
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer después de leer un número.

            // Se utiliza un switch para ejecutar la acción correspondiente a cada opción.
            switch (opcion) {
                case 1:
                    // Opción para cargar datos en la agenda.
                    cargarDatosEnAgenda();
                    break;
                case 2:
                    // Opción para buscar un teléfono por nombre.
                    buscarTelefonoPorNombre();
                    break;
                case 3:
                    // Opción para listar todos los contactos de la agenda.
                    listarAgenda();
                    break;
                case 4:
                    // Opción para salir del programa.
                    System.out.println("Saliendo de la agenda...");
                    break;
                default:
                    // Mensaje de error si se elige una opción no válida.
                    System.out.println("Opción no válida. Por favor, elija una opción del menú.");
            }
        } while (opcion != 4); // El bucle termina cuando el usuario selecciona la opción 4.
    }
    //---------------------------------------------------------------------------------------------
    // Metodo para cargar contactos en la agenda.
    public void cargarDatosEnAgenda() {
        String nombre;
        Long telefono;
        boolean continuar = true;

        // Bucle que permite agregar varios contactos hasta que el usuario decida detenerse.
        while (continuar) {
            System.out.print("Ingrese el nombre completo de la persona: ");
            // Se lee el nombre del contacto.
            nombre = scanner.nextLine();

            // Se verifica si el nombre ya existe en la agenda.
            if (agenda.containsKey(nombre)) {
                // Si ya existe, se informa al usuario.
                System.out.println("La persona ya se encuentra en la agenda.");
            } else {
                // Si no existe, se solicita el número de teléfono.
                System.out.print("Ingrese el número de teléfono: ");
                telefono = scanner.nextLong();
                scanner.nextLine(); // Limpiar el buffer después de leer un número.
                // Se agrega el nombre y teléfono al HashMap.
                agenda.put(nombre, telefono);
                System.out.println("Contacto agregado con éxito.");
            }

            // Se pregunta al usuario si desea agregar otro contacto.
            System.out.print("¿Desea agregar otro contacto? (si/no): ");
            continuar = scanner.nextLine().equalsIgnoreCase("si");
        }
    }
    //---------------------------------------------------------------------------------------------
    // Metodo para buscar un teléfono en la agenda por nombre.
    public void buscarTelefonoPorNombre() {
        System.out.print("Ingrese el nombre de la persona a buscar: ");
        // Se lee el nombre que el usuario desea buscar.
        String nombre = scanner.nextLine();

        // Se verifica si el nombre existe en el HashMap.
        if (agenda.containsKey(nombre)) {
            // Si existe, se muestra el teléfono correspondiente.
            System.out.println("Teléfono de " + nombre + ": " + agenda.get(nombre));
        } else {
            // Si no existe, se informa al usuario.
            System.out.println("La persona buscada no se encuentra en la agenda.");
        }
    }
    //---------------------------------------------------------------------------------------------
    // Metodo para listar todos los contactos almacenados en la agenda.
    public void listarAgenda() {
        // Se verifica si la agenda está vacía.
        if (agenda.isEmpty()) {
            System.out.println("La agenda está vacía.");
        } else {
            System.out.println("\n--- Listado de Contactos ---");
            // Se recorre el HashMap y se muestran todos los nombres y teléfonos almacenados.
            for (String nombre : agenda.keySet()) {
                System.out.println("Nombre: " + nombre + " - Teléfono: " + agenda.get(nombre));
            }
        }
    }

}
