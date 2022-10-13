/**
 * @author Ximena Blard Guevara
 * @version 1
 */

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class UI {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    /**
     * @param args es un array de Strings que debe aparecer obligatoriamente como argumento
     *             del método main en un programa Java
     * @throws IOException error que se podría dar en el Input o Output
     */
    public static void main(String[] args) throws IOException{
        int opcion;

        BL.inicializarListas();

        do {
            mostrarMenu();
            opcion = leerOpcion();
            procesarOpcionSeleccionada(opcion);
        }while(opcion != 0);
    }

    public static void mostrarMenu() {
        out.println("------------- Menú -------------");
        out.println("1. Registrar un cliente nuevo");
        out.println("2. Mostrar clientes registrados");
        out.println("3. Crear una cuenta");
        out.println("4. Realizar un depósito");
        out.println("5. Realizar un retiro");
        out.println("6. Mostrar el saldo de una cuenta");
        out.println("0. Salir");
    }

    /**
     * @return la opción del menú que fue seleccionada por el usuario
     * @throws IOException error que se podría dar en el Input o Output
     */
    public static int leerOpcion() throws IOException{
        out.println("\nIngrese la opción que desea realizar:");
        int opcion = Integer.parseInt(in.readLine());
        return opcion;
    }

    /**
     * @param pOpcion opción del menú que fue seleccionada por el usuario
     * @throws IOException error que se podría dar en el Input o Output
     */
    public static void procesarOpcionSeleccionada(int pOpcion) throws IOException{
        switch (pOpcion) {
            case 0:
                out.println("Gracias por visitarnos!!");
                break;
            case 1:
                obtenerDatosRegistroCliente();
                break;
            case 2:
                mostrarListaCliente();
                break;
            case 3:
                obtenerDatosRegistroCuenta();
                break;
            case 4:
                obtenerDatosDeposito();
                break;
            case 5:
                obtenerDatosRetiro();
                break;
            case 6:
                mostrarSaldoCuenta();
                break;
            default:
                out.println("Opción inválida");
                break;
        }
    }

    /**
     * @throws IOException error que se podría dar en el Input o Output
     */
    public static void obtenerDatosRegistroCliente() throws IOException {
        out.println("Ingrese el nombre del cliente:");
        String nombre = in.readLine();

        out.println("Ingrese el apellido de " + nombre);
        String apellido = in.readLine();

        out.println("Ingrese la cédula de " + nombre + " " + apellido);
        String identificacion = in.readLine();

        out.println("Ingrese el año en el que nació " + nombre + " " + apellido);
        int anno = Integer.parseInt(in.readLine());

        out.println("Ingrese el número del mes en el que nació " + nombre + " " + apellido);
        int mes = Integer.parseInt(in.readLine());

        out.println("Ingrese el día en el que nació " + nombre + " " + apellido);
        int dia = Integer.parseInt(in.readLine());

        LocalDate fechaNacimiento = LocalDate.of(anno,mes,dia);

        out.println("Ingrese la edad de " + nombre + " " + apellido);
        int edad = Integer.parseInt(in.readLine());

        out.println("Ingrese la dirección de dónde vive " + nombre + " " + apellido + " de la siguiente manera:" +
                " Cantón, Distrito, Provincia");
        String direccion = in.readLine();

        out.println("Ingrese el número del cliente");
        int numCliente = Integer.parseInt(in.readLine());

        out.println(BL.registrarCliente(nombre, apellido, identificacion, fechaNacimiento, edad, direccion, numCliente));
    }

    public static void mostrarListaCliente() {
        ArrayList<String> listaClientes = BL.obtenerListaClientes();
        for (String objCliente : listaClientes) {
            out.println(objCliente);
        }
    }

    /**
     * @throws IOException error que se podría dar en el Input o Output
     */
    public static void obtenerDatosRegistroCuenta() throws IOException{
        out.println("Ingrese el número de cuenta (mínimo de 7 dígitos)");
        String numCuenta = in.readLine();

        out.println("Digite el depósito inicial que desea realizar el cliente (mínimo de 50 mil colones)");
        double saldo = Double.parseDouble(in.readLine());

        out.println("Ingrese el número de cliente asociado a la cuenta");
        int numCliente = Integer.parseInt(in.readLine());

        out.println(BL.registrarCuenta(numCuenta, saldo, numCliente));
    }

    /**
     * @throws IOException error que se podría dar en el Input o Output
     */
    public static void obtenerDatosDeposito() throws IOException{
        out.println("Ingrese la cuenta destino del depósito");
        String cuentaDestino = in.readLine();

        out.println("Ingrese la descripción del depósito");
        String descripcion = in.readLine();

        out.println("Ingrese el monto del depósito");
        double monto = Double.parseDouble(in.readLine());

        String tipo = "1";

        out.println(BL.registrarTransaccion(descripcion, cuentaDestino, monto, tipo));
    }

    /**
     * @throws IOException error que se podría dar en el Input o Output
     */
    public static void obtenerDatosRetiro() throws IOException{
        out.println("Ingrese la cuenta destino del retiro");
        String cuentaDestino = in.readLine();

        out.println("Ingrese la descripción del retiro");
        String descripcion = in.readLine();

        out.println("Ingrese el monto del retiro");
        double monto = Double.parseDouble(in.readLine());

        String tipo = "2";

        out.println(BL.registrarTransaccion(descripcion, cuentaDestino, monto, tipo));
    }

    /**
     * @throws IOException error que se podría dar en el Input o Output
     */
    public static void mostrarSaldoCuenta() throws IOException{
        out.println("Ingrese el número de cuenta del saldo que desea ver");
        String numCuenta = in.readLine();

        out.println(BL.obtenerMontoCuenta(numCuenta));
    }
}