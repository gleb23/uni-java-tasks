/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hlibbabii.mailapplication9;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author Gleb
 */
public class SettingsDialog extends Dialog implements ActionListener {

    private static final String DEFAULT_SMTP_SERVER = "smtp.gmail.com";
    private static final String DEFAULT_ACCOUNT_EMAIL = "<your account email>";

    private final MailController mailController;

    private TextField smtpServerField;
    private TextField accountEmailField;
    private TextField accountPasswordField;
    
    SettingsDialog(MyMainFrame parentWindow, MailController mailController) {
        super(parentWindow, "Settings", true);
        this.mailController = mailController;
        initUi();
    }

    private void initUi() {
        setLayout(new GridLayout(4,2));

        this.setSize(240, 160);

        Label postServerLabel = new Label("Post Server", Label.RIGHT);
        Label emailLabel = new Label("e-mail", Label.RIGHT);
        Label passwordLabel = new Label("Password", Label.RIGHT);

        smtpServerField = new TextField(DEFAULT_SMTP_SERVER, 12);
        smtpServerField.isEditable();

        accountEmailField = new TextField(DEFAULT_ACCOUNT_EMAIL, 12);
        accountEmailField.setEditable(true);

        accountPasswordField = new TextField(12);
        accountPasswordField.setEditable(true);
        accountPasswordField.setEchoChar('*');

        Button ok = new Button("OK");
        ok.setActionCommand("OK");

        add(postServerLabel);
        add(smtpServerField);
        add(emailLabel);
        add(accountEmailField);
        add(passwordLabel);
        add(accountPasswordField);
        add(ok);

        ok.addActionListener(this);

        this.addWindowListener(new MyWindowAdapter(this));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("OK")) {
            this.mailController.authenticate(
                    this.smtpServerField.getText(),
                    accountEmailField.getText(),
                    accountPasswordField.getText()
            );

            this.dispose();

        }
    }
    
    public class MyWindowAdapter extends WindowAdapter {
        SettingsDialog dlg;
        MyWindowAdapter(SettingsDialog dlg) {
            this.dlg = dlg;
        }

        @Override
        public void windowClosing(WindowEvent e) {
            dlg.dispose();
        }
        
    }
}
