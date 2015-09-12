/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailclient;

import java.io.Serializable;

/**
 *
 * @author ThanhHung
 */
public class Account implements Serializable{
    String Email, Password, SmtpHost, SmtpPort, ImapHost, ImapPort;
    public Account()
    {
        Email = Password = SmtpHost = SmtpPort = ImapHost = ImapPort = null;
    }
    public Account(String email, String password, String smtpHost,String smtpPort, String imapHost, String imapPort)
    {
        this.Email = email;
        this.Password = password;
        this.SmtpHost = smtpHost;
        this.SmtpPort = smtpPort;
        this.ImapHost = imapHost;
        this.ImapPort = imapPort;
    }
    String getEmail()
    {
        return Email;
    }
    String getPassword()
    {
        return Password;
    }
    String getSmtpHost()
    {
        return SmtpHost;
    }
    String getSmtpPort()
    {
        return SmtpPort;
    }
    String getImapHost()
    {
        return ImapHost;
    }
    String getImapPort()
    {
        return ImapPort;
    }
}
