package h04;

public class CoinCollection implements WithCoinTypes {
    private int numberOfSilverCoins;
    private int numberOfBrassCoins;
    private int numberOfCopperCoins;

    /**
     * Initializes a new Coin Collector with three coin types.
     *
     * @param numberOfSilverCoins the amount of the silver coins
     * @param numberOfBrassCoins the amount of the brass coins
     * @param numberOfCopperCoins the amount of the copper coins
     */
    public CoinCollection(int numberOfSilverCoins, int numberOfBrassCoins, int numberOfCopperCoins) {
        this.numberOfSilverCoins = numberOfSilverCoins;
        this.numberOfBrassCoins = numberOfBrassCoins;
        this.numberOfCopperCoins = numberOfCopperCoins;
    }

    /**
     * This method returns the current amount of silver coins.
     *
     * @return amount of silver coins
     */
    public int getNumberOfSilverCoins() {
        return numberOfSilverCoins;
    }

    /**
     * @return the amount of Brass Coins
     */
    public int getNumberOfBrassCoins() {
        return numberOfBrassCoins;
    }

    /**
     * @return the amount of copper Coins
     */
    public int getNumberOfCopperCoins() {
        return numberOfCopperCoins;
    }

    /**
     * This method adds a coin of the specified coin type.
     *
     * @param coinType the specified coin type
     */
    public void insertCoin(CoinType coinType) {
        switch (coinType) {
            case SILVER -> numberOfSilverCoins++;
            case BRASS -> numberOfBrassCoins++;
            case COPPER -> numberOfCopperCoins++;
            default -> throw new IllegalArgumentException("Ungültiges CoinType");
        }
    }

    /**
     * This method removes a coin of the specified coin type.
     *
     * @param type the specified coin type
     */
    public void removeCoin(CoinType coinType) {
        switch (coinType) {
            case SILVER -> {
                if (0 < numberOfSilverCoins)
                    numberOfSilverCoins--;
            }
            case BRASS -> {
                if (0 < numberOfBrassCoins)
                    numberOfBrassCoins--;
            }
            case COPPER -> {
                if (0 < numberOfCopperCoins) {
                    numberOfCopperCoins--;
                }
            }
            default -> throw new IllegalArgumentException("Ungültiges CoinType");
        }
    }

    @Override
    public void setNumberOfCoinsOfType(CoinType coinType, int n) {
        if (n < 0) {
            n = 0;
        }
        switch (coinType) {
            case SILVER -> this.numberOfSilverCoins = n;
            case BRASS -> this.numberOfBrassCoins = n;
            case COPPER -> this.numberOfCopperCoins = n;
            default -> throw new IllegalArgumentException("Üngültiges CoinType");
        }
    }

    @Override
    public int getNumberOfCoinsOfType(CoinType coinType) {
            switch (coinType) {
                case SILVER -> {
                    return numberOfSilverCoins;
                }
                case BRASS -> {
                    return numberOfBrassCoins;
                }
                case COPPER -> {
                    return numberOfCopperCoins;
                }
                default -> throw new IllegalArgumentException("Fehler, falsches CoinType");
            }
    }
}
