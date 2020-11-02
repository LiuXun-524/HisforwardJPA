package com.example.demojpa.domain.entity;

import java.util.List;

public class RespMsg<T> {
	//0是成功，999是数据库错误，-1是服务器端异常
	private int code;
	//成功或错误描述
	private String msg;

	private List<T> list;//<T>代表object类型
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public RespMsg(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
}
