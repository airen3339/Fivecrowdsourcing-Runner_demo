package runnerServlet;

import java.io.PrintWriter;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * runnerServlet implementation class runnerLogin
 */
@WebServlet(
		description = "runner��¼", 
		urlPatterns = { "/runnerLogin" }, 
		initParams = { 
				@WebInitParam(name = "account", value = "wang", description = "�ʺ�"), 
				@WebInitParam(name = "password", value = "", description = "����")
		})
public class runnerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public runnerLogin() {
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// request.setCharacterEncoding("utf-8");  //���������ĸ�ʽ
		 
		//doPost(request,response);//��ת��dopost����
		 //String account = request.getParameter("account"); // �� request �л�ȡ��Ϊ account �Ĳ�����ֵ 
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//�������ԣ���ӡ�˻���
		/* response.setContentType("text/html;charset=utf-8"); // ������Ӧ���ĵı����ʽ  
		PrintWriter pw =response.getWriter();
		pw.println("getAccount��"+account);
		pw.flush();*/
		String code = "";  
        String message = "";  
        
        
		  String account = request.getParameter("account"); // �� request �л�ȡ��Ϊ account �Ĳ�����ֵ  
		  String password = request.getParameter("password"); // �� request �л�ȡ��Ϊ password �Ĳ�����ֵ  
		    System.out.println("account:" + account + "\npassword:" + password); // ��ӡ������һ��  
		  
		    /*String result = "";  
		    if("��x".equals(account)   
		            && "��x".equals(password)){ // �������  
		        result = "Login Success!" + "�ɹ��ˣ�"; // ��ӦҲ�ӵ�����  
		    }else {  
		        result = "Sorry Account or password error." + "�е����⣡"; // ��ӦҲ�ӵ�����  
		    }  
		    /* ��������ֻ��ģ����һ����򵥵�ҵ���߼�����Ȼ�����ʵ��ҵ������൱���� */  
		      
		    /*PrintWriter pw = response.getWriter(); // ��ȡ response �������  
		    pw.println(result); // ͨ���������ҵ���߼��Ľ�����  
		    pw.flush(); */
		    
		    
	        try {  
	        	 Connection connect = DBUtil.getConnection(); 
	        	if(!connect.isClosed()) 
	                System.out.println("Succeeded connecting to the Database!");
	                else System.out.println("Failed connecting to the Database!");
	        	
	      
	            Statement statement =  connect.createStatement(); // Statement�������Ϊ���ݿ����ʵ���������ݿ�����в�����ͨ������ʵ��  
	            
	            String sql = "select account from " + DBUtil.TABLE_ACCOUNT + " where account='" + account  
	                    + "' and password='" + password + "'";  
	            System.out.println(sql);  
	            ResultSet result = DBUtil.query(sql);  
	            if (result.next()) { // �ܲ鵽���˺ţ�˵���Ѿ�ע�����  
	                code = "200";  
	                message = "��½�ɹ�";  
	            } else {  
	  
	                code = "100";  
	                message = "��¼ʧ�ܣ����벻ƥ����˺�δע��";  
	            }  
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        }  
	        response.setContentType("text/html;charset=utf-8"); // ������Ӧ���ĵı����ʽ  
	        response.getWriter().append("code:").append(code).append(";message:").append(message);  
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 request.setCharacterEncoding("utf-8");  //���������ĸ�ʽ
		 response.setContentType("text/html;charset=utf-8"); // ������Ӧ���ĵı����ʽ  
		 
		String account = request.getParameter("account"); // �� request �л�ȡ��Ϊ account �Ĳ�����ֵ 
		String password = request.getParameter("password"); // �� request �л�ȡ��Ϊpassword �Ĳ�����ֵ 
		
		System.out.println("account:" + account + "\npassword:" + password); // ��ӡ������һ�� 
		
		
		PrintWriter pw =response.getWriter();
		pw.println("postAccount��"+account+" postPassword:"+password);
		pw.flush();
	}

}
