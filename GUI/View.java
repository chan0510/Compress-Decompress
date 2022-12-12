package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import Codefiles.Compress;
import Codefiles.Decompress;

public class View extends JFrame implements ActionListener  {
    JButton compressButton;
    JButton decomprressButton;
    View(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,300);
        this.getContentPane().setBackground(Color.darkGray);
        this.setLayout(null);
        compressButton=new JButton("Select File to Compress");
        compressButton.setBounds(20,200,200,30);
        compressButton.addActionListener(this);
        decomprressButton=new JButton("Select File to Decompress");
        decomprressButton.setBounds(250,200,200,30);
        decomprressButton.addActionListener(this);
        this.add(compressButton);
        this.add(decomprressButton);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==compressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file=new File(fileChooser.getSelectedFile().getAbsolutePath());
                try{
                    Compress.compressFunction(file);
                }
                catch (Exception excp){
                    JOptionPane.showMessageDialog(null,excp.toString());
                }
            }
        }
        if(e.getSource()==decomprressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file=new File(fileChooser.getSelectedFile().getAbsolutePath());
                try{
                    Decompress.decompressFunction(file);
                }
                catch (Exception excp){
                    JOptionPane.showMessageDialog(null,excp.toString());
                }
            }
        }
    }

 public  static void main(String[] args){
        View view = new View();
        view.setVisible(true);
 }
}
