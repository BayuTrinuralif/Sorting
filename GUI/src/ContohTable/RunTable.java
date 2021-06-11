package ContohTable;

import javax.swing.*;

public class RunTable {
    public static void main(String[] args) {
        ImageIcon ImageIcon = new ImageIcon("res/icon.jpg");
        JFrame gambar = new JFrame("membuat Table sederhana");
        gambar.setIconImage(ImageIcon.getImage());
        gambar.setContentPane(new Table().getRootPanel1());
        gambar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gambar.setSize(740, 440);
        gambar.setLocationRelativeTo(null);
        gambar.setVisible(true);
    }
}