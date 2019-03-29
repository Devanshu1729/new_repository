package com.cts.gsd.daoInterface;

import java.util.ArrayList;

import com.cts.gsd.bean.GSDdetailbean;

public interface GSDdetailInterface {
	boolean insert(GSDdetailbean s);
	ArrayList<GSDdetailbean> displayAll();
	ArrayList<GSDdetailbean> display();
	ArrayList<GSDdetailbean> displayclose();
}