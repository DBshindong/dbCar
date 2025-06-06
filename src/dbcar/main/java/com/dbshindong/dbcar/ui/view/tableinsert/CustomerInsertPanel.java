package dbcar.main.java.com.dbshindong.dbcar.ui.view.tableinsert;

import javax.swing.*;

import dbcar.main.java.com.dbshindong.dbcar.common.exception.GlobalExceptionHandler;
import dbcar.main.java.com.dbshindong.dbcar.config.AppConfig;
import dbcar.main.java.com.dbshindong.dbcar.domain.customer.Customer;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class CustomerInsertPanel extends JPanel {

	AppConfig ac = AppConfig.getInstance();
	private final JTextField usernameField = new JTextField(10);
	private final JTextField passwordField = new JTextField(10);
	private final JTextField licenseNumberField = new JTextField(10);
	private final JTextField nameField = new JTextField(10);
	private final JTextField addressField = new JTextField(10);
	private final JTextField phoneField = new JTextField(10);
	private final JTextField emailField = new JTextField(10);

	private final JButton saveButton = new JButton("저장");
	private final JButton cancelButton = new JButton("취소");
	private final JButton clearButton = new JButton("초기화");

	private static final String CUSTOMER_ID = "고객 ID";
	private static final String USERNAME = "아이디";
	private static final String PASSWORD = "비밀번호";
	private static final String LICENSE_NUMBER = "운전면허증 번호";
	private static final String NAME = "고객명";
	private static final String ADDRESS = "주소";
	private static final String PHONE = "전화번호";
	private static final String EMAIL = "이메일";

	public CustomerInsertPanel() {
		setLayout(new BorderLayout(10, 10));

		JPanel formPanel = new JPanel(new GridLayout(7, 2, 10, 10));
		formPanel.setBorder(BorderFactory.createTitledBorder("Customer 정보 입력"));

		formPanel.add(new JLabel(USERNAME));
		formPanel.add(usernameField);

		formPanel.add(new JLabel(PASSWORD));
		formPanel.add(passwordField);

		formPanel.add(new JLabel(LICENSE_NUMBER));
		formPanel.add(licenseNumberField);

		formPanel.add(new JLabel(NAME));
		formPanel.add(nameField);

		formPanel.add(new JLabel(ADDRESS));
		formPanel.add(addressField);

		formPanel.add(new JLabel(PHONE));
		formPanel.add(phoneField);

		formPanel.add(new JLabel(EMAIL));
		formPanel.add(emailField);

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(saveButton);
		buttonPanel.add(cancelButton);
		buttonPanel.add(clearButton);

		add(formPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);

		saveButton.addActionListener(e -> {
			try {
				// 엔티티 생성 및 유효성 검증

				// Customer 객체 생성
				Customer customer = ac.dataInsertService().createCustomer(usernameField.getText().trim(),
						passwordField.getText().trim(), licenseNumberField.getText().trim(), nameField.getText().trim(),
						addressField.getText().trim(), phoneField.getText().trim(), emailField.getText().trim());

				// Customer 저장
				ac.dataInsertService().insertCustomer(customer);
				JOptionPane.showMessageDialog(this, "저장 되었습니다.");

				// 필드 지우기
				clearFields();
			} catch (Exception ex) {
				// 예외 핸들링
				GlobalExceptionHandler.handle(ex);
			}
		});

		cancelButton.addActionListener(e -> {
			clearFields();
			ac.appCoordinator().clearContentPanel();
		});

		clearButton.addActionListener(e -> {
			clearFields();
		});
	}

	private void clearFields() {
		usernameField.setText("");
		passwordField.setText("");
		licenseNumberField.setText("");
		nameField.setText("");
		addressField.setText("");
		phoneField.setText("");
		emailField.setText("");
	}

	public JButton getSaveButton() {
		return saveButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}
}