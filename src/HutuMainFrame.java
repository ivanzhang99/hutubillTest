

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class HutuMainFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new JFrame();
		f.setSize(500, 450);
		f.setTitle("���˱ʼǱ�");
		f.setLocationRelativeTo(null);// ��������
		f.setResizable(false);// ���ڴ�С���ɸı�
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//		������
		JToolBar tb = new JToolBar();
		JButton bSpend = new JButton("����һ��");
		JButton bRecord = new JButton("��һ��");
		JButton bCategory = new JButton("���ѷ���");
		JButton bReport = new JButton("�����ѱ���");
		JButton bConfig = new JButton("����");
		JButton bBackup = new JButton("����");
		JButton bRecover = new JButton("�ָ�");
//		��ӽ���ť��������
		tb.add(bSpend);
		tb.add(bRecord);
		tb.add(bCategory);
		tb.add(bRecord);
		tb.add(bConfig);
		tb.add(bBackup);
		tb.add(bRecover);
		f.setLayout(new BorderLayout());
		f.add(tb, BorderLayout.NORTH);
		f.add(new JPanel(), BorderLayout.CENTER);
		f.setVisible(true);

		bSpend.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		bRecord.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		bCategory.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		bConfig.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		bBackup.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		bRecover.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

}
