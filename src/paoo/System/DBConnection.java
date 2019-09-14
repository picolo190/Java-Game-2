package paoo.System;


import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

public class DBConnection {
    private Connection c=null;
    ArrayList<String> vector= new ArrayList<>();

    public DBConnection(){
        createConnection();
        System.out.println("Opened database successfully");
    }

    public ArrayList<String> getHighScores(){
        try {
            Statement statement = c.createStatement();
            int i=0;

            //Select all the fields from the HighScore table and print the records
            ResultSet rs = statement.executeQuery("SELECT * FROM HIGHSCORE ORDER BY LEVEL DESC, SCORE DESC");
            if(vector.size()==0) {
                while (rs.next() && i < 15) {
                    String namedb = rs.getString("Name");
                    int scoredb = rs.getInt("Score");
                    int leveldb = rs.getInt("Level");
                    vector.add(i + ") Nume: " + namedb + " Level: " + leveldb + " Scor: " + scoredb);
                    ++i;
                }
            }
            else{
                while (rs.next() && i < 15 && i<vector.size()) {
                    String namedb = rs.getString("Name");
                    int scoredb = rs.getInt("Score");
                    int leveldb = rs.getInt("Level");
                    vector.set(i,i + ") Nume: " + namedb + " Level: " + leveldb + " Scor: " + scoredb);
                    ++i;
                }
            }
            statement.close();
            return vector;
        }
        catch(Exception e){
            //codde
            e.printStackTrace();
            System.exit(0);
        }
        return null;
    }

    public void setScore(String name, int score, int level){
        try {
            PreparedStatement stmt = c.prepareStatement("INSERT INTO HIGHSCORE(NAME, SCORE, LEVEL) VALUES(?, ?, ?)");

            stmt.setString(1,name);
            stmt.setString(2, score+"");
            stmt.setString(3, level+"");
            int rowInserted=stmt.executeUpdate();
            System.out.println(rowInserted);
            stmt.close();
        }
        catch ( Exception e1) {
            e1.printStackTrace();
            System.exit(0);
        }
    }

    public void createConnection(){
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:game.db");
            //c.setAutoCommit(false);
        }
        catch(Exception e){
            //Exception handler
            e.printStackTrace();
            System.exit(0);
        }
    }


}
