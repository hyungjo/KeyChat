package com.keychat.controller.chat;

import java.io.IOException;
import java.io.StringWriter;
import java.util.*;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/chat/{channel}")
public class Chatroom {
//	private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());

	private static Map<Session, String> clients = Collections.synchronizedMap(new HashMap<Session, String>());
	@OnMessage
	public void onMessage(@PathParam("channel") String channel, String message, Session session) throws IOException {
		
		synchronized(clients) {
			for(Map.Entry<Session, String> client : clients.entrySet()) {
				if (!client.getKey().equals(session) && client.getValue().equals(channel)){
			          client.getKey().getBasicRemote().sendText(message);
				}
			}
		}
	}
		
	@OnOpen
	  public void onOpen (@PathParam("channel") String channel, Session session) {
	  // Add session to the connected sessions set
	    clients.put(session, channel);
	    System.out.println(session.getId() + " / " + channel + " has opened a connection");
	  }

	@OnClose
	public void onClose (@PathParam("channel") String channel, Session session) {
	// Remove session from the connected sessions set
		clients.remove(session);
		System.out.println(session.getId() + " / " + channel + " has closed a connection");
	}
}
