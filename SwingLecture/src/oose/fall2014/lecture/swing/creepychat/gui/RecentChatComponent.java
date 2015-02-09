package oose.fall2014.lecture.swing.creepychat.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JComponent;

import oose.fall2014.lecture.swing.creepychat.model.CreepyChatModel;
import oose.fall2014.lecture.swing.creepychat.model.CreepyChatModelListener;
import oose.fall2014.lecture.swing.creepychat.model.Message;

public class RecentChatComponent extends JComponent {
	public static final int BUBBLE_SIZE = 15;

	private CreepyChatModel model;
	private String currentUser;

	public RecentChatComponent(CreepyChatModel model, String currentUser) {
		super();
		this.model = model;
		this.currentUser = currentUser;
		this.model.addListener(new CreepyChatModelListener() {
			
			@Override
			public void messageReceived() {
				repaint();\
			}
		});
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(BUBBLE_SIZE, BUBBLE_SIZE);
	}

	@Override
	public void paint(Graphics g) {
		final boolean mostRecentlySent;
		List<Message> messages = model.getAllMessages();
		if (messages.size() > 0) {
			Message message = messages.get(messages.size() - 1);
			mostRecentlySent = message.getUser().equals(this.currentUser);
		} else {
			mostRecentlySent = false;
		}
		g.setColor(mostRecentlySent ? Color.GREEN : Color.ORANGE);
		g.fillOval(0, 0, BUBBLE_SIZE, BUBBLE_SIZE);
	}

}
