package net.utility;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MyAuthenticator extends Authenticator{
	//메일서버(POP3/SMTP)에서 인증 받은 계정+비번
	
	private PasswordAuthentication pa;
	
	//기본생성자
	public MyAuthenticator() {
		pa=new PasswordAuthentication("soldesk@pretyimo.cafe24.com","soldesk6901");
	}//end
	
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return pa;
	}
	
}//class end
