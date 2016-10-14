package com.clicker.window.ui;

import java.awt.Font;
import java.awt.Graphics;

import com.clicker.window.args.Variables;

@SuppressWarnings({ "unused" })
public class WindowUI {

	public Graphics g;

	public WindowUI() {

	}

	public void update() {
		Graphics g = Variables.bs.getDrawGraphics();
	}

	public void render() {
		Graphics g = Variables.bs.getDrawGraphics();
	}
}
