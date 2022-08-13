package com.inventario.main.socket;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.inventario.main.entities.User;

@Controller
public class SocketController {
	private final static Logger LOGGER = LoggerFactory.getLogger(SocketController.class);
	@Autowired
	private SimpMessageSendingOperations sendingOperations;
	private ArrayList<User> users = new ArrayList<User>();
	
	@MessageMapping("/users")
	@SendTo("/topic/users")
	public ArrayList<User> sendUserLogged (@Payload User user, SimpMessageHeaderAccessor headerAccessor) {
		headerAccessor.getSessionAttributes().put("username", user.getUsername());
		users.add(user);
		LOGGER.info("Usuario "+ user.getUsername()+" conectado");
		return users;
	}
	@SubscribeMapping("/topic/users")
	public ArrayList<User> sendUserLogged () {
		return users;
	}
	@MessageMapping("/inventoryStatus")
	public void inventoryStatus(Boolean status) {
		sendingOperations.convertAndSend("/topic/inventoryStatus", status);
	}
	@EventListener
	public void handleWebSocketEventConnectListener(final SessionConnectedEvent event) {
		LOGGER.info("Novo usuario conectado");
	}
	
	@EventListener
	public void handleWebSocketEventDisconnectListener(final SessionDisconnectEvent event) {
		final StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
		final String username = (String) headerAccessor.getSessionAttributes().get("username");
		for(int x= 0; x<users.size();x++) {
			if(users.get(x).getUsername().equals(username)) {
				users.remove(x);
			}
		}
		LOGGER.info("Usuario "+username+" desconectado");
		sendingOperations.convertAndSend("/topic/users",users);
	}
}
