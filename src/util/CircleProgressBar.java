package util;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class CircleProgressBar extends JPanel {
	private int minimumProgress;
	private int maximunProgress;
	private int progress;
	private String progressText;
	private Color backgroundColor;
	private Color foregoundColor;

	public CircleProgressBar() {
		minimumProgress = 0;
		maximunProgress = 100;
		progressText = "0%";
	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D graphics2d = (Graphics2D) g;
		// ¿ªÆô¿¹¾â³Ý
		graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int x = 0;
		int y = 0;
		int width = 0;
		int height = 0;
		int fontSize = 0;

		if (getWidth() >= getHeight()) {
			x = (getWidth() - getHeight()) / 2 + 25;
			y = 25;
			width = getHeight() - 50;
			height = getHeight() - 50;
			fontSize = getWidth() / 8;
		} else {
			x = 25;
			y = (getHeight() - getWidth()) / 2 + 25;
			width = getWidth() - 50;
			height = getHeight() - 50;
			fontSize = getHeight() / 8;
		}

		graphics2d.setStroke(new BasicStroke(20.0f));
		graphics2d.setColor(backgroundColor);
		graphics2d.drawArc(x, y, width, height, 0, 360);
		graphics2d.setColor(foregoundColor);
		graphics2d.drawArc(x, y, width, height, 90,
				-(int) (360 * ((progress * 1.0) / maximunProgress - minimumProgress)));
		graphics2d.setFont(new Font("ºÚÌå", Font.BOLD, fontSize));
		FontMetrics fontMetrics = graphics2d.getFontMetrics();
		int digitalWidth = fontMetrics.stringWidth(progressText);
		int digitalAsent = fontMetrics.getAscent();
		graphics2d.setColor(foregoundColor);
		graphics2d.drawString(progressText, getWidth() / 2 - digitalWidth / 2, getHeight() / 2 + digitalAsent / 2);
	}

	public int gerProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		if (progress >= minimumProgress && progress <= maximunProgress)
			this.progress = progress;
		if (progress > maximunProgress)
			this.progress = maximunProgress;
		this.progressText = String.valueOf(progress + "%");
		this.repaint();
	}

	public Color getBackgoundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
		this.repaint();
	}

	public Color getForegroundColor() {
		return foregoundColor;

	}

	public void setForegroundColor(Color foregoundColor) {
		this.foregoundColor = foregoundColor;
		this.repaint();
	}
}
