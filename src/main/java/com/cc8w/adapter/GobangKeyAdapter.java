package com.cc8w.adapter;

import java.awt.event.KeyAdapter;

import com.cc8w.view.GobangView;

public class GobangKeyAdapter extends KeyAdapter {
	public GobangView gv=null;
	public GobangKeyAdapter(GobangView g)
	{
		this.gv = g;
	}
}
