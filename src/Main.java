import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Distribuidor distribuidor = new Distribuidor();
        int opcion = 0;

        // Datos iniciales de prueba para facilitar la ejecución
        distribuidor.registrarBodega("B01", "Bodega Norte");
        distribuidor.registrarBodega("B02", "Bodega Sur");
        distribuidor.registrarProducto("P01", "Laptop Gamer");
        distribuidor.registrarRuta("R01", "B01", "B02", 50.0);
        Bodega b1 = distribuidor.buscarBodega("B01");
        if (b1 != null) b1.agregarStock("P01", 40);
        Ruta r1 = distribuidor.buscarRuta("B01", "B02");
        if (r1 != null) r1.verificarYOcuparRuta(35); // Deja capacidad 50, uso 35 (Caso obligatorio)

        do {
            System.out.println("\n==========================================");
            System.out.println("  SISTEMA DE DISTRIBUCIÓN - GRUPO 3");
            System.out.println("==========================================");
            System.out.println("1. Registrar Bodega");
            System.out.println("2. Registrar Producto e Inventario inicial");
            System.out.println("3. Registrar Ruta de Transporte");
            System.out.println("4. Realizar Despacho entre Bodegas");
            System.out.println("5. Mostrar Rutas Saturadas");
            System.out.println("6. Mostrar Historial de Despachos e Inventarios");
            System.out.println("7. Salir");
            System.out.print("Elija una opción: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // limpiar buffer

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese ID de la bodega: ");
                        String idB = scanner.nextLine();
                        System.out.print("Ingrese Nombre de la bodega: ");
                        String nomB = scanner.nextLine();
                        if (distribuidor.registrarBodega(idB, nomB)) {
                            System.out.println("¡Bodega registrada con éxito!");
                        } else {
                            System.out.println("Error: Ya existe una bodega con ese ID.");
                        }
                        break;

                    case 2:
                        System.out.print("Ingrese Código del producto: ");
                        String codP = scanner.nextLine();
                        System.out.print("Ingrese Nombre del producto: ");
                        String nomP = scanner.nextLine();
                        distribuidor.registrarProducto(codP, nomP);
                        
                        System.out.print("Ingrese ID de la bodega donde agregar stock: ");
                        String idBodegaStock = scanner.nextLine();
                        Bodega bodegaEncontrada = distribuidor.buscarBodega(idBodegaStock);
                        if (bodegaEncontrada != null) {
                            System.out.print("Ingrese cantidad inicial: ");
                            int cant = scanner.nextInt();
                            scanner.nextLine();
                            bodegaEncontrada.agregarStock(codP, cant);
                            System.out.println("¡Stock agregado correctamente!");
                        } else {
                            System.out.println("Error: Bodega no encontrada.");
                        }
                        break;

                    case 3:
                        System.out.print("Ingrese ID de la ruta: ");
                        String idR = scanner.nextLine();
                        System.out.print("Ingrese ID Bodega Origen: ");
                        String orig = scanner.nextLine();
                        System.out.print("Ingrese ID Bodega Destino: ");
                        String dest = scanner.nextLine();
                        System.out.print("Ingrese Capacidad Máxima: ");
                        double cap = scanner.nextDouble();
                        scanner.nextLine();
                        if (distribuidor.registrarRuta(idR, orig, dest, cap)) {
                            System.out.println("¡Ruta registrada con éxito!");
                        } else {
                            System.out.println("Error: Capacidad inválida o ID de ruta duplicado.");
                        }
                        break;

                    case 4:
                        System.out.print("Ingrese ID Bodega Origen: ");
                        String oDesp = scanner.nextLine();
                        System.out.print("Ingrese ID Bodega Destino: ");
                        String dDesp = scanner.nextLine();
                        System.out.print("Ingrese Código del Producto: ");
                        String pDesp = scanner.nextLine();
                        System.out.print("Ingrese Cantidad a despachar: ");
                        int cantDesp = scanner.nextInt();
                        scanner.nextLine();
                        String resultado = distribuidor.realizarDespacho(oDesp, dDesp, pDesp, cantDesp);
                        System.out.println(resultado);
                        break;

                    case 5:
                        distribuidor.mostrarRutasSaturadas();
                        break;

                    case 6:
                        distribuidor.mostrarRutas();
                        System.out.println();
                        distribuidor.mostrarBodegas();
                        System.out.println();
                        distribuidor.mostrarHistorial();
                        break;

                    case 7:
                        System.out.println("Saliendo del sistema...");
                        break;

                    default:
                        System.out.println("Opción inválida. Intente de nuevo.");
                }
            } else {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next();
            }
        } while (opcion != 7);

        scanner.close();
    }
}