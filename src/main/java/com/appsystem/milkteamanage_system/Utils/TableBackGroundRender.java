package com.appsystem.milkteamanage_system.Utils;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class  TableBackGroundRender   extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        // Áp dụng màu xanh lá cho cột "Name" (cột 0) và "Email" (cột 1)
        if (column == 0 || column == 1) {
            cell.setForeground(Color.GREEN);
        } else {
            cell.setForeground(table.getForeground()); // Giữ màu chữ mặc định cho các cột khác
        }
        return cell;
    }
}