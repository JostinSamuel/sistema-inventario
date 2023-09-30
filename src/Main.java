import java.util.Scanner;

public class Main {
    private static String[] arrayProductos = {"Leche", "Atún", "Fideos", "Azúcar", "Galletas"};
    private static int[] arrayProductosCantidad = {100, 180, 84, 98, 150};
    private static int[] cantidadOriginal = {100, 180, 84, 98, 150};

    public static void main(String[] args) {
        imprimeTitulo();

        Scanner scanner = new Scanner(System.in);

        mostrarListaDeProductos(); //1. Muestra de lista de productos

        do {
            registrarProductoVendido(); //2. Seleccionar producto para registrar
        } while (continuarRegistro());

        int opcionAdicional = seleccionarOpcionAdicional(scanner);
        procesarOpcionAdicional(opcionAdicional, scanner);

        System.out.println("Se cierra sesión del sistema.");
    }

    private static void mostrarListaDeProductos() {
        System.out.println("Detalle de Inventario");
        for (int i = 0; i < arrayProductos.length; i++) {
            System.out.println("Producto: " + arrayProductos[i] + " - Cantidad: " + arrayProductosCantidad[i] + " unidades");
        }
    }

    private static void registrarProductoVendido() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Lista de productos (Seleccione un número)");
            for (int i = 0; i < arrayProductos.length; i++) {
                System.out.println(i + 1 + ". " + arrayProductos[i]);
            }

            System.out.println("Ingrese el producto a registrar");
            int producto = scanner.nextInt();

            if (producto < 1 || producto > arrayProductos.length) {
                System.out.println("Producto no válido. Ingrese un número válido.");
            } else {
                // El número de producto es válido, continuar con la entrada de la cantidad.
                System.out.println("Ingrese cantidad a registrar");
                int cantidad = scanner.nextInt();

                if (cantidad > arrayProductosCantidad[producto - 1]) {
                    System.out.println("No hay suficientes unidades disponibles de " + arrayProductos[producto - 1]);
                } else {
                    // Registro exitoso.
                    arrayProductosCantidad[producto - 1] -= cantidad;
                    System.out.println("Se registró " + cantidad + " unidades del producto " + arrayProductos[producto - 1]);
                    break; // Salir del bucle una vez que se haya realizado el registro exitoso.
                }
            }
        }
    }


    private static boolean continuarRegistro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Desea registrar más productos? SI - NO");
        String nuevaDecision = scanner.nextLine();
        return nuevaDecision.equalsIgnoreCase("SI");
    }

    private static int seleccionarOpcionAdicional(Scanner scanner) {
        System.out.println("1. Guardar registro y finalizar");
        System.out.println("2. Eliminar producto");
        return scanner.nextInt();
    }

    private static void procesarOpcionAdicional(int opcionAdicional, Scanner scanner) {

        switch (opcionAdicional) {
            case 1:
                System.out.println("Se actualizó el inventario exitosamente.");
                mostrarListaDeProductos();
                break;
            case 2:
                System.out.println("Ingrese el producto a eliminar (Número de producto)");
                int productoEliminar = scanner.nextInt();
                eliminarProducto(productoEliminar);
                mostrarListaDeProductos();
                break;
            default:
                System.out.println("Error. Ingrese opción válida");

        }

    }

    private static void eliminarProducto(int productoEliminar) {
        if (productoEliminar >= 1 && productoEliminar <= arrayProductos.length) {
            arrayProductosCantidad[productoEliminar - 1] = cantidadOriginal[productoEliminar - 1];
            System.out.println("El producto " + arrayProductos[productoEliminar - 1] + " ha sido eliminado del registro.");
        } else {
            System.out.println("Producto no válido");
        }
    }























    private static void imprimeTitulo() {
        String asciiArt =
                "  _                 ____         _               \n" +
                        " | |    ___  ___   / ___|___  __| |_ __ ___  ___ \n" +
                        " | |   / _ \\/ __| | |   / _ \\/ _` | '__/ _ \\/ __|\n" +
                        " | |__| (_) \\__ \\ | |__|  __/ (_| | | | (_) \\__ \\\n" +
                        " |_____\\___/|___/  \\____\\___|\\__,_|_|  \\___/|___/\n" +
                        "                                                 ";

        System.out.println(asciiArt);
        //https://patorjk.com/software/taag/#p=display&f=Graffiti&t=Tienda%20Los%20Cedros
    }
}
