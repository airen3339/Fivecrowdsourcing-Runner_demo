package runnerServlet;

import java.util.ArrayList;
import java.util.HashMap;

public class commonResponse {

	private String resCode;//״̬��
	private String resMsg;//״̬��Ϣ

	private HashMap<String, String> property;//�����Ϣ

	private ArrayList<HashMap<String, String>> list;

	public commonResponse() {
		super();
		resCode = "";
		resMsg = "";
		property = new HashMap<String, String>();
		list = new ArrayList<HashMap<String, String>>();

	}

	public void setResult(String resCode, String resMsg) {
		this.resCode = resCode;
		this.resMsg = resMsg;
	}

	public String getResCode() {
		return resCode;
	}

	public void setResCode(String resCode) {
		this.resCode = resCode;
	}

	public String getResMsg() {
		return resMsg;
	}

	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}

	public HashMap<String, String> getProperty() {
		return property;
	}

	public void addListItem(HashMap<String, String> map) {
		list.add(map);
	}
	
	public ArrayList<HashMap<String, String>> getList() {
		return list;
	}
}
