package Persistence;

import Model.Currency;
import Model.CurrencySet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseSetLoader extends CurrencySetLoader{

   private static final String URL = "jdbc:oracle:thin:@" + "localhost:1521:orcl";
    private static final String USER = "system";
    private static final String PASSWORD = "orcl";
    private static DataBaseSetLoader instances;

    public DataBaseSetLoader() {
    }

   @Override
    public DataBaseSetLoader getInstance() {
        if (instances == null)
            instances = new DataBaseSetLoader();
        return instances;
    }

    public static void load() throws SQLException {
        CurrencySet set = CurrencySet.getInstance();
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        java.sql.Statement statement = connection.createStatement();
        ResultSet resulSet = statement.executeQuery("SELECT * FROM CAMBIO_EUR_A");
        if (set.isEmpty()) {
            while (resulSet.next()){
                set.add(new Currency(resulSet.getString("DIVISA")));
            }
            set.add(new Currency("EUR"));
        }
        connection.close();
    }
    
}
