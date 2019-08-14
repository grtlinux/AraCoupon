package kr.co.arajeju.aracoupon3.vo;

import java.io.Serializable;

import kr.co.arajeju.aracoupon3.util.Flag;

public class SessionVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String itmNo;
	private String itmTyp;
	private String loginYn;
	private String lastDttm; // yyyy-MM-dd HH:mm:ss

	//////////////////////////////////////////////////

	public SessionVO() throws Exception {
		this.itmNo = "1001";
		this.itmTyp = "USR";
		this.loginYn = "Y";
		this.lastDttm = Flag.getDateTime("yyyy-MM-dd HH:mm:ss");
	}
	public SessionVO(String itmNo, String itmTyp, String loginYn) throws Exception {
		this.itmNo = itmNo;
		this.itmTyp = itmTyp;
		this.loginYn = loginYn;
		this.lastDttm = Flag.getDateTime("yyyy-MM-dd HH:mm:ss");
	}
	public String getItmNo() {
		return itmNo;
	}
	public void setItmNo(String itmNo) {
		this.itmNo = itmNo;
	}
	public String getItmTyp() {
		return itmTyp;
	}
	public void setItmTyp(String itmTyp) {
		this.itmTyp = itmTyp;
	}
	public String getLoginYn() {
		return loginYn;
	}
	public void setLoginYn(String loginYn) {
		this.loginYn = loginYn;
	}
	public String getLastDttm() {
		return lastDttm;
	}
	public void setLastDttm(String lastDttm) {
		this.lastDttm = lastDttm;
	}
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(String.format("SessionVO: [itmNo,itmTyp,loginYn,lastDttm]=[%s,%s,%s,%s]", this.itmNo, this.itmTyp, this.loginYn, this.lastDttm));
		return sb.toString();
	}
}
