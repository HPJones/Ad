
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlumnoT
 */
public class codigoexistdb {
    
    public static void main(String args[]){
        
        
        
            Collection col = null;
            String db = "prueba";
            String username = "admin";
            String password = "root";
            String consulta = "for $a in //libro return $a";
            
            String modificacion = "for $a in //libro/precio\n"+
            "where $a/../autor/apellido[.='Abiteboul']\n"+
            "return update value $a with '0.0'";
            
            col = Herramientas2.Herramientas2.conectar(db,username, password);
            
            
            //Sintaxis de java xpath
            
            Herramientas2.Herramientas2.operarxml(col, consulta, modificacion);
            
           //Herramientas2.Herramientas2.consulta(col,consulta);
        
            
        
        
        
    }
    
    
    
}
