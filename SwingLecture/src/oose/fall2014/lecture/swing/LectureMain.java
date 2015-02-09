package oose.fall2014.lecture.swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class LectureMain {
	public static void main(String[] args) {
		JFrame frame = new JFrame("A Frame!");
		
		JButton button = new JButton("Button?");
		button.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Yeah, button.");
			}
		});
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(300,300);
		
		frame.getContentPane().add(button);
		frame.getContentPane().setLayout(new FlowLayout());
		
		frame.setVisible(true);
	}
}
