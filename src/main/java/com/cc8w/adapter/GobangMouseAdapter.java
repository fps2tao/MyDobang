package com.cc8w.adapter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.cc8w.controller.GobangController;
import com.cc8w.view.GobangView;

public class GobangMouseAdapter extends MouseAdapter  {
	public GobangView gv=null;
	public GobangMouseAdapter(GobangView g)
	{
		this.gv = g;
	}
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		boolean flag = 
		GobangController.isTransboundary(e.getX(), e.getY());
		if(flag)
		{//在工作区进行处理
			GobangController gc = new GobangController(gv);
			gc.dropPoint(gv.getGraphics(), e.getX(), e.getY(), GobangView._flag);
			
			System.out.println("点击了工作区我要处理了");
		}

		
	}
	
}
