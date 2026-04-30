
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Clase de pruebas unitarias para la clase Inventario.
 * Verifica el correcto funcionamiento de los métodos principales:
 * agregar productos, calcular el valor total y validar cantidades.
 * 
 * Cada prueba utiliza aserciones de JUnit para comparar el resultado
 * real con el esperado.
 * 
 * @author TuNombre
 */
public class InventarioTest {

    /**
     * Verifica que un producto se agrega correctamente al inventario.
     *
     * @throws AssertionError si el tamaño de la lista no coincide con el esperado.
     */
    @Test
    void testAgregarProducto() {
        Inventario inventario = new Inventario();
        Producto p = new Producto("A001", "Teclado", 10, 20.0);

        inventario.agregarProducto(p);

        assertEquals(1, inventario.getProductos().size());
    }

    /**
     * Comprueba que el cálculo del valor total del inventario es correcto.
     *
     * @return No aplica (método de prueba), pero valida que el valor devuelto
     *         por calcularValorTotal() coincide con el esperado.
     * @throws AssertionError si el valor calculado no coincide con el esperado.
     */
    @Test
    void testCalcularValorInventario() {
        Inventario inventario = new Inventario();
        inventario.agregarProducto(new Producto("A001", "Microfono", 2, 50.0));

        double valorEsperado = 100.0;

        assertEquals(valorEsperado, inventario.calcularValorTotal());
    }

    /**
     * Verifica que el sistema no permite agregar productos con cantidades negativas.
     *
     * @throws AssertionError si no se lanza la excepción esperada.
     */
    @Test
    void testNoPermitirCantidadNegativa() {
        Inventario inventario = new Inventario();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            inventario.agregarProducto(new Producto("A002", "Ratón", -17, 10.0));
        });

        assertTrue(exception.getMessage().contains("cantidad"));
    }
}

