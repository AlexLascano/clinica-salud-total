package util;

public class Validador {

    public static boolean campoVacio(String valor) {
        return valor == null || valor.trim().isEmpty();
    }

    public static boolean correoValido(String correo) {
        return correo != null && correo.contains("@") && correo.contains(".");
    }

    public static boolean telefonoValido(String telefono) {
        return telefono != null && telefono.matches("\\d+");
    }

    public static boolean edadValida(int edad) {
        return edad >= 18 && edad <= 99;
    }

    public static boolean cedulaValida(String cedula) {
        return cedula != null && cedula.matches("\\d{6,15}");
    }

    public static boolean mayorACero(double valor) {
        return valor > 0;
    }

    public static boolean mayorACero(int valor) {
        return valor > 0;
    }

    public static Integer parsearEntero(String texto) {
        try {
            return Integer.parseInt(texto.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static Double parsearDouble(String texto) {
        try {
            return Double.parseDouble(texto.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }
}