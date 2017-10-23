package com.cc8w.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.cc8w.adapter.GobangKeyAdapter;
import com.cc8w.adapter.GobangMouseAdapter;
import com.cc8w.adapter.GobangWinAdapter;
import com.cc8w.dao.GobangDao;

public class GobangView extends JFrame {
	/**
	 * 前期一些配置信息
	 */
	private static final long serialVersionUID = 1L;
	public static int offsetNum = 50;//画方格是的偏移量
	public static int gobang_size_width = 500;//窗口宽度
	public static int gobang_size_height = 500;//窗口高度
	public  int winWidth=0;//获取屏幕宽度
	public  int winHeight=0;//获取屏幕宽度
	public static int gobang_grid_width = 400;//棋盘工作区宽度
	public static int gobang_grid_height = 400;//棋盘工作区宽度
	public static int _x=0;//x轴起始点
	public static int _y=0;//y轴起始点
	public static int _gap = 20;//方框间隔
	public static boolean _flag = true;//棋子的颜色 真空心圆，假实心圆
	public static int point_size_width = 10;//棋子大小
	public static int point_size_height = 10;//棋子大小
	public static int cur_x = 0;//当前为棋盘工作区的第几格（x值）
	public static int cur_y = 0;//当前为棋盘工作区的第几格（y值）
	public GobangView()
	{
		//Toolkit.getDefaultToolkit().getScreenSize().width
		winWidth = (int) getToolkit().getScreenSize().getWidth();
		winHeight = (int) getToolkit().getScreenSize().getHeight();
		this.setTitle("五子棋 V1.0");
		this.setSize(gobang_size_width, gobang_size_height);
		//这句话有潜在风险，当屏幕小于500像素，下面语句有报错可能
		this.setLocation((winWidth-gobang_size_width)/2, (winHeight-gobang_size_height)/2);
		//测试按钮开始
		JButton jb = new JButton("输出");
		jb.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				GobangDao gbd1 = GobangDao.getInstance();
				int [][] ar = gbd1.getGobang();
				for(int i=0;i<ar.length;i++)
				{
					for(int j=0;j<ar[i].length;j++)
					{
						System.out.print(ar[i][j]);
						System.out.print(" ");
					}
					System.out.println("");
				}
			}
		});
		this.add(jb);
		this.setLayout(new FlowLayout());
		//测试按钮结束
		this.addWindowListener(new GobangWinAdapter(this));
		this.addKeyListener(new GobangKeyAdapter(this));
		this.addMouseListener(new GobangMouseAdapter(this));
		this.setVisible(true);	
	}
	@Override
	public void paint(Graphics pg) {
		
		pg.setColor(Color.RED);		
		for(int i=0;i<=(gobang_grid_height/_gap);i++)
		{
			pg.drawLine((_x+i)*_gap+offsetNum, _y+offsetNum, (_x+i)*_gap+offsetNum, gobang_grid_height+offsetNum);
			pg.drawLine(_x+offsetNum, (_y+i)*_gap+offsetNum, gobang_grid_width+offsetNum,(_y+i)*_gap+offsetNum);
		}
	}
	


}
