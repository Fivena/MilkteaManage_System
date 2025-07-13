/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appsystem.milkteamanage_system.Utils;

/**
 *
 * @author Admin
 */
public class FormatCurrency {
    public static String formatCurrency(double amount) {
        return new java.text.DecimalFormat("#,###").format(amount) + "đ";
    }
}
