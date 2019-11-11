package test;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

import util.CircleProgressBar;
import util.ColorUtil;
import util.GUIUtil;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GUIUtil.useLNF();
		JPanel p = new JPanel();

		CircleProgressBar cpd = new CircleProgressBar();
		cpd.setBackgroundColor(ColorUtil.blueColor);
		cpd.setProgress(0);
		JButton b = new JButton("µã»÷");
		p.setLayout(new BorderLayout());
		p.add(cpd, BorderLayout.CENTER);
		p.add(b, BorderLayout.SOUTH);
//		p.setVisible(false);
		GUIUtil.showPanel(p);
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new SwingWorker() {

					@Override
					protected Object doInBackground() throws Exception {
						for (int i = 0; i < 100; i++) {
							cpd.setProgress(i + 1);
							cpd.setForegroundColor(ColorUtil.getByPercentage(i + 1));
							try {
								Thread.sleep(100);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						return null;
					}

				}.execute();
			}
		});
		// p.add(new JButton("°´âo1"));
//		p.add(new JButton("°´âo2"));
//		GUIUtil.showPanel(p);
	}

}
