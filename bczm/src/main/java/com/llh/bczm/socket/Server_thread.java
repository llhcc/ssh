package com.llh.bczm.socket;

import java.net.ServerSocket;
import java.net.Socket;

public class Server_thread {

	public static void main(String[] args) {
		//服务器线程处理
		//和本线程相关的socket
		Socket socket =null;
		//
		public serverThread(Socket socket){
		this.socket = socket;
		}

		public void run(){
		//服务器处理代码
		}

		//============================================
		//服务器代码
		ServerSocket serverSocket =new ServerSocket(10086);
		Socket socket =null;
		int count =0;//记录客户端的数量
		while(true){
		socket = serverScoket.accept();
		ServerThread serverThread =new ServerThread(socket);
		 serverThread.start();
		 count++;
		System.out.println("客户端连接的数量："+count);
		}
	}

}
