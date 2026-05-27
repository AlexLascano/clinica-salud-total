1. Herencia (extends)
Medico y Administrativo heredan de Empleado. Esto significa que ambas subclases obtienen automáticamente los atributos comunes
(cedula, nombre, edad, telefono, correo) y solo agregan los campos que les son propios.

2. Encapsulamiento (private + getters/setters)
Todos los atributos de Empleado, Medico y Administrativo son privados (private). Solo se accede a ellos a través de métodos públicos getters y setters.
Esto protege el estado interno del objeto.

3. Polimorfismo (ArrayList<Empleado> + métodos abstractos)
Se usa una lista polimórfica ArrayList<Empleado> que almacena tanto Medico como Administrativo. Al llamar e.mostrarInformacion() o
e.calcularPago(), Java ejecuta automáticamente la versión correcta según el tipo real del objeto.

4. Excepciones (try-catch)
Se capturan errores en tiempo de ejecución para que el programa no se detenga inesperadamente

5. Conversiones (Integer.parseInt / Double.parseDouble)
Todo lo que el usuario escribe llega como String. Se convierte explícitamente al tipo necesario

6. Validaciones (util/Validador.java)
Clase utilitaria con métodos estáticos que centralizan todas las reglas de negocio
