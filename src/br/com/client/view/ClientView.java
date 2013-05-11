/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.client.view;

import java.beans.PropertyChangeEvent;

import javax.swing.JOptionPane;

import br.com.client.exception.SystemException;
import br.com.client.exception.UserException;

/**
 * Classe responsavel por estabelecer a comunicacao direta com o usuario.
 *
 * @author Mauricio Barbosa
 */
public class ClientView extends javax.swing.JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String VERSION = "v1.2.5 beta";
	private static final String CONNECTION_OPEN = "OPEN";
	private static final String CONNECTION_CLOSE = "CLOSE";
	private String userName;
	/**
	 * Objeto resposavel por referenciar o controller.
	 */
	private ClientController controller;
    /**
     * Creates new form ClientView
     */
    public ClientView() {
        // this.controller = controller;
        initComponents();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlIP = new javax.swing.JLabel();
        jtfIP = new javax.swing.JTextField();
        jbOk = new javax.swing.JButton();
        jlMessages = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaMessages = new javax.swing.JTextArea();
        jbSendMessage = new javax.swing.JButton();
        jlPorta = new javax.swing.JLabel();
        jtfPorta = new javax.swing.JTextField();
        jbFinish = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtfSendMessage = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(400, 200);
        setTitle("Client " + VERSION);
        
        jlIP.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jlIP.setText("IP:");

        jbOk.setText("Ok");
        jbOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbOkActionPerformed(evt);
            }
        });

        jlMessages.setText("Mensagens:");

        jtaMessages.setEditable(false);
        jtaMessages.setColumns(20);
        jtaMessages.setRows(5);
        jtaMessages.setEnabled(false);
        jScrollPane1.setViewportView(jtaMessages);

        jbSendMessage.setText("Enviar");
        jbSendMessage.setEnabled(false);
        jbSendMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSendMessageActionPerformed(evt);
            }
        });

        jlPorta.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jlPorta.setText("Porta:");

        jbFinish.setText("Sair");
        jbFinish.setEnabled(false);
        jbFinish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFinishActionPerformed(evt);
            }
        });

        jtfSendMessage.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jtfSendMessage.setEnabled(false);
        jScrollPane2.setViewportView(jtfSendMessage);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlMessages)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbSendMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbFinish, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jlIP)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jtfIP)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jlPorta)
                            .addGap(18, 18, 18)
                            .addComponent(jtfPorta, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jbOk))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlIP)
                    .addComponent(jtfIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbOk)
                    .addComponent(jlPorta)
                    .addComponent(jtfPorta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlMessages)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbSendMessage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbFinish))
                    .addComponent(jScrollPane2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Metodo responsavel por repassar ao controller o endereco ip e a porta para conexao com o servidor.
     * Caso a conexao seja estabelecida, habilita os componentes resposaveis pela conversa cliente/servidor.
     * 
     * @param evt
     */
    private void jbOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbOkActionPerformed
    	String ip 	= jtfIP.getText();
    	String port = jtfPorta.getText();
    	
    	try {
    		
    		if(ip.isEmpty() || port.isEmpty())
    			throw new UserException("O IP e a porta devem ser informados!");
    		
    		userName = JOptionPane.showInputDialog(this, "Informe o nome do usuario:","UserName",
					  									  JOptionPane.QUESTION_MESSAGE);
    		if (userName != null) {
	    		if (userName.isEmpty()) 
	    			throw new UserException("O nome do usuario deve ser informado!");
	    		
    			this.controller.openConnection(ip, port, userName);
    			
    			// Configura o estado dos componentes
    			componentsConfigure(CONNECTION_OPEN);

    		}
		} catch (SystemException | UserException e) {
			String messageError = e.getMessage();
			String typeError;
			
			if (e instanceof SystemException)
				typeError = "System Error";
			else 
				typeError = "User Error";
			
			JOptionPane.showMessageDialog(this, messageError, typeError, JOptionPane.ERROR_MESSAGE);
		}
    }//GEN-LAST:event_jbOkActionPerformed
    /**
     * Metodo responsavel por repassar ao controller a mensagem que o cliente deseja enviar ao servidor.
     * 
     * @param evt
     */
    private void jbSendMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSendMessageActionPerformed
    	String message = jtfSendMessage.getText();
   
    	if(!message.isEmpty()) {
	    	controller.sendMessage(message);
	    	
	    	jtfSendMessage.setText("");
	    	jtaMessages.append("eu : " + message + "\n");
    	}
    	
    }//GEN-LAST:event_jbSendMessageActionPerformed
    /**
     * Metodo responsavel por solicitar ao controller a finalizacao da conexao com o servidor.
     * Restaura o estado dos componentes ao mesmo do inicio da aplicacao
     * 
     * @param evt
     */
    private void jbFinishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFinishActionPerformed
        
    	String warningMessage = "Tem certeza que deseja finalizar a conexao com o servidor ?";
    	
    	int response = JOptionPane.showConfirmDialog(this, warningMessage , "End Connection", 
    								  				JOptionPane.YES_NO_OPTION, 
    								  				JOptionPane.WARNING_MESSAGE);
    	
    	if(response == JOptionPane.OK_OPTION) {
    		try {
    			controller.closeConnection();
    		} catch(SystemException e) {
    			String messageError = e.getMessage();
    			
    			JOptionPane.showMessageDialog(this, messageError, "System Error", JOptionPane.ERROR_MESSAGE);
    		}
    		
	    	//Limpa os componentes.
	    	jtfIP.setText("");
	    	jtfPorta.setText("");
	    	jtaMessages.setText("");
	    	jtfSendMessage.setText("");
	    	
	        // Configura o estado dos componentes
			componentsConfigure(CONNECTION_CLOSE);
    	}
    }//GEN-LAST:event_jbFinishActionPerformed
    /**
     * Metodo responsavel por receber do controller novas mensagens enviadas pelo servidor.
     * Atualiza o estado do componente textArea.
     * 
     * @param evt
     */
    public void newMessage(PropertyChangeEvent evt) {
    	String newMessage = (String) evt.getNewValue();
    	
    	if (newMessage.equals("end")) {
    		String message = "O servidor saiu do ar";
        	
        	JOptionPane.showMessageDialog(this, message, "System Error", JOptionPane.ERROR_MESSAGE);
        	
        	//Limpa os componentes.
        	jtfIP.setText("");
        	jtfPorta.setText("");
        	jtaMessages.setText("");
        	jtfSendMessage.setText("");
        	
            // Configura o estado dos componentes
    		componentsConfigure(CONNECTION_CLOSE);
    	} else
    		jtaMessages.append(newMessage + "\n");
    }

    private void componentsConfigure(String status) {
    	boolean value = status.equals(CONNECTION_OPEN);
    	
    	String title = "Client " + VERSION + (value ? " [User : "+ userName + "]" : "");
    	
    	setTitle(title);
    	
    	jlIP.setEnabled(!value);
		jlPorta.setEnabled(!value);
    	jtfIP.setEnabled(!value);
    	jtfPorta.setEnabled(!value);
    	jbOk.setEnabled(!value);
    	jtaMessages.setEnabled(value);
    	jtfSendMessage.setEnabled(value);
    	jbSendMessage.setEnabled(value);
    	jbFinish.setEnabled(value);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2; 
    private javax.swing.JButton jbFinish;
    private javax.swing.JButton jbOk;
    private javax.swing.JButton jbSendMessage;
    private javax.swing.JLabel jlIP;
    private javax.swing.JLabel jlMessages;
    private javax.swing.JLabel jlPorta;
    private javax.swing.JTextArea jtaMessages;
    private javax.swing.JTextField jtfIP;
    private javax.swing.JTextField jtfPorta;
    private javax.swing.JTextField jtfSendMessage;
    // End of variables declaration//GEN-END:variables
}
