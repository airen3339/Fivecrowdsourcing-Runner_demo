package runnerServlet;

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

import runnerServlet.DBUtil;

/**
 * runnerServlet implementation class runnerRegister
 */
@WebServlet(
		description = "runner��¼", 
		urlPatterns = { "/runnerRegister" }, 
		initParams = { 
				@WebInitParam(name = "account", value = "wang", description = "�ʺ�"), 
				@WebInitParam(name = "password", value = "", description = "����")
		})
public class runnerRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public runnerRegister() {
        // TODO Auto-generated constructor stub
    }
    @Override  
    protected void service(HttpServletRequest request, HttpServletResponse response)  
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
    }  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*String account;  
	    String password;  
	      
	    BufferedReader reader = request.getReader();  
	    String requestStr = reader.readLine();  
	   // LogUtil.log(requestStr); // �鿴һ���õ��Ĳ����Ǹ�ʲô���Ľṹ��Ȼ��������ԵĽ���  
	      System.out.println(requestStr);
	    HashMap<String, String> requestMap = parseStrToMap(requestStr);  
	    account =requestMap.get("account");  
	    password = requestMap.get("password");  
	      
	    response.getWriter().append("���ύ���˺�Ϊ: ").append(account).append("\n���룺").append(password);  */
		 BufferedReader reader = request.getReader();  
		    String requestStr = reader.readLine();  
		String account = request.getParameter("account"); // �� request �л�ȡ��Ϊ account �Ĳ�����ֵ  
        String password = request.getParameter("password"); // �� request �л�ȡ��Ϊ password �Ĳ�����ֵ  
        System.out.println("account:" + account + "\npassword:" + password); // ��ӡ������һ��  
       
	   // LogUtil.log(requestStr); // �鿴һ���õ��Ĳ����Ǹ�ʲô���Ľṹ��Ȼ��������ԵĽ���  
	      System.out.println(requestStr);
	      
        String resCode = "";  
        String resMsg = "";  
        String userId = ""; 
        if(account!=null&&password!=null)
		{try {  
			//���������ݿ������
	            Connection connect = DBUtil.getConnection();  
	            if(!connect.isClosed()) 
	                System.out.println("Succeeded connecting to the Database!");
	                else System.out.println("Failed connecting to the Database!");
	            Statement statement =  connect.createStatement(); // Statement�������Ϊ���ݿ����ʵ���������ݿ�����в�����ͨ������ʵ��  
	            
	            ResultSet result;  
	              
	            String sqlQuery = "select * from " +DBUtil.TABLE_ACCOUNT  + " where account='" + account + "'";  
	              
	            // ��ѯ���������һ��ResultSet���ϣ�û�в鵽���ʱResultSet�ĳ���Ϊ0  
	            result = statement.executeQuery(sqlQuery); // �Ȳ�ѯͬ�����˺ţ������ֻ��ţ��Ƿ����  
	            if(result.next()){ // �Ѵ���  
	                resCode = "201";  
	                resMsg = "���˺���ע�ᣬ��ʹ�ô��˺�ֱ�ӵ�¼��ʹ�������˺�ע��";  
	                userId = "";  
	                
	            } else { // ������  
	                String sqlInsertPass = "insert into " + DBUtil.TABLE_ACCOUNT+ "(account,password) values('"+account+"','"+password+"')";  
	                // �������������һ��int���͵�ֵ������ò���Ӱ�쵽������  
	                int row1 = statement.executeUpdate(sqlInsertPass); // �����ʺ�����  
	                if(row1 == 1){  
	                System.out.println( "����ɹ���");
	             
	                  
	                    resCode = "100";  
	                    resMsg = "ע��ɹ�";  
	                    
	            } 
	            }
	              
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	           
	        } }
        else { resCode = "202";  
        resMsg = "�ʺ�����Ϊ��"; }
	          
	        HashMap<String, String> map = new HashMap<>();  
	        map.put("resCode", resCode);  
	        map.put("resMsg", resMsg);  
	        map.put("userId", userId);  
	          
	        response.setContentType("text/html;charset=utf-8"); // ������Ӧ���ĵı����ʽ  
	        PrintWriter pw = response.getWriter(); // ��ȡ response �������  
	        pw.println(map.toString()); // ͨ���������ҵ���߼��Ľ�����  
	        pw.flush();  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account;  
	    String password;  
	      
	    BufferedReader reader = request.getReader();  
	    String requestStr = reader.readLine();  
	   // LogUtil.log(requestStr); // �鿴һ���õ��Ĳ����Ǹ�ʲô���Ľṹ��Ȼ��������ԵĽ���  
	      System.out.println(requestStr);
	    HashMap<String, String> requestMap = parseStrToMap(requestStr);  
	    account =requestMap.get("account");  
	    password = requestMap.get("password");  
	      
	    response.getWriter().append("���ύ���˺�Ϊ: ").append(account).append("\n���룺").append(password);  
	      
	}
	
	private HashMap<String, String> parseStrToMap(String str) {  
	    HashMap<String, String> resultMap = new HashMap<>();  
	    String[] items = str.split("&");  
	    String[] itemStrs = new String[2];  
	    for (String item : items) {  
	        itemStrs = item.split("=");  
	        resultMap.put(itemStrs[0], itemStrs[1]);  
	    }  
	    return resultMap;  
	}  
}
