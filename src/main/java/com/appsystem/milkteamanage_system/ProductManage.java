/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.appsystem.milkteamanage_system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class ProductManage extends JFrame {
    public ProductManage() {
        setTitle("Product Management");
        setSize(900, 700); 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Main panel with a pinkish background
        JPanel mainPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                GradientPaint gp = new GradientPaint(0, 0, new Color(230, 128, 128), 0, getHeight(), new Color(200, 100, 100));
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Header
        JLabel headerLabel = new JLabel("Product Management");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setBorder(new EmptyBorder(0, 10, 10, 0));
        mainPanel.add(headerLabel, BorderLayout.NORTH);

        // Placeholder for stats cards
        JPanel statsPlaceholder = new JPanel(new BorderLayout());
        statsPlaceholder.setOpaque(false);
        statsPlaceholder.setBorder(new LineBorder(new Color(200, 200, 200), 1));
        JLabel placeholderLabel = new JLabel("Stats Cards (Placeholder)", SwingConstants.CENTER);
        placeholderLabel.setFont(new Font("Arial", Font.BOLD, 18));
        placeholderLabel.setForeground(Color.WHITE);
        statsPlaceholder.add(placeholderLabel, BorderLayout.CENTER);
        mainPanel.add(statsPlaceholder, BorderLayout.CENTER);

        add(mainPanel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ProductManage productManage = new ProductManage();
            productManage.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
