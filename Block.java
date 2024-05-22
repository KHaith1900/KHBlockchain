import java.util.Date;

public class Block{
    public String hash;
    public String prevHash;
    private String data;
    private long timeStamp;

    //Block Constructor
    public Block(String data, String prevHash)
    {
        this.data = data;
        this.prevHash = prevHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }

    public String calculateHash()
    {
        String calculatedhash = StringUtil.applySha256(prevHash + Long.toString(timeStamp) + data);
        return calculatedhash;
    }
}

