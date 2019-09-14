package paoo.System;

import javax.swing.*;
import java.sql.*;

public class DBConnection {
    private Connection c=null;

    public DBConnection(){
        createConnection();
        System.out.println("Opened database successfully");
    }

    public void getHighScores(JPanel panel){
        try {
            Statement statement = c.createStatement();
            int i=1;

            //Select all the fields from the HighScore table and print the records
            ResultSet rs = statement.executeQuery("SELECT * FROM HIGHSCORE ORDER BY LEVEL DESC, SCORE DESC");
            while(rs.next() && i<=15) {
                String namedb = rs.getString("Name");
                int scoredb = rs.getInt("Score");
                int leveldb = rs.getInt("Level");
                JLabel temp = new JLabel(i + ") Nume: " + namedb + " Level: " + leveldb + " Scor: " + scoredb);
                temp.setBounds(Renderer.WIDTH * 3 / 4, 25 + (i * 25), 500, 25);
                panel.add(temp);
                temp.setVisible(true);
                ++i;
            }
        }
        catch(Exception e){
            //codde
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void setScore(String name, int score, int level){
        try {
            PreparedStatement stmt = c.prepareStatement("INSERT INTO HIGHSCORE(NAME, SCORE, LEVEL) VALUES(?, ?, ?)");

            stmt.setString(1,name);
            stmt.setString(2, score+"");
            stmt.setString(3, level+"");
            int rowInserted=stmt.executeUpdate();
            System.out.println(rowInserted);

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
            c.setAutoCommit(false);
        }
        catch(Exception e){
            //Exception handler
            e.printStackTrace();
            System.exit(0);
        }
    }


}
