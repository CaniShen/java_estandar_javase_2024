package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import locator.LocatorConnection;

import model.Pedido;

public class PedidosDaoImpl implements PedidosDao {

	@Override
	public void save(Pedido pedido) {
	
			try (Connection con = LocatorConnection.getConnection()) {
				String sql = "insert into pedidos(producto,tienda,fechaPedido,precio) values(?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(sql);
			
				ps.setString(1, pedido.getProducto());
				ps.setString(2, pedido.getTienda());
				ps.setTimestamp(3, Timestamp.valueOf(pedido.getFechaPedido()));//	ps.setTimestamp(4, Timestamp.valueOf(pedido.getFechaPedido()));
				ps.setDouble(4, pedido.getPrecio());
				ps.execute();
			
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}


		}

	}

