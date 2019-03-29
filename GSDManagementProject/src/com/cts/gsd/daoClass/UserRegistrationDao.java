package com.cts.gsd.daoClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cts.gsd.bean.UserRegistrationBean;
import com.cts.gsd.connection.DBUtil;
import com.cts.gsd.daoInterface.UserRegistrationInterface;

public class UserRegistrationDao implements UserRegistrationInterface{
	Connection con = DBUtil.getConnection();
	@Override
	public String insert(UserRegistrationBean sb) {
		String fname = sb.getUser_First_Name();
        String lname = sb.getUser_Last_Name();
        String age = sb.getAge();
        String gender = sb.getGender();
        String c_no = sb.getContact_Number();
        String city = sb.getCity();
        String zipcode = sb.getZip_Code();
        
        String password = sb.getPassword();
        int temp = autoGenerate();
		String userid = fname.substring(0,3) + temp;
        String status = null;
        
        try {
                   System.out.println("inside try of dao insert");     
                        PreparedStatement ps = con.prepareStatement("insert into User_Registration values(?,?,?,?,?,?,?,?,?)");
                        ps.setString(1, fname);
                        ps.setString(2, lname);
                        ps.setString(3, age);
                        ps.setString(4, gender);
                        ps.setString(5, c_no);
                        ps.setString(6, city);
                        ps.setString(7, zipcode);
                        ps.setString(8, userid);
                        ps.setString(9,password);
                        int x = ps.executeUpdate();
                        System.out.println("after execution insert");
                        if(x > 0)
                                        status = userid;
                        else
                                        status = null;
                        
        } catch (SQLException e) {
                        
                        e.printStackTrace();
        }
        
        return status;
	}
	//----------------------------------------------
	@Override
	public boolean login_check(UserRegistrationBean s) {

		String userid = s.getUser_ID();
		String password = s.getPassword();
		
		boolean status = false;
		
		try {
			PreparedStatement pst=con.prepareStatement("select * from User_Registration where User_ID=? and Password=?");
			pst.setString(1, userid);
			pst.setString(2,password);
			
			
			ResultSet count = pst.executeQuery();
			
			if(count.next()){
				status = true;
			}
			else
			{
				status = false;
			}
			
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			
			return status;
		}


//------------------------------------------------------
	@Override
	public ArrayList<UserRegistrationBean> displayAll() {
		ArrayList<UserRegistrationBean> a1= new ArrayList<UserRegistrationBean>();
	       try {
	                       Statement st =  con.createStatement();
	                       ResultSet rs =  st.executeQuery("select User_ID,Password from User_Registration");
	                       
	                       while (rs.next()) {
	                    	   UserRegistrationBean sb= new UserRegistrationBean();
	                                       sb.setUser_ID(rs.getString(1));
	                                       sb.setPassword(rs.getString(2));
	                                       a1.add(sb);
	                       }
	       } catch (SQLException e) {
	                       System.out.println("Error");
	                       e.printStackTrace();
	       }
	       return a1;
	}
//----------------------------------------------------------
	@Override
	public int autoGenerate() {
		int val = 0;
	    try {
	           
	           Statement st = con.createStatement();
	           ResultSet rs = st.executeQuery("select user_sq.nextval from dual");
	           
	           while(rs.next()) {
	                 
	                 val = rs.getInt(1);
	           }
	    } catch(SQLException q) {
	           q.printStackTrace();
	    }
	    
	    return val;
	}

}
