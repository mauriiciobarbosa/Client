package br.com.client.view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import br.com.client.business.ClientBO;
import br.com.client.exception.SystemException;
import br.com.client.exception.UserException;
/**
 * Classe responsavel por repassar aos objetos cadastrados, notificacoes de atualizacao de estado de
 * outros objetos.
 * 
 * @author Mauricio Barbosa
 *
 */
public class ClientController implements PropertyChangeListener {
	/**
	 * Objeto que armazena a view interessada em enviar e receber notificacoes de atualizacao.
	 */
	private ClientView 	registreredClientView;
	/**
	 * Objeto que armazena o "modelo" interessado em enviar e receber notificacoes de atualizacao.
	 */
	private ClientBO 	registreredClientBO;
	private static ClientController instance;
	
	private ClientController() {}
	
	public static ClientController getInstance() {
		if (instance == null)
			instance = new ClientController();
		
		return instance;
	}
	
	/**
	 * Metodo responsavel por adicionar views interessadas em receber notificacoes de atualizacao.
	 * Nesse caso, sera somente uma view do tipo ClientView.
	 * 
	 * @param clientView
	 */
	public void addclientView(ClientView clientView) {
		this.registreredClientView = clientView;
	}
	/**
	 * Metodo responsavel por adicionar "modelos" interessados em receber notificacoes para ser atualizado.
	 * Vale ressaltar que este controller tem interesse em receber notificacoes de alteracao de estado do modelo
	 * (novas mensagens), sendo assim, se faz necessario "assinar o model".
	 * 
	 * @param clientBO
	 */
	public void addClientBO(ClientBO clientBO) {
		this.registreredClientBO = clientBO;
	}
	/**
	 * Metodo responsavel por repassar a camada de negocios a solicitacao de abertura de conexao com o servidor,
	 * efetuada pela view.
	 * 
	 * @param ip = Maquina em que a aplicacao servidor esta.
	 * @param port = porta da maquina em que a aplicacao servidor esta rodando.
	 * @param userName = Nome do usuario.
	 * @throws UserException = Excessao causada por algum erro do usuario.
	 * @throws SystemException = Excessao causada por algum erro do sistema.
	 */
	public void openConnection(String ip, String port, String userName) throws SystemException, UserException {
		registreredClientBO.openConnection(ip, port, userName);
	}
	/**
	 * Metodo responsavel por repassar a camada de negocios a solicitacao de envio de mensagem ao servidor,
	 * efetuada pela view. 
	 * 
	 * @param message
	 */
	public void sendMessage(String message) {
		registreredClientBO.sendMessage(message);
	}
	/**
	 * Metodo responsavel por repassar a camada de negocios a solicitacao de finalizacao de comunicacao
	 * como o servidor, efetuada pela view.
	 */
	public void closeConnection() throws SystemException {
		this.registreredClientBO.closeConnection("byClient");
	}
	/**
	 * Metodo responsavel por repassar a view notificacoes de Novas mensagens.
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		this.registreredClientView.newMessage(evt);
	}
}
