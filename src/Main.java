import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        //Definicion de variables
        int cantidad;
        int opcionAdicional;
        boolean decision;
        int producto;
        String productoEliminar;

        Scanner scannerProducto = new Scanner(System.in);
        Scanner scannerCantidad = new Scanner(System.in);
        Scanner scannerDecision = new Scanner(System.in);
        Scanner scannerOpcionAdicional = new Scanner(System.in);
        Scanner scannerProductoEliminar = new Scanner(System.in);

        String[] arrayProductos = {"Leche","Atún","Fideos","Azúcar","Galletas"};
        int[] arrayProductosCantidad = {100,180,84,98,150};
        System.out.println("Bienvenido al Inventario de la tienda 'Los Cedros' ");
        do {
            System.out.println("Lista de productos (Seleccione un número)");
            for (int i = 0; i < arrayProductos.length; i++) {
                System.out.println(i+1 + ". "+arrayProductos[i]);
            }
            System.out.println("Ingrese el producto a registrar");
            producto = scannerProducto.nextInt(); //validar que sea entero
            System.out.println("Ingrese cantidad a registrar");
            cantidad = scannerCantidad.nextInt();
            arrayProductosCantidad[producto-1] = arrayProductosCantidad[producto-1] - cantidad;
            System.out.println("Se registró " + cantidad + " unidades del producto " + producto);
            System.out.println("Desea registrar más productos? SI - NO");
            String nuevaDecision = scannerDecision.nextLine();
            if (nuevaDecision.equalsIgnoreCase("SI")){
                decision = true;
            }else {
                decision = false;
            }
        }
        while (decision);


        System.out.println("1. Guardar productos y finalizar");
        System.out.println("2. Eliminar producto");
        opcionAdicional = scannerOpcionAdicional.nextInt();

        switch (opcionAdicional){
            case 1 :
                System.out.println("Se actualizó el inventario exitosamente.");
                mostrarListaDeProductos(arrayProductos, arrayProductosCantidad);
                break;
            case 2 :
                System.out.println("Ingrese el producto a eliminar");
                productoEliminar = scannerProductoEliminar.nextLine();
                System.out.println("El producto " + productoEliminar + " ha sido eliminado.");
                mostrarListaDeProductos(arrayProductos, arrayProductosCantidad);
                break;
            default:
                System.out.println("Opción incorrecta. Ingrese opción válida");
        }

        System.out.println("Se cierra sesión del sistema.");
    }

    private static void mostrarListaDeProductos(String[] arrayProductos, int[] arrayProductosCantidad) {
        System.out.println("Detalle de Inventario");
        for (int i = 0; i < arrayProductos.length; i++) {
            System.out.println("Producto: " + arrayProductos[i] + " - Cantidad: " + arrayProductosCantidad[i] + " unidades");
        }
    }
}
