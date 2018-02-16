package runnerServlet;
/*
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
*/
import runnerServlet.DBUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;

/*
import beans.CommonRequest;
import beans.CommonResponse;
import constants.DBNames;
import encrypt.DecryptUtil;
import encrypt.EncryptUtil;

import util.DatabaseUtil;*/

/**
 * runnerServlet implementation class runnerRegister
 */
@WebServlet(
		description = "runner��¼", 
		urlPatterns = { "/runnerRegister" } 
		)
public class runnerRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public runnerRegister() {
        // TODO Auto-generated constructor stub
    }
    @Override  
  /*  protected void service(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        String method = request.getMethod();  
        if ("GET".equals(method)) {  
           System.out.println("���󷽷���GET");  
            doGet(request, response);  
        } else if ("POST".equals(method)) {  
            System.out.println("���󷽷���POST");  
            doPost(request, response);  
        } else {  
            System.out.println("���󷽷��ֱ�ʧ�ܣ�");  
        }  
    }  */
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("��֧��GET����;");
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
		        
		      
		        // ��һ������ȡ �ͻ��� ���������󣬻ָ���Json��ʽ����>��Ҫ�ͻ��˷�����ʱҲ��װ��Json��ʽ
		        JSONObject object = JSONObject.fromObject(req);
		        System.out.println(object);
		      
		     // requestCode��ʱ�ò���
		     		// ע���±��õ���2���ֶ�����requestCode��requestParamҪ�Ϳͻ���CommonRequest��װʱ�������һ��
		     		//String str1 = object.getString("account");
		        
		     		JSONObject requestParam = object.getJSONObject("requestParam");
		     		System.out.println(requestParam.toString());
		     		
		     		String account = requestParam.getString("account"); // �� request �л�ȡ��Ϊ account �Ĳ�����ֵ  
		            String password = requestParam.getString("password"); // �� request �л�ȡ��Ϊ password �Ĳ�����ֵ  
		     		
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
		            if(result.next()){ // �Ѵ���  
		            	res.setResult("201", "���˺���ע�ᣬ��ʹ�ô��˺�ֱ�ӵ�¼��ʹ�������˺�ע��");
		            }		                      
		            else { // ������  
		                String sqlInsertPass = "insert into " + DBUtil.TABLE_ACCOUNT+ "(account,password) values('"+account+"','"+password+"')";  
		                // �������������һ��int���͵�ֵ������ò���Ӱ�쵽������  
		                int row1 = DBUtil.update(sqlInsertPass); // �����ʺ�����  
		                if(row1 == 1){  
		                System.out.println( "����ɹ���");
		                res.setResult("100", "ע��ɹ�");
		              
		            } 
		            }
		        }
		            catch (SQLException e) {
		            res.setResult("300", "���ݿ��ѯ����");
		            e.printStackTrace();
		        }

		        // ���������������װ��Json��ʽ׼�����ظ��ͻ��ˣ���ʵ�����紫��ʱ���Ǵ���json���ַ���
		        // ������֮ǰ��String����һ����ֻ��Json�ṩ���ض����ַ���ƴ�Ӹ�ʽ
		        String resStr = JSONObject.fromObject(res).toString();
		        System.out.println(resStr);
//		      response.getWriter().append(EncryptUtil.getEDSEncryptStr(resStr)); // ���Զ��ַ������м��ܲ�������Ӧ�ĵ��˿ͻ��˾���Ҫ����
		        response.getWriter().append(resStr).flush(); 
	      
	}
	

}
