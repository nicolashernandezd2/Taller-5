package uniandes.dpoo.hamburguesas.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.excepciones.NoHayPedidoEnCursoException;
import uniandes.dpoo.hamburguesas.excepciones.YaHayUnPedidoEnCursoException;
import uniandes.dpoo.hamburguesas.mundo.Combo;
import uniandes.dpoo.hamburguesas.mundo.Ingrediente;
import uniandes.dpoo.hamburguesas.mundo.Pedido;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;
import uniandes.dpoo.hamburguesas.mundo.Restaurante;

public class RestauranteTest {
	
	private Restaurante restaurante;
	private Pedido pedidoEnCurso;
	private ArrayList<Pedido> pedidos;
	private ArrayList<ProductoMenu> menuBase;
	private ArrayList<Combo> menuCombos;
	private ArrayList<Ingrediente> ingredientes;
	
	@BeforeEach
	public void setUp() {
		restaurante = new Restaurante();
	}
	
	@Test
	public void testIniciarPedido() throws YaHayUnPedidoEnCursoException {
		restaurante.iniciarPedido("nicolas","calle 13");
		assertNotNull(pedidoEnCurso, "No se inicializa correctamente el pedido");
	}
	
	@Test
	public void testCerrarYGuardarPedido() throws YaHayUnPedidoEnCursoException, NoHayPedidoEnCursoException, IOException {
		restaurante.iniciarPedido("nicolas","calle 13");
		restaurante.cerrarYGuardarPedido();
		assertNull(pedidoEnCurso, "No se cierra correctamente el pedido en curso");
	}
	
	@Test
	public void testGetPedidoEnCurso() {
		assertEquals(pedidoEnCurso, restaurante.getPedidoEnCurso(),"No se obtiene correctamente el pedido en curso");
	}
	
	@Test
	public void testGetPedidos() {
		assertEquals(pedidos, restaurante.getPedidos(),"No se obtienen correctamente los pedidos cerrados");
	}
	
	@Test
	public void testGetMenuBase() {
		assertEquals(menuBase, restaurante.getMenuBase(),"No se obtiene correctamente el menu base");
	}
	
	@Test
	public void testGetMenuCombos() {
		assertEquals(menuCombos, restaurante.getMenuCombos(),"No se obtiene correctamente el menu de combos");
	}
	
	@Test
	public void testGetIngredientes() {
		assertEquals(ingredientes, restaurante.getIngredientes(),"No se obtienen correctamente los ingredientes");
	}
}
