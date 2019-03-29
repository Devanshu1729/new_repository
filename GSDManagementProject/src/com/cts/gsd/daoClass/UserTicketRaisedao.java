package com.cts.gsd.daoClass;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cts.gsd.bean.UserTicketRaisebean;
import com.cts.gsd.connection.DBUtil;
import com.cts.gsd.daoInterface.UserTicketRaiseInterface;

public class UserTicketRaisedao implements UserTicketRaiseInterface {
	
	Connection con=DBUtil.getConnection();
	/*@Override
	public boolean insert(UserTicketRaisebean s) {
		String uid=s.getUSER_ID();
		String gid=s.getGSD_ID();
		String id=s.getIssue_Description();
		String st=s.getStatus();
		boolean status=false;

		try{
			PreparedStatement pst=con.prepareStatement("insert into User_Ticket_Raise values (?,?,?,?)");
			pst.setString(1, uid);
			pst.setString(2, gid);
			pst.setString(3, id);
			pst.setString(4, st);
			int x=pst.executeUpdate();
			if(x>0)
			{
				status=true;
			}
			else
			{
				status=false;
			}


		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return status;
	}

	@Override
    public boolean update(UserTicketRaisebean s) {
           boolean status=false;
           String query="update User_Ticket_Raise set Status=? where User_ID=?";
           try
           {
        	   
        	   String st=s.getStatus();
        	   String uid = s.getUSER_ID();
                  PreparedStatement pst=con.prepareStatement(query);
                               pst.setString(1, st);
                               pst.setString(2, uid);
                          int count=pst.executeUpdate();
                          if(count>0)
                          {
                               status=true;
                          }
                          else
                          {
                               status=false;
                          }
           }
                          catch(SQLException sq)
                          {
                               System.out.println("error in updates");
                          }
           
           return false;
    }
    */
	@Override

	public ArrayList<UserTicketRaisebean> displayAll()
	{
	ArrayList<UserTicketRaisebean> a1= new ArrayList<UserTicketRaisebean>();
	       try
	       {
	              Statement st=con.createStatement();
	              ResultSet rs=st.executeQuery("select * from User_Ticket_Raise");
	              
	              
	              while (rs.next())
	              {
	                    UserTicketRaisebean sb = new UserTicketRaisebean();
	                    sb.setUSER_ID(rs.getString(1));
	                    sb.setGSD_ID(rs.getString(2));
	                    sb.setIssue_Description(rs.getString(3));
	                    sb.setStatus(rs.getString(4));
	                    a1.add(sb);
	              }
	       }
	       catch (SQLException e)
	       {
	              System.out.println("error in display");
	              e.printStackTrace();
	       }
	       
	       return a1;
	}           
}
