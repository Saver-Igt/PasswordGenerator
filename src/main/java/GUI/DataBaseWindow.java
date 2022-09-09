package GUI;

import javax.swing.*;

public class DataBaseWindow extends Window{

	public DataBaseWindow(String title, int x, int y, int width, int height, int closeOperation) {
		super(title, x, y, width, height, closeOperation);
	}
	public void createMenu() {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menuMain = new JMenu("Главная");
		JMenuItem menu1 = new JMenuItem("База данных");
		JMenuItem menu2 = new JMenuItem("Выход");
		menuMain.add(menu1);
		menuMain.add(menu2);
		
	//	menu1.addActionListener(event->getPassword());
		menu2.addActionListener(event->closeWindow());
		
		menuBar.add(menuMain);
		mainFrame.setJMenuBar(menuBar);
	}
	public void closeWindow() {
		int exit = JOptionPane.showConfirmDialog(null, "Закрыть окно?", "Выход", 
				   JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		if (JOptionPane.YES_OPTION==exit) {
			mainFrame.dispose();
		}
	}
}
