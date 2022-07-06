package main;
import GUI.*;
public class Main {
	public static void main(String[] args) {
	    MainWindow gui = new MainWindow("Генератор пароля");
	    gui.createMenu();
	    gui.createMainPanel();
	    gui.setMainWindowVisible();
	}
}
