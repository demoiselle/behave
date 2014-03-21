package br.gov.serpro.treino.business.implementation;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.gov.serpro.treino.bean.Setting;
import br.gov.serpro.treino.business.ISendMailBC;

public class SendMailBC implements ISendMailBC {

	private static final long serialVersionUID = 1L;

	public void sendMail(String to, String assunto, String message) {
		try {
			Setting setting = SettingBC.getCurrentSetting();

			if (setting.getSendMail()) {
				Properties props = new Properties();
				props.put("mail.smtp.host", setting.getSmtpServer());
				Session sessionEmail = Session.getDefaultInstance(props, null);

				MimeMessage msg = new MimeMessage(sessionEmail);
				msg.setSubject(assunto);
				msg.setContent(message, "text/html; charset=utf-8");
				msg.setFrom(new InternetAddress(setting.getDefaultFrom()));
				msg.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(to, false));

				Transport.send(msg);
			}
		} catch (Throwable e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public void sendMailFeedback(String to, String ss, String projectName,
			String link) {

		Setting setting = SettingBC.getCurrentSetting();

		String subject = setting.getFeedbackSubject();
		String message = setting.getFeedbackMessage();

		subject = subject.replace(Setting.VAR_SS, ss);
		message = message.replace(Setting.VAR_SS, ss);
		message = message.replace(Setting.VAR_PROJECT, projectName);
		message = message.replace(Setting.VAR_LINK, link);

		sendMail(to, subject, message);

	}

}
