/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Carlos
 */
public class Conexion {

    Connection conexion;
    Statement st;

    public Connection getConexion() {
        return conexion;
    }

    public Statement getSt() {
        return st;

    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public Conexion() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            //String BaseDeDatos = "jdbc:oracle:thin:@localhost:1521:sysdba";
            
            String BaseDeDatos = "jdbc:oracle:thin:@//192.168.1.7:1521/prueba";
            conexion = DriverManager.getConnection(BaseDeDatos, "banco", "bancoexamen");
            if (conexion != null) {
                System.out.println("Conexion exitosa ");
                st = getConexion().createStatement();
            } else {
                System.out.println("Conexion fallida");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        
    }

}
