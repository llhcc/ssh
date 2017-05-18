package com.llh.dsubmit;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 问题：
同一个用户打开同一个浏览器进程的多个窗口来并发访问同一个WEB站点的多个FORM表单页面时，将会出现表单无法正常提交的情况。 
解决方案：
将FORM表单的标识号作为表单隐藏字段的名称，如下所示：
<input type='hidden' name='4b15c6b2f573831b4b5107d849fcafb8' value=''>
将所有的表单标识号存储进一个Vector集合对象中，并将Vector集合对象存储进Session域中。当表单提交时，先从Session域中取出Vector集合对象，
然后再从Vector集合对象中逐一取出每个表单标识号作为参数调用HttpServletRequest.getParameter方法，如果其中有一次调用的返回值不为null，
则接受并处理该表单数据，处理完后将该表单标识号从Vector集合对象中删除。
 *
 */
public class DoFormServlet2 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

    	    try {
				Thread.sleep(3*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
            boolean b = isRepeatSubmit(request);//判断用户是否是重复提交
            if(b==true){
                System.out.println("请不要重复提交");
                return;
            }
            request.getSession().removeAttribute("token");//移除session中的token
            System.out.println("处理用户提交请求！！");
        }
        
        /**
         * 判断客户端提交上来的令牌和服务器端生成的令牌是否一致
         * @param request
         * @return 
         *         true 用户重复提交了表单 
         *         false 用户没有重复提交表单
         */
        private boolean isRepeatSubmit(HttpServletRequest request) {
            String client_token = request.getParameter("token");
            //1、如果用户提交的表单数据中没有token，则用户是重复提交了表单
            if(client_token==null){
                return true;
            }
            //取出存储在Session中的token
            String server_token = (String) request.getSession().getAttribute("token");
            //2、如果当前用户的Session中不存在Token(令牌)，则用户是重复提交了表单
            if(server_token==null){
                return true;
            }
            //3、存储在Session中的Token(令牌)与表单提交的Token(令牌)不同，则用户是重复提交了表单
            if(!client_token.equals(server_token)){
                return true;
            }
            
            return false;
        }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}