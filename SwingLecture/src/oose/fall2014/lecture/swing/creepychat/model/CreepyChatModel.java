package oose.fall2014.lecture.swing.creepychat.model;

import java.util.List;

public interface CreepyChatModel {
	public List<Message> getAllMessages();
	
	public void postMessage(Message message);
	
	public void addListener(CreepyChatModelListener listener);
	
	public void removeListener(CreepyChatModelListener listener);
}
