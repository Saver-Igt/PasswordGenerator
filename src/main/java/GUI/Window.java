package GUI;

import javax.swing.*;

public class Window {
	protected JFrame mainFrame;
	protected JPanel mainPanel;

	public Window(String title, int x, int y, int width, int height,int closeOperation) {
		mainFrame = new JFrame(title);
		mainFrame.setBounds(x,y,width,height);
		mainFrame.setResizable(false);
		
		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainFrame.add(mainPanel);
		
		//dispose - 1, 2; close - 3
		mainFrame.setDefaultCloseOperation(closeOperation);
		mainFrame.setVisible(true);
	}
	
	public void repaintFrame() {
		mainFrame.getContentPane().validate();
		mainFrame.getContentPane().repaint();
	}
}
