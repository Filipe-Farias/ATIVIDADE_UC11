
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
public class conectaDAO {
    
    public Connection connectDB(){
        Connection conn = null;
        
        try {
        
            conn = DriverManager.getConnection("jdbc:mysql://localhost/uc11?user=root&password=");
            
        } catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ConectaDAO" + erro.getMessage());
        }
        Connection con = null;
        try {
            
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root");
            System.out.println( "Conexao com o banco de dados estabelecida." );
        } catch ( SQLException sqle ) {
            System.out.println( "Erro na conexao ao Bando de Dados : " +
                                        sqle.getMessage() );
        }
    
 }
    
}
    

