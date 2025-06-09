/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.appsystem.milkteamanage_system;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author Admin
 */
public class Home extends javax.swing.JFrame {

    private JPanel mainContentPanel;
    private JButton activeButton; 
    private JButton dashboardButton;
    private JButton usersButton;
    private JButton productsButton;
    private JButton ordersButton;
    private JButton statsButton;
    private JButton testButton;
    private JButton optionsButton;
    private JButton logoutButton;

    
   public Home() throws IOException {
        setTitle("Bubble Tea Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        
        // Main BorderLayout with root background
       setLayout(new BorderLayout());
        JPanel rootPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                g2d.setPaint(new Color(240, 242, 245)); // -fx-background-color: #f0f2f5
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        setContentPane(rootPanel);

        // Sidebar (equivalent to .sidebar)
        JPanel sidebar = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                GradientPaint gp = new GradientPaint(0, 0, new Color(0, 180, 219), 0, getHeight(), new Color(0, 131, 176)); // -fx-primary-gradient-start/end
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setPreferredSize(new Dimension(280, getHeight()));
        sidebar.setBorder(new EmptyBorder(0, 0, 0, 0));

        // Logo container
        JPanel logoContainer = new JPanel(new BorderLayout(15, 0)) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setPaint(new Color(255, 255, 255, 25)); // rgba(255,255,255,0.1)
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        logoContainer.setOpaque(false);
        logoContainer.setBorder(new EmptyBorder(5, 10, 5, 10)); // Reduced top/bottom padding to 5px
        logoContainer.setPreferredSize(new Dimension(280, 200)); // Set fixed height to 50px
        logoContainer.setMaximumSize(new Dimension(280, 200)); // Enforce height limit
        JLabel logoImage = new JLabel();
        logoImage.setIcon(loadAndResizeIcon("src/main/images/milk-tea.png", 30, 30)); // Reduced icon size to 30x30px
        logoImage.setHorizontalAlignment(SwingConstants.CENTER);
        logoImage.setOpaque(false);
        JLabel logoLabel = new JLabel("Chào bạn, Admin");
        logoLabel.setFont(new Font("Segoe UI", Font.BOLD, 18)); // Reduced font size to 18pt
        logoLabel.setForeground(Color.WHITE);
        logoContainer.add(logoImage, BorderLayout.WEST);
        logoContainer.add(logoLabel, BorderLayout.CENTER);

        // Main Menu
        JPanel mainMenu = new JPanel();
        mainMenu.setLayout(new BoxLayout(mainMenu, BoxLayout.Y_AXIS));
        mainMenu.setOpaque(false);
        mainMenu.setBorder(new EmptyBorder(20, 0, 20, 0)); // Reduced right padding
        JLabel mainMenuHeader = new JLabel("MAIN MENU");    
        mainMenuHeader.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainMenuHeader.setFont(new Font("Segoe UI", Font.BOLD, 13)); // -fx-font-size: 13px
        mainMenuHeader.setForeground(new Color(255, 255, 255, 179)); // rgba(255,255,255,0.7)
//        mainMenuHeader.setBorder(new EmptyBorder(10, 0, 5, 0)); // Reduced right padding
        mainMenu.add(mainMenuHeader);
        mainMenu.add(Box.createVerticalStrut(10));

        // Navigation buttons
        dashboardButton = createNavButton("Dashboard", "🏠", e -> {
            showDashboard();
            setActiveButton(dashboardButton);
        });
        mainMenu.add(dashboardButton);
        mainMenu.add(createSeparator());
        usersButton = createNavButton("Quản Lí Nhân Viên", "user-icon.png", e -> {
            showUsersManage();
            setActiveButton(usersButton);
        });
        mainMenu.add(usersButton);
        mainMenu.add(createSeparator());
        productsButton = createNavButton("Quản Lí Hàng Hoá", "mug-icon.png", e -> {
            showProductsManage();
            setActiveButton(productsButton);
        });
        mainMenu.add(productsButton);
        mainMenu.add(createSeparator());
        ordersButton = createNavButton("Quản Lí Đơn Hàng", "receipt-icon.png", e -> {
            showOrdersManage();
            setActiveButton(ordersButton);
        });
        mainMenu.add(ordersButton);
        mainMenu.add(createSeparator());
        statsButton = createNavButton("Thống Kê", "chart-icon.png", e -> setActiveButton(statsButton));
        mainMenu.add(statsButton);

        // Additional Menu
        JPanel additionalMenu = new JPanel();
        additionalMenu.setLayout(new BoxLayout(additionalMenu, BoxLayout.Y_AXIS));
        additionalMenu.setOpaque(false);
        additionalMenu.setBorder(new EmptyBorder(20, 10, 20, 10)); // Reduced right padding
        JLabel additionalMenuHeader = new JLabel("MY DATA");
        additionalMenuHeader.setAlignmentX(Component.CENTER_ALIGNMENT);
        additionalMenuHeader.setFont(new Font("Segoe UI", Font.BOLD, 13));
        additionalMenuHeader.setForeground(new Color(255, 255, 255, 179));
        additionalMenuHeader.setBorder(new EmptyBorder(10, 15, 5, 15)); // Reduced right padding
        additionalMenu.add(additionalMenuHeader);
        additionalMenu.add(Box.createVerticalStrut(5));
        testButton = createNavButton("TEST", "plus-icon.png", e -> setActiveButton(testButton));
        additionalMenu.add(testButton);
        additionalMenu.add(createSeparator());
        optionsButton = createNavButton("Tuỳ Chọn Khác...", "ellipsis-icon.png", e -> setActiveButton(optionsButton));
        additionalMenu.add(optionsButton);
        additionalMenu.add(createSeparator());
        logoutButton = createNavButton("Đăng Xuất", "logout-icon.png", e ->{ 
        setActiveButton(logoutButton);
        this.dispose();
        });
        additionalMenu.add(logoutButton);

        sidebar.add(logoContainer);
        sidebar.add(mainMenu);
        sidebar.add(additionalMenu);

        // Main content area
        mainContentPanel = new JPanel(new BorderLayout());
        mainContentPanel.setBackground(new Color(240, 242, 245)); // -fx-background-color: #f0f2f5

        // Add components to frame
        rootPanel.add(sidebar, BorderLayout.WEST);
        rootPanel.add(mainContentPanel, BorderLayout.CENTER);

        // Show dashboard by default and set active button
        showDashboard();
        setActiveButton(dashboardButton);
    }
     private ImageIcon loadAndResizeIcon(String iconPath, int width, int height) throws IOException {
         // Kiểm tra nếu iconPath là emoji
         if (iconPath.length() <= 2 && Character.isHighSurrogate(iconPath.charAt(0))) {
             // Tạo icon từ emoji
             return createEmojiIcon(iconPath, width, height);
         }
         // Load image file
         File iconFile = new File(iconPath);
         if (!iconFile.exists()) {
             System.out.println("Icon file not found: " + iconPath);
             return createDefaultIcon(width, height);
         }
         BufferedImage originalImage = ImageIO.read(iconFile);
         if (originalImage == null) {
             System.out.println("Could not read image: " + iconPath);
             return createDefaultIcon(width, height);
         }
         // Resize image with high quality
         Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
         return new ImageIcon(resizedImage);
    }
    
    // Create emoji icon
    private ImageIcon createEmojiIcon(String emoji, int width, int height) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setFont(new Font("Segoe UI Emoji", Font.PLAIN, width - 8));
        FontMetrics fm = g2d.getFontMetrics();
        int x = (width - fm.stringWidth(emoji)) / 2;
        int y = ((height - fm.getHeight()) / 2) + fm.getAscent();
        g2d.drawString(emoji, x, y);
        g2d.dispose();
        return new ImageIcon(image);
    }
    
    // Create default icon when image loading fails
    private ImageIcon createDefaultIcon(int width, int height) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(new Color(255, 255, 255, 100));
        g2d.fillRoundRect(2, 2, width-4, height-4, 4, 4);
        g2d.setColor(new Color(255, 255, 255, 150));
        g2d.drawRoundRect(2, 2, width-4, height-4, 4, 4);
        g2d.dispose();
        return new ImageIcon(image);
    }
    

    private JButton createNavButton(String text, String iconPath, java.awt.event.ActionListener action) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                if (getModel().isRollover()) {
                    g2d.setColor(new Color(255, 255, 255, 38)); // -fx-background-color: rgba(255,255,255,0.15) on hover
                    g2d.fillRect(0, 0, getWidth(), getHeight());
                }
                if (getModel().isPressed()) {
                    g2d.setColor(new Color(255, 255, 255, 51)); // -fx-background-color: rgba(255,255,255,0.2) on pressed
                    g2d.fillRect(0, 0, getWidth(), getHeight());
                }
                if (this == activeButton) {
                    g2d.setColor(new Color(255, 255, 255, 64)); // -fx-background-color: rgba(255,255,255,0.25) for active
                    g2d.fillRect(0, 0, getWidth(), getHeight());
                    g2d.setColor(new Color(255, 210, 0)); // -fx-border-color: #ffd200
                    g2d.fillRect(0, 0, 4, getHeight()); // -fx-border-width: 0 0 0 4px
                }
            }
        };
        button.setFont(new Font("Segoe UI", Font.PLAIN, 14)); // -fx-font-size: 14px
        button.setForeground(Color.WHITE); // -fx-text-fill: white
        button.setContentAreaFilled(false);
        button.setBorder(new EmptyBorder(10, 15, 10, 15)); // Reduced left and right padding to 5px
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setFocusPainted(false);   
     
        button.setMaximumSize(new Dimension(280, 40)); // Adjusted to fit within 280px sidebar minus padding
        button.setPreferredSize(new Dimension(280, 40));
        button.setIcon(new ImageIcon(iconPath)); // Placeholder: replace with actual icon
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setIconTextGap(10); // Reduced from 15 to 10 for better fit
        if (action != null) {
            button.addActionListener(action);
        }
        return button;
    }


    private JSeparator createSeparator() {
        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(224, 224, 224)); // -fx-border-color: #e0e0e0
        separator.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
        separator.setOpaque(false);
        return separator;
    }

    private void setActiveButton(JButton button) {
        if (activeButton != null) {
            activeButton.repaint(); // Clear previous active state
        }
        activeButton = button;
        button.repaint(); // Apply active state
    }

    private void showDashboard() {
        mainContentPanel.removeAll();
        Dashboard dashboardPanel = new Dashboard();
        mainContentPanel.add(dashboardPanel.getContentPane(), BorderLayout.CENTER);
        mainContentPanel.revalidate();
        mainContentPanel.repaint();
    }


     private void showUsersManage() {
        mainContentPanel.removeAll();
        UserManage userManagePanel = new UserManage();
        mainContentPanel.add(userManagePanel.getContentPane(), BorderLayout.CENTER);
        mainContentPanel.revalidate();
        mainContentPanel.repaint();
    }

    private void showProductsManage() {
        mainContentPanel.removeAll();
        ProductManage productManagePanel = new ProductManage();
        mainContentPanel.add(productManagePanel.getContentPane(), BorderLayout.CENTER);
        mainContentPanel.revalidate();
        mainContentPanel.repaint();
    }

    private void showOrdersManage() {
        mainContentPanel.removeAll();
        JLabel placeholder = new JLabel("Orders Management (Placeholder)", SwingConstants.CENTER);
        placeholder.setFont(new Font("Segoe UI", Font.BOLD, 18));
        mainContentPanel.add(placeholder, BorderLayout.CENTER);
        mainContentPanel.revalidate();
        mainContentPanel.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
        try {
            UIManager.setLookAndFeel("com.formdev.flatlaf.FlatLightLaf"); // Optional: modern look
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            Home home = null;
            try {
                home = new Home();
            } catch (IOException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
            home.setVisible(true);
        });
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

              
