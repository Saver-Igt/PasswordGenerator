package GUI;

import javax.swing.*;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import Generator.*;

public class MainWindow extends Window{
	
	private JTextField passwordField;
	private JTextField sizeField;
	
	public MainWindow(String title, int x, int y, int width, int height, int closeOperation) {
		super(title, x, y, width, height, closeOperation);	
	}
	public void createMainPanel() {
		JLabel label1 = new JLabel("Введите количество знаков: "); 				
		label1.setBounds(5,10,170,25);
		mainPanel.add(label1);
		
		sizeField = new JTextField();
		sizeField.setBounds(175,10,70,25);
		mainPanel.add(sizeField);
		
		JLabel label2 = new JLabel("Ваш пароль: "); 				
		label2.setBounds(5,100,170,25);
		mainPanel.add(label2);
		
		passwordField = new JTextField();
		passwordField.setBounds(5,130,200,25);
		mainPanel.add(passwordField);
		
		JButton buttonPassword = new JButton("Получить");
		buttonPassword.setBounds(5,40,100,25);
		mainPanel.add(buttonPassword);
		buttonPassword.addActionListener(event->getPassword());
		
		JButton buttonCopy = new JButton("Копировать");
		buttonCopy.setBounds(210,130,102,25);
		mainPanel.add(buttonCopy);
		buttonCopy.addActionListener(event->copy());
		
		JButton buttonExit = new JButton("Выйти");
		buttonExit.setBounds(210,170,102,25);
		mainPanel.add(buttonExit);
		buttonExit.addActionListener(event->closeWindow());
		
		JButton buttonCreateDBWindow = new JButton("Открыть Базу Данных");
		buttonCreateDBWindow.setBounds(5,170,175,25);
		mainPanel.add(buttonCreateDBWindow);
		buttonCreateDBWindow.addActionListener(event->createDBWindow());
	}
	public void copy() {
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		StringSelection stringSelection = new StringSelection(passwordField.getText());
		clipboard.setContents(stringSelection, null);
	}
	public void getPassword() {
		if(sizeField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null,"Введите количество знаков!!!","Ошибка",0);
		}else {
			try {
				GeneratorPassword generator = new GeneratorPassword();
				generator.generate(Integer.parseInt(sizeField.getText()));
				passwordField.setText(generator.getPassword());
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null,"Введите число!!!","Ошибка",0);
			}
		}
	}
	public void createDBWindow() {
		DataBaseWindow gui = new DataBaseWindow("База данных",1500,150,320,250,2);
	    gui.createMenu();
	}
	public void closeWindow() {
		int exit = JOptionPane.showConfirmDialog(null, "Вы действительно хотите выйти?", "Завершение работы", 
				   JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		if (JOptionPane.YES_OPTION==exit) {
			System.exit(1);
		}
	}
	public void createMenu() {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menuMain = new JMenu("Главная");
		JMenuItem menu1 = new JMenuItem("База данных");
		JMenuItem menu2 = new JMenuItem("Выход");
		menuMain.add(menu1);
		menuMain.add(menu2);
		
		menu1.addActionListener(event->getPassword());
		menu2.addActionListener(event->closeWindow());
		
		menuBar.add(menuMain);
		mainFrame.setJMenuBar(menuBar);
	}
}
