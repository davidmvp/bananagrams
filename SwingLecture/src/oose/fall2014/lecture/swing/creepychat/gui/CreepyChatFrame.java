package oose.fall2014.lecture.swing.creepychat.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import oose.fall2014.lecture.swing.creepychat.model.CreepyChatModel;
import oose.fall2014.lecture.swing.creepychat.model.CreepyChatModelListener;
import oose.fall2014.lecture.swing.creepychat.model.Message;

public class CreepyChatFrame extends JFrame {
	private CreepyChatModel model;
	private JTextArea area;
	
	public CreepyChatFrame(final String user, final CreepyChatModel model) {
		this.setTitle("CreepyChat!");
		
		this.model = model;

		area = new JTextArea(5, 40);
		RecentChatComponent recentChat = new RecentChatComponent(model, user);
		JScrollPane scrollPane = new JScrollPane(area);
		JButton button = new JButton("Send");
		final JTextField field = new JTextField(30);

		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new BorderLayout());
		bottomPanel.add(field, BorderLayout.CENTER);
		bottomPanel.add(button, BorderLayout.EAST);

		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(recentChat, BorderLayout.NORTH);
		this.getContentPane().add(scrollPane, BorderLayout.CENTER);
		this.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.postMessage(new Message(user, field.getText()));
				field.setText("");
			}
		});
		
		model.addListener(new CreepyChatModelListener() {
			@Override
			public void messageReceived() {
				updateMessagesFromModel();
			}
		});
		
		updateMessagesFromModel();

		this.pack();
	}
	
	private void updateMessagesFromModel()
	{
		StringBuilder sb = new StringBuilder();
		for (Message message : model.getAllMessages())
		{
			sb.append(message.getUser());
			sb.append(": ");
			sb.append(message.getText());
			sb.append('\n');
		}
		area.setText(sb.toString());
	}
	
	/*
	 class MyListener implements ActionListener
	 {
	 	// ...
	 }
	 // button.addActionListener(new MyListener());
	 */
}
