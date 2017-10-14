package com.cc8w.adapter;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.cc8w.view.GobangView;

public class GobangWinAdapter extends WindowAdapter {
	public GobangView gv=null;
	public GobangWinAdapter(GobangView g)
	{
		this.gv = g;
	}
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		super.windowActivated(arg0);
		gv.repaint();
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		super.windowClosed(arg0);
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("窗口关闭");
		System.exit(0);
	}

	@Override
	public void windowLostFocus(WindowEvent arg0) {
		// TODO Auto-generated method stub
		super.windowLostFocus(arg0);
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		super.windowOpened(arg0);
	}

}
