/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailclient;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author ThanhHung
 */
public class mailOffline extends javax.swing.JFrame {

    /**
     * Creates new form mailOffline
     */
    String email,password,noidung;
    Account ac;
    Properties prop;
    Session mailSession;
    int numMsg = 0;
    DefaultListModel listModel = new DefaultListModel();
    MimeMessage[] folderMail = new MimeMessage[1000];
    File[] folderMsg;
    public mailOffline() {
        initComponents();
        prop = System.getProperties();
                    
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tbEmail = new javax.swing.JTextField();
        tbPassword = new javax.swing.JPasswordField();
        btXacnhan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listMail = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        epContent = new javax.swing.JEditorPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tbFrom = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tbSubject = new javax.swing.JTextField();
        tbDate = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btDelete = new javax.swing.JButton();
        btDecrypt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("OFEN Mail [Offline]");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Thông tin tài khoản"));

        jLabel1.setText("Email: ");

        jLabel2.setText("Password:");

        btXacnhan.setText("Xác nhận");
        btXacnhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXacnhanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                    .addComponent(tbPassword))
                .addGap(18, 18, 18)
                .addComponent(btXacnhan)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btXacnhan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tbPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        listMail.setBorder(javax.swing.BorderFactory.createTitledBorder("Email"));
        listMail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listMailMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listMail);

        epContent.setEditable(false);
        epContent.setBorder(javax.swing.BorderFactory.createTitledBorder("Nội dung email"));
        epContent.setContentType("text/html"); // NOI18N
        epContent.setText("\n"); // NOI18N
        jScrollPane2.setViewportView(epContent);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin Email"));

        jLabel3.setText("Người gửi:");

        jLabel4.setText("Tiêu đề");

        jLabel5.setText("Ngày gửi:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tbSubject)
                            .addComponent(tbDate)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(19, 19, 19)
                        .addComponent(tbFrom)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tbFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tbDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btDelete.setText("Xóa ");
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        btDecrypt.setText("Giải mã");
        btDecrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDecryptActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btDecrypt, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btDecrypt, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(btDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btXacnhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXacnhanActionPerformed
        mailSession = Session.getInstance(prop, null);
        InputStream in = null;
        numMsg = 0;
        email = tbEmail.getText();
        password = tbPassword.getText();
        File accDir = new File("src/dat/"+email);
        
        if (!accDir.exists())
        {
            JOptionPane.showMessageDialog(null, "Tài khoản này không có thư được lưu trữ trong máy!","Cảnh báo",2);
        }
        else
        {
            try {
                ac = (Account) ioObject.readObject(email+"/account.dat");
                
                
                if (!password.equals(ac.getPassword()))
                {
                    JOptionPane.showMessageDialog(null, "Mật khẩu không đúng!","Lỗi",0);
                }
                else
                {
                    
                    JOptionPane.showMessageDialog(null, "Xác thực thành công!");
                    
                    folderMsg = accDir.listFiles(new FileFilter() {

                        @Override
                        public boolean accept(File pathname) {
                            if (pathname.getName().endsWith(".msg")) //To change body of generated methods, choose Tools | Templates.
                                return true;
                            else return false;
                        }
                    });
                    folderMail = new MimeMessage[folderMsg.length];
                    for (File fmsg:folderMsg)
                    {
                        //File fmsg = new File("src/dat/"+email+"/"+numMsg+".msg");
                        if (fmsg.exists())
                        {
                            InputStream is = new FileInputStream(fmsg);    
                            MimeMessage message = new MimeMessage(mailSession, is);
                            listModel.addElement(numMsg+"."+message.getSubject());
                            folderMail[numMsg] = message;
                            numMsg++;
                            
                        }
                        else
                            
                            break;
                    }
                    listMail.setModel(listModel);
                    
                }
            } catch (IOException ex) {
                Logger.getLogger(mailOffline.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(mailOffline.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MessagingException ex) {
                Logger.getLogger(mailOffline.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_btXacnhanActionPerformed

    private void listMailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listMailMouseClicked
        String textms = "";
        noidung = "";
        try {
            int indexMsg = listMail.getSelectedIndex();
            MimeMessage msg = folderMail[indexMsg];
            String from = "";
            InternetAddress[] addresses = (InternetAddress[]) msg.getFrom();
            for (InternetAddress address : addresses)
            {
                from += address.getAddress();
            }
            
           
            tbFrom.setText(from);
            tbSubject.setText(msg.getSubject());
            tbDate.setText(msg.getSentDate().toString());
            
            Object content = msg.getContent();
            if (content instanceof InputStream)
            {
                InputStream in = (InputStream) content;
                int c;
                while ((c=in.read())!=-1)
                {
                    textms+=c;
                }
                printTextms(textms);
                
            }
            if (content instanceof Multipart)
            {
                processMultipart((Multipart) content);
            }
            else 
            {
                processPart(msg);
            }
        } catch (IOException ex) {
            Logger.getLogger(mailOffline.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(mailOffline.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }//GEN-LAST:event_listMailMouseClicked

    private void btDecryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDecryptActionPerformed
        // TODO add your handling code here:
        
         String desKey = "";
         {
             try {
                 
                 desKey = JOptionPane.showInputDialog("Mời bạn nhập key để mã hóa (độ dài key = 16)");
                 if (desKey.length() != 16)
                 {
                     JOptionPane.showMessageDialog(null, "Giải mã không thành công!Bạn phải nhập key có 16 kí tự","Cảnh báo",2);
                     return;
                 }
                 else 
                 noidung = EncryptorDecryptor.decrypt(noidung, desKey);
                 JOptionPane.showMessageDialog(null, "Giải mã thành công!","Thông báo",1);
                 
             } catch (Exception ex) {
                 Logger.getLogger(mainClient.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(null, "Giải mã không thành công! Key không đúng","Cảnh báo",2);
             }
             
         }
         epContent.setText(noidung);
    }//GEN-LAST:event_btDecryptActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        // TODO add your handling code here:
        int index = listMail.getSelectedIndex();
        File fileDel = folderMsg[index];
        fileDel.delete();
        folderMsg = null;
        epContent.setText("");
        numMsg = 0;
        
        listModel.removeAllElements();
        File accDir = new File("src/dat/"+email);
        folderMsg = accDir.listFiles(new FileFilter() {

                        @Override
                        public boolean accept(File pathname) {
                            if (pathname.getName().endsWith(".msg")) //To change body of generated methods, choose Tools | Templates.
                                return true;
                            else return false;
                        }
                    });
        folderMail = new MimeMessage[folderMsg.length];
        for (File fmsg:folderMsg)
                    {
                        //File fmsg = new File("src/dat/"+email+"/"+numMsg+".msg");
                        if (fmsg.exists())
                        {
                            InputStream is = null;    
                            try {
                                is = new FileInputStream(fmsg);
                                MimeMessage message = new MimeMessage(mailSession, is);
                                listModel.addElement(numMsg+"."+message.getSubject());
                                folderMail[numMsg] = message;
                                numMsg++;
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(mailOffline.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (MessagingException ex) {
                                Logger.getLogger(mailOffline.class.getName()).log(Level.SEVERE, null, ex);
                            } finally {
                                try {
                                    is.close();
                                } catch (IOException ex) {
                                    Logger.getLogger(mailOffline.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            
                        }
                        else
                            break;
                    }
                    listMail.setModel(listModel);
                    JOptionPane.showMessageDialog(null, "Xóa mail thành công!");
    }//GEN-LAST:event_btDeleteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mailOffline.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mailOffline.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mailOffline.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mailOffline.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mailOffline().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDecrypt;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btXacnhan;
    private javax.swing.JEditorPane epContent;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList listMail;
    private javax.swing.JTextField tbDate;
    private javax.swing.JTextField tbEmail;
    private javax.swing.JTextField tbFrom;
    private javax.swing.JPasswordField tbPassword;
    private javax.swing.JTextField tbSubject;
    // End of variables declaration//GEN-END:variables

    private void printTextms(String textms) {
        if (textms.contains("<head"))
                textms = textms.substring(textms.indexOf("<body"),textms.indexOf("</body>"));
        epContent.setText(textms);
    }

    private void processMultipart(Multipart mp) throws IOException {
        try {
            int count = mp.getCount();
            for (int i=0;i<count;i++)
            {
                processPart(mp.getBodyPart(i));
            }
        } catch (MessagingException ex) {
            Logger.getLogger(mailOffline.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void processPart(Part p) throws IOException, MessagingException {
        Object content = p.getContent();
         if (content instanceof Multipart)
         {
             processMultipart((Multipart) content);
         }
         else if (content instanceof String)
         {
         String textms="";
         
         //if (content instanceof String)
            //{
                textms+=content;
            //}
           // else 
           
           
           
            printTextms(textms);
            noidung = textms;
         }
    }
}
