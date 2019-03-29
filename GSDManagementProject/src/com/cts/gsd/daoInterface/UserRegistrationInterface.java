package com.cts.gsd.daoInterface;

import java.util.ArrayList;

import com.cts.gsd.bean.UserRegistrationBean;


public interface UserRegistrationInterface {
	String insert(UserRegistrationBean s);	
	ArrayList<UserRegistrationBean> displayAll();
	int autoGenerate();
	boolean login_check(UserRegistrationBean s);
}
