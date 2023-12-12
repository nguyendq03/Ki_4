/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Product;

/**
 *
 * @author Admin
 */
public class ProductDao extends DBContext {

    public List<Product> findAll() {
        try {
            String sql = "select p.name as productName," +
                " Description, Price," +
                " s.Name as supplierName" +
                " from Products p" +
                " inner join Suppliers s" +
                " on p.SupplierID = s.ID";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            List<Product> products = new ArrayList<>();
            while (rs.next()) {
                Product product = new Product();
                product.setName(rs.getString("productName"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getFloat("price"));
                product.setSupplierName(rs.getString("supplierName"));
                products.add(product);
            }
            return products;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
}
