import java.util.Date;

public class chain{
    public String hash;
    public String prevHash;
    private String data;
    private long timeStamp;

    //Block Constructor
    public chain(String data, String prevHash)
    {
        this.data = data;
        this.prevHash = prevHash;
        this.timeStamp = new Date().getTime();
    }
    public static void main(String[] args)
    {
        
    }
}

