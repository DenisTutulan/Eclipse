import java.util.ArrayList;
import java.util.List;

public class Inventario {

    private List<Producto> productos;

    public Inventario() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public double calcularValorTotal() {
        double total = 0;

        for (Producto p : productos) {
            total += p.getCantidad() * p.getPrecio();
        }

        return total;
    }
}
