package h04;

import fopbot.Direction;

public class RobotWithCoinTypesAndRefStateOne extends RobotWithCoinTypes implements RobotWithReferenceState {
    private int refX;
    private int refY;
    private Direction refDirection;
    private int refNumberOfCoins;

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
    public RobotWithCoinTypesAndRefStateOne(int x, int y, Direction direction, int numberOfSilverCoins, int numberOfBrassCoins, int numberOfCopperCoins) {
        super(x, y, direction, numberOfSilverCoins, numberOfBrassCoins,numberOfCopperCoins);
        refX = x;
        refY = y;
        refDirection = direction;
        refNumberOfCoins = numberOfSilverCoins + numberOfBrassCoins + 					numberOfCopperCoins;
    }

    @Override
    public void setCurrentStateAsReferenceState() {
        this.refX = getX();
        this.refY = getY();
        this.refDirection = getDirection();
        this.refNumberOfCoins = getNumberOfCoins();
    }

    @Override
    public int getDiffX() {
        return getX() - refX;
    }

    @Override
    public int getDiffY() {
        return getY() - refY;
    }

    @Override
    public Direction getDiffDirection() {
        Direction newDirection;
        if (getDirection() == refDirection) {
            newDirection = Direction.UP;
        } else if (getDirection() == Direction.UP && refDirection == Direction.RIGHT || getDirection()	== Direction.RIGHT && refDirection == Direction.DOWN || getDirection() == Direction.DOWN && refDirection == Direction.LEFT || getDirection() == Direction.LEFT && refDirection == Direction.UP) {
            newDirection = Direction.LEFT;
        } else if (getDirection() == Direction.UP && refDirection == Direction.DOWN || 	getDirection()	== Direction.RIGHT && refDirection == Direction.LEFT || getDirection() == Direction.DOWN && refDirection == Direction.UP || getDirection() == Direction.LEFT && refDirection == Direction.RIGHT) {
            newDirection = Direction.DOWN;
        } else {
            newDirection = Direction.RIGHT;
        }
        return newDirection;

    }

    @Override
    public int getDiffNumberOfCoins() {
        return getNumberOfCoins() - refNumberOfCoins;
    }
}
