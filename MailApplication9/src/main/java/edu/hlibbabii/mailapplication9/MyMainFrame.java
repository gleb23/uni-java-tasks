package edu.hlibbabii.mailapplication9;


import javax.mail.AuthenticationFailedException;
import javax.mail.MessagingException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyMainFrame extends Frame implements ActionListener {

    private MailController mailController;

    private TextField subjectField;
    private TextArea messageArea;
    private TextField toAddressField;

    Button submitButton;

    MyMainFrame() {
        super("Mail Manager");
        initUi();
    }

    private void initUi() {
        setBackground(Color.orange);
        setSize(700, 400);
        setVisible(true);

        /*
         * Menu
         */
        MenuBar menuBar = new MenuBar();
        setMenuBar(menuBar);

        Menu fileMenu = new Menu("File");

        MenuItem exitMenuItem = new MenuItem("Exit");
        exitMenuItem.setActionCommand("Exit");
        exitMenuItem.addActionListener(this);
        MenuItem changeSettingsMenuItem = new MenuItem("Change Settings");
        changeSettingsMenuItem.setActionCommand("Change Settings");
        changeSettingsMenuItem.addActionListener(this);

        fileMenu.add(changeSettingsMenuItem);
        fileMenu.add(exitMenuItem);
        menuBar.add(fileMenu);

        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        subjectField = new TextField("", 12);
        subjectField.setEditable(true);

        messageArea = new TextArea("", 10, 80);
        messageArea.setEditable(true);

        toAddressField = new TextField("", 12);
        toAddressField.setEditable(true);

        submitButton = new Button("Submit");
        submitButton.setActionCommand("Submit");
        submitButton.addActionListener(this);

        Label toAddressLabel = new Label("Adressee", Label.LEFT);

        /*
         * Adding elements to container
         */

        add(messageArea);

        add(submitButton);

        add(toAddressLabel);
        add(toAddressField);
    }

    public void setMailController(MailController m) {
        mailController = m;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Submit":
                try {
                    Email email = new Email.Builder()
                            .setSubject(subjectField.getText())
                            .setText(messageArea.getText())
                            .setTo(toAddressField.getText())
                            .build();
                    mailController.send(email);
                } catch (AuthenticationFailedException ee) {
                    JOptionPane.showMessageDialog(this, "Incorrect Login/Password!");
                } catch(MessagingException ee) {
                    ee.printStackTrace();
                }
                JOptionPane.showMessageDialog(this, "Sent successfully!");
                break;
            case "Exit":
                this.dispose();
                break;
            case "Change Settings":
                SettingsDialog settingsDialog = new SettingsDialog(this, mailController);
                settingsDialog.setVisible(true);
                break;
        }
    }
}
