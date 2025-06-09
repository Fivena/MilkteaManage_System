/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.appsystem.milkteamanage_system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class UserManage extends JFrame {
    public UserManage() {
        setTitle("User Management");
        setSize(900, 700); // Default size, will be overridden by parent
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Main panel with a light background
        JPanel mainPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                GradientPaint gp = new GradientPaint(0, 0, new Color(240, 248, 255), 0, getHeight(), new Color(200, 220, 255));
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Header
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        headerPanel.setOpaque(false);
        JLabel headerLabel = new JLabel("User Management");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headerLabel.setForeground(new Color(30, 30, 30));
        headerPanel.add(headerLabel);
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // Center panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setOpaque(false);
        centerPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Search bar
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        searchPanel.setOpaque(false);
        JLabel searchLabel = new JLabel("Search:");
        searchLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        JTextField searchField = new JTextField("Enter username or email...");
        searchField.setFont(new Font("Arial", Font.PLAIN, 14));
        searchField.setPreferredSize(new Dimension(300, 30));
        searchField.setForeground(new Color(100, 100, 100));
        searchField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (searchField.getText().equals("Enter username or email...")) {
                    searchField.setText("");
                    searchField.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (searchField.getText().isEmpty()) {
                    searchField.setText("Enter username or email...");
                    searchField.setForeground(new Color(100, 100, 100));
                }
            }
        });
        JButton searchButton = new JButton("Search");
        searchButton.setFont(new Font("Arial", Font.PLAIN, 14));
        searchButton.setBackground(new Color(70, 130, 180));
        searchButton.setForeground(Color.WHITE);
        searchButton.setBorder(new LineBorder(new Color(50, 100, 150), 1));
        searchPanel.add(searchLabel);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        // Table
        String[] columnNames = {"Tên", "Email", "Vai Trò", "Trạng thái"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable userTable = new JTable(tableModel);
        userTable.setFillsViewportHeight(true);
        userTable.setBackground(Color.WHITE);
        userTable.setGridColor(new Color(200, 200, 200));
        userTable.setFont(new Font("Arial", Font.PLAIN, 14));
        userTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        userTable.getTableHeader().setBackground(new Color(70, 130, 180));
        userTable.getTableHeader().setForeground(Color.WHITE);
        JScrollPane tableScrollPane = new JScrollPane(userTable);
        tableScrollPane.setBorder(new LineBorder(new Color(70, 130, 180), 2));

        centerPanel.add(searchPanel);
        centerPanel.add(Box.createVerticalStrut(20));
        centerPanel.add(tableScrollPane);

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // Bottom buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        buttonPanel.setOpaque(false);
        buttonPanel.setBorder(new EmptyBorder(10, 0, 10, 0));
        JButton addButton = new JButton("Add User");
        addButton.setFont(new Font("Arial", Font.PLAIN, 14));
        addButton.setBackground(new Color(34, 139, 34));
        addButton.setForeground(Color.WHITE);
        JButton editButton = new JButton("Edit User");
        editButton.setFont(new Font("Arial", Font.PLAIN, 14));
        editButton.setBackground(new Color(255, 140, 0));
        editButton.setForeground(Color.WHITE);
        JButton deleteButton = new JButton("Delete User");
        deleteButton.setFont(new Font("Arial", Font.PLAIN, 14));
        deleteButton.setBackground(new Color(220, 20, 60));
        deleteButton.setForeground(Color.WHITE);
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

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
            UserManage userManage = new UserManage();
            userManage.setVisible(true);
        });
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
