package com.now.hack.service;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.now.hack.Hack4PeopleApplication;
import com.now.hack.model.User;
import com.now.hack.repository.HackUserRepository;
import com.sun.org.apache.xml.internal.security.utils.Base64;

@Service
public class HackUserService {
	private static final Logger logger = LogManager.getLogger(Hack4PeopleApplication.class);
	@Autowired
	private HackUserRepository hackUserRepository;

	public String createNewUser(JSONObject inputJson) throws Exception {
		try {
			User user = new User();
			user.setEmail(inputJson.getString("email"));
			user.setDateOfBirth(stringToDate(inputJson.getString("dateOfBirth")));
			user.setFirstName(inputJson.getString("firstName"));
			user.setPassword(inputJson.getString("password"));
			user.setPhone(inputJson.getString("phone"));
			user.setLastName(inputJson.getString("lastName"));
			user.setPoints(new BigInteger("0"));
			User savedUser = hackUserRepository.save(user);
			if (savedUser == null) {
				throw new Exception("User not created in DB.");
			}
			return "success";
		} catch (JSONException e) {
			e.printStackTrace();
			return "failure";
		}

	}

	public Date stringToDate(String dateInString) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss a", Locale.ENGLISH);
		formatter.setTimeZone(TimeZone.getTimeZone("America/Chicago"));
		Date date = formatter.parse(dateInString);
		return date;
	}

	public String userLogIn(JSONObject inputJson) {
		try {
			String email = inputJson.getString("email");
			String password = inputJson.getString("password");
			User user = hackUserRepository.getUserDetails(email, password);
			if (user == null) {
				throw new Exception("no user is present");
			}
			return user.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return "invalid credentials";
		}
	}

	public String changePassword(JSONObject inputJson) {
		try {
			String email = inputJson.getString("email");
			String newPassword = inputJson.getString("password");
			User user = hackUserRepository.updateUserPassword(email, newPassword);
			if (user != null)
				return "success";
			return "Failure";
		} catch (Exception e) {
			e.printStackTrace();
			return "Failure";
		}
	}

	public String checkAndchangePassword(JSONObject inputJson) {
		try {
			String email = inputJson.getString("email");
			String oldPassword = inputJson.getString("oldPassword");
			User user = hackUserRepository.getUserDetails(email, oldPassword);
			if (user != null) {
				return changePassword(inputJson);
			}
			return "Failure";
		} catch (Exception e) {
			e.printStackTrace();
			return "Failure";
		}

	}
	private static final String key = "aesEncryptionKey";
	private static final String initVector = "encryptionIntVec";

	public static String encrypt(String value) {
		try {
			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

			byte[] encrypted = cipher.doFinal(value.getBytes());
			return Base64.encode(encrypted);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	public static String decrypt(String encrypted) {
		try {
			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
			byte[] original = cipher.doFinal(Base64.decode(encrypted));

			return new String(original);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}
	
}
