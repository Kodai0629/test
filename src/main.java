import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class main {
    public static void main(String[] args) {
        String sql = "insert into student(name, department) VALUES (?, ?)";

        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:h2:~/h2db/lecture;Mode=PostgreSQL;AUTO_SERVER=TRUE;",
                    "b2180520", "kodai0629");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "Kodai Okadai");
            preparedStatement.setString(2, "情報システム工学科");
            preparedStatement.execute();
            sql ="insert into GRADE(student_name, point) values (?,?)";

            PreparedStatement preparedstatement = connection.prepareStatement(sql);
            preparedstatement.setString(1, "Kodai Okadai");
            preparedstatement.setString(2, "59");
            preparedstatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
