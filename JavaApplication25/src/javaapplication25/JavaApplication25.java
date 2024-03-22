/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication25;

import java.sql.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Thabiso
 */
public class JavaApplication25 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         try {
            
             
             Connection nb = DriverManager.getConnection("jdbc:mysql://localhost:3306/pointsales", "root", ""); 
             
             Statement abc = nb.createStatement();
             
             ResultSet bca = abc.executeQuery("select * from pointsales");
             
             
                     Scanner s = new Scanner(System.in);
        
        String products = "";
    
        String slip = "";
        
        double total =0;
        ArrayList<product> a = new ArrayList();
        while(bca.next()){
            
            
            a.add(new product(bca.getString("product"),bca.getDouble("price")));
            
        }
        
        

        
        System.out.println("welcome to matuku shop");
        System.out.println("list of products");
        for (int i = 0; i < a.size(); i++) {
            
            System.out.println(i+1 +" " +a.get(i).getName() + " R" + a.get(i).getPrice());
            
        }
        
        System.out.println("select products to buy use numbers");
        
        int next = 1;
        
        while(next !=-1){
        for (int i = 0; i < a.size(); i++) {
            
            System.out.println(i+1 +" " +a.get(i).getName() + " R" + a.get(i).getPrice());
            
        }
            System.out.println("choose");
            
            products += String.valueOf(s.nextInt()-1);
            System.out.println("press any number to choose more products or zero to finish");
            next = s.nextInt() -1;
            
        }
        
        for (int i = 0; i<products.length() ; i++) {
            
            int aa = Integer.parseInt(String.valueOf(products.charAt(i)));
           
            
            slip += a.get(aa).getName() + " " + a.get(aa).getPrice() +"\n";
            
            total +=  a.get(aa).getPrice();
            
            
        }
        
        System.out.println(slip +"\n total  " +total);
             
             
             
             
        } catch (Exception e) {
            
            e.printStackTrace();
        }

        
    
    
}
}