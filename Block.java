import java.util.Date;

public class Block{
    public String hash;
    public String prevHash;
    private String data;
    private long timeStamp;
    private int nonce;

    //Block Constructor
    public Block(String data, String prevHash)
    {
        this.data = data;
        this.prevHash = prevHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }

    /**
     * calculateHash
     * 
     * returns the hash of the block using 
     * the Sha256 hash in the StringUtil class
     * 
     * @return: calculatedhash - String value of the hash of the block created
     */
    public String calculateHash()
    {
        String calculatedhash = StringUtil.applySha256(prevHash + 
        Long.toString(timeStamp) +
        Integer.toString(nonce) +
        data);
        return calculatedhash;
    }

    /** 
     * mineBlock
     * 
     * provides the input to potentially be stored in the D register
     * during doClockHigh
     *
     * @param: diff - integer value denoting the amount of 0's being solved for
    */
    public void mineBlock(int diff)
    {
        String target = new String(new char[diff]).replace('\0', '0');
        while(!hash.substring(0, diff).equals(target))
        {
            nonce ++;
            hash = calculateHash();
        }
        System.out.println("Mined a Block!!! : " + hash);
    }
}

