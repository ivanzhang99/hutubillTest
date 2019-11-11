package gui.panel;

import javax.swing.JButton;
import javax.swing.JPanel;

import gui.listener.RecoverListener;
import util.ColorUtil;
import util.GUIUtil;

public class RecoverPanel extends WorkingPanel {
	static {
		GUIUtil.useLNF();
	}
	public static RecoverPanel instance = new RecoverPanel();
	JButton bRecover = new JButton("»Ö¸´");

	private RecoverPanel() {
		GUIUtil.setColor(ColorUtil.blueColor, bRecover);
		this.add(bRecover);

		addListener();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GUIUtil.showPanel(RecoverPanel.instance);

	}

	@Override
	public void updateDate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		RecoverListener listener = new RecoverListener();
		bRecover.addActionListener(listener);
	}

}
