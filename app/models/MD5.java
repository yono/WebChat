package models;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import play.Logger;

public class MD5 {

	public static String crypt(String str) {
		if (str == null || str.length() == 0) {
			throw new IllegalArgumentException("String to encrypt cannot be null or zero length");
		}
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte[] hash = md.digest();
			return hashByte2MD5(hash);
		} catch (NoSuchAlgorithmException e) {
			Logger.fatal(e, "System configuration error");
			return null;
		}
	}
	
	private static String hashByte2MD5(byte []hash) {
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < hash.length; i++) {
			if ((0xff & hash[i]) < 0x10) {
				hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
			} else {
				hexString.append(Integer.toHexString(0xFF & hash[i]));
			}
		}
		
		return hexString.toString();
	}
}
