package com.cc8w.controller;

import java.awt.Graphics;
import java.awt.Point;

import com.cc8w.view.GobangView;

//游戏的一些逻辑操作
public class GobangController {
	public GobangView gv=null;
	public GobangController(GobangView g)
	{
		this.gv = g;
	}
	//根据GobangView的一些配置计算方格的工作区
	public static int[] workSpace()
	{//数组的顺序为上右下左（顺时针一圈）
		int[] ws= {0,0,0,0};
		int _u = 0;//上边界初始化up
		int _r = 0;//右边界初始化right
		int _d = 0;//下边界初始化down
		int _l = 0;//左边界初始化left
		
		_u = GobangView.offsetNum;
		_r = GobangView.offsetNum+GobangView.gobang_grid_width;
		_d = GobangView.offsetNum+GobangView.gobang_grid_height;
		_l = GobangView.offsetNum;
		ws[0] = _u;
		ws[1] = _r;
		ws[2] = _d;
		ws[3] = _l;
		
		return ws;
	}
	//是否越界
	public static boolean isTransboundary(int x,int y)
	{
		int ws[] = GobangController.workSpace();
		int _u = ws[0];
		int _r = ws[1];
		int _d = ws[2];
		int _l = ws[3];
		//x轴范围
		boolean xx = (_u< x && x < _d);
		boolean yy = (_l< y && y < _r);
		if(xx&&yy)
		{
			return true;
		}
		else
		{
			return false;	
		}		
	}
	public void dropPoint(Graphics pg,int x,int y,boolean falg)
	{//落点 真为白点，假为黑点
		
		if(falg)
		{
			pg.drawOval(x, y, GobangView.point_size_width, GobangView.point_size_height);
			GobangView._flag = false;
		}
		else
		{
			pg.fillOval(x, y, GobangView.point_size_width, GobangView.point_size_height);
			GobangView._flag = true;
		}
		
	}
	public Point focusXY()
	{//鼠标随机落点，一定要落在十字线上（此方法就是校对落点位置的）
		Point pt = new Point();
		
		return pt;
	}
	
	
	
}
