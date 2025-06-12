package com.appsystem.milkteamanage_system.Utils;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class TableBackGroundRender extends DefaultTableCellRenderer {
    private static final Color EVEN_ROW_COLOR = new Color(240, 248, 255); // Alice Blue for even rows
    private static final Color ODD_ROW_COLOR = new Color(220, 231, 245); // Light Steel Blue for odd rows
    private static final Color SELECTED_ROW_COLOR = new Color(255, 183, 77); // Light Orange for selected rows
    private static final Color TEXT_COLOR = new Color(44, 62, 80); // Dark Slate Gray for text
    private static final Color SELECTED_TEXT_COLOR = new Color(255, 255, 255); // White for selected text

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        setOpaque(true);

        if (hasFocus) {
            // Orange border for focused cells
            setBorder(BorderFactory.createLineBorder(SELECTED_ROW_COLOR, 1));
        } else {
            setBorder(null);
        }

        if (isSelected) {
            // Orange background for selected rows
            cell.setBackground(SELECTED_ROW_COLOR);
            cell.setForeground(SELECTED_TEXT_COLOR);
        } else {
            // Alternate row colors
            cell.setBackground(row % 2 == 0 ? EVEN_ROW_COLOR : ODD_ROW_COLOR);
            cell.setForeground(TEXT_COLOR);
        }

        return cell;
    }
}