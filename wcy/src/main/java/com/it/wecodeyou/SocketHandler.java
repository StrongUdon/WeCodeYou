package com.it.wecodeyou;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class SocketHandler extends TextWebSocketHandler implements InitializingBean {

	private final Logger logger = LoggerFactory.getLogger(SocketHandler.class);
	private Set<WebSocketSession> sessionSet = new HashSet<WebSocketSession>();
	
	public SocketHandler() {
		this.logger.info("create SocketHandler instance");
	}
	
	
	/* 채팅종류시 호출되는 메소드 */
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		super.afterConnectionClosed(session, status);
		sessionSet.remove(session);
		this.logger.info("remove session!");
	}
	
	/* 소켓 연결 성공시 호출되는 메소드 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		super.afterConnectionEstablished(session);
		
		sessionSet.add(session);
		this.logger.info("afterConnectoinEstablished: added session " );
	}
	
	/* 메세지를 보낼때 호출 */
	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		super.handleMessage(session, message);
		
		this.logger.info("handleMessage:" + message.toString());
	}
	
	/* 대화 내용 전송 실패시 호출 */
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		super.handleTransportError(session, exception);
		this.logger.info("handleTransportError: ", exception);
	}
	/* 부분 메세지(?)를 처리할때 호출 */
	@Override
	public boolean supportsPartialMessages() {
		this.logger.info("supportPartialMessages: ");
		return super.supportsPartialMessages();
	}
	
	/* 세션들을 보내는 메소드를 호출 */
	public void sendMessage(String message) {
		for(WebSocketSession session: this.sessionSet) {
			if(session.isOpen()) {
				try {
					session.sendMessage(new TextMessage(message));
				} catch (Exception e) {
					this.logger.error("fail to send message!", e);
				}
			}
		}
	}
	
	
	/*예시에서 채팅시간을 기록하기 위한 메소드 
	 1초마다 전송 
	 */
	public void afterPropertiesSet() throws Exception{
		
		/*
		 * Thread thread = new Thread() { int i = 0;
		 * 
		 * @Override public void run() { while(true) { try {
		 * sendMessage("send message index " + i++); Thread.sleep(1000); } catch
		 * (InterruptedException e) { e.printStackTrace(); break; } } } };
		 * thread.start();
		 */
	}
}
