import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author Ximena Blard Guevara
 * @version 1
 * @see Cuenta
 * @since 2
 */
public class Cliente {
    private String nombre;
    private String apellido;
    private String identificacion;
    private LocalDate fechaNacimiento;
    private int edad;
    private String direccion;
    private int numeroCliente;
    private ArrayList<Cuenta> listaCuentasAsociadas;

    /**
     *
     */
    public Cliente() {
    }

    /**
     * @param nombre el nombre del cliente
     * @param apellido el apellido del cliente
     * @param identificacion la cédula del cliente
     * @param fechaNacimiento la fecha de nacimiento del cliente
     * @param edad la edad que tiene el cliente
     * @param direccion la dirección del cliente
     * @param numeroCliente el número que el banco utiliza para identificar el cliente
     * @see Cuenta
     * @since 2
     */
    public Cliente(String nombre, String apellido, String identificacion, LocalDate fechaNacimiento, int edad, String direccion,
                   int numeroCliente) {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setIdentificacion(identificacion);
        this.setFechaNacimiento(fechaNacimiento);
        this.setEdad(edad);
        this.setDireccion(direccion);
        this.setNumeroCliente(numeroCliente);
        listaCuentasAsociadas = new ArrayList<Cuenta>();
    }

    /**
     * @param nombre el nombre del cliente
     * @param apellido el apellido del cliente
     * @param identificacion la cédula del cliente
     * @param fechaNacimiento la fecha de nacimiento del cliente
     * @param edad la edad que tiene el cliente
     * @param direccion la dirección del cliente
     * @param numeroCliente el número que el banco utiliza para identificar el cliente
     * @param listaCuentasAsociadas la lista que contiene las cuentas del cliente
     * @see Cuenta
     * @since 2
     */
    public Cliente(String nombre, String apellido, String identificacion, LocalDate fechaNacimiento, int edad, String direccion, int numeroCliente, ArrayList<Cuenta> listaCuentasAsociadas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.direccion = direccion;
        this.numeroCliente = numeroCliente;
        this.listaCuentasAsociadas = listaCuentasAsociadas;
    }

    /**
     * @return el nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre el nombre del cliente que ingresa el usuario
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return el apellido del cliente
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido el apellido del cliente que ingresa el usuario
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return la cédula del cliente
     */
    public String getIdentificacion() {
        return identificacion;
    }

    /**
     * @param identificacion la cédula del cliente que ingresa el usuario
     */
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    /**
     * @return la fecha de nacimiento del cliente
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento la fecha de nacimiento del cliente que ingresa el usuario
     */
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @return la dirección del cliente
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion la dirección del cliente que ingresa el usuario
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return el número que el banco utiliza para identificar al cliente
     */
    public int getNumeroCliente() {
        return numeroCliente;
    }

    /**
     * @param numeroCliente el número que el banco utiliza para identificar al cliente que fue ingresado por  el usuario
     */
    public void setNumeroCliente(int numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    /**
     * @return la edad que tiene el cliente
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad la edad que tiene el cliente que ingresó el usuario
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return la lista de cuentas asociadas al cliente
     * @see Cuenta
     */
    public ArrayList<Cuenta> getListaCuentasAsociadas() {
        return listaCuentasAsociadas;
    }

    /**
     * @param listaCuentasAsociadas la lista de cuentas asociadas al cliente que fueron ingresadas por el usuario
     * @see Cuenta
     */
    public void setListaCuentasAsociadas(ArrayList<Cuenta> listaCuentasAsociadas) {
        this.listaCuentasAsociadas = listaCuentasAsociadas;
    }

    /**
     * @param objCuenta la cuenta que se acaba de registrar y se va asociar al cliente
     * @see Cuenta
     */
    public void agregarCuenta(Cuenta objCuenta) {
        this.listaCuentasAsociadas.add(objCuenta);
    }

    /**
     * @return un mensaje que contiene toda la información del cliente
     * @see Cuenta
     * @since 3
     */
    @Override
    public String toString() {
        return "Cliente:" +
                "\nNombre = '" + nombre + '\'' +
                "\nApellido = '" + apellido + '\'' +
                "\nIdentificación = '" + identificacion + '\'' +
                "\nFecha de nacimiento = " + fechaNacimiento +
                "\nEdad = " + edad +
                "\nDirección = '" + direccion + '\'' +
                "\nNúmero de cliente = " + numeroCliente +
                "\nLista cuentas = " + listaCuentasAsociadas +
                '\n';
    }
}
