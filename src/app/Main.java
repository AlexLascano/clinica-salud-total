package app;

import servicio.EmpleadoServicio;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EmpleadoServicio servicio = new EmpleadoServicio(scanner);

        boolean ejecutando = true;

        while (ejecutando) {
            mostrarMenu();
            int opcion = leerOpcionMenu(scanner);

            switch (opcion) {
                case 1:
                    servicio.registrarMedico();
                    break;
                case 2:
                    servicio.registrarAdministrativo();
                    break;
                case 3:
                    servicio.mostrarEmpleados();
                    break;
                case 4:
                    servicio.buscarPorCedula();
                    break;
                case 5:
                    servicio.reemplazarInformacion();
                    break;
                case 6:
                    servicio.eliminarRegistro();
                    break;
                case 7:
                    servicio.calcularPagos();
                    break;
                case 8:
                    servicio.mostrarEstadisticas();
                    break;
                case 9:
                    System.out.println("\n Gracias por usar el sistema. ¡Hasta pronto!");
                    ejecutando = false;
                    break;
                default:
                    System.out.println("  Opción no válida.");
            }

            if (ejecutando) {
                System.out.println("\nPresione ENTER para continuar...");
                try { scanner.nextLine(); } catch (Exception ignored) {}
            }
        }

        scanner.close();
    }


    private static void mostrarMenu() {
        System.out.println("===== CLÍNICA SALUD TOTAL ===== ");
        System.out.println("1. Registrar médico ");
        System.out.println("2. Registrar administrativo");
        System.out.println("3. Mostrar empleados");
        System.out.println("4. Buscar por cédula");
        System.out.println("5. Reemplazar información");
        System.out.println("6. Eliminar registro");
        System.out.println("7. Calcular pagos ");
        System.out.println("8. Mostrar estadísticas ");
        System.out.println("9. Salir ");
        System.out.print("  Seleccione una opción: ");
    }

    private static int leerOpcionMenu(Scanner scanner) {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                int opcion = Integer.parseInt(input);
                if (opcion < 1 || opcion > 9) {
                    System.out.println("Error: opción inválida. Ingrese un número del 1 al 9.");
                    System.out.print("Seleccione una opción: ");
                } else {
                    return opcion;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: opción inválida. Ingrese un número del 1 al 9.");
                System.out.print("Seleccione una opción: ");
            }
        }
    }
}