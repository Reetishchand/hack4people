package com.now.hack.service;

import java.math.BigInteger;
import java.security.spec.KeySpec;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
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
	private static String secret = "vusjbdisljbcsdcbsdhbc6328oyu2yuo2i7dyv26732gdqhx";
	private static String salt = 				"8723dhu70g7to42ufh8372uq8hiquan;njin78yguca;kjc";
	 
	public  String encrypt(String strToEncrypt) 
	{
	    try
	    {
	        byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	        IvParameterSpec ivspec = new IvParameterSpec(iv);
	         
	        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
	        KeySpec spec = new PBEKeySpec(secret.toCharArray(), salt.getBytes(), 65536, 256);
	        SecretKey tmp = factory.generateSecret(spec);
	        SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
	         
	        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
	        return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
	    } 
	    catch (Exception e) 
	    {
	      logger.error("Error while encrypting: {}" , e.toString());
	    }
	    return null;
	}	
	
	
	public  String decrypt(String strToDecrypt) {
	    try
	    {
	        byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	        IvParameterSpec ivspec = new IvParameterSpec(iv);
	         
	        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
	        KeySpec spec = new PBEKeySpec(secret.toCharArray(), salt.getBytes(), 65536, 256);
	        SecretKey tmp = factory.generateSecret(spec);
	        SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
	         
	        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
	        return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
	    } 
	    catch (Exception e) {
	    	  logger.error("Error while decrypting: {}" , e.toString());
	    }
	    return null;
	}
	
}
