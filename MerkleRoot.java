import java.util.*;
import java.security.MessageDigest;

public class MerkleRoot{

    public static void main(String[] args){

        ArrayList<String> merkleData = new ArrayList<String>();
        String data = new String("abc");

        for(int i = 0; i < data.length(); i++) {
            String c1 = String.valueOf(data.charAt(i));
            merkleData.add(sha256(c1));
        }

        System.out.println("Nodes:");
        for(int i = 0; i < merkleData.size(); i++) {
            System.out.println(merkleData.get(i));
        }
        System.out.println();

        String merkleRoot = findMerkleRoot(merkleData);
        System.out.println("\nFinal Merkle Root: " + merkleRoot);

    }

    public static String findMerkleRoot(ArrayList<String> merkleData) {
        if(merkleData.size() == 1) {
            return merkleData.get(0);
        }

        ArrayList<String> merkleTree = new ArrayList<String>();
        int n = merkleData.size();
        
        for(int i = 0; i < n; i+=2) {
            if(i == (n-1)) {
                System.out.println("Node " + i + ": " + merkleData.get(i));
                merkleTree.add(sha256(merkleData.get(i) + merkleData.get(i)));
            } else {
                System.out.println("Node " + i + ": " + merkleData.get(i));
                System.out.println("Node " + (i+1) + ": " + merkleData.get(i+1));
                merkleTree.add(sha256(merkleData.get(i) + merkleData.get(i+1)));
            }
        }

        return findMerkleRoot(merkleTree);
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
