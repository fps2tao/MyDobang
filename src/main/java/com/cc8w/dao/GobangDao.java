package com.cc8w.dao;

import com.cc8w.view.GobangView;

public class GobangDao {
	public static int arr [][];
	public static GobangDao gbd;
	private GobangDao() {}
	public static GobangDao getInstance()
	{
		if(gbd ==null)
		{
			gbd = new GobangDao();			
			int curX=(GobangView.gobang_grid_width/GobangView._gap)+1;
			int cury=(GobangView.gobang_grid_height/GobangView._gap)+1;
			arr = new int[curX][cury];
		}
		return gbd;
	}

	/**存储棋子坐标
	 * @param :棋子x坐标数
	 * @param :棋子y坐标数
	 * @param :黑棋（2），白旗（1），空白（0）
	 */
	public boolean setGobang(int x,int y,boolean _flag)
	{//坐标是arr[1][2],arr[1][3],arr[1][4]
		GobangDao.arr[y][x]=0;
		if(_flag)
		{
			GobangDao.arr[y][x]=1;
		}
		else
		{
			GobangDao.arr[y][x]=2;
		}
		if(GobangDao.arr[y][x]==0)
		{
			return false;
		}
		else 
		{
			return true;
		}			
	}
	/**获取棋子坐标
	 * @param :棋子x坐标
	 * @param :棋子y坐标
	 * @return :黑棋（2），白旗（1），空白（0）
	 */
	public int getGobang(int x,int y)
	{		
		return GobangDao.arr[y][x];
	}
	public int [][] getGobang()
	{
		return GobangDao.arr;
	}

}
