package br.com.client.business;

import java.beans.PropertyChangeSupport;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import br.com.client.exception.SystemException;
import br.com.client.exception.UserException;
import br.com.client.model.ClientVO;
import br.com.client.view.ClientController;
/**
 * Classe responsavel por estabelecer toda a comunicacao com o servidor.
 * 
 * @author Mauricio Barbosa
 *
 */
public class ClientBO {
	/**
	 * Imagem do cliente. Acho que nao e necessario.
	 */
	private ClientVO client;
	/**
	 * Objeto responsavel por ficar "escutando" o servidor.
	 */
	private BufferedReader reader;
	/**
	 * Objeto responsavel por "falar" com o servidor.
	 */
	private PrintStream writer;
	
	private PropertyChangeSupport listener;
	
	
	public ClientBO(ClientController controller) {
		listener = new PropertyChangeSupport(this);
		listener.addPropertyChangeListener(controller);
	}

	
	/**
	 * Metodo responsavel por fazer a validacao do ip.
	 * @param ip
	 * 
	 * @return boolean
	 */
	private boolean validateIP(String ip) {
		final String ruleIP = "\\d{1,3}(\\.\\d{1,3}){3}";
		
		if (ip.equalsIgnoreCase("localhost"))
			return true;
		else if (ip.matches(ruleIP)) {
			String octets[] = ip.split("\\.");
			int octet;
			for(int i = 0; i < 4; i++) {
				octet = Integer.parseInt(octets[i]);
				
				if (!(octet >= 0 && octet <= 255))
					return false;
				 // Se o primeiro octeto for 0, ou o ultimo octeto for 0 ou 255, o ip e invalido.
				if (i == 0 && octet == 0 || i == 3 && (octet == 0 || octet == 255))
					return false;
			}
			
			return true;
		}
		
		return false;
		
	}
	/**
	 * Metodo responsavel por fazer a validacao da porta.
	 * @param port
	 * @return boolean
	 */
	private boolean validatePort(String port) {
		try {
			int portInt = Integer.parseInt(port);
			
			 // Faixa de portas tcp disponiveis.
			return (portInt > 0 && portInt < 65536);
		}catch(Exception ex) {
			return false;
		}
	}
	/**
	 * Metodo responsavel por estabelecer a conexao com o servidor.
	 *
	 * @param ip = Maquina em que a aplicacao servidor esta.
	 * @param port = porta da maquina em que a aplicacao servidor esta rodando.
	 * @param userName = Nome do usuario.
	 * @throws UserException = Excessao causada por algum erro do usuario.
	 * @throws SystemException = Excessao causada por algum erro do sistema.
	 */
	public void openConnection(String ip, String port, String userName) throws UserException, SystemException {
		if(!this.validateIP(ip))
			throw new UserException("O IP informado e invalido!");
		
		if(!this.validatePort(port)) 
			throw new UserException("O numero de porta informado e invalido!");
		
		Socket socketClient;
		
		try {
			socketClient = new Socket(ip, Integer.parseInt(port));
			client  	 = new ClientVO(userName, socketClient);
			//Aloca os recursos para comunicacao com o servidor.
			writer = new PrintStream(socketClient.getOutputStream());
			reader = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
			new Thread(new NewMessage(), "NewMessage").start();
		}catch(IOException ex) {
			String messageError = "Nao foi possivel estabelecer conexao com o servidor!" + "\n" +
								  "Verifique se o ip e a porta informados estao corretos, " +
								  "ou tente novamente mais tarde.";
			throw new SystemException(messageError);
		}
	}
	/**
	 * Metodo responsavel por enviar mensagens ao servidor.
	 * 
	 * @param message
	 */
	public void sendMessage(String message) {
		// String newMessage = "[" + new SimpleDateFormat("hh:mm:ss").format(new Date(System.currentTimeMillis())) + "]" + client.getName() + " diz : " + message;
		String newMessage = client.getName() + " diz : " + message;
		writer.println(newMessage);
	}
	/**
	 * Metodo responsavel por receber mensagens do servidor e repassar aos objetos interessados
	 * em receber notificacoes deste, nesse caso, o controller.
	 */
	public void receiveMessage(String message) throws SystemException {
		listener.firePropertyChange(null, null, message);
		
		if (message.equalsIgnoreCase("end"))
			closeConnection("byServer");
	}
	/**
	 * Metodo responsavel por finalizar a comunicacao com o servidor.
	 */
	public void closeConnection(String origem) throws SystemException {
		try {
			//Notifica o servidor que vai fechar a conexao e desaloca os recursos.
			if (origem.equalsIgnoreCase("byClient"))
				writer.println("end");
			
			writer.close();
			reader.close();
			client.getSocket().close();
			
		} catch (IOException e) {
			throw new SystemException("Ocorreu um erro inesperado ao tentar finalizar a conexao com o servidor!");
		}
	}
	
	private class NewMessage implements Runnable {
		@Override
		public void run() {
			String message;
			boolean value = true;
			
			while(value) {
				try {
					message = reader.readLine();
					
					value = !message.equals("end");
					
					if (!message.startsWith(client.getName()))
						receiveMessage(message);
					
				} catch(NullPointerException e) {
					value = false;
				} catch (IOException e) {
					
				}
			}
		}
	}
}
