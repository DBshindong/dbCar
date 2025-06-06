package dbcar.main.java.com.dbshindong.dbcar.domain.repair.external;

import java.util.Objects;

import dbcar.main.java.com.dbshindong.dbcar.common.Validator;
import dbcar.main.java.com.dbshindong.dbcar.domain.repair.external.exception.InvalidExternalRepairShopException;

public class ExternalRepairShop {
	private final Integer shop_id;
	private final String name;
	private final String address;
	private final String phone;
	private final String manager_name;
	private final String manager_email;

	private static final String NULL_MESSAGE = "%s은(는) null이 들어갈 수 없습니다.";

	private final static String SHOP_ID = "캠핑카 정비소 ID";
	private final static String NAME = "정비소명";
	private final static String ADDRESS = "주소";
	private final static String PHONE = "정비소 전화번호";
	private final static String MANAGER_NAME = "담당자 이름";
	private final static String MANAGER_EMAIL = "담당자 이메일";

	public ExternalRepairShop(Integer shop_id, String name, String address, String phone, String manager_name,
			String manager_email) {
		this.validate(shop_id, name, address, phone, manager_name, manager_email);
		this.shop_id = shop_id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.manager_name = manager_name;
		this.manager_email = manager_email;
	}

	public ExternalRepairShop(String name, String address, String phone, String manager_name, String manager_email) {
		this.validate(-1, name, address, phone, manager_name, manager_email);
		this.shop_id = -1;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.manager_name = manager_name;
		this.manager_email = manager_email;
	}

	private void validate(Integer shop_id, String name, String address, String phone, String manager_name,
			String manager_email) {
		try {
			Objects.requireNonNull(shop_id, String.format(NULL_MESSAGE, SHOP_ID));
			Validator.requireNonBlank(name, String.format(NULL_MESSAGE, NAME));
			Validator.requireNonBlank(address, String.format(NULL_MESSAGE, ADDRESS));
			Validator.requireNonBlank(phone, String.format(NULL_MESSAGE, PHONE));
			Validator.requireNonBlank(manager_name, String.format(NULL_MESSAGE, MANAGER_NAME));
			Validator.requireNonBlank(manager_email, String.format(NULL_MESSAGE, MANAGER_EMAIL));
		} catch (NullPointerException e) {
			throw new InvalidExternalRepairShopException(e.getMessage(), e);
		}

		if (!Validator.isValidEmail(manager_email)) {
			throw new InvalidExternalRepairShopException(MANAGER_EMAIL + "의 입력값이 올바르지 않습니다.");
		}
	}

	@Override
	public String toString() {
		return String.format(
				"{ \"shop_id\": %d, \"name\": \"%s\", \"address\": \"%s\", \"phone\": \"%s\", "
						+ "\"manager_name\": \"%s\", \"manager_email\": \"%s\" }",
				shop_id, name, address, phone, manager_name, manager_email);
	}

	public int getShop_id() {
		return shop_id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public String getManager_name() {
		return manager_name;
	}

	public String getManager_email() {
		return manager_email;
	}
}