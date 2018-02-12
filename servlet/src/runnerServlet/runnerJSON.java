package runnerServlet;

import java.io.PrintWriter;
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

import net.sf.json.JSONObject;

@WebServlet(
		description = "runnerJSON", 
		urlPatterns = { "/runnerJSON" }
		)
public class runnerJSON extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public runnerJSON() {
		super();
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BufferedReader reader = request.getReader();  
		    String requestStr = reader.readLine();  
		   // LogUtil.log(requestStr); // �鿴һ���õ��Ĳ����Ǹ�ʲô���Ľṹ��Ȼ��������ԵĽ���  
		      System.out.println(requestStr);
		   /* HashMap<String, String> requestMap = parseStrToMap(requestStr);  
		   String account =requestMap.get("account");  
		   String password = requestMap.get("password");  
		      
		    response.getWriter().append("���ύ���˺�Ϊ: ").append(account).append("\n���룺").append(password);  
		   
		
		/* BufferedReader read = request.getReader();
	        StringBuilder sb = new StringBuilder();
	        String line = null;
	        while ((line = read.readLine()) != null) {
	            sb.append(line);
	            System.out.println(line);
	        }
	        System.out.println(sb);
	        String req = sb.toString();
	        System.out.println(req);*/

	        // ��һ������ȡ �ͻ��� ���������󣬻ָ���Json��ʽ����>��Ҫ�ͻ��˷�����ʱҲ��װ��Json��ʽ
	        /*JSONObject object = JSONObject.fromObject(req);

	        // �ڶ�������Jsonת��Ϊ������ݽṹ����ʹ�û���ֱ��ʹ�ã��˴�ֱ��ʹ�ã�������ҵ�������ɽ��
	        // ƴ��SQL��ѯ���
	        String sql = String.format("SELECT * FROM %s WHERE account='%s'", 
	                DBNames.Table_Account, 
	                object.getString("name"));
	        System.out.println(sql);

	        // �Զ���Ľ����Ϣ��
	        CommonResponse res = new CommonResponse();
	        try {
	            ResultSet result = DatabaseUtil.query(sql); // ���ݿ��ѯ����
	            if (result.next()) {
	                if (result.getString("password").equals(object.getString("password"))) {
	                    res.setResult("0", "��½�ɹ�");
	                    res.getProperty().put("custId", result.getString("_id"));
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
//	      response.getWriter().append(EncryptUtil.getEDSEncryptStr(resStr)); // ���Զ��ַ������м��ܲ�������Ӧ�ĵ��˿ͻ��˾���Ҫ����
	        response.getWriter().append(resStr).flush();*/
	    }


}
