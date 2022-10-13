import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author Ximena Blard Guevara
 * @version 1
 */
public class BL {
    private final static ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
    private final static ArrayList<Cuenta> listaCuentas = new ArrayList<Cuenta>();

    /**
     * @see Cuenta
     * @since 1
     * @see Cliente
     * @since 1
     */
    public static void inicializarListas() {
        Cliente objCliente1 = new Cliente("Ximena", "Blard", "402500885",
                LocalDate.of(2001,3,5), 20, "Belén, Heredia", 1);
        Cliente objCliente2 = new Cliente("Chris", "Guevara", "110600256",
                LocalDate.of(1980,2,21), 41, "Belén, Heredia", 2);
        Cliente objCliente3 = new Cliente("Sean", "O'Donnell", "923400347",
                LocalDate.of(1970,6,12), 51, "Belén, Heredia", 3);
        Cliente objCliente4 = new Cliente("Mia", "O'Donnell", "305100567",
                LocalDate.of(2004,12,26), 16, "Belén, Heredia", 4);

        listaClientes.add(objCliente1);
        listaClientes.add(objCliente2);
        listaClientes.add(objCliente3);
        listaClientes.add(objCliente4);

        Cuenta objCuenta1 = new Cuenta("0000001", 25560.7, 1);
        Cuenta objCuenta2 = new Cuenta("0000002", 167890.2, 2);
        Cuenta objCuenta3 = new Cuenta("0000003", 1234500.8, 3);
        Cuenta objCuenta4 = new Cuenta("0000004", 11234.4, 4);
        Cuenta objCuenta5 = new Cuenta("0000005", 300672.5, 3);

        listaCuentas.add(objCuenta1);
        listaCuentas.add(objCuenta2);
        listaCuentas.add(objCuenta3);
        listaCuentas.add(objCuenta4);
        listaCuentas.add(objCuenta5);

        objCliente1.agregarCuenta(objCuenta1);
        objCliente2.agregarCuenta(objCuenta2);
        objCliente3.agregarCuenta(objCuenta5);
        objCliente3.agregarCuenta(objCuenta3);
        objCliente4.agregarCuenta(objCuenta4);
    }

    /**
     * @param pNombre el nombre del cliente a registrar
     * @param pApellido el apellido del cliente a registrar
     * @param pIdentificacion la cédula del cliente a registrar
     * @param pFechaNacimiento la fecha de nacimiento del cliente a registrar
     * @param pEdad la edad que tiene el cliente a registrar
     * @param pDireccion la dirección del cliente a registrar
     * @param pNumeroCliente el número de cliente que va a utilizar el banco para identificar el cliente a registrar
     * @return un mensaje para que el usuario sepa si se registró o no el cliente
     * @see Cliente
     * @since 1
     */
    public static String registrarCliente(String pNombre, String pApellido, String pIdentificacion, LocalDate pFechaNacimiento,
                                          int pEdad, String pDireccion, int pNumeroCliente) {
        boolean sePuedeRegistrar;
        String msj;

        Cliente objClienteNuevo = new Cliente(pNombre, pApellido, pIdentificacion, pFechaNacimiento, pEdad, pDireccion,
                pNumeroCliente);
        sePuedeRegistrar = verificacionClienteNoRepetido(objClienteNuevo);
        if (sePuedeRegistrar) {
            listaClientes.add(objClienteNuevo);
            msj = "El cliente fue registrado exitosamente!";
        } else {
            msj = "El cliente con el número de cliente " + pNumeroCliente + " ya está registrado.";
        }

        return msj;
    }

    /**
     * @param pobjClienteNuevo el cliente que el usuario quiere registrar
     * @return un valor booleano que indica si el cliente ya está registrado o no
     * @see Cliente
     * @since 2
     */
    public static boolean verificacionClienteNoRepetido(Cliente pobjClienteNuevo) {
        boolean clienteNoRepetido = true;

        for (Cliente objCliente : listaClientes) {
            if (objCliente.getNumeroCliente() == pobjClienteNuevo.getNumeroCliente()){
                clienteNoRepetido = false;
            }
        }

        return clienteNoRepetido;
    }

    /**
     * @param pNumeroCuenta el número de cuenta de la cuenta a registrar
     * @param pSaldo el saldo inicial que se deposita en la cuenta a registrar
     * @param pNumCliente el número del cliente registrado al cuál se le va a asignar la cuenta a registrar
     * @return un mensaje que le indica al usuario si la cuenta se registró o no
     * @see Cliente
     * @since 2
     * @see Cuenta
     * @since 1
     */
    public static String registrarCuenta(String pNumeroCuenta, double pSaldo, int pNumCliente) {
        boolean sePuedeRegistrar;
        String msj = "";
        Cliente objCliente;

        Cuenta objCuentaNueva = new Cuenta(pNumeroCuenta, pSaldo, pNumCliente);
        objCliente = buscarCliente(pNumCliente);

        sePuedeRegistrar = verificacionCuentaNoRepetida(objCuentaNueva);

        if (sePuedeRegistrar && pNumeroCuenta.length() == 7 && pSaldo >= 50000) {
            listaCuentas.add(objCuentaNueva);
            objCliente.agregarCuenta(objCuentaNueva);
            msj = "La cuenta se ha registrado exitosamente!";
        } else {
            if (!sePuedeRegistrar){
                msj = "La cuenta no se puede registrar porque la cuenta " + pNumeroCuenta + " ya existe.\n";
            }
            if (pNumeroCuenta.length() < 7){
                msj += "La cuenta no se puede registrar porque la cuenta " + pNumeroCuenta + " tiene menos de 7 " +
                        "dígitos.\n";
            }
            if (pSaldo < 50000) {
                msj += "La cuenta no se puede registrar porque la cuenta " + pNumeroCuenta + " tiene un depósito " +
                        "inicial menor a 50000\n";
            }
        }

        return msj;
    }

    /**
     * @param pobjCuentaNueva la cuenta que el usuario quiere registrar
     * @return un valor booleano que indica si la cuenta ya está registrada o no
     * @see Cuenta
     * @since 2
     */
    public static boolean verificacionCuentaNoRepetida(Cuenta pobjCuentaNueva) {
        boolean cuentaNoRepetida = true;

        for (Cuenta objCuenta : listaCuentas) {
            if (objCuenta.getNumeroCuenta().equals(pobjCuentaNueva.getNumeroCuenta())){
                cuentaNoRepetida = false;
            }
        }

        return cuentaNoRepetida;
    }

    /**
     * @param pDescripcion la razón de porqué se está realizando la transacción
     * @param pNumCuentaDestino esta es la cuenta destino de dónde se retira el dinero o dónde se deposita
     * @param pMonto la cantidad de dinero que se retira o deposita
     * @param pTipo se determina si es un retiro o depósito
     * @return un mensaje que le indica al usuario si la transacción fue exitosa o no
     * @see Transaccion
     * @since 3
     * @see Cuenta
     * @since 3
     */
    public static String registrarTransaccion(String pDescripcion, String pNumCuentaDestino, double pMonto, String pTipo) {
        Transaccion objTransaccion = new Transaccion(pDescripcion, pNumCuentaDestino, pMonto, pTipo);
        Cuenta objCuenta;
        String msj = "";

        objCuenta = buscarCuenta(pNumCuentaDestino);

        if (pTipo.equals("1")) {
            if (pMonto <= 0) {
                msj = "El depósito no se puede realizar porque el monto debe ser mayor a cero";
            } else{
                double nuevoSaldo = objCuenta.getSaldo() + pMonto;
                objCuenta.setSaldo(nuevoSaldo);
                msj = "El depósito fue exitoso!";
            }
        }

        if (pTipo.equals("2")) {
            if (pMonto > 0 && pMonto <= objCuenta.getSaldo()) {
                double nuevoSaldo = objCuenta.getSaldo() - pMonto;
                objCuenta.setSaldo(nuevoSaldo);
                msj = "El retiro fue exitoso!";
            } else{
                if (pMonto > objCuenta.getSaldo()) {
                    msj = "El retiro no se puede realizar porque el monto es mayor al saldo de la cuenta";
                }

                if (pMonto <= 0) {
                    msj = "El retiro no se puede realizar porque debe ser mayor a 0";
                }
            }
        }

        return msj;
    }

    /**
     * @return una lista que contiene todos los clientes registrados
     * @see Cliente
     * @since 1
     */
    public static ArrayList<String> obtenerListaClientes() {
        ArrayList<String> lista = new ArrayList<String>();
        for (Cliente objCliente : listaClientes){
            lista.add(objCliente.toString());
        }
        return lista;
    }

    /**
     * @param pNumCuenta el número de cuenta que se desea encontrar
     * @return la cuenta registrada que tiene el número de cuenta que se buscó
     * @see Cuenta
     * @since 2
     */
    public static Cuenta buscarCuenta(String pNumCuenta) {
        Cuenta cuentaEncontrada = new Cuenta();

        for (Cuenta objCuenta : listaCuentas) {
            if (objCuenta.getNumeroCuenta().equals(pNumCuenta)){
                cuentaEncontrada = objCuenta;
            }
        }
        return cuentaEncontrada;
    }

    /**
     * @param pNumCliente el número del cliente que se desea encontrar
     * @return el cliente registrado que tiene el número de cliente que se buscó
     * @see Cliente
     * @since 3
     */
    public static Cliente buscarCliente(int pNumCliente) {
        Cliente clienteEncontrado = new Cliente();

        for (Cliente objCliente : listaClientes) {
            if (objCliente.getNumeroCliente() == pNumCliente){
                clienteEncontrado = objCliente;
            }
        }
        return clienteEncontrado;
    }

    /**
     * @param pNumCuenta el número de cuenta de la cuenta que se quiere buscar
     * @return un mensaje que le indica al usuario si la cuenta que se buscó tiene fondos o no,
     *         y si los tiene cúal sería su saldo
     * @see Cuenta
     * @since 2
     */
    public static String obtenerMontoCuenta(String pNumCuenta) {
        Cuenta objCuenta;
        String msj;

        objCuenta = buscarCuenta(pNumCuenta);

        if (objCuenta.getNumeroCuenta() == null) {
            msj = "La cuenta " + pNumCuenta + " no existe";
        }
        if (objCuenta.getSaldo() == 0) {
            msj = "La cuenta no tiene fondos";
        } else {
            msj = "El saldo de la cuenta " + objCuenta.getNumeroCuenta() + " es de " + objCuenta.getSaldo();
        }

        return msj;
    }
}

