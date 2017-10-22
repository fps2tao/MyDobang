package com.cc8w.dao;

public class GobangDao {
	public static int arr [][];
	public static GobangDao gbd;
	private GobangDao() {}
	public static GobangDao getInstance()
	{
		if(gbd ==null)
		{
			gbd = new GobangDao();
		}
		return gbd;
	}
	/**初始化
	 * @param :棋盘x坐标数
	 * @param :棋盘y坐标数
	 */
	public void init(int xNum,int yNum)
	{
		arr = new int[xNum][yNum];
		
	}
	/**存储棋子坐标
	 * @param :棋子x坐标
	 * @param :棋子y坐标
	 * @param :黑棋（2），白旗（1），空白（0）
	 */
	public boolean setGobang(int x,int y,boolean _flag)
	{
		return false;
	}
	/**获取棋子坐标
	 * @param :棋子x坐标
	 * @param :棋子y坐标
	 * @return :黑棋（2），白旗（1），空白（0）
	 */
	public int getGobang(int x,int y)
	{
		
		return 0;
	}

}
