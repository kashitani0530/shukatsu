package com.internousdev.glanq.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.glanq.dao.UserInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordCompleteAction extends ActionSupport implements SessionAware {
	private String loginId;
	private String password;
	private String categoryId;
	private Map<String, Object> session;

	public String execute() {
		String result = ERROR;
		String token = String.valueOf(session.get("token"));
		if (token == "admin") {
			result = "admin";
			return result;
		}
		UserInfoDAO userInfoDAO = new UserInfoDAO();

		// sessionに格納されている新しいパスワードをresetPassword機能に渡す
		int count = userInfoDAO.resetPassword(String.valueOf(session.get("loginId")),
				String.valueOf(session.get("newPassword")));
		if (count > 0) {
			session.remove("loginId");
			result = SUCCESS;
		} else {
			result = ERROR;
		}
		return result;
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

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
