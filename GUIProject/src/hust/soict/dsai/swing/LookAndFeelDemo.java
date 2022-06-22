package hust.soict.dsai.swing;

import java.util.Arrays;
import java.util.ArrayList;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

public class LookAndFeelDemo extends JFrame {

	public LookAndFeelDemo() {
		// TODO Auto-generated constructor stub
		addDemoComponents();
		addLookAndFeelComboBox();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(380,100);
		setVisible(true);
	}
	
	void addDemoComponents() {
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(new JLabel("Label: "));
		cp.add(new JTextField("Textfield"));
		cp.add(new JRadioButton("Radio button"));
		cp.add(new JButton("Button"));
	}
	
	void addLookAndFeelComboBox() {
		Container cp = getContentPane();
		cp.add(new JLabel("Change Look and Feel here: "));
		
		ArrayList<LookAndFeelInfo> lafInfos = new ArrayList<LookAndFeelInfo>(Arrays.asList(UIManager.getInstalledLookAndFeels()));
		ArrayList<String> lafNames = new ArrayList<String>();
		for (int i = 0; i< lafInfos.size(); i++) {
			lafNames.add(lafInfos.get(i).getName());
		}
		lafNames.add("Java");
		lafNames.add("System");
	
		JComboBox cbLookAndFeel = new JComboBox(lafNames.toArray());
		cp.add(cbLookAndFeel);
		
		JFrame frame = this;
		cbLookAndFeel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				// TODO Auto-generated method stub
				int index = cbLookAndFeel.getSelectedIndex();
				try {
					if (index == lafInfos.size()) {
						UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
						System.out.println("Done");
					} else if (index == lafInfos.size() + 1) {
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					} else {
						UIManager.setLookAndFeel(lafInfos.get(index).getClassName());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				SwingUtilities.updateComponentTreeUI(frame);
				setTitle(lafNames.get(index) + "Look and Feel");
				}
			
		});
	}
	public static void main (String[] args) {
		new LookAndFeelDemo();
	}
}