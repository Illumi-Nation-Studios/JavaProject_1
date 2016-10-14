package com.clicker.window;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import com.clicker.window.args.Variables;
import com.clicker.window.input.Keyboard;
import com.clicker.window.ui.WindowUI;

@SuppressWarnings({ "serial", "unused" })
public class Window extends Canvas implements Runnable {
	public static Variables v;
	public JFrame frame;

	public boolean running = false;

	public Window() {
		Dimension size = new Dimension(Variables.width, Variables.height);
		setPreferredSize(size);

		Variables.k = new Keyboard();
		Variables.ui = new WindowUI();
		frame = new JFrame();
	}

	public synchronized void start() {
		running = true;
		Variables.thread = new Thread(this, "Clicker");
		Variables.thread.start();
	}

	public synchronized void stop() {
		running = false;
		try {
			Variables.thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		v = new Variables();
		v.reset();
		requestFocus();
		while (running) {
			long now = System.nanoTime();
			v.delta += (now - v.lastTime) / v.ns;
			v.lastTime = now;
			while (v.delta >= 1) {
				update();
				v.updates++;
				v.delta--;
			}
			render();
			v.frames++;

			if (System.currentTimeMillis() - v.timer > 1000) {
				v.timer += 1000;
				v.tFrames = v.frames;
				v.updates = 0;
				v.frames = 0;
			}
		}
		stop();
	}

	public void update() {
		Variables.ui.update();
	}

	public void render() {
		Variables.bs = getBufferStrategy();
		if (Variables.bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = Variables.bs.getDrawGraphics();

		g.setFont(v.Monospaced);
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());

		g.setColor(Color.black);
		g.drawString("Frames: " + v.tFrames / 10, 0, 10);
		
		Variables.ui.render();
		
		g.dispose();
		Variables.bs.show();
	}

	public static void main(String[] args) {
		Window window = new Window();

		window.frame.setResizable(false);
		window.frame.setTitle(Variables.title);
		window.frame.add(window);
		window.frame.pack();
		window.frame.setBackground(Color.white);
		window.frame.setLocationRelativeTo(null);
		window.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.frame.setVisible(true);

		window.start();
	}
}