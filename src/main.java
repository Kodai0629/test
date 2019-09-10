import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class main {
    public static void main(String[] args) {
            try {
                Class.forName("org.h2.Driver");
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }try (Connection connection = DriverManager.getConnection("jdbc:h2:~/h2db/lecture;Mode=PostgreSQL;　AUTO_SERVER=TRUE;", "Okada", "kodai0629");
                  Statement statement=connection.createStatement()){
                String sql="insert into student(name,student_number,department)" +
                        "values ('山田　太一郎',1,'一般')";
                statement.executeUpdate(sql);
            } catch(SQLException e) {
                e.printStackTrace();

            }

        }

    }

