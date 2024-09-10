import java.sql.*;

public class Main {
    public static void main(String[] args) throws Exception {
        StudentDAO studentDAO = new StudentDAO();
//        studentDAO.addStudent(5, "Kishan");
        Student student = studentDAO.getStudent(3);
        System.out.println(student);

        studentDAO.updateName(3, "Sanam");
         student = studentDAO.getStudent(3);
        System.out.println(student);




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
//            System.out.println(name);
            s.name = name;

        }
        else System.out.println("No student found");
        st.close();
        con.close();
        return s;

    }

    public boolean addStudent(int roll, String name) throws  Exception{

        Student s = new Student(roll, name);
        String query = "INSERT INTO students (roll,sname) VALUES (?,?);";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://root@localhost/students","root","root");
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, roll);
        ps.setString(2, name);
        int res = ps.executeUpdate();
        ps.close();
        con.close();
        return res > 0;

    }

    public boolean updateName(int roll, String name) throws  Exception{
        String query = "UPDATE Students SET sname = ? WHERE roll = ?";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/students","root","root");
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(2, roll);
        ps.setString(1, name);
        int res = ps.executeUpdate();
        return res>0;
    }




}