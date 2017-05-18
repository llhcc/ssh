package com.llh.dsubmit;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DoFormServlet extends HttpServlet{

	 /**
	 * 场景一：在网络延迟的情况下让用户有时间点击多次submit按钮导致表单重复提交
	 * 场景二：表单提交后用户点击【刷新】按钮导致表单重复提交
	 * 场景三：用户提交表单后，点击浏览器的【后退】按钮回退到表单页面后进行再次提交
	 * 使用JavaScript防止表单重复提交的做法只对上述提交到导致表单重复提交的三种场景中的【场景一】有效，而对于【场景二】和【场景三】是没有用，依然无法解决表单重复提交问题。
	 * 
	 * 对于【场景二】和【场景三】导致表单重复提交的问题，既然客户端无法解决，那么就在服务器端解决，在服务器端解决就需要用到session了。

	　　具体的做法：在服务器端生成一个唯一的随机标识号，专业术语称为Token(令牌)，同时在当前用户的Session域中保存这个Token。然后将Token发送到客户端的Form表单中，在Form表单中使用隐藏域来存储这个Token，表单提交的时候连同这个Token一起提交到服务器端，然后在服务器端判断客户端提交上来的Token与服务器端生成的Token是否一致，如果不一致，那就是重复提交了，此时服务器端就可以不处理重复提交的表单。如果相同则处理表单提交，处理完后清除当前用户的Session域中存储的标识号。
	　　在下列情况下，服务器程序将拒绝处理用户提交的表单请求：
	
	      存储Session域中的Token(令牌)与表单提交的Token(令牌)不同。
	      当前用户的Session中不存在Token(令牌)。
	      用户提交的表单数据中没有Token(令牌)。
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	private static final long serialVersionUID = -6910839182828919245L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        //客户端是以UTF-8编码传输数据到服务器端的，所以需要设置服务器端以UTF-8的编码进行接收，否则对于中文数据就会产生乱码
	        request.setCharacterEncoding("UTF-8");
	        String userName = request.getParameter("username");
	        try {
	            //让当前的线程睡眠3秒钟，模拟网络延迟而导致表单重复提交的现象
	            Thread.sleep(3*1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        System.out.println("向数据库中插入数据："+userName);
	    }

	    public void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        doGet(request, response);
	    }

}
