/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlumnoT
 */
public class ConexionBaseDatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        
        String consulta = "select * from java2";
        
        String insert = "insert into java2 values(?,?)";
        
        String[] valores = {"Programacion","Script","0.0","Paradigma"};
        
        int[] valores1 = {102,103,104,105};
              
        
        //Herramientas2.Herramientas2.select(Herramientas2.Herramientas2.connectToDataBase(),"select * from eje1");
        
        //Herramientas2.Herramientas2.crearTabla(Herramientas2.Herramientas2.connectToDataBase());
        
        //Herramientas2.Herramientas2.WhereSelect(Herramientas2.Herramientas2.connectToDataBase(),consulta);
        
        //Herramientas2.Herramientas2.crearTabla(Herramientas2.Herramientas2.connectToDataBase());
        
        //Herramientas2.Herramientas2.InsertData(Herramientas2.Herramientas2.connectToDataBase(),"insert into java2 values(?,?)");
        
        
        
        Herramientas2.Herramientas2.InsertArray(Herramientas2.Herramientas2.connectToDataBase(),insert, valores,valores1);
        
        Herramientas2.Herramientas2.select(Herramientas2.Herramientas2.connectToDataBase(),consulta);
        
        
    }
    
}
