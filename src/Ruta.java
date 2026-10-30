public class Ruta {
    private String idRuta;
    private String idBodegaOrigen;
    private String idBodegaDestino;
    private double capacidadMax;
    private double usoActual;

    public Ruta(String idRuta, String idBodegaOrigen, String idBodegaDestino, double capacidadMax) {
        this.idRuta = idRuta;
        this.idBodegaOrigen = idBodegaOrigen;
        this.idBodegaDestino = idBodegaDestino;
        this.capacidadMax = capacidadMax;
        this.usoActual = 0.0;
    }

    public String getIdRuta() {
        return idRuta;
    }

    public String getIdBodegaOrigen() {
        return idBodegaOrigen;
    }

    public String getIdBodegaDestino() {
        return idBodegaDestino;
    }

    public double getCapacidadMax() {
        return capacidadMax;
    }

    public double getUsoActual() {
        return usoActual;
    }

    public boolean verificarYOcuparRuta(double cantidad) {
        if (usoActual + cantidad <= capacidadMax) {
            usoActual += cantidad;
            return true;
        }
        return false;
    }

    public boolean estaSaturada() {
        return usoActual >= capacidadMax;
    }

    @Override
    public String toString() {
        return "Ruta " + idRuta + " [" + idBodegaOrigen + " -> " + idBodegaDestino + "] | Capacidad Máx: " + capacidadMax + " | Uso Actual: " + usoActual + (estaSaturada() ? " (SATURADA)" : "");
    }
}
