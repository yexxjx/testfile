package test.model.dao;

import test.model.dto.ProductDto;

import java.sql.*;
import java.util.ArrayList;

public class ProductDao {
    private ProductDao(){connect();}
    private static final ProductDao instance=new ProductDao();
    public static ProductDao getInstance(){return instance;}

    private String url="jdbc:mysql://localhost:3306/test";
    private String user="root"; private String password="1234";
    private Connection conn;
    private void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection(url, user, password);
            System.out.println("[준비] 데이터베이스 연동 성공");
        }catch(Exception e){
            System.out.println("[경고] 데이터베이스 연동 실패 : 관리자에게 문의");}
    }

    public boolean create(String pnick, String pname, String pcomment, int pprice, String ppw, String pphone){
        try {
            String sql = "insert into product(pnick,pname,pcomment,pprice,ppw,pphone) values(?,?,?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,pnick);
            ps.setString(2,pname);
            ps.setString(3, pcomment);
            ps.setInt(4, pprice);
            ps.setString(5, ppw);
            ps.setString(6, pphone);
            int count=ps.executeUpdate();
            if(count==1){return true;}
            else{return false;}
        }catch(SQLException e){
            System.out.println("[시스템오류] SQL 문법 문제 발생:"+e);}
        return false;
    }

    public ArrayList<ProductDto> read() {
        ArrayList<ProductDto> products = new ArrayList<>();
        try {
            String sql = "select*from product";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int pno = rs.getInt("pno");
                String pnick= rs.getString("pnick");
                String pname = rs.getString("pname");
                String pcomment = rs.getString("pcomment");
                int pprice = rs.getInt("pprice");
                String ppw = rs.getString("ppw");
                String pphone = rs.getString("pphone");
                ProductDto productDto=new ProductDto(pno,pnick,pname,pcomment,pprice,ppw,pphone);
                products.add(productDto);
            }
        } catch (SQLException e) {
            System.out.println("[시스템오류] SQL 문법 문제 발생" + e);
        }
        return products;
    }

    public boolean update(String pname, String pcomment, int pprice, String pphone){
        try{
            String sql="update product set pname = ?, pcomment = ?, pprice = ? where pphone = ?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, pname);
            ps.setString(2, pcomment);
            ps.setInt(3, pprice);
            ps.setString(4, pphone);
            int count=ps.executeUpdate();
            if(count==1){return true;}
            else{return false;}
        }catch(SQLException e){
            System.out.println("[시스템오류] SQL 문법 문제 발생"+e);}
        return false;
    }

    public boolean delete(int pno){
        try {
            String sql = "delete from product where pno=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,pno);
            int count=ps.executeUpdate();
            if(count==1){return true;}
            else{return false;}
        }catch(SQLException e){
            System.out.println("[시스템오류] SQL 문법 문제 발생"+e);
        } return false;
    }

}
