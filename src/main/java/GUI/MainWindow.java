package GUI;

import javax.swing.*;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import Generator.*;

public class MainWindow {
	private JFrame window;
	private JPanel mainPanel;
	private JTextField passwordField;
	private JTextField sizeField;
	public MainWindow(String title) {
		window = new JFrame(title);
		window.setBounds(500,150,320,250);
		window.setResizable(false);
	}
	public void createMainPanel() {
		mainPanel = new JPanel();
		mainPanel.setLayout(null);

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

		window.add(mainPanel);
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
	public void createMenu() {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menuMain = new JMenu("Главная");
		JMenuItem menu1 = new JMenuItem("Информация о команде");
		JMenuItem menu2 = new JMenuItem("Выход");
		menuMain.add(menu1);
		menuMain.add(menu2);
		
		menuBar.add(menuMain);
		window.setJMenuBar(menuBar);
	}
	public void setMainWindowVisible() {
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
}
