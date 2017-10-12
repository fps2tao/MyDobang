package com.cc8w.view;

import javax.swing.JFrame;

import com.cc8w.adapter.GobangKeyAdapter;
import com.cc8w.adapter.GobangMouseAdapter;
import com.cc8w.adapter.GobangWinAdapter;

public class GobangView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int offsetNum = 5;//画方格是的偏移量
	public static int gobang_size_width = 500;//窗口宽度
	public static int gobang_size_height = 500;//窗口高度
	public static int winWidth=0;//获取屏幕宽度
	public static int winHeight=0;//获取屏幕宽度
	public GobangView()
	{
		//Toolkit.getDefaultToolkit().getScreenSize().width
		winWidth = (int) getToolkit().getScreenSize().getWidth();
		winHeight = (int) getToolkit().getScreenSize().getHeight();
		this.setTitle("五子棋 V1.0");
		this.setSize(gobang_size_width, gobang_size_height);
		//这句话有潜在风险，当屏幕小于500像素，下面语句有报错可能
		this.setLocation((winWidth-gobang_size_width)/2, (winHeight-gobang_size_height)/2);
		this.setVisible(true);
		this.addWindowListener(new GobangWinAdapter());
		this.addKeyListener(new GobangKeyAdapter());
		this.addMouseListener(new GobangMouseAdapter());
	}
	

}
