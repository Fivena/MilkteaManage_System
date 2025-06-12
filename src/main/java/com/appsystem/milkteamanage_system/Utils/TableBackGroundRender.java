package com.appsystem.milkteamanage_system.Utils;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class TableBackGroundRender extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        setOpaque(true); // Đảm bảo ô bảng không trong suốt
        if (!isSelected) {
            cell.setBackground(new Color(70, 130, 180)); // Màu xanh biển
        } else {
            cell.setBackground(table.getSelectionBackground()); // Giữ màu chọn mặc định
        }
        cell.setForeground(Color.WHITE); // Chữ trắng để dễ đọc trên nền xanh
        return cell;
    }
}