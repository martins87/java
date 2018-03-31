import java.util.*;
import java.security.MessageDigest;

class SHA256{
	
	public static void main(String args[]) {

		String name = "Satoshi Nakamoto";
		String hash = sha256(name);
		
		System.out.println("Hash of '" + name + "' : " + hash);
		
	}
	
	public static String sha256(String data) {
		try{
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(data.getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer();

			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if(hex.length() == 1) hexString.append('0');
				hexString.append(hex);
			}

			return hexString.toString();
		} catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}
}