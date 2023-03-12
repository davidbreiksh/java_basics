import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DesktopForm {
    private JPanel mainPanel;
    private JButton collapseButton;
    private JTextField nameTextField;
    private JTextField surnameTextField;
    private JTextField middlenameTextField;
    private boolean isCollapsed = false;

    public DesktopForm() {
        super();
        mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(5, 5, 5, 5);
        mainPanel.add(new JLabel("Имя:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 1.0;
        nameTextField = new JTextField(10);
        mainPanel.add(nameTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0.0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        mainPanel.add(new JLabel("Фамилия:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 1.0;
        surnameTextField = new JTextField(10);
        mainPanel.add(surnameTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0.0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        mainPanel.add(new JLabel("Отчество:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 1.0;
        middlenameTextField = new JTextField(10);
        mainPanel.add(middlenameTextField, gbc);

        collapseButton = new JButton("Collapse");
        collapseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isCollapsed) {
                    if (nameTextField.getText().isEmpty() || surnameTextField.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(mainPanel, "Ошибка заполнения форму",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        String fullName = String.format("%s, %s, %s",
                                nameTextField.getText(),
                                surnameTextField.getText(),
                                middlenameTextField.getText());
                        JOptionPane.showMessageDialog(mainPanel, fullName, "Full Name",
                                JOptionPane.INFORMATION_MESSAGE);
                        collapseButton.setText("Expand");
                        isCollapsed = true;
                        middlenameTextField.setVisible(false);
                    }
                } else {
                    if (nameTextField.getText().isEmpty() || surnameTextField.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(mainPanel, "Ошибка заполнения форму",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        collapseButton.setText("Collapse");
                        isCollapsed = false;
                        middlenameTextField.setVisible(true);
                    }
                }
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0.0;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(collapseButton, gbc);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}