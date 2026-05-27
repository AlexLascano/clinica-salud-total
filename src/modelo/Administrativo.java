package modelo;

public class Administrativo extends Empleado {

    private String departamento;
    private double horasTrabajadas;
    private double valorHora;

    public Administrativo(String cedula, String nombre, int edad, String telefono, String correo,
                          String departamento, double horasTrabajadas, double valorHora) {
        super(cedula, nombre, edad, telefono, correo);
        this.departamento    = departamento;
        this.horasTrabajadas = horasTrabajadas;
        this.valorHora       = valorHora;
    }

    public String getDepartamento()    { return departamento; }
    public double getHorasTrabajadas() { return horasTrabajadas; }
    public double getValorHora()       { return valorHora; }

    public void setDepartamento(String departamento)       { this.departamento = departamento; }
    public void setHorasTrabajadas(double horasTrabajadas) { this.horasTrabajadas = horasTrabajadas; }
    public void setValorHora(double valorHora)             { this.valorHora = valorHora; }

    @Override
    public double calcularPago() {
        return horasTrabajadas * valorHora;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("ADMINISTRATIVO");
        System.out.printf ("Cédula      : ", getCedula());
        System.out.printf ("Nombre      : ", getNombre());
        System.out.printf ("Edad        : ", getEdad());
        System.out.printf ("Teléfono    : ", getTelefono());
        System.out.printf ("Correo      : ", getCorreo());
        System.out.printf ("Departamento: ", departamento);
        System.out.printf ("Horas Trab. :", horasTrabajadas);
        System.out.printf ("Valor/Hora  : ", valorHora);
        System.out.printf ("PAGO TOTAL  : ", calcularPago());
    }
}