package com.database;
/*
 * Cette classe permet de se connecter a la base de donnee mysql
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * @author ATOUMANE FAYE
 */
public class DB {
    //pour la connexion
    private Connection cnx;
    //pour les resultats des requetes de types SEMECT
    private ResultSet rs;
    //
    private PreparedStatement pstm;
    //pour les resultats des requetes de types mise a jour (INSERT? UPDATE?DELETE)
    private int ok;


    public void getConnetion() {
        String url = "jdbc:mysql://localhost:3306/gestion_projet_java";
        String user = "root";
        String password = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {System.out.println(e.getMessage());}
    }

    public void initPrepare(String sql) {
        try {
            getConnetion();
            pstm = cnx.prepareStatement(sql);
        } catch (Exception e) {System.out.println(e.getMessage());}
    }

    
    public ResultSet executeSelect(String sql) {
        try {
            getConnetion();
            initPrepare(sql);
            rs = pstm.executeQuery();
        } catch (Exception e) {System.out.println(e.getMessage());}
        
        return rs;
    }

    public int executeMaj() {
        try {
            ok = pstm.executeUpdate();
        } catch (Exception e) {System.out.println(e.getMessage());}
        
        return ok;
    }

    public void closeConnection() {
        try {
            if (cnx != null)
                cnx.close();
        } catch (Exception e) {
        }
    }

    public PreparedStatement getPstm() throws SQLException {
        return pstm;
    }

    

}
