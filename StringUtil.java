import java.security.MessageDigest;

public class StringUtil {
    /**
     * applySha256
     * 
     * applies the sha256 hash to the String provided as
     * a parameter and returns the hashed value
     * 
     * @param input - The parameters of the block object
     * @return: hexString- the applied sha256 hash based on
     * string input provided from the input parameter
     */
    //Applies Sha256 to a string and returns the result
    public static String applySha256(String input)
    {
        try
        {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            //Applies sha256 to the input,
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer(); // holds the string as a hexadecimal
            for(int i = 0; i < hash.length; i++)
            {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        }
        catch(Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
