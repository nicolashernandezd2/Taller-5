package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.Pedido;
import uniandes.dpoo.hamburguesas.mundo.Producto;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class PedidoTest {
	
	private Pedido pedido;
	private ArrayList<Producto> productos;
	private ProductoMenu producto1;
	private ProductoMenu producto2;
	private ProductoMenu producto3;
	private File archivo;
	
	
	@BeforeEach
	public void setUp() {
		
		producto1 = new ProductoMenu("papas medianas", 5500);
		producto2 = new ProductoMenu("corral", 14000);
		producto3 = new ProductoMenu("gaseosa", 5000);
		productos = new ArrayList<Producto>();
		productos.addLast(producto1);
		productos.addLast(producto2);
		pedido = new Pedido("nicolas", "calle 13");
		archivo = new File("facturas.txt");
		
	}
	
	@Test
	public void testGetIdPedido() {
		assertEquals(1, pedido.getIdPedido(), "El ID del pedido no es correcto");
	}
	
	@Test
	public void testGetNombreCliente() {
		assertEquals("nicolas", pedido.getNombreCliente(), "El nombre del cliente que hizo el pedido no es correcto");
	}
	
	@Test
	public void testAgregarProducto() {
		pedido.agregarProducto(producto3);
		assertEquals(3, productos.size(), "El producto no se agrego correctamente");
	}
	
	@Test
	public void testGetPrecioTotalPedido() {
		assertEquals(23205, pedido.getPrecioTotalPedido(), "El precio total del pedido no es correcto");
	}
	
	@Test
	public void testGetPrecioNetoPedido() {
		assertEquals(19500, pedido.getPrecioNetoPedido(), "El precio neto del pedido no es correcto");
	}
	
	@Test
	public void testGetPrecioIVAPedido() {
		assertEquals(3705, pedido.getPrecioIVAPedido(), "El precio del IVA del pedido no es correcto");
	}
	
	@Test
	public void testGenerarTextoFactura() {
		assertEquals("Cliente: " + "nicolas" + "\n" + 
					 "Dirección: " + "calle 13" + "\n" +
					 "----------------\n" +
					 "papas medianas" + "\n" + "            " + "5500" + "\n" +
					 "corral" + "\n" + "            " + "14000" + "\n" +
					 "----------------\n" +
					 "Precio Neto:  " + "19500" + "\n" +
					 "IVA:          " + "3705" + "\n" +
					 "Precio Total: " + "23205" + "\n" , pedido.generarTextoFactura(), "El texto de la factura no es correcto");
	}
	
	public String leerArchivoTxt() {
		String cadena = "";
	    try (FileReader fr = new FileReader("facturas.txt")) {
	       BufferedReader br = new BufferedReader(fr);
	       // Lectura del fichero
	       String linea = br.readLine();
	       while(linea!=null) {
	          cadena += linea +"\n";
	       }}
	    catch(Exception e){
	         e.printStackTrace();
	      }
	    return cadena;
	  }
	
	@Test
	public void testGuardarFactura() throws FileNotFoundException {
		pedido.guardarFactura(archivo);
		String cadena = leerArchivoTxt();
		assertEquals("Cliente: " + "nicolas" + "\n" + 
				 "Dirección: " + "calle 13" + "\n" +
				 "----------------\n" +
				 "papas medianas" + "\n" + "            " + "5500" + "\n" +
				 "corral" + "\n" + "            " + "14000" + "\n" +
				 "----------------\n" +
				 "Precio Neto:  " + "19500" + "\n" +
				 "IVA:          " + "3705" + "\n" +
				 "Precio Total: " + "23205" + "\n" , cadena, "La factura no se guarda correctamente");
	}
	
}
