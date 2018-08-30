package com.internousdev.glanq.action;

import java.util.Date;
import java.util.Map;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class MailSendAction extends ActionSupport implements SessionAware{
	private String loginId;
	private String password;
	private String categoryId;

	private Map<String,Object>session;


	//public static void main(String[] args){
	public String execute(){
		String result = ERROR;
		result = SUCCESS;


		try{
			//SMTPサーバー設定
			Properties props = System.getProperties();
			final String userName = "ksy05x30";
			final String password = "password";
			String host = "localhost";
			String from = "rob@rnwood.co.uk";
			props.setProperty("localhost", "25");
			props.setProperty("localhost", "true");
			props.put("mail.smtp.starttls.enable", "ture");
			Session session = Session.getInstance(props, new Authenticator(){
				protected PasswordAuthentication getPasswordAuthentication(){
					return new PasswordAuthentication(userName,password);
				}
			});
			MimeMessage mimeMessage = new MimeMessage(session);

			//送信元メールアドレスと送信者を指定
			mimeMessage.setFrom(new InternetAddress(userName + "@yahoo.co.jp",userName,"UTF-8"));

			//送信先メールアドレスを指定
			mimeMessage.setRecipients(Message.RecipientType.TO,"rob@rnwood.co.uk");

			//メールのタイトルを指定
			mimeMessage.setSubject("メールテスト","UTF-8");

			//メールの内容を指定
			mimeMessage.setText("こんにちは\n","UTF-8");

			//メールの形式を指定
			mimeMessage.setHeader("Content-Type", "text/html");

			//送信日時を指定
			mimeMessage.setSentDate(new Date());

			//送信します
			Transport transport = session.getTransport("smtp");
			transport.connect(host, from, password);
			transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
			transport.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}


	public Map<String, Object> getSession() {
		return session;
	}


	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


	public String getLoginId() {
		return loginId;
	}


	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}





}
