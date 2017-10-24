package com.cc8w.controller;

import java.awt.Graphics;
import java.awt.Point;

import com.cc8w.dao.GobangDao;
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
	
	public static boolean isTransboundary(int x,int y)
	{//是否越界
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
	/**
	 * 
	 * @param pg 画笔
	 * @param x 画笔画圆x位置
	 * @param y 画笔画圆y位置
	 * @param falg 画圆是棋子颜色 - 真空心圆，假实心圆， 黑棋（2），白旗（1），空白（0）
	 */
	public void dropPoint(Graphics pg,int x,int y,boolean falg)
	{//落点 真为白点，假为黑点
		Point pt = focusXY(x,y);
		GobangDao gbd1 = GobangDao.getInstance();//单例模式只能这样实例化
		
		Point arr_pt = getGobangArr(pt.x,pt.y);//棋盘二维数组坐标值
		//System.out.println(arr_pt.x+"--"+arr_pt.y);
		if(falg)
		{
			pg.drawOval(pt.x, pt.y, GobangView.point_size_width, GobangView.point_size_height);
			//存值
			gbd1.setGobang(arr_pt.x, arr_pt.y, falg);
			
			GobangView._flag = false;
		}
		else
		{
			pg.fillOval(pt.x, pt.y, GobangView.point_size_width, GobangView.point_size_height);
			//存值
			gbd1.setGobang(arr_pt.x, arr_pt.y, falg);
			GobangView._flag = true;
		}
		
	}
	/**
	 * 
	 * @param x 鼠标点击x
	 * @param y 鼠标点击y
	 * @return Point:返回校正后的x，y用Point返回
	 */
	public Point focusXY(int x,int y)
	{//鼠标随机落点，一定要落在十字线上（此方法就是校对落点位置的）
		int pointX = 0;
		int pointY= 0;
		//(GobangView.gobang_grid_width + GobangView.offsetNum)/GobangView._gap
		int xCount = (x-GobangView.offsetNum)/GobangView._gap;
		int yCount = (y-GobangView.offsetNum)/GobangView._gap;		
		pointX = (xCount*GobangView._gap)+GobangView.offsetNum;
		int pointX1 = ((xCount+1)*GobangView._gap)+GobangView.offsetNum;
		if(Math.abs(pointX-x)>Math.abs(pointX1-x))
		{
			pointX = pointX1;
		}		
		pointY = (yCount*GobangView._gap)+GobangView.offsetNum;
		int pointY1 = ((yCount+1)*GobangView._gap)+GobangView.offsetNum;
		if(Math.abs(pointY-y)>Math.abs(pointY1-y))
		{
			pointY = pointY1;
		}		
		Point pt = new Point(pointX-5,pointY-5);
		return pt;
	}
	/**
	 * 
	 * @param x
	 * @param y
	 * @param _flag 当前判断 _flag为真白旗1，为假，黑棋2
	 * @return true 赢  ，false 输
	 */
	public boolean isWin(int x,int y,boolean _flag)
	{//判断输赢
		int qi=2;
		if(_flag)qi=1;
		int counter = 0;//计数器
		//判断算法：以当点为中心前后各取5个点循环判断有没有相同的值，中间值空了，计数器清零，只有连续5个的计数器累加>=5跳出
		//横向判断
		for(int j=-5;j<=10;j++)
		{
			if ((y+j)<0)continue;//防止越界
			if(GobangDao.arr[x][y+j]==qi)
			{
				counter = counter+1;
				break;
			}
			else
			{
				counter=0;
			}
			
		}
		//纵向判断
		
		//斜向判断
		
		
		return false;		
	}
	public Point getGobangArr(int x,int y)
	{//返回棋盘数组
		//System.out.println(x+"--"+y);
		int arr_x = ((x-GobangView.offsetNum+30)/GobangView._gap)-1;//为什么会加30呢，因为窗口的标题栏占30px..
		int arr_y = ((y-GobangView.offsetNum+30)/GobangView._gap)-1;//为什么减1呢，这个是一个个数，不为零，数组是从零开始的		
		Point pt = new Point(arr_x,arr_y);//因为数组从0开始，这个计算是1，校正下
		return pt;
	}
	
	
	
}
