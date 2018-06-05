package com.keychat.controller.chat;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/chat")
public class Chatroom {
	private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());
	
	@OnMessage
	public void onMessage(String message, Session session) throws IOException {
		
		synchronized(clients) {
			for(Session client : clients) {
				if (!client.equals(session)){
			          client.getBasicRemote().sendText(message);
				}
			}
		}
	}
		
	@OnOpen
	  public void onOpen (Session session) {
	  // Add session to the connected sessions set
	    clients.add(session);
	    System.out.println(session.getId() + " has opened a connection");
	  }

	@OnClose
	public void onClose (Session session) {
	// Remove session from the connected sessions set
		clients.remove(session);
		System.out.println("close : " + session.getId());
	}
}
