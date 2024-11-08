package uniandes.dpoo.hamburguesas.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class ProductoMenuTest {
	
	private ProductoMenu productoBasico;
	
	@BeforeEach
	public void setUp() {
		
		productoBasico = new ProductoMenu("papas medianas", 5500);
		
	}
	
	@Test
	public void testGetNombre() {
		assertEquals("papas medianas", productoBasico.getNombre(), "El nombre del producto no es correcto");
	}
	
	@Test
	public void testGetPrecio() {
		assertEquals(5500, productoBasico.getPrecio(), "El precio del producto no es correcto");
	}
	
	@Test
	public void testGenerarTextoFactura() {
		assertEquals("papas medianas" + "\n" + "            " + "5500" + "\n", productoBasico.generarTextoFactura(), "El texto en la factura no es correcto");
	}
	
	
}



