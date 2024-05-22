import java.util.ArrayList;

public class chain
{
    public static ArrayList<Block> blockchain = new ArrayList<Block>();

    /**
     * isValid
     * 
     * checks each block in the blockchain and compares
     * the registered hash to the calculated hash if
     * any registered hash from a block or the previous block are
     * not equal to the calculated hash method returns false
     * 
     * @return: Boolean true or false
     */
    public static Boolean isValid()
    {
        Block currBlock;
        Block prevBlock;

        for(int i = 1; i < blockchain.size(); i++)
        {
            currBlock = blockchain.get(i);
            prevBlock = blockchain.get(i-1);
            //compare registered hash and calculated hash:
            if(!currBlock.hash.equals(currBlock.calculateHash()))
            {
                System.out.println("Current Hashes are not equal");
                return false;
            }
            //compare previous hash and registered previous hash
            if(!prevBlock.hash.equals(currBlock.prevHash))
            {
                System.out.println("Previous Hashes are not equal");
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args)
    {
        blockchain.add(new Block("First Block", "0"));
        blockchain.add(new Block("Second Block", blockchain.get(blockchain.size()-1).hash));
        blockchain.add(new Block("Third Block", blockchain.get(blockchain.size()-1).hash));
    }
}