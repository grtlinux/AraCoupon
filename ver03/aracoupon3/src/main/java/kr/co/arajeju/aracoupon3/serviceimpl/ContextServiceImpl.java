package kr.co.arajeju.aracoupon3.serviceimpl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import kr.co.arajeju.aracoupon3.service.ContextService;
import kr.co.arajeju.aracoupon3.util.Flag;

@Service
public class ContextServiceImpl implements ContextService {

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
		if (Flag.flag) {
			System.getProperties().forEach((k,v) -> System.out.println("\tProperty [" + k + "=" + v + "]"));
			System.getenv().forEach((k,v) -> System.out.println("\tEnv [" + k + "=" + v + "]"));
		}
		HOME = System.getenv("HOME");
		userHome = System.getProperty("user.home", "/tmp");
		
		System.out.printf("\t>>>>>> ContextService.HOME     = %s%n", HOME);
		System.out.printf("\t>>>>>> ContextService.userHome = %s%n", userHome);
	}
	
	/////////////////////////////////////////////////////////////

	public String getStaticURL() {
		return this.staticURL;
	}
	public String getStaticPATH() {
		return this.staticPATH;
	}
	public String getStaticPATHSasurl() {
		return this.staticPATHSasurl;
	}
	public String getStaticPATHSvaurl() {
		return this.staticPATHSvaurl;
	}
	public String getStaticServerType() {
		return this.staticServerType;
	}
	public String getStaticServerTypeAprvid() {
		return this.staticServerTypeAprvid;
	}
	public String getAraSalesType() {
		return this.araSalesType;
	}
	public String getAraSalesOpenTime() {
		return this.araSalesOpenTime;
	}
	public String getAraSalesCloseTime() {
		return this.araSalesCloseTime;
	}
	public String getAraDbBackupTime() {
		return this.araDbBackupTime;
	}
	public String getAraFileBasePath1() {
		if (this.araFileBasePath1.indexOf("${HOME}") > -1) {
			this.araFileBasePath1 = this.araFileBasePath1.replaceAll("\\$\\{HOME\\}", HOME);
		} else if (this.araFileBasePath1.indexOf("${user.home}") > -1) {
			this.araFileBasePath1 = this.araFileBasePath1.replaceAll("\\$\\{user.home\\}", userHome);
		}
		return this.araFileBasePath1;
	}
	public String getAraFileBasePath2() {
		if (this.araFileBasePath2.indexOf("${HOME}") > -1) {
			this.araFileBasePath2 = this.araFileBasePath2.replaceAll("\\$\\{HOME\\}", HOME);
		} else if (this.araFileBasePath2.indexOf("${user.home}") > -1) {
			this.araFileBasePath2 = this.araFileBasePath2.replaceAll("\\$\\{user.home\\}", userHome);
		}
		return this.araFileBasePath2;
	}
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(String.format(" >>>>>>>>>>> ContextService start ---------------%n"));
		sb.append(String.format("\tContextService.getStaticURL             () = %s%n", this.getStaticURL             ()));
		sb.append(String.format("\tContextService.getStaticPATH            () = %s%n", this.getStaticPATH            ()));
		sb.append(String.format("\tContextService.getStaticPATHSasurl      () = %s%n", this.getStaticPATHSasurl      ()));
		sb.append(String.format("\tContextService.getStaticPATHSvaurl      () = %s%n", this.getStaticPATHSvaurl      ()));
		sb.append(String.format("\tContextService.getStaticServerType      () = %s%n", this.getStaticServerType      ()));
		sb.append(String.format("\tContextService.getStaticServerTypeAprvid() = %s%n", this.getStaticServerTypeAprvid()));
		sb.append(String.format("\tContextService.getAraSalesType          () = %s%n", this.getAraSalesType          ()));
		sb.append(String.format("\tContextService.getAraSalesOpenTime      () = %s%n", this.getAraSalesOpenTime      ()));
		sb.append(String.format("\tContextService.getAraSalesCloseTime     () = %s%n", this.getAraSalesCloseTime     ()));
		sb.append(String.format("\tContextService.getAraDbBackupTime       () = %s%n", this.getAraDbBackupTime       ()));
		sb.append(String.format("\tContextService.getAraFileBasePath1      () = %s%n", this.getAraFileBasePath1      ()));
		sb.append(String.format("\tContextService.getAraFileBasePath2      () = %s%n", this.getAraFileBasePath2      ()));
		sb.append(String.format("\t------------ ContextService end ---------------"));
		return sb.toString();
	}
}
