package kr.co.arajeju.aracoupon3.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.arajeju.aracoupon3.util.Flag;

public class SessionVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String itmNo;
	private String itmTyp;
	private String loginYn;
	private String lastDttm1;
	private Timestamp lastDttm2;
	private LocalDateTime lastDttm3;  // yyyy-MM-dd HH:mm:ss

	private String str = null;        // for function toString

	//////////////////////////////////////////////////

	public SessionVO() throws Exception {
		this.itmNo = "1001";
		this.itmTyp = "USR";
		this.loginYn = "Y";
		this.lastDttm1 = Flag.getDateTime("yyyy-MM-dd HH:mm:ss");
		this.lastDttm2 = new Timestamp(new Date().getTime());
		this.lastDttm3 = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
	}
	public SessionVO(String itmNo, String itmTyp, String loginYn) throws Exception {
		this.itmNo = itmNo;
		this.itmTyp = itmTyp;
		this.loginYn = loginYn;
		this.lastDttm1 = Flag.getDateTime("yyyy-MM-dd HH:mm:ss");
		this.lastDttm2 = new Timestamp(new Date().getTime());
		this.lastDttm3 = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
	}
	public String toString() {
		//StringBuffer sb = new StringBuffer();
		//sb.append(String.format("SessionVO: [itmNo,itmTyp,loginYn,lastDttm]=[%s,%s,%s,%s]", this.itmNo, this.itmTyp, this.loginYn, this.lastDttm));
		//return sb.toString();
		if (this.str == null) {
			try {
				str = new ObjectMapper().writeValueAsString(this);
			} catch (Exception e) {
				str = "[no data]";
			}
		}
		return str;
	}
	//////////////////////////////////////////////////
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
	public String getLastDttm1() {
		return lastDttm1;
	}
	public void setLastDttm1(String lastDttm1) {
		this.lastDttm1 = lastDttm1;
	}
	public Timestamp getLastDttm2() {
		return lastDttm2;
	}
	public void setLastDttm2(Timestamp lastDttm2) {
		this.lastDttm2 = lastDttm2;
	}
	public LocalDateTime getLastDttm3() {
		return lastDttm3;
	}
	public void setLastDttm3(LocalDateTime lastDttm3) {
		this.lastDttm3 = lastDttm3;
	}
}
