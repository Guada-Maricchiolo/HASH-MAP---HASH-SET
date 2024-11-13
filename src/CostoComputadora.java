import java.util.Scanner;

public class CostoComputadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String respuesta;

        do {
            System.out.print("Ingrese la marca de la computadora: ");
            String marca = scanner.nextLine();

            System.out.print("Ingrese el modelo de la computadora: ");
            String modelo = scanner.nextLine();

            // Crear una nueva computadora
            Computadora computadora = new Computadora(marca, modelo);

            // Cargar componentes
            boolean agregarOtroComponente = true;
            while (agregarOtroComponente) {
                System.out.print("Ingrese el nombre del componente (ej: Memoria RAM 2Gb): ");
                String nombreComponente = scanner.nextLine();

                System.out.print("Ingrese la marca del componente: ");
                String marcaComponente = scanner.nextLine();

                System.out.print("Ingrese la cantidad de componentes: ");
                int cantidad = scanner.nextInt();

                System.out.print("Ingrese el precio por unidad del componente: ");
                double precio = scanner.nextDouble();
                scanner.nextLine(); // Limpiar el buffer

                // Crear el objeto ComponenteCPU y añadirlo a la computadora
                ComponenteCPU componente = new ComponenteCPU(nombreComponente, precio, cantidad, marcaComponente);
                computadora.agregarComponente(componente);

                System.out.print("¿Desea agregar otro componente? (si/no): ");
                agregarOtroComponente = scanner.nextLine().equalsIgnoreCase("si");
            }

            // Mostrar detalles de la computadora y el precio
            computadora.mostrarDetalles();

            // Preguntar si se desea cotizar otra computadora
            System.out.print("¿Desea cotizar una nueva computadora? (si/no): ");
            respuesta = scanner.nextLine();

        } while (respuesta.equalsIgnoreCase("si"));

        System.out.println("Programa terminado.");
        scanner.close();
    }
}

