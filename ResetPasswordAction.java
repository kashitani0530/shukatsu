package com.internousdev.glanq.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordAction extends ActionSupport implements SessionAware {
	private String categoryId;
	private Map<String, Object> session;
	private String loginId;
	private boolean savedLoginId;

	public String execute() {
		String result = ERROR;
		String token = String.valueOf(session.get("token"));
		if (token == "admin") {
			result = "admin";
			return result;
		}

		// sessionに格納されている対象の要素を削除
		session.remove("loginErrorMessageList");
		session.remove("passwordErrorMessageList");
		session.remove("passwordIncorrectErrorMessageList");
		session.remove("newPasswordErrorMessageList");
		session.remove("reConfirmationNewPasswordErrorMessageList");
		session.remove("newPasswordIncorrectErrorMessageList");

		// 「ログイン保存」チェックボックス対応の為変更
		if (savedLoginId == true) {
			session.put("savedLoginId", true);
			session.put("saveId", loginId);
		}

		// 天国か地獄か。。。
		result = SUCCESS;
		return result;
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

	public boolean isSavedLoginId() {
		return savedLoginId;
	}

	public void setSavedLoginId(boolean savedLoginId) {
		this.savedLoginId = savedLoginId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

}