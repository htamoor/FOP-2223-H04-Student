package h04;

import fopbot.Direction;

public class RobotWithCoinTypesAndRefStateTwo extends RobotWithCoinTypes implements RobotWithReferenceState {
    private ReferenceRobot refRobot;

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
    public RobotWithCoinTypesAndRefStateTwo(int x, int y, Direction direction, int numberOFSilverCoins, int numberOfBrassCoins, int numberOfCopperCoins) {
        super(x, y, direction, numberOFSilverCoins, numberOfBrassCoins, numberOfCopperCoins);
        refRobot = new ReferenceRobot(x, y, direction, numberOFSilverCoins + numberOfBrassCoins + numberOfCopperCoins);
    }

    @Override
    public void setCurrentStateAsReferenceState() {
        refRobot.setRefX(getX());
        refRobot.setRefY(getY());
        refRobot.setRefDirection(getDirection());
        refRobot.setRefNumberOfCoins(getNumberOfCoins());
    }

    @Override
    public int getDiffX() {
        return getX() - refRobot.getRefX();
    }

    @Override
    public int getDiffY() {
        return getY() - refRobot.getRefY();
    }

    @Override
    public Direction getDiffDirection() {
        Direction newDirection;
        if (getDirection() == refRobot.getRefDirection()) {
            newDirection = Direction.UP;
        } else if (getDirection() == Direction.UP && refRobot.getRefDirection() == Direction.RIGHT || getDirection() == Direction.RIGHT && refRobot.getRefDirection() == Direction.DOWN || getDirection() == Direction.DOWN && refRobot.getRefDirection() == Direction.LEFT || getDirection() == Direction.LEFT && refRobot.getRefDirection() == Direction.UP) {
            newDirection = Direction.LEFT;
        } else if (getDirection() == Direction.UP && refRobot.getRefDirection() == Direction.DOWN || getDirection() == Direction.RIGHT && refRobot.getRefDirection() == Direction.LEFT || getDirection() == Direction.DOWN && refRobot.getRefDirection() == Direction.UP || getDirection() == Direction.LEFT && refRobot.getRefDirection() == Direction.RIGHT) {
            newDirection = Direction.DOWN;
        } else {
            newDirection = Direction.RIGHT;
        }
        return newDirection;
    }

    @Override
    public int getDiffNumberOfCoins() {
        return getNumberOfCoins() - refRobot.getRefNumberOfCoins();
    }
}
