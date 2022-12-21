package application;

public abstract class Alien {
    protected int eyes;
    protected int arms;
    private int heads;

    /**
     * Constructor with arguments
     * @param eyes, arms, heads
     */
    public Alien(int eyes, int arms, int heads) {
        this.arms = arms;
        this.eyes = eyes;
        this.heads = heads;
    }

    /**
     * @return getHeads the heads
     */
    public int getHeads() {
        return heads;
    }

    /**
     * @param heads the heads to set
     */
    public void setHeads(int heads) {
        this.heads = heads;
    }

    /**
     * toString() method
     * Returns a String containing a complete description of the Alien
     * @return Complete description of the Alien
     */
    @Override
    public String toString() {
        return "This Alien has " + heads + " head(s), " + arms + " arm(s), and " + eyes + " eye(s)";
    }
}
