package modelo;

public class Medico extends Empleado {

    private String especialidad;
    private int    numeroPacientesAtendidos;
    private double valorConsulta;

    public Medico(String cedula, String nombre, int edad, String telefono, String correo,
                  String especialidad, int numeroPacientesAtendidos, double valorConsulta) {
        super(cedula, nombre, edad, telefono, correo);
        this.especialidad              = especialidad;
        this.numeroPacientesAtendidos  = numeroPacientesAtendidos;
        this.valorConsulta             = valorConsulta;
    }

    public String getEspecialidad()             { return especialidad; }
    public int    getNumeroPacientesAtendidos()  { return numeroPacientesAtendidos; }
    public double getValorConsulta()             { return valorConsulta; }

    public void setEspecialidad(String especialidad)                  { this.especialidad = especialidad; }
    public void setNumeroPacientesAtendidos(int numeroPacientesAtendidos) { this.numeroPacientesAtendidos = numeroPacientesAtendidos; }
    public void setValorConsulta(double valorConsulta)                { this.valorConsulta = valorConsulta; }

    @Override
    public double calcularPago() {
        return numeroPacientesAtendidos * valorConsulta;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("MÉDICO ");
        System.out.printf ("Cédula:", getCedula());
        System.out.printf ("Nombre: ", getNombre());
        System.out.printf ("Edad: ", getEdad());
        System.out.printf ("Teléfono: ", getTelefono());
        System.out.printf ("Correo: ", getCorreo());
        System.out.printf ("Especialidad: ", especialidad);
        System.out.printf ("Pacientes  : ", numeroPacientesAtendidos);
        System.out.printf ("Valor/Cita : ", valorConsulta);
        System.out.printf ("PAGO TOTAL :", calcularPago());

    }
}