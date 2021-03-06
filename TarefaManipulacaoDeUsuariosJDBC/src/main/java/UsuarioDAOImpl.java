import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl implements UsuarioDAO {

	private static final String CON_URL = "jdbc:postgresql://localhost:5432/coursera";
	private static final String USER = "postgres";
	private static final String PASS = "postgres";
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void inserir(Usuario u) {
		try (Connection c = DriverManager.getConnection(CON_URL, USER, PASS)) {
			String sql = "INSERT INTO usuario(login, email, nome, senha, pontos) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement stm = c.prepareStatement(sql);
			stm.setString(1, u.getLogin());
			stm.setString(2, u.getEmail());
			stm.setString(3, u.getNome());
			stm.setString(4, u.getSenha());
			stm.setInt(5, u.getPontos());
		
			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Usuario recuperar(String login) {
		
		Usuario usuario = new Usuario();
		
		try (Connection c = DriverManager.getConnection(CON_URL, USER, PASS)) {
			String sql = "SELECT * FROM usuario WHERE login = ?";
			PreparedStatement stm = c.prepareStatement(sql);
			stm.setString(1, login);
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				usuario.setLogin(rs.getString("login"));
				usuario.setEmail(rs.getString("email"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setPontos(rs.getInt("pontos"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}

	@Override
	public void adicionarPontos(String login, int pontos) {

		try (Connection c = DriverManager.getConnection(CON_URL, USER, PASS)) {
			String sql = "UPDATE usuario SET pontos = pontos + ? WHERE login = ?";
			PreparedStatement stm = c.prepareStatement(sql);
			stm.setInt(1, pontos);
			stm.setString(2, login);
			
			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Usuario> ranking() {
		List<Usuario> usuarios = new ArrayList<>();
		
		try (Connection c = DriverManager.getConnection(CON_URL, USER, PASS)) {
			String sql = "SELECT * FROM usuario ORDER BY pontos DESC";
			PreparedStatement stm = c.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setLogin(rs.getString("login"));
				usuario.setEmail(rs.getString("email"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setPontos(rs.getInt("pontos"));
				
				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}
}
