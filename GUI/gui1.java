// package src.GUI;

import javax.swing.JOptionPane;

public class gui1 {
    public static void main(String[] args){
    
        String name = JOptionPane.showInputDialog("Enter your name");
        // JOptionPane.showMessageDialog(null,"Hello "+name);
        
        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age"));
        // JOptionPane.showMessageDialog(null,"You are "+age+" year old");

        double hight = Double.parseDouble(JOptionPane.showInputDialog("Enter your hight"));
        // JOptionPane.showMessageDialog(null,"Hello "+hight+" inch tall");
    
        System.out.println("Hello "+name+" you are "+age+" year old and "+hight+" inch tall");
    }
}