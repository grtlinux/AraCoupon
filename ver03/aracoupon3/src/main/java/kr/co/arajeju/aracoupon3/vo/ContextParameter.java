package kr.co.arajeju.aracoupon3.vo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import kr.co.arajeju.aracoupon3.common.interceptor.ActionInterceptor;
import kr.co.arajeju.aracoupon3.util.Flag;

@Component
public class ContextParameter {

	protected Log log = LogFactory.getLog(ActionInterceptor.class);

	// server.static.url = http://localhost
	@Value("#{contextProperties['server.static.url']}")
	private String staticURL;

	@Value("#{contextProperties['server.static.path']}")
	private String staticPATH;

	// server.static.url.sasurl = http://11campb-operwb-alp01:7980
	@Value("#{contextProperties['server.static.url.sasurl']}")
	private String staticPATHSasurl;

	// server.static.vaurl=http://11campb-operwb-alp01:7980
	@Value("#{contextProperties['server.static.vaurl']}")
	private String staticPATHSvaurl;

	// server.type.chk = DEV
	@Value("#{contextProperties['server.type.chk']}")
	private String staticServerType;

	// server.type.aprvid = admin
	@Value("#{contextProperties['server.type.aprvid']}")
	private String staticServerTypeAprvid;

	// ara.sales.type       = HH:mm
	@Value("#{contextProperties['ara.sales.type']}")
	private String araSalesType;

	// ara.sales.open.time  = 04:00
	@Value("#{contextProperties['ara.sales.open.time']}")
	private String araSalesOpenTime;

	// ara.sales.close.time = 23:00
	@Value("#{contextProperties['ara.sales.close.time']}")
	private String araSalesCloseTime;

	// ara.db.backup.time = 23:30
	@Value("#{contextProperties['ara.db.backup.time']}")
	private String araDbBackupTime;

	// ara.file.base.path1       = ${HOME}
	@Value("#{contextProperties['ara.file.base.path1']}")
	private String araFileBasePath1;

	// ara.file.base.path2       = ${basedir}
	@Value("#{contextProperties['ara.file.base.path2']}")
	private String araFileBasePath2;

	/////////////////////////////////////////////////////////////
	
	private static String HOME;
	private static String userHome;
	
	static {
		if (!Flag.flag) {
			System.getProperties().forEach((k,v) -> System.out.println("\tProperty [" + k + ":" + v + "]"));
			System.getenv().forEach((k,v) -> System.out.println("\tEnv [" + k + ":" + v + "]"));
		}
		HOME = System.getenv("HOME");
		userHome = System.getProperty("user.home", "/tmp");
		
		System.out.printf(">>>>>> ContextParameter.HOME     = %s%n", HOME);
		System.out.printf(">>>>>> ContextParameter.userHome = %s%n", userHome);
	}
	
	/////////////////////////////////////////////////////////////

	public String getStaticURL() {
		return staticURL;
	}

	public void setStaticURL(String staticURL) {
		this.staticURL = staticURL;
	}

	public String getStaticPATH() {
		return staticPATH;
	}

	public void setStaticPATH(String staticPATH) {
		this.staticPATH = staticPATH;
	}

	public String getStaticPATHSasurl() {
		return staticPATHSasurl;
	}

	public void setStaticPATHSasurl(String staticPATHSasurl) {
		this.staticPATHSasurl = staticPATHSasurl;
	}

	public String getStaticPATHSvaurl() {
		return staticPATHSvaurl;
	}

	public void setStaticPATHSvaurl(String staticPATHSvaurl) {
		this.staticPATHSvaurl = staticPATHSvaurl;
	}

	public String getStaticServerType() {
		return staticServerType;
	}

	public void setStaticServerType(String staticServerType) {
		this.staticServerType = staticServerType;
	}

	public String getStaticServerTypeAprvid() {
		return staticServerTypeAprvid;
	}

	public void setStaticServerTypeAprvid(String staticServerTypeAprvid) {
		this.staticServerTypeAprvid = staticServerTypeAprvid;
	}

	public String getAraSalesType() {
		return araSalesType;
	}

	public void setAraSalesType(String araSalesType) {
		this.araSalesType = araSalesType;
	}

	public String getAraSalesOpenTime() {
		return araSalesOpenTime;
	}

	public void setAraSalesOpenTime(String araSalesOpenTime) {
		this.araSalesOpenTime = araSalesOpenTime;
	}

	public String getAraSalesCloseTime() {
		return araSalesCloseTime;
	}

	public void setAraSalesCloseTime(String araSalesCloseTime) {
		this.araSalesCloseTime = araSalesCloseTime;
	}

	public String getAraDbBackupTime() {
		return araDbBackupTime;
	}

	public void setAraDbBackupTime(String araDbBackupTime) {
		this.araDbBackupTime = araDbBackupTime;
	}

	public String getAraFileBasePath1() {
		if (this.araFileBasePath1.indexOf("${HOME}") > -1) {
			this.araFileBasePath1 = this.araFileBasePath1.replaceAll("\\$\\{HOME\\}", HOME);
		} else if (this.araFileBasePath1.indexOf("${user.home}") > -1) {
			this.araFileBasePath1 = this.araFileBasePath1.replaceAll("\\$\\{user.home\\}", userHome);
		}
		return araFileBasePath1;
	}

	public void setAraFileBasePath1(String araFileBasePath1) {
		this.araFileBasePath1 = araFileBasePath1;
	}

	public String getAraFileBasePath2() {
		if (this.araFileBasePath2.indexOf("${HOME}") > -1) {
			this.araFileBasePath2 = this.araFileBasePath2.replaceAll("\\$\\{HOME\\}", HOME);
		} else if (this.araFileBasePath2.indexOf("${user.home}") > -1) {
			this.araFileBasePath2 = this.araFileBasePath2.replaceAll("\\$\\{user.home\\}", userHome);
		}
		return araFileBasePath2;
	}

	public void setAraFileBasePath2(String araFileBasePath2) {
		this.araFileBasePath2 = araFileBasePath2;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(String.format("------------ ContextParameter ---------------%n"));
		sb.append(String.format("\tContextParameter.getStaticURL             () = %s%n", this.getStaticURL             ()));
		sb.append(String.format("\tContextParameter.getStaticPATH            () = %s%n", this.getStaticPATH            ()));
		sb.append(String.format("\tContextParameter.getStaticPATHSasurl      () = %s%n", this.getStaticPATHSasurl      ()));
		sb.append(String.format("\tContextParameter.getStaticPATHSvaurl      () = %s%n", this.getStaticPATHSvaurl      ()));
		sb.append(String.format("\tContextParameter.getStaticServerType      () = %s%n", this.getStaticServerType      ()));
		sb.append(String.format("\tContextParameter.getStaticServerTypeAprvid() = %s%n", this.getStaticServerTypeAprvid()));
		sb.append(String.format("\tContextParameter.getAraSalesType          () = %s%n", this.getAraSalesType          ()));
		sb.append(String.format("\tContextParameter.getAraSalesOpenTime      () = %s%n", this.getAraSalesOpenTime      ()));
		sb.append(String.format("\tContextParameter.getAraSalesCloseTime     () = %s%n", this.getAraSalesCloseTime     ()));
		sb.append(String.format("\tContextParameter.getAraDbBackupTime       () = %s%n", this.getAraDbBackupTime       ()));
		sb.append(String.format("\tContextParameter.getAraFileBasePath1      () = %s%n", this.getAraFileBasePath1      ()));
		sb.append(String.format("\tContextParameter.getAraFileBasePath2      () = %s%n", this.getAraFileBasePath2      ()));
		return sb.toString();
	}
}
