package com.llh.bczm.socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;

public class InetAddress_ {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		//获取本机的InetAddress实例
		InetAddress address =InetAddress.getLocalHost();
		System.out.println(address.getHostName());//获取计算机名
		System.out.println(address.getHostAddress());//获取IP地址
		byte[] bytes = address.getAddress();//获取字节数组形式的IP地址,以点分隔的四部分
		System.out.println(bytes);
		//获取其他主机的InetAddress实例
		InetAddress address2 =InetAddress.getByName("IT-lanlonghui");
		InetAddress address3 =InetAddress.getByName("10.10.152.22");
		System.out.println(address2.getHostAddress());
		System.out.println(address3.getHostName());
		
		//创建一个URL的实例
		URL baidu =new URL("http://www.baidu.com?u=9");
		URL url =new URL(baidu,"/index.html?username=tom#test");//？表示参数，#表示锚点
		System.out.println(url.getProtocol());//获取协议
		System.out.println(url.getHost());//获取主机
		System.out.println(url.getPort());//如果没有指定端口号，根据协议不同使用默认端口。此时getPort()方法的返回值为 -1
		System.out.println(url.getPath());//获取文件路径
		System.out.println(url.getFile());//文件名，包括文件路径+参数
		System.out.println(url.getRef());//相对路径，就是锚点，即#号后面的内容
		System.out.println(url.getQuery());//查询字符串，即参数
		
		System.out.println(baidu.getQuery());//查询字符串，即参数
		
		
		url();
		
		
	}
	
	public static void url() throws Exception{
		//使用URL读取网页内容
		//创建一个URL实例
		URL url =new URL("http://www.baidu.com");
		InputStream is = url.openStream();//通过openStream方法获取资源的字节输入流
		InputStreamReader isr =new InputStreamReader(is,"UTF-8");//将字节输入流转换为字符输入流,如果不指定编码，中文可能会出现乱码
		BufferedReader br =new BufferedReader(isr);//为字符输入流添加缓冲，提高读取效率
		String data = br.readLine();//读取数据
		while(data!=null){
		System.out.println(data);//输出数据
		data = br.readLine();
		}
		br.close();
		isr.close();
		is.close();
	}

}
