import java.util.HashMap;
import java.util.Map;

public class Bodega {
    private String idBodega;
    private String nombre;
    private Map<String, Integer> inventario; // Clave: código de producto, Valor: cantidad

    public Bodega(String idBodega, String nombre) {
        this.idBodega = idBodega;
        this.nombre = nombre;
        this.inventario = new HashMap<>();
    }

    public String getIdBodega() {
        return idBodega;
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarStock(String codigoProducto, int cantidad) {
        if (cantidad > 0) {
            inventario.put(codigoProducto, inventario.getOrDefault(codigoProducto, 0) + cantidad);
        }
    }

    public boolean reducirStock(String codigoProducto, int cantidad) {
        int actual = inventario.getOrDefault(codigoProducto, 0);
        if (actual >= cantidad && cantidad > 0) {
            inventario.put(codigoProducto, actual - cantidad);
            return true;
        }
        return false;
    }

    public int obtenerStock(String codigoProducto) {
        return inventario.getOrDefault(codigoProducto, 0);
    }

    public void mostrarInventario() {
        System.out.println("--- Inventario de Bodega: " + nombre + " (" + idBodega + ") ---");
        if (inventario.isEmpty()) {
            System.out.println("La bodega está vacía.");
        } else {
            for (Map.Entry<String, Integer> entry : inventario.entrySet()) {
                System.out.println("  - Producto [Cod: " + entry.getKey() + "] | Cantidad: " + entry.getValue());
            }
        }
    }
}
