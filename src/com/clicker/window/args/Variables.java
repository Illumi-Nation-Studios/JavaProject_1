package com.clicker.window.args;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

import javax.swing.JFrame;

import com.clicker.window.Window;
import com.clicker.window.input.Keyboard;
import com.clicker.window.ui.WindowUI;

public class Variables {

	// Initial Variables
	public static int width = 720;
	public static int height = width / 16 * 9;
	public int tFrames;
	public static String title = "JavaProject_1";
	public static int fontHeight = 12;
	public static int fontStyle = 0;
	
	// Font Variables
	public Font Helvetica = new Font("Helvetica", fontStyle, fontHeight);
	public Font Times = new Font("Times", fontStyle, fontHeight);
	public Font Serif = new Font("Serif", fontStyle, fontHeight);
	public Font Monospaced = new Font("Monospaced", fontStyle, fontHeight);

	// Key Variables
	public String keyLeft = "Left";
	public String keyRight = "Right";
	public String keyUp = "Up";
	public String keyDown = "Down";

	// Components
	public Graphics graphics;
	public static Thread thread;
	public static Keyboard k;
	public static Window window;
	public static JFrame frame;
	public static WindowUI ui;
	public static BufferStrategy bs;
	public static Random random;

	// Frame Limiter Variables
	public long lastTime = System.nanoTime();
	public long timer = System.currentTimeMillis();
	public final double ns = 1000000000.0 / 60.0;
	public double delta = 0;
	public int frames = 0;
	public int updates = 0;

	@SuppressWarnings("unused")
	public void reset() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		boolean running = false;
	}
}
