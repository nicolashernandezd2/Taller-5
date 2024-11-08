package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.Combo;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class ComboTest {
	
	private ProductoMenu producto1;
	private ProductoMenu producto2;
	private ProductoMenu producto3;
	private ArrayList<ProductoMenu> productosCombo;
	private Combo combo;
	
	@BeforeEach
	public void setUp() {
		
		producto1 = new ProductoMenu("corral", 14000);
		producto2 = new ProductoMenu("papas medianas", 5500);
		producto3 = new ProductoMenu("gaseosa", 5000);
		productosCombo = new ArrayList<ProductoMenu>();
		productosCombo.addLast(producto1);
		productosCombo.addLast(producto2);
		productosCombo.addLast(producto3);
		combo = new Combo("combo corral", 0.9, productosCombo);
		
	}
	
	@Test
	public void testGetNombre() {
		assertEquals("combo corral", combo.getNombre(), "El nombre del combo no es correcto");
	}
	
	@Test
	public void testGetPrecio() {
		assertEquals(22050, combo.getPrecio(), "El precio del combo no es correcto");
	}
	
	@Test
	public void testGenerarTextoFactura() {
		assertEquals("Combo " + "combo corral" + "\n" +
				     " Descuento: " + "0.9" + "\n"  +
				     "            " + "22050" + "\n", combo.generarTextoFactura(), "El texto de la factura no es correcto");
	}
	
}
