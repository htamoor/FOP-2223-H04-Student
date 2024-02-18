package h04;

import fopbot.Direction;
import fopbot.Robot;

public class RobotWithCoinTypes extends Robot implements WithCoinTypes {
    private int numberOfSilverCoins;
    private int numberOfBrassCoins;
    private int numberOfCopperCoins;

    /**
     * Initializes a new robot with three coin types.
     *
     * @param x The value of the x-coordinate of the robot.
     * @param y The value of the y-coordinate of the robot.
     * @param direction The value of the direction of the robot.
     * @param numberOfSilverCoins The amount of the silver coins of the robot.
     * @param numberOfBrassCoins The amount of the brass coins of the robot.
     * @param numberOfCopperCoins The amount of the copper coins of the robot.
     */
    public RobotWithCoinTypes(int x, int y, Direction direction, int numberOfSilverCoins, int numberOfBrassCoins, int numberOfCopperCoins) {
        super(x, y, direction, numberOfSilverCoins + numberOfBrassCoins + numberOfCopperCoins);
        this.numberOfSilverCoins = numberOfSilverCoins;
        this.numberOfBrassCoins = numberOfBrassCoins;
        this.numberOfCopperCoins = numberOfCopperCoins;
    }

    @Override
    public void setNumberOfCoins(int coins) {
        if (coins < 0) {
            super.setNumberOfCoins(coins);
        } else {
            this.numberOfCopperCoins = coins;
        }
    }

    @Override
    public void setNumberOfCoinsOfType(CoinType coinType, int n) {
        if (n < 0) {
            super.setNumberOfCoins(n);
        }
        switch (coinType) {
            case SILVER -> this.numberOfSilverCoins = n;
            case BRASS -> this.numberOfBrassCoins = n;
            case COPPER -> this.numberOfCopperCoins = n;
            default -> throw new IllegalArgumentException("Üngültiges CoinType");
        }
        super.setNumberOfCoins(numberOfSilverCoins + numberOfBrassCoins + numberOfCopperCoins);
    }

    @Override
    public int getNumberOfCoinsOfType(CoinType coinType) {
        return getCoinType(coinType);
    }

    @Override
    public void pickCoin() {
        super.pickCoin();
        this.numberOfCopperCoins++;
    }

    @Override
    public void putCoin() {
        if (this.numberOfCopperCoins != 0) {
            this.numberOfCopperCoins--;
        }
        else if (this.numberOfBrassCoins != 0) {
            this.numberOfBrassCoins--;
        }
        else if (this.numberOfSilverCoins != 0) {
            this.numberOfSilverCoins--;
        }
        super.putCoin();
    }

    private int getCoinType(CoinType coinType) {
        switch (coinType) {
            case SILVER -> {
                return this.numberOfSilverCoins;
            }
            case COPPER -> {
                return this.numberOfCopperCoins;
            }
            case BRASS -> {
                return this.numberOfBrassCoins;
            }
            default -> throw new IllegalArgumentException("Ungültiges CoinType");
        }
    }
}
