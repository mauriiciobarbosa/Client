package br.com.client.model;

import java.net.Socket;

public class ClientVO {
	private String name;
	private Socket socket;
	
	public ClientVO() {
		
	}
	
	public ClientVO(String name, Socket socket) {
		this.name 	= name;
		this.socket = socket;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Socket getSocket() {
		return socket;
	}
	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	@Override
	public String toString() {
		return this.name + "[" + this.socket.getInetAddress() + "] ";
	}
}
