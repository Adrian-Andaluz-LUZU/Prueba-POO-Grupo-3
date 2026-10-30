import java.util.ArrayList;
import java.util.List;

public class Distribuidor {
    private List<Bodega> bodegas;
    private List<Producto> productos;
    private List<Ruta> rutas;
    private List<String> historialDespachos;

    public Distribuidor() {
        this.bodegas = new ArrayList<>();
        this.productos = new ArrayList<>();
        this.rutas = new ArrayList<>();
        this.historialDespachos = new ArrayList<>();
    }

    public boolean registrarBodega(String id, String nombre) {
        for (Bodega b : bodegas) {
            if (b.getIdBodega().equalsIgnoreCase(id)) return false;
        }
        bodegas.add(new Bodega(id, nombre));
        return true;
    }

    public boolean registrarProducto(String codigo, String nombre) {
        for (Producto p : productos) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) return false;
        }
        productos.add(new Producto(codigo, nombre));
        return true;
    }

    public boolean registrarRuta(String idRuta, String origen, String destino, double capacidad) {
        if (capacidad <= 0) return false;
        for (Ruta r : rutas) {
            if (r.getIdRuta().equalsIgnoreCase(idRuta)) return false;
        }
        rutas.add(new Ruta(idRuta, origen, destino, capacidad));
        return true;
    }

    public Bodega buscarBodega(String id) {
        for (Bodega b : bodegas) {
            if (b.getIdBodega().equalsIgnoreCase(id)) return b;
        }
        return null;
    }

    public Ruta buscarRuta(String origen, String destino) {
        for (Ruta r : rutas) {
            if (r.getIdBodegaOrigen().equalsIgnoreCase(origen) && r.getIdBodegaDestino().equalsIgnoreCase(destino)) {
                return r;
            }
        }
        return null;
    }

    public String realizarDespacho(String idOrigen, String idDestino, String codProducto, int cantidad) {
        if (cantidad <= 0) return "Error: La cantidad a despachar debe ser mayor a cero.";

        Bodega origen = buscarBodega(idOrigen);
        Bodega destino = buscarBodega(idDestino);
        if (origen == null || destino == null) return "Error: Bodega de origen o destino no encontrada.";

        Ruta ruta = buscarRuta(idOrigen, idDestino);
        if (ruta == null) return "Error: No existe una ruta registrada entre estas dos bodegas.";

        // Verificaciones de negocio obligatorias
        if (origen.obtenerStock(codProducto) < cantidad) {
            return "Error: Stock insuficiente en la bodega de origen.";
        }

        if (!ruta.verificarYOcuparRuta(cantidad)) {
            return "Rechazado: La ruta excede su capacidad máxima con este despacho.";
        }

        // Actualización de inventarios
        origen.reducirStock(codProducto, cantidad);
        destino.agregarStock(codProducto, cantidad);

        String registro = "Éxito: Despacho de " + cantidad + " unidades del producto " + codProducto + " de " + idOrigen + " a " + idDestino;
        historialDespachos.add(registro);
        return registro;
    }

    public void mostrarRutasSaturadas() {
        System.out.println("--- Rutas Saturadas ---");
        boolean haySaturadas = false;
        for (Ruta r : rutas) {
            if (r.estaSaturada()) {
                System.out.println(r);
                haySaturadas = true;
            }
        }
        if (!haySaturadas) System.out.println("No hay rutas saturadas actualmente.");
    }

    public void mostrarHistorial() {
        System.out.println("--- Historial de Despachos ---");
        if (historialDespachos.isEmpty()) {
            System.out.println("No hay despachos registrados.");
        } else {
            for (String h : historialDespachos) {
                System.out.println("- " + h);
            }
        }
    }

    public void mostrarBodegas() {
        for (Bodega b : bodegas) {
            b.mostrarInventario();
        }
    }

    public void mostrarRutas() {
        System.out.println("--- Listado de Rutas ---");
        for (Ruta r : rutas) {
            System.out.println(r);
        }
    }
}