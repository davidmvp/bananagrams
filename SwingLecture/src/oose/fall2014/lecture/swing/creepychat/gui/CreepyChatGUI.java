package oose.fall2014.lecture.swing.creepychat.gui;

import javax.swing.JFrame;

import oose.fall2014.lecture.swing.creepychat.model.CreepyChatModel;
import oose.fall2014.lecture.swing.creepychat.model.CreepyChatModelImpl;
import oose.fall2014.lecture.swing.creepychat.model.Message;

public class CreepyChatGUI {
	public static void main(String[] args) {
		CreepyChatModel model = new CreepyChatModelImpl();
		model.postMessage(new Message("system", "Welcome to CreepyChat!"));
		for (int i = 0; i < 2; i++) {
			CreepyChatFrame frame = new CreepyChatFrame("User " + (i+1), model);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setVisible(true);
		}
	}
}
