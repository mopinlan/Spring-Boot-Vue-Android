package com.zwj.news.jsbridge;


public interface LvUJsBridge {
	
	public void send(String data);
	public void send(String data, CallBackFunction responseCallback);
	
	

}
