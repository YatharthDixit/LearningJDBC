import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        StudentDAO studentDAO = new StudentDAO();
        Student student = studentDAO.getStudent(4);

    }
}
class StudentDAO{
    public Student getStudent(int roll) throws ClassNotFoundException, SQLException {
        Student s  = new Student();
        s.roll =  roll;
        String query = "SELECT sname FROM students WHERE roll = " + roll + ";";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://root@localhost/students","root","root");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        if(rs.next()){
            String name = rs.getString("sname");
            System.out.println(name);
            s.name = name;

        }
        else System.out.println("No student found");
        return s;
    }
}