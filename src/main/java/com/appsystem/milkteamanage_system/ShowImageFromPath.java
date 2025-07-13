/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appsystem.milkteamanage_system;

/**
 *
 * @author Admin
 */
import javax.swing.*;
import java.awt.*;

public class ShowImageFromPath extends JFrame {

    public ShowImageFromPath() {
        // Cài đặt cửa sổ
        setTitle("Hiển thị ảnh");
        setSize(100, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Canh giữa màn hình

        // ✅ Đường dẫn ảnh (bạn thay bằng đường dẫn thật của bạn)
        String imagePath = "C:\\Users\\Admin\\Desktop\\CodeJAVA\\milkteaManage_system\\src\\main\\Resources\\images\\applogo.png";

        // Tạo ImageIcon từ đường dẫn
        ImageIcon imageIcon = new ImageIcon(imagePath);

        // Tùy chọn: Resize ảnh cho vừa cửa sổ
        Image image = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);

        // Gắn vào JLabel
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);

        // Thêm vào JFrame
        add(imageLabel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ShowImageFromPath());
    }
}