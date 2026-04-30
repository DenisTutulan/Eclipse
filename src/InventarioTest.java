
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class InventarioTest {

    @Test
    void testAgregarProducto() {
        Inventario inventario = new Inventario();
        Producto p = new Producto("A001", "Teclado", 10, 20.0);

        inventario.agregarProducto(p);

        assertEquals(1, inventario.getProductos().size());
    }

    @Test
    void testCalcularValorInventario() {
        Inventario inventario = new Inventario();
        inventario.agregarProducto(new Producto("A001", "Teclado", 2, 50.0));

        double valorEsperado = 100.0;

        extracted(inventario, valorEsperado);
    }

	private void extracted(Inventario inventario, double valorEsperado) {
		assertEquals(valorEsperado, inventario.calcularValorTotal());
	}

    @Test
    void testNoPermitirCantidadNegativa() {
        Inventario inventario = new Inventario();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            inventario.agregarProducto(new Producto("A002", "Ratón", -17, 10.0));
        });

        assertTrue(exception.getMessage().contains("cantidad"));
    }
}
