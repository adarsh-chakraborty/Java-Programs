import java.sql.DriverManager;
import java.sql.Connection;

import java.sql.SQLException;
import java.util.Properties;

class Driver{
  public static void main(String args[]){
    Connection conn = null;
    // Statement stmt = null;
    // ResultSet rs = null;

    String url = "jdbc:mysql://localhost:3306/testdb";
    Properties property = new Properties();
    property.put("user", "root");
    property.put("password", "superdoge1234");

    // String user = "";
    // String password = "";

    try{
      // Class.forName("com.mysql.cj.jdbc.Driver");
      // Class.forName("com.mysql.jdbc.Driver");-co

      conn = DriverManager.getConnection(url,property);
      System.out.println("Connected to local mysql instance");
      conn.close();

      
      
    }catch(SQLException e){
     e.printStackTrace();
    }




  }
}


// Compile
// javac Driver.java

// Running the program
// java -cp "lib/mysql-connector.jar;" Driver