package com.cts.gsd.daoInterface;

import java.util.ArrayList;

import com.cts.gsd.bean.AdminRegistrationBean;

public interface AdminRegistrationInterface {
	String insert(AdminRegistrationBean s);
	boolean login_check(AdminRegistrationBean s);
	ArrayList<AdminRegistrationBean> displayAll();
	int autoGenerate();
}
