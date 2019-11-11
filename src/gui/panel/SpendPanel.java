package gui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.page.SpendPage;
import service.SpendService;
import util.CenterPanel;
import util.CircleProgressBar;
import util.ColorUtil;
import util.GUIUtil;

public class SpendPanel extends WorkingPanel {

	static {
		GUIUtil.useLNF();
	}

	public static SpendPanel instance = new SpendPanel();
	JLabel lMonthSpend = new JLabel("��������");
	JLabel lTodaySpend = new JLabel("��������");
	JLabel lAvgSpendPerDay = new JLabel("�վ�����");
	JLabel lMonthLeft = new JLabel("����ʣ��");
	JLabel lDayAvgAvailable = new JLabel("�վ�����");
	JLabel lMonthLeftDay = new JLabel("���x��ĩ");

	JLabel vMonthSpend = new JLabel("��2300");
	JLabel vTodaySpend = new JLabel("��25");
	JLabel vAvgSpendPerDay = new JLabel("��120");
	JLabel vMonthAvailable = new JLabel("��2084");
	JLabel vDayAvgAvailable = new JLabel("��389");
	JLabel vMonthLeftDay = new JLabel("15��");

	CircleProgressBar bar;

	private SpendPanel() {
		this.setLayout(new BorderLayout());
		bar = new CircleProgressBar();
		bar.setBackgroundColor(ColorUtil.blueColor);

		GUIUtil.setColor(ColorUtil.grayColor, lMonthSpend, lTodaySpend, lAvgSpendPerDay, lMonthLeft, lDayAvgAvailable,
				lMonthLeftDay, vAvgSpendPerDay, vMonthAvailable, vDayAvgAvailable, vMonthLeftDay);
		GUIUtil.setColor(ColorUtil.blueColor, vMonthSpend, vTodaySpend);

		vMonthSpend.setFont(new Font("΢���ź�", Font.BOLD, 23));
		vTodaySpend.setFont(new Font("΢���ź�", Font.BOLD, 23));

		this.add(center(), BorderLayout.CENTER);
		this.add(south(), BorderLayout.SOUTH);

	}

	private JPanel south() {
		// TODO Auto-generated method stub
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(2, 4));
		p.add(lAvgSpendPerDay);
		p.add(lMonthLeft);
		p.add(lDayAvgAvailable);
		p.add(lMonthLeftDay);
		p.add(vAvgSpendPerDay);
		p.add(vMonthAvailable);
		p.add(vDayAvgAvailable);
		p.add(vMonthLeftDay);
		return p;
	}

	private JPanel center() {
		// TODO Auto-generated method stub
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.add(west(), BorderLayout.WEST);
		p.add(center2(), BorderLayout.CENTER);
		return p;
	}

	private JPanel center2() {
		// TODO Auto-generated method stub
		return bar;
	}

	private JPanel west() {
		// TODO Auto-generated method stub

		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4, 1));
		p.add(lMonthSpend);
		p.add(vMonthSpend);
		p.add(lTodaySpend);
		p.add(vTodaySpend);
		return p;
	}

	public static void main(String[] args) {
		GUIUtil.showPanel(SpendPanel.instance);
	}

	@Override
	public void updateDate() {
		// TODO Auto-generated method stub
		SpendPage spend = new SpendService().getSpendPage();
		vMonthSpend.setText(spend.monthSpend);
		vTodaySpend.setText(spend.todaySpend);
		vAvgSpendPerDay.setText(spend.avgSpendPerDay);
		vMonthAvailable.setText(spend.monthAvailable);
		vDayAvgAvailable.setText(spend.dayAvgAvailable);
		vMonthLeftDay.setText(spend.monthLeftDay);

		bar.setProgress(spend.usagePercentage);
		if (spend.isOverSpend) {
			vMonthAvailable.setForeground(ColorUtil.warningColor);
			vMonthSpend.setForeground(ColorUtil.warningColor);
			vTodaySpend.setForeground(ColorUtil.warningColor);
		} else {
			vMonthAvailable.setForeground(ColorUtil.grayColor);
			vMonthSpend.setForeground(ColorUtil.blueColor);
			vTodaySpend.setForeground(ColorUtil.blueColor);
		}
		bar.setForegroundColor(ColorUtil.getByPercentage(spend.usagePercentage));
		addListener();
	}

	@Override
	public void addListener() {
		// TODO Auto-generated method stub

	}
}
