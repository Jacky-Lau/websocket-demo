package edu.zju.bme.websocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import edu.zju.bme.websocket.model.Greeting;
import edu.zju.bme.websocket.model.HelloMessage;

@Controller
public class WebsocketController {

	public WebsocketController() {
		System.out.println("WebsocketController initialized.");
	}

	@MessageMapping("/greet")
	@SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage message) throws Exception {
		System.out.println(message.getName());
		return new Greeting("Hello, " + message.getName() + "!");
	}
}
