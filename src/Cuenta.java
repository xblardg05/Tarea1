/**
 * @author Ximena Blard Guevara
 * @version 1
 */
public class Cuenta {
    private String numeroCuenta;
    private double saldo;
    private int numClienteAsociado;

    /**
     *
     */
    public Cuenta() {
    }

    /**
     * @param numeroCuenta el número que el banco va a utilizar para identificar la cuenta
     * @param saldo la cantidad de dinero que contiene la cuenta
     * @param numClienteAsociado el número del cliente que es el "dueño" de la cuenta
     */
    public Cuenta(String numeroCuenta, double saldo, int numClienteAsociado) {
        this.setNumeroCuenta(numeroCuenta);
        this.setSaldo(saldo);
        this.setNumClienteAsociado(numClienteAsociado);
    }

    /**
     *
     * @return el número que el banco utiliza para identificar la cuenta
     */
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     *
     * @param numeroCuenta el número que el banco va a utilizar para identificar la cuenta que fue ingresada por el
     *                     usuario
     */
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    /**
     *
     * @return la cantidad de dinero que contiene la cuenta
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     *
     * @param saldo la cantidad de dinero que contiene la cuenta, que ingresó el usuario
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     *
     * @return el número del cliente que es el "dueño" de la cuenta
     */
    public int getNumClienteAsociado() {
        return numClienteAsociado;
    }

    /**
     *
     * @param numClienteAsociado el número del cliente que el usuario asoció a la cuenta
     */
    public void setNumClienteAsociado(int numClienteAsociado) {
        this.numClienteAsociado = numClienteAsociado;
    }

    /**
     *
     * @return un mensaje que contiene toda la información de la cuenta
     */
    @Override
    public String toString() {
        return "Cuenta: " +
                "\nNúmero de cuenta ='" + numeroCuenta + '\'' +
                "\nSaldo = " + saldo +
                '\n';
    }
}

