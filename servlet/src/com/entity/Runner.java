package com.entity;

public class Runner {
  private Long runnerid;//������id
  private String phone;//�绰
  private String name;//����
  private String password;//����
  private String idcardnumber;//����֤��
  private String photoofidcardinhand;//�ֳ�����֤�մ洢��ַ
  private String photoofidcardoppo;//����֤�����մ洢��ַ
  private String photoofidcardposi;//����֤�����մ洢��ַ
  private String photoofhealcert;//����֤��Ƭ�洢��ַ
  private Double balance;//���
  private int integral;//����
 
  private short margin;//��֤���ύ״̬��1���ύ��2��δ�ύ
  
  public Long getRunnerid() {
    return runnerid;
  }

  public void setRunnerid(Long runnerid) {
    this.runnerid = runnerid;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getIdcardnumber() {
    return idcardnumber;
  }

  public void setIdcardnumber(String idcardnumber) {
    this.idcardnumber = idcardnumber;
  }

  public String getPhotoofidcardinhand() {
    return photoofidcardinhand;
  }

  public void setPhotoofidcardinhand(String photoofidcardinhand) {
    this.photoofidcardinhand = photoofidcardinhand;
  }

  public String getPhotoofidcardoppo() {
    return photoofidcardoppo;
  }

  public void setPhotoofidcardoppo(String photoofidcardoppo) {
    this.photoofidcardoppo = photoofidcardoppo;
  }

  public String getPhotoofidcardposi() {
    return photoofidcardposi;
  }

  public void setPhotoofidcardposi(String photoofidcardposi) {
    this.photoofidcardposi = photoofidcardposi;
  }

  public String getPhotoofhealcert() {
    return photoofhealcert;
  }

  public void setPhotoofhealcert(String photoofhealcert) {
    this.photoofhealcert = photoofhealcert;
  }

  public Double getBalance() {
	return balance;
}

public void setBalance(Double balance) {
	this.balance = balance;
}

public int getIntegral() {
	return integral;
}

public void setIntegral(int integral) {
	this.integral = integral;
}

public short getMargin() {
    return margin;
  }

  public void setMargin(short margin) {
    this.margin = margin;
  }

  public String getPassword() {
  	  return password;
  }

  public void setPassword(String password) {
	  this.password = password;
  }
}