package servicio;

import modelo.Administrativo;
import modelo.Empleado;
import modelo.Medico;

import java.util.ArrayList;
import java.util.Scanner;

import util.Validador;

public class EmpleadoServicio {

    // Polimorfismo: ArrayList de tipo padre Empleado
    private ArrayList<Empleado> empleados = new ArrayList<>();
    private Scanner scanner;

    public EmpleadoServicio(Scanner scanner) {
        this.scanner = scanner;
    }


    public void registrarMedico() {
        System.out.println("\n─── REGISTRAR MÉDICO ───");

        String cedula    = pedirCedulaUnica();
        String nombre    = pedirCampoTexto("Nombre");
        int    edad      = pedirEdad();
        String telefono  = pedirTelefono();
        String correo    = pedirCorreo();
        String especialidad = pedirCampoTexto("Especialidad");
        int    pacientes = pedirEnteroPositivo("Número de pacientes atendidos");
        double valorC    = pedirDoublePositivo("Valor por consulta ($)");

        Medico medico = new Medico(cedula, nombre, edad, telefono, correo,
                especialidad, pacientes, valorC);
        empleados.add(medico);
        System.out.println(" Médico registrado correctamente.");
    }

    public void registrarAdministrativo() {
        System.out.println("\n─── REGISTRAR ADMINISTRATIVO ───");

        String cedula       = pedirCedulaUnica();
        String nombre       = pedirCampoTexto("Nombre");
        int    edad         = pedirEdad();
        String telefono     = pedirTelefono();
        String correo       = pedirCorreo();
        String departamento = pedirCampoTexto("Departamento");
        double horas        = pedirDoublePositivo("Horas trabajadas");
        double valorH       = pedirDoublePositivo("Valor por hora ($)");

        Administrativo adm = new Administrativo(cedula, nombre, edad, telefono, correo,
                departamento, horas, valorH);
        empleados.add(adm);
        System.out.println(" Administrativo registrado correctamente.");
    }

    public void mostrarEmpleados() {
        System.out.println("\n─── LISTA DE EMPLEADOS ───");
        if (empleados.isEmpty()) {
            System.out.println("  No hay empleados registrados.");
            return;
        }

        for (Empleado e : empleados) {
            e.mostrarInformacion();
        }
    }

    public void buscarPorCedula() {
        System.out.println("\n─── BUSCAR POR CÉDULA ───");
        System.out.print("Ingrese la cédula: ");
        String cedula = scanner.nextLine().trim();

        try {
            Empleado encontrado = encontrarPorCedula(cedula);
            if (encontrado != null) {
                encontrado.mostrarInformacion();
            } else {
                System.out.println(" Registro no encontrado.");
            }
        } catch (Exception e) {
            System.out.println("  Error en la búsqueda: " + e.getMessage());
        }
    }

    public void reemplazarInformacion() {
        System.out.println("\n─── REEMPLAZAR INFORMACIÓN ───");
        System.out.print("Ingrese la cédula del empleado a actualizar: ");
        String cedula = scanner.nextLine().trim();

        Empleado emp = encontrarPorCedula(cedula);
        if (emp == null) {
            System.out.println(" Registro no encontrado.");
            return;
        }

        System.out.println("Empleado encontrado. Ingrese los nuevos datos:");
        System.out.println("(Presione ENTER para mantener el valor actual)");

        String nombre   = pedirOpcional("Nombre [" + emp.getNombre() + "]", emp.getNombre());
        String telefono = pedirTelefonoOpcional(emp.getTelefono());
        String correo   = pedirCorreoOpcional(emp.getCorreo());

        int edad = emp.getEdad();
        while (true) {
            System.out.print("Edad [" + edad + "]: ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) break;
            Integer e2 = Validador.parsearEntero(input);
            if (e2 == null || !Validador.edadValida(e2)) {
                System.out.println(" Edad inválida (18-99). Intente de nuevo.");
            } else {
                edad = e2;
                break;
            }
        }

        emp.setNombre(nombre);
        emp.setTelefono(telefono);
        emp.setCorreo(correo);
        emp.setEdad(edad);

        if (emp instanceof Medico) {
            Medico m = (Medico) emp;
            String esp = pedirOpcional("Especialidad [" + m.getEspecialidad() + "]", m.getEspecialidad());
            m.setEspecialidad(esp);

            int pac = m.getNumeroPacientesAtendidos();
            while (true) {
                System.out.print("Pacientes atendidos [" + pac + "]: ");
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) break;
                Integer p2 = Validador.parsearEntero(input);
                if (p2 == null || !Validador.mayorACero(p2)) {
                    System.out.println("⚠  Debe ser un número mayor a cero.");
                } else { pac = p2; break; }
            }
            m.setNumeroPacientesAtendidos(pac);

            double vc = m.getValorConsulta();
            while (true) {
                System.out.print("Valor consulta [" + vc + "]: ");
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) break;
                Double v2 = Validador.parsearDouble(input);
                if (v2 == null || !Validador.mayorACero(v2)) {
                    System.out.println("⚠  Debe ser un número mayor a cero.");
                } else { vc = v2; break; }
            }
            m.setValorConsulta(vc);

        } else if (emp instanceof Administrativo) {
            Administrativo a = (Administrativo) emp;
            String dep = pedirOpcional("Departamento [" + a.getDepartamento() + "]", a.getDepartamento());
            a.setDepartamento(dep);

            double ht = a.getHorasTrabajadas();
            while (true) {
                System.out.print("Horas trabajadas [" + ht + "]: ");
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) break;
                Double h2 = Validador.parsearDouble(input);
                if (h2 == null || !Validador.mayorACero(h2)) {
                    System.out.println("⚠  Debe ser un número mayor a cero.");
                } else { ht = h2; break; }
            }
            a.setHorasTrabajadas(ht);

            double vh = a.getValorHora();
            while (true) {
                System.out.print("Valor por hora [" + vh + "]: ");
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) break;
                Double v2 = Validador.parsearDouble(input);
                if (v2 == null || !Validador.mayorACero(v2)) {
                    System.out.println("⚠  Debe ser un número mayor a cero.");
                } else { vh = v2; break; }
            }
            a.setValorHora(vh);
        }

        System.out.println("Información actualizada correctamente.");
    }


    public void eliminarRegistro() {
        System.out.println("\n─── ELIMINAR REGISTRO ───");
        System.out.print("Ingrese la cédula del empleado a eliminar: ");
        String cedula = scanner.nextLine().trim();

        Empleado emp = encontrarPorCedula(cedula);
        if (emp == null) {
            System.out.println(" Registro no encontrado.");
            return;
        }

        emp.mostrarInformacion();
        System.out.print("¿Confirma la eliminación? (s/n): ");
        String confirm = scanner.nextLine().trim().toLowerCase();
        if (confirm.equals("s")) {
            empleados.remove(emp);
            System.out.println(" Registro eliminado correctamente.");
        } else {
            System.out.println("  Operación cancelada.");
        }
    }

    public void calcularPagos() {
        System.out.println("\n─── CÁLCULO DE PAGOS ───");
        if (empleados.isEmpty()) {
            System.out.println("⚠  No hay empleados registrados.");
            return;
        }
        for (Empleado e : empleados) {
            String tipo = (e instanceof Medico) ? "Médico" : "Administrativo";
            System.out.printf("%-15s | %-25s | Pago: $%.2f%n",
                    tipo, e.getNombre(), e.calcularPago());
        }
    }

    public void mostrarEstadisticas() {
        System.out.println("\n─── ESTADÍSTICAS ───");

        int totalMedicos = 0, totalAdmins = 0;
        double pagoMedicos = 0, pagoAdmins = 0;
        Empleado mayorIngreso = null;
        double maxPago = -1;

        try {
            for (Empleado e : empleados) {
                double pago = e.calcularPago();
                if (e instanceof Medico) {
                    totalMedicos++;
                    pagoMedicos += pago;
                } else if (e instanceof Administrativo) {
                    totalAdmins++;
                    pagoAdmins += pago;
                }
                if (pago > maxPago) {
                    maxPago = pago;
                    mayorIngreso = e;
                }
            }
        } catch (Exception e) {
            System.out.println("⚠  Error al calcular estadísticas: " + e.getMessage());
            return;
        }

        System.out.println("RESUMEN ESTADÍSTICO");
        System.out.printf ("Total médicos           :", totalMedicos);
        System.out.printf ("Total administrativos   :", totalAdmins);
        System.out.printf ("Total empleados         :", empleados.size());
        System.out.printf ("Pago total médicos      :", pagoMedicos);
        System.out.printf ("Pago total administrativos:", pagoAdmins);

        if (mayorIngreso != null) {
            System.out.printf("Empleado mayor ingreso  :", mayorIngreso.getNombre());
            System.out.printf("Ingreso                 :", maxPago);
        } else {
            System.out.println("Sin empleados registrados ");
        }
    }

    private String pedirCedulaUnica() {
        while (true) {
            System.out.print("Cédula: ");
            String cedula = scanner.nextLine().trim();
            if (!Validador.cedulaValida(cedula)) {
                System.out.println(" Cédula inválida (solo dígitos, 6-15 caracteres).");
                continue;
            }
            if (encontrarPorCedula(cedula) != null) {
                System.out.println("Cédula duplicada. Ya existe un empleado con esa cédula.");
                continue;
            }
            return cedula;
        }
    }

    private String pedirCampoTexto(String campo) {
        while (true) {
            System.out.print(campo + ": ");
            String valor = scanner.nextLine().trim();
            if (Validador.campoVacio(valor)) {
                System.out.println("El campo " + campo + " no puede estar vacío.");
            } else {
                return valor;
            }
        }
    }

    private int pedirEdad() {
        while (true) {
            System.out.print("Edad: ");
            String input = scanner.nextLine().trim();
            Integer edad = Validador.parsearEntero(input);
            if (edad == null) {
                System.out.println(" Error: ingrese un número entero válido.");
            } else if (!Validador.edadValida(edad)) {
                System.out.println("  Edad inválida. Debe estar entre 18 y 99 años.");
            } else {
                return edad;
            }
        }
    }

    private String pedirTelefono() {
        while (true) {
            System.out.print("Teléfono: ");
            String tel = scanner.nextLine().trim();
            if (Validador.campoVacio(tel)) {
                System.out.println(" El teléfono no puede estar vacío.");
            } else if (!Validador.telefonoValido(tel)) {
                System.out.println(" El teléfono solo debe contener dígitos.");
            } else {
                return tel;
            }
        }
    }

    private String pedirCorreo() {
        while (true) {
            System.out.print("Correo: ");
            String correo = scanner.nextLine().trim();
            if (Validador.campoVacio(correo)) {
                System.out.println(" El correo no puede estar vacío.");
            } else if (!Validador.correoValido(correo)) {
                System.out.println(" Correo inválido. Debe contener '@' y '.'.");
            } else {
                return correo;
            }
        }
    }

    private int pedirEnteroPositivo(String campo) {
        while (true) {
            System.out.print(campo + ": ");
            String input = scanner.nextLine().trim();
            Integer valor = Validador.parsearEntero(input);
            if (valor == null) {
                System.out.println("  Error: ingrese un número entero válido.");
            } else if (!Validador.mayorACero(valor)) {
                System.out.println("  El valor debe ser mayor a cero.");
            } else {
                return valor;
            }
        }
    }

    private double pedirDoublePositivo(String campo) {
        while (true) {
            System.out.print(campo + ": ");
            String input = scanner.nextLine().trim();
            Double valor = Validador.parsearDouble(input);
            if (valor == null) {
                System.out.println(" Error: ingrese un número válido (ej: 4.50).");
            } else if (!Validador.mayorACero(valor)) {
                System.out.println(" El valor debe ser mayor a cero.");
            } else {
                return valor;
            }
        }
    }

    private String pedirOpcional(String prompt, String actual) {
        System.out.print(prompt + ": ");
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) return actual;
        if (Validador.campoVacio(input)) {
            System.out.println(" El campo no puede quedar vacío. Se mantendrá el valor anterior.");
            return actual;
        }
        return input;
    }

    private String pedirTelefonoOpcional(String actual) {
        while (true) {
            System.out.print("Teléfono [" + actual + "]: ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) return actual;
            if (!Validador.telefonoValido(input)) {
                System.out.println(" Solo dígitos. Intente de nuevo.");
            } else {
                return input;
            }
        }
    }

    private String pedirCorreoOpcional(String actual) {
        while (true) {
            System.out.print("Correo [" + actual + "]: ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) return actual;
            if (!Validador.correoValido(input)) {
                System.out.println(" Debe contener '@' y '.'. Intente de nuevo.");
            } else {
                return input;
            }
        }
    }

    private Empleado encontrarPorCedula(String cedula) {
        try {
            for (Empleado e : empleados) {
                if (e.getCedula().equals(cedula)) return e;
            }
        } catch (Exception ex) {
            System.out.println(" Error al buscar empleado: " + ex.getMessage());
        }
        return null;
    }
}