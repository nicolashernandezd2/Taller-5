package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.Ingrediente;
import uniandes.dpoo.hamburguesas.mundo.ProductoAjustado;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class ProductoAjustadoTest {
	
	private ProductoMenu productoBasico;
	private ProductoAjustado productoAjustado;
	private Ingrediente ingrediente1;
	private Ingrediente ingrediente2;
	private Ingrediente ingrediente3;
	private ArrayList<Ingrediente> agregados;
	private ArrayList<Ingrediente> eliminados;
	
	@BeforeEach
	public void setUp() {
		
		productoBasico = new ProductoMenu("papas medianas", 5500);
		ingrediente1 = new Ingrediente("tomate", 1000);
		ingrediente2 = new Ingrediente("cebolla", 1000);
		ingrediente3 = new Ingrediente("queso americano", 2500);
		agregados = new ArrayList<Ingrediente>(); 
		eliminados = new ArrayList<Ingrediente>(); 
		agregados.addLast(ingrediente1);
		agregados.addLast(ingrediente2);
		eliminados.addLast(ingrediente3);
		productoAjustado = new ProductoAjustado( productoBasico );
		
	}
	
	@Test
	public void testGetNombre() {
		assertEquals("papas medianas", productoAjustado.getNombre(), "El nombre del producto no es correcto");
	}
	
	@Test
	public void testGetPrecio() {
		assertEquals(7500, productoAjustado.getPrecio(), "El precio del producto no es correcto");
	}
	
	@Test
	public void testGenerarTextoFactura() {
		assertEquals("papas fritas medianas" + "\n" + "            " + "5500" + "\n" + 
				     "    +" + "tomate" + "                " + "1000" + 
				     "    +" + "cebolla" + "                " + "1000" + 
				     "    -" + "queso americano" + 
				     "            " + "7500" + "\n"
				     , productoAjustado.generarTextoFactura(), "El texto en la factura no es correcto");
	}
}
