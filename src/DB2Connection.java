import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class DB2Connection {
	 
	public static void main(String[] args) {
        String jdbcClassName="com.ibm.db2.jcc.DB2Driver";
        String url="jdbc:db2://localhost:50000/LOGIN";
        String user="lao";
        String password="invalid";
 
        Connection conn = null;
        Statement st = null;
   
        
        
        
    try {
        //Load class into memory
        Class.forName(jdbcClassName);
        //Establish connection
        conn = DriverManager.getConnection(url, user, password);

    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    }finally{
        if(conn!=null){
            System.out.println("Connected successfully.");
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
   /*
    try{
        //STEP 2: Register JDBC driver
        Class.forName(jdbcClassName);

        //STEP 3: Open a connection
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(url,user,password);

        //STEP 4: Execute a query
        System.out.println("Creating statement...");
        st = conn.createStatement();
        String sql;
        sql = "SELECT empno, firstnme, lastname FROM Employee";
        ResultSet rs = st.executeQuery(sql);

        //STEP 5: Extract data from result set
        while(rs.next()){
           //Retrieve by column name
           int id  = rs.getInt("empno");
           String first = rs.getString("firstnme");
           String last = rs.getString("lastname");

           //Display values
           System.out.print("ID: " + id);
           System.out.print(", First: " + first);
           System.out.println(", Last: " + last);
        }
        //STEP 6: Clean-up environment
        rs.close();
        st.close();
        conn.close();
     }catch(SQLException se){
        //Handle errors for JDBC
        se.printStackTrace();
     }catch(Exception e){
        //Handle errors for Class.forName
        e.printStackTrace();
     }finally{
        //finally block used to close resources
        try{
           if(st!=null)
              st.close();
        }catch(SQLException se2){
        }// nothing we can do
        try{
           if(conn!=null)
              conn.close();
        }catch(SQLException se){
           se.printStackTrace();
        }//end finally try
        
     }  */
    try {
     
    String sql = "delete from UserInfo where firstname='Julius'";
    
    
   // System.out.print(sql);
    	
    conn = DriverManager.getConnection(url, user, password);
    	
    	st = conn.createStatement();
    	int rs = st.executeUpdate(sql);
    	
    	System.out.print("Table updated!");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	   
}

