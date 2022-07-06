package Generator;

import java.util.Random;

public class GeneratorPassword {
	private String alphabet = "0123456789QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm_#!?+-";
	private String password;
	public void generate(int size) {
		Random random = new Random();
		password = "";
	    for (int i = 0; i < size; i++) {
	    	password += alphabet.charAt(random.nextInt(alphabet.length()));
	    }
	}
	public String getPassword() {
		return password;
	}
}
