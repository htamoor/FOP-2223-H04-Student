package h04;

public interface WithCoinTypes {

    /**
     * This method sets the amount of coins of coinType to the value of number.
     *
     * @param coinType the coin type which amount should be changed
     * @param n the new value for the specified coin type
     */
    public void setNumberOfCoinsOfType(CoinType coinType, int n);
    /**
     * This method returns the current amount of coins of coinType.
     *
     * @param coinType the coin type which amount should be returned
     * @return the amount of the specified coin type
     */
    public int getNumberOfCoinsOfType(CoinType coinType);
}
