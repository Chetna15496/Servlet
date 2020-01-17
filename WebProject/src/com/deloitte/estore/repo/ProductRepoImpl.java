package com.deloitte.estore.repo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.deloitte.estore.model.Product;

@SuppressWarnings("unused")
public class ProductRepoImpl implements ProductRepo {

	@Override
	public boolean addProduct(Product product) throws Exception {
		Connection con = getDbConnection();
		PreparedStatement ps= con.prepareStatement("insert into product values(?,?,?)");
		ps.setInt(1,product.getProductId());
		ps.setString(2,product.getProductName());
		ps.setFloat(3,product.getPrice());
		if(ps.executeUpdate()>0)
			return true;
		return false;
	}



	@Override
	public boolean deleteProduct(Product product) throws Exception {
		Connection con = getDbConnection();
		PreparedStatement ps= con.prepareStatement("delete from product where product_id =?");
		ps.setInt(1,product.getProductId());
		if(ps.executeUpdate()>0)
			return true;
		return false;
	
	}

	@Override
	public boolean updateProduct(Product product) throws Exception {
		Connection con = getDbConnection();
		PreparedStatement ps= con.prepareStatement("update product set product_name=?,price=? where product_id=?");
		ps.setString(1,product.getProductName());
		ps.setFloat(2,product.getPrice());
		ps.setInt(3,product.getProductId());
		ps.executeUpdate();
			return true;
		
	}

	@Override
	public Product getProductById(int productId) throws Exception {
		Connection con = getDbConnection();
		Statement st= con.createStatement();
	    ResultSet rs=st.executeQuery("select * from product where product_id="+productId);
		//PreparedStatement ps= con.prepareStatement("select * from product where product_id=?");
		Product p=new Product();
		if(rs.next()) {
			p.setProductId(rs.getInt(1));
			p.setProductName(rs.getString(2));
			p.setPrice(rs.getFloat(3));
			return p;}
		return null;
		}
		
	
	

	@Override
	public List<Product> getAllProducts() throws Exception {
		Connection con = getDbConnection();
		PreparedStatement ps=con.prepareStatement("select * from product");
	    ResultSet rs=ps.executeQuery();
	    List<Product> products=new ArrayList<>();
	    while(rs.next()) {
	    	Product p= new Product();
	    	p.setProductId(rs.getInt("product_id"));
	    	p.setProductName(rs.getString("product_name"));
	    	p.setPrice(rs.getFloat("price"));
	    	products.add(p);
	    }
	    return products;
	}

	@Override
	public Connection getDbConnection() throws Exception {
	Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
	return con;
		
	}

}
