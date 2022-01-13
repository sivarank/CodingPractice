package progPractice.games;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;



public class Pega {
  public static void main(String[] args) throws Exception {
    /*KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
    kpg.initialize(1024);
    KeyPair keyPair = kpg.genKeyPair();
*/
	  
    byte[] data = "testtesttesttesttesttesttesttesttest".getBytes("UTF8");

    Signature sig = Signature.getInstance("MD5WithRSA");
    
   // KEy = from keystore API 
    // signature generation 
    //sig.initSign(KEy);
    sig.update(data);
    byte[] signatureBytes = sig.sign();
    System.out.println("Singature:" + new String(signatureBytes));

    // signature verififcation 
   // sig.initVerify(keyPair.getPublic());
    sig.update(data);

    System.out.println(sig.verify(signatureBytes));
  }
}