/**
 * @author Ximena Blard Guevara
 * @version 1.3
 */
public class Transaccion {
    private String descripcion;
    private String numeroCuentaDestino;
    private double monto;
    private String tipo;

    public Transaccion() {
    }

    /**
     * @param descripcion la razón de porqué se está realizando la transacción
     * @param numeroCuentaDestino esta es la cuenta destino de dónde se retira el dinero o dónde se deposita
     * @param monto la cantidad de dinero que se retira o deposita
     * @param tipo se determina si es un retiro o depósito
     */
    public Transaccion(String descripcion, String numeroCuentaDestino, double monto, String tipo) {
        this.setDescripcion(descripcion);
        this.setNumeroCuentaDestino(numeroCuentaDestino);
        this.setMonto(monto);
        this.setTipo(tipo);
    }

    /**
     * @return monto de dinero que se retira o se deposita
     */
    public double getMonto() {
        return monto;
    }

    /**
     * @param monto monto de dinero que se retira o se deposita
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }

    /**
     * @return la razón de porqué se está realizando la transacción
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion la razón de porqué se está realizando la transacción
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return esta es la cuenta destino de dónde se retira el dinero o dónde se deposita
     */
    public String getNumeroCuentaDestino() {
        return numeroCuentaDestino;
    }

    /**
     * @param numeroCuentaDestino esta es la cuenta destino de dónde se retira el dinero o dónde se deposita
     */
    public void setNumeroCuentaDestino(String numeroCuentaDestino) {
        this.numeroCuentaDestino = numeroCuentaDestino;
    }

    /**
     * @return se determina si es un retiro o depósito
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo se determina si es un retiro o depósito
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return un mensaje con toda la información de la transacción
     */
    @Override
    public String toString() {
        return "Transacción:" +
                "\nDescripcion = '" + descripcion + '\'' +
                "\nNúmero de cuenta destino = " + numeroCuentaDestino +
                "\nMonto = " + monto +
                '\n';
    }
}

