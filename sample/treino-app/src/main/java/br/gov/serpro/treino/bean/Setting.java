package br.gov.serpro.treino.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import br.gov.framework.demoiselle.core.bean.IPojo;

@Entity
@Table(name = "tb_setting")
public class Setting implements IPojo {

	private static final long serialVersionUID = 1L;

	public static final String VAR_PROJECT = "@{PROJECT}";
	public static final String VAR_LINK = "@{LINK}";
	public static final String VAR_SS = "@{SS}";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "chartCache")
	private Integer chartCache;

	@Column(name = "chartInterval")
	private Integer chartInterval;

	@Column(name = "departmentLDAP", length = 30)
	private String departmentLDAP;

	@Column(name = "enableLDAP")
	private Boolean enableLDAP;

	@Column(name = "sendMail")
	private Boolean sendMail;

	@Column(name = "feedbackSubject", length = 50)
	private String feedbackSubject;

	@Column(name = "feedbackMessage")
	@Lob
	private String feedbackMessage;

	@Column(name = "backupFolder")
	private String backupFolder;

	@Column(name = "uploadImagesFolder")
	private String uploadImagesFolder;

	@Column(name = "url")
	private String url;

	@Column(name = "smtpServer")
	private String smtpServer;

	@Column(name = "defaultFrom")
	private String defaultFrom;

	@Column(name = "defaultTo")
	private String defaultTo;

	public Boolean getEnableLDAP() {
		if (enableLDAP == null) {
			return false;
		}
		return enableLDAP;
	}

	public void setEnableLDAP(Boolean enableLDAP) {
		this.enableLDAP = enableLDAP;
	}

	public Boolean getSendMail() {
		if (sendMail == null) {
			return false;
		}
		return sendMail;
	}

	public void setSendMail(Boolean sendMail) {
		this.sendMail = sendMail;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getChartCache() {
		return chartCache;
	}

	public void setChartCache(Integer chartCache) {
		this.chartCache = chartCache;
	}

	public Integer getChartInterval() {
		return chartInterval;
	}

	public void setChartInterval(Integer chartInterval) {
		this.chartInterval = chartInterval;
	}

	public String getDepartmentLDAP() {
		if (this.departmentLDAP == null) {
			return "";
		}
		return departmentLDAP;
	}

	public void setDepartmentLDAP(String departmentLDAP) {
		this.departmentLDAP = departmentLDAP;
	}

	public String getFeedbackSubject() {
		return feedbackSubject;
	}

	public void setFeedbackSubject(String feedbackSubject) {
		this.feedbackSubject = feedbackSubject;
	}

	public String getFeedbackMessage() {
		return feedbackMessage;
	}

	public void setFeedbackMessage(String feedbackMessage) {
		this.feedbackMessage = feedbackMessage;
	}

	public String getBackupFolder() {
		return backupFolder;
	}

	public void setBackupFolder(String backupFolder) {
		this.backupFolder = backupFolder;
	}

	public String getUploadImagesFolder() {
		return uploadImagesFolder;
	}

	public void setUploadImagesFolder(String uploadImagesFolder) {
		this.uploadImagesFolder = uploadImagesFolder;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSmtpServer() {
		return smtpServer;
	}

	public void setSmtpServer(String smtpServer) {
		this.smtpServer = smtpServer;
	}

	public String getDefaultFrom() {
		return defaultFrom;
	}

	public void setDefaultFrom(String defaultFrom) {
		this.defaultFrom = defaultFrom;
	}

	public String getDefaultTo() {
		return defaultTo;
	}

	public void setDefaultTo(String defaultTo) {
		this.defaultTo = defaultTo;
	}

}
