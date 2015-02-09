package oose.fall2014.lecture.swing.creepychat.model;

import java.util.ArrayList;
import java.util.List;

public class CreepyChatModelImpl implements CreepyChatModel {
	
	private List<Message> messages;
	private List<CreepyChatModelListener> listeners;
	
	public CreepyChatModelImpl()
	{
		this.messages = new ArrayList<>();
		this.listeners = new ArrayList<>();
	}

	@Override
	public List<Message> getAllMessages() {
		return this.messages;
	}

	@Override
	public void postMessage(Message message) {
		this.messages.add(message);
		for (CreepyChatModelListener listener : this.listeners)
		{
			listener.messageReceived();
		}
	}

	@Override
	public void addListener(CreepyChatModelListener listener) {
		this.listeners.add(listener);
	}

	@Override
	public void removeListener(CreepyChatModelListener listener) {
		this.listeners.remove(listener);
	}

}
