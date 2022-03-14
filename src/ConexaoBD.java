import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoBD {
    // Biblioteca do mysql
    private static String driver = "com.mysql.jdbc.Driver";

    // Nome da base de dados
    private static String database = "sistemafinanceiro";

    // Host
    private static String hostname = "DESKTOP-CLJ30BE";

    // Porta mysql
    private static String port = "3306";

    // URL
    private static String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";

    // Nome do usuario
    private static String user = "root";

    // Senha do banco de dados
    private static String password = "jan.0495";

   

    // Conexao com o banco
    public static Connection conectar() throws SQLException {
        Connection con = null;

        try {

            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao concectar, conexão não realizada.");
        }

        if (con != null) {
            System.out.println("Conectado");
        }
        return con;
    }
    
    
}
