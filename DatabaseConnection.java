import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection
{
    private static final String url = "jdbc:postgresql://localhost:5150/Drug_Patient_db";
    private static final String user = "postgres";
    private static final String password = "Abcd23452345!";

    public static Connection getcon()
    {
        Connection connection = null;
        try
        {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
        }
        catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
        return connection;
    }
}
