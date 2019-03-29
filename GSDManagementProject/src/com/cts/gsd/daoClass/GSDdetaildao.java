package com.cts.gsd.daoClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cts.gsd.bean.GSDdetailbean;
import com.cts.gsd.connection.DBUtil;

public class GSDdetaildao {
	Connection con=DBUtil.getConnection();

		public boolean insert(GSDdetailbean s) {
			String uid=s.getUSER_ID();
			String gid=s.getGSD_ID();
			String id=s.getIssue_Description();
			String st=s.getStatus();
		

                        boolean status=false;
                        
                        try{
                        PreparedStatement pst=con.prepareStatement("insert into GSD_detail values ('"+uid+"','"+gid+"','"+id+"','initiated')");
                        /*pst.setString(1, uid);
                        pst.setString(2, gid);
                        pst.setString(3, id);
                        pst.setString(4, st);*/
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
		
		

		public ArrayList<GSDdetailbean> displayAll()
		{
		ArrayList<GSDdetailbean> a1= new ArrayList<GSDdetailbean>();
		       try
		       {
		              java.sql.Statement st=con.createStatement();
		              ResultSet rs=st.executeQuery("select * from  GSD_detail");
		              
		              
		              while (rs.next())
		              {
		            	  GSDdetailbean sb = new GSDdetailbean();
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
		
	    public boolean update(GSDdetailbean s) {
	           boolean status=false;
	           String query="update GSD_detail set Status= ? where GSD_ID = ?";
	           try
	           {
	        	   
	        	   String st=s.getStatus();
	        	   String gid = s.getGSD_ID();
	                  PreparedStatement pst=con.prepareStatement(query);
	                               pst.setString(1, st);
	                               pst.setString(2, gid);
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
	    
	    
	    public ArrayList<GSDdetailbean> display(String user_id)
		{
		ArrayList<GSDdetailbean> a2= new ArrayList<GSDdetailbean>();
		       try
		       {
		    	    
		    			   PreparedStatement pst=con.prepareStatement("select * from  GSD_detail where user_id=?");
		    			   pst.setString(1,user_id);
		              ResultSet ra=pst.executeQuery();
		              
		              pst.setString(1,user_id);
		              while (ra.next())
		              {
		            	  GSDdetailbean sn = new GSDdetailbean();
		                    sn.setUSER_ID(ra.getString(1));
		                    sn.setGSD_ID(ra.getString(2));
		                    sn.setIssue_Description(ra.getString(3));
		                    sn.setStatus(ra.getString(4));
		                    a2.add(sn);
		              }
		       }
		       catch (SQLException e)
		       {
		              System.out.println("error in display");
		              e.printStackTrace();
		       }
		       
		       return a2;
}
	    public ArrayList<GSDdetailbean> displayclose(String gsd_id)
		{
		ArrayList<GSDdetailbean> a2= new ArrayList<GSDdetailbean>();
		       try
		       {
		    	    
		    			   PreparedStatement pst=con.prepareStatement("select gsd_id, status from  GSD_detail where gsd_id=? and status='Closed'");
		    			   pst.setString(1,gsd_id);
		    			   
		              ResultSet ra=pst.executeQuery();
		              
		              pst.setString(1,gsd_id);
		              while (ra.next())
		              {
		            	  GSDdetailbean sn = new GSDdetailbean();
		                   
		                    sn.setGSD_ID(ra.getString(1));
		                    
		                    sn.setStatus(ra.getString(2));
		                    a2.add(sn);
		              }
		       }
		       catch (SQLException e)
		       {
		              System.out.println("error in display");
		              e.printStackTrace();
		       }
		       
		       return a2;
}
}
