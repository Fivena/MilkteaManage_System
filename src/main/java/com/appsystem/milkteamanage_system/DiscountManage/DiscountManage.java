package com.appsystem.milkteamanage_system.DiscountManage;

import java.awt.BorderLayout;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DiscountManage extends JPanel {
    private JTable discountTable;
    private DefaultTableModel model;

    public DiscountManage() {
        setLayout(new BorderLayout());
        JLabel title = new JLabel("Quản Lý Khuyến Mãi", JLabel.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(title, BorderLayout.NORTH);

        // Table setup
        String[] columnNames = {"ID", "Tên", "Mô tả", "Phần trăm", "Ngày bắt đầu", "Ngày kết thúc", "Ngày tạo"};
        model = new DefaultTableModel(columnNames, 0);
        discountTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(discountTable);
        add(scrollPane, BorderLayout.CENTER);

        // Load data
        loadDiscountsFromDatabase();

        // Buttons
        JPanel buttonPanel = new JPanel();
        JButton btnAdd = new JButton("Thêm");
        JButton btnEdit = new JButton("Sửa");
        JButton btnDelete = new JButton("Xoá");
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnEdit);
        buttonPanel.add(btnDelete);
        add(buttonPanel, BorderLayout.SOUTH);

        // TODO: Add action listeners for add/edit/delete
    }

    private void loadDiscountsFromDatabase() {
        model.setRowCount(0); // Clear table
        try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/MilkTea", "postgres", "123456");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Discounts")) {
            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                row.add(rs.getInt("DiscountID"));
                row.add(rs.getString("Name"));
                row.add(rs.getString("Description"));
                row.add(rs.getBigDecimal("DiscountPercent"));
                row.add(rs.getTimestamp("StartDate"));
                row.add(rs.getTimestamp("EndDate"));
                row.add(rs.getTimestamp("CreatedDate"));
                model.addRow(row);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi tải dữ liệu khuyến mãi: " + e.getMessage());
        }
    }
}
