package com.cts.gsd.daoClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cts.gsd.bean.AdminRegistrationBean;
import com.cts.gsd.connection.DBUtil;
import com.cts.gsd.daoInterface.AdminRegistrationInterface;

public class AdminRegistrationDao implements AdminRegistrationInterface {
	Connection con = DBUtil.getConnection();
	@Override
	public String insert(AdminRegistrationBean rg) {
		String fname = rg.getAdmin_First_Name();
		String lname = rg.getAdmin_Last_Name();
		String age = rg.getAge();
		String gender = rg.getGender();
		String c_no = rg.getContact_Number();
		String password = rg.getPassword();
		int temp = autoGenerate();
		String adminid = fname.substring(0,3) + temp;

		String status = null;

		try {
			System.out.println("inside try of dao insert");     
					PreparedStatement ps = con.prepareStatement("insert into Admin_Registration values(?,?,?,?,?,?,?)");
					ps.setString(1, fname);
					ps.setString(2, lname);
					ps.setString(3, age);
					ps.setString(4, gender);
					ps.setString(5, c_no);
					ps.setString(6, adminid);
					ps.setString(7,password);
					int x = ps.executeUpdate();
					System.out.println("after execution insert");
					if(x > 0)
						status = adminid;
					else
						status = null;

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return status;
	}
//------------------------------------------------------------
	@Override
	public boolean login_check(AdminRegistrationBean s) {
		String adminid = s.getAdmin_ID();
		String password = s.getPassword();
		System.out.println(adminid+"IN LOGIN CHECK");
System.out.println(password+"in login check");
		boolean status = false;

		try {
			PreparedStatement pst=con.prepareStatement("select * from Admin_Registration where Admin_ID = ? and Password = ?");
			pst.setString(1, adminid);
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
//---------------------------
	@Override
	public ArrayList<AdminRegistrationBean> displayAll() {
		ArrayList<AdminRegistrationBean> a1= new ArrayList<AdminRegistrationBean>();
		try {
			Statement st =  con.createStatement();
			ResultSet rs =  st.executeQuery("select User_ID,Password from User_Registration");

			while (rs.next()) {
				AdminRegistrationBean sb= new AdminRegistrationBean();
				sb.setAdmin_ID(rs.getString(1));
				sb.setPassword(rs.getString(2));
				a1.add(sb);
			}
		} catch (SQLException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
		return a1;
	}
//-----------------
	@Override
	public int autoGenerate() {
		int val = 0;
        try {
               
               Statement st = con.createStatement();
               ResultSet rs = st.executeQuery("select admin_sq.nextval from dual");
               
               while(rs.next()) {
                     
                     val = rs.getInt(1);
               }
        } catch(SQLException q) {
               q.printStackTrace();
        }
        
        return val;

	}

}
