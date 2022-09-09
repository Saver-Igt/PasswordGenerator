package main;
import GUI.*;
public class Main {
	public static void main(String[] args) {
	    MainWindow gui = new MainWindow("Генератор пароля", 500,150,320,250, 3);
	   //не работает
	   // gui.createMenu();
	    gui.createMainPanel(); 
	    gui.repaintFrame();
	}
}
