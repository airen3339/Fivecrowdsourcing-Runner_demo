package runnerServlet;

import java.io.PrintWriter;
import java.io.Reader;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.zip.GZIPInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import net.sf.json.JSONArray;   
import net.sf.json.JSONObject; 

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
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        StringBuilder sb = new StringBuilder();
        BufferedReader br = request.getReader();;

        String str = null;

        // retrieve JOSNArray send to Servlet
        while ((str = br.readLine()) != null) {
            sb.append(str);
        }
        if(sb.equals(null))
        	System.out.println("BufferedReader : NULL");
        else System.out.println("BufferedReader : NOT NULL");
        
        String req = sb.toString();
        //String req = "{\"requestParam\":{\"password\":\"123\", \"account\":\"abc\"}}";
        //System.out.println(req);
        
        JSONObject string_to_json = JSONObject.fromObject("{\"data\": {\"pages\": [ {\"comment\": \"just for test\"},{\"comment\": \"just for test\"}],\"total_count\": 2 },\"errcode\": 0}");
        System.out.println(string_to_json);
        JSONObject json_to_data = string_to_json.getJSONObject("data");
        System.out.println(json_to_data.toString());
        // ��һ������ȡ �ͻ��� ���������󣬻ָ���Json��ʽ����>��Ҫ�ͻ��˷�����ʱҲ��װ��Json��ʽ
        JSONObject object = JSONObject.fromObject(req);
        System.out.println(object);
      
     // requestCode��ʱ�ò���
     		// ע���±��õ���2���ֶ�����requestCode��requestParamҪ�Ϳͻ���CommonRequest��װʱ�������һ��
     		//String str1 = object.getString("account");
        
     		JSONObject requestParam = object.getJSONObject("requestParam");
     		System.out.println(requestParam.toString());
     		
        // �ڶ�������Jsonת��Ϊ������ݽṹ����ʹ�û���ֱ��ʹ�ã��˴�ֱ��ʹ�ã�������ҵ�������ɽ��
        // ƴ��SQL��ѯ���
        String sql = String.format("SELECT * FROM %s WHERE account='%s'", 
                DBUtil.TABLE_ACCOUNT, 
                requestParam.getString("account"));
        System.out.println(sql);

        // �Զ���Ľ����Ϣ��
        commonResponse res = new commonResponse();
        try {
            ResultSet result = DBUtil.query(sql); // ���ݿ��ѯ����
            if (result.next()) {
                if (result.getString("password").equals(requestParam.getString("password"))) {
                    res.setResult("0", "��½�ɹ�");
                    res.getProperty().put("user_Id", result.getString("user_id"));
                } else {
                    res.setResult("100", "��¼ʧ�ܣ���¼�������");
                }
            } else {
                res.setResult("200", "�õ�½�˺�δע��");
            }
        } catch (SQLException e) {
            res.setResult("300", "���ݿ��ѯ����");
            e.printStackTrace();
        }

        // ���������������װ��Json��ʽ׼�����ظ��ͻ��ˣ���ʵ�����紫��ʱ���Ǵ���json���ַ���
        // ������֮ǰ��String����һ����ֻ��Json�ṩ���ض����ַ���ƴ�Ӹ�ʽ
        String resStr = JSONObject.fromObject(res).toString();
        System.out.println(resStr);
//      response.getWriter().append(EncryptUtil.getEDSEncryptStr(resStr)); // ���Զ��ַ������м��ܲ�������Ӧ�ĵ��˿ͻ��˾���Ҫ����
        response.getWriter().append(resStr).flush();
    }

}