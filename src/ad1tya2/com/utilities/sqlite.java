package ad1tya2.com.utilities;
import java.sql.*;

public class sqlite {

    public static void main(String bob) {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);


            stmt = c.createStatement();

            stmt.executeUpdate(bob);

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            log.console("exception found");
        }

    }

    public static Integer intensity(String uuid) {
        log.console("Sending now!");
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);

            Integer time = timestamp.main();
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM data WHERE uuid='" + uuid + "' AND time >= " + time + "-30;");
            int oo = 0;
            while (rs.next()) {
                oo = oo + rs.getInt("intensity");
            }


            stmt.close();
            c.close();
            rs.close();
            return oo;


        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            log.console("exception found");
            return null;

        }
    }

    public static Integer count(String uuid) {
        log.console("Sending now!");
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);

            Integer time = timestamp.main();
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM data WHERE uuid='" + uuid + "' AND time >=" + time + "-1;");
            Integer oo = 0;
            while (rs.next()) {
                oo = rs.getInt("COUNT(*)");
            }


            stmt.close();
            c.close();
            rs.close();
            log.console(oo.toString());
            return oo;


        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            log.console("exception found");
            return null;

        }
    }

}