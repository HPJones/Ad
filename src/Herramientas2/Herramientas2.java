/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Herramientas2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xmldb.api.DatabaseManager;
import static org.xmldb.api.DatabaseManager.getCollection;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XPathQueryService;

/**
 *
 * @author AlumnoT
 */
public class Herramientas2 {
    
    
    public static Collection conectar(String bd,String user,String passwd){
        
        String driver = "org.exist.xmldb.DatabaseImpl";
        String URI = "xmldb:exist://localhost:8080/exist/xmlrpc/db/"+bd;
        
        //Proceso de conexion
        
        try{
            Class C1 = Class.forName(driver);
            Database database = (Database)C1.newInstance();
            DatabaseManager.registerDatabase(database);
            System.out.println("Inicializado el driver");           
                        
        }catch(Exception e){
            System.out.println("error al iniciar la B.D");
        }
        
        
        Collection col=null;
        try {
            col = DatabaseManager.getCollection(URI,user,passwd);
            
            if(col==null){
            System.out.println("La coleccion no existe");
            
             }
            else{
            System.out.println("Te has Conectado");
            
            }
                     
        } catch (XMLDBException ex) {
            System.out.println("Error Fatal");
        }
        
      return col;  
    }
    
    public static void consulta(Collection col,String consulta){       
        try {
            XPathQueryService S = (XPathQueryService) col.getService("XPathQueryService","1.0");
            ResourceSet result=S.query(consulta);
            ResourceIterator i = result.getIterator();
            
            while(i.hasMoreResources()){
                Resource r = i.nextResource();
                System.out.println(r.getContent());
                
            }
        } catch (XMLDBException ex) {
            Logger.getLogger(Herramientas2.class.getName()).log(Level.SEVERE, null, ex);
        }              
    }
    
     public static void operarxml(Collection col,String consulta,String modificacion){       
        try {
            XPathQueryService S = (XPathQueryService) col.getService("XPathQueryService","1.0");
            ResourceSet result=S.query(consulta);
            ResourceSet operacion=S.query(modificacion);
            ResourceIterator i = operacion.getIterator();
            
            while(i.hasMoreResources()){
                Resource r = i.nextResource();
                System.out.println(r.getContent());               
            }
            
            consulta(col,consulta);
            
        } catch (XMLDBException ex) {
            Logger.getLogger(Herramientas2.class.getName()).log(Level.SEVERE, null, ex);
        }              
    }
     
     public static Connection connectToDataBase(){
         Connection c=null;
         
         try{
             
             Class.forName("org.sqlite.JDBC");
             c=DriverManager.getConnection(("jdbc:sqlite:c:\\sqlite3\\ejemplo.db"));
             System.out.println("Conexion Establecida");                       
             
         }catch(Exception e){
                 System.out.println("Error");          
                 }
          
         return c;
     }
     
     public static void select(Connection c,String consulta){
         
        try {
            Statement stat = c.createStatement();
            ResultSet rs = stat.executeQuery(consulta);
                while(rs.next()){               
                    int id = rs.getInt(1);
                    String nom = rs.getString(2);                  
                    System.out.println("id: "+id);
                    System.out.println("Nombre: "+nom);                   
                }
            
        } catch (SQLException ex) {
            Logger.getLogger(Herramientas2.class.getName()).log(Level.SEVERE, null, ex);
        }                           
     }
     
     public static void WhereSelect(Connection c,String consulta){
         
        try {
            PreparedStatement stat = c.prepareStatement(consulta);
            stat.setString(1,"%e");
            ResultSet rs = stat.executeQuery();
                while(rs.next()){               
                    System.out.println(rs.getString(1));
                }
            
        } catch (SQLException ex) {
            Logger.getLogger(Herramientas2.class.getName()).log(Level.SEVERE, null, ex);
        }                           
     }
     
     public static void crearTabla(Connection c){
        try {
            
            Statement stat = c.createStatement();
            String tabla = "CREATE TABLE java2(id int(3) primary key not null,nombre varchar(20))";
            
            stat.executeUpdate(tabla);
            
            
            stat.close();
            System.out.println("Tabla Creado");
        } catch (SQLException ex) {
            Logger.getLogger(Herramientas2.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
    public static void InsertData(Connection c,String in){
        try {
            
            PreparedStatement stat = c.prepareStatement(in);
            stat.setInt(1,100);
            stat.setString(2, "Lenguaje");
            stat.executeUpdate();
                                    
            stat.close();
            c.close();
            System.out.println("Tabla Creado");
        } catch (SQLException ex) {
            Logger.getLogger(Herramientas2.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
    
    public static void InsertArray(Connection c,String in,String[] on,int[] on1){
        try {  
                        
            PreparedStatement stat = c.prepareStatement(in);
            for (int i=0;i<on.length;i++){
                stat.setInt(1,on1[i]);
                stat.setString(2, on[i]);                     
            stat.executeUpdate();  
            }
            
            stat.close();
            c.close();
            System.out.println("Tabla Creado");
        } catch (SQLException ex) {
            Logger.getLogger(Herramientas2.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    
}
