package mavenproject;

public class CeilingFan {
    // Fields
    public int TurnOff;
    private int rotateSpeed;
    private Direction direction;
    private int speed;
    private int rotateSetting;

    public CeilingFan() { // constructor
        TurnOff = 0;
        rotateSpeed = TurnOff;
        direction = Direction.FORWARD;
        speed = TurnOff;
        rotateSetting = TurnOff;
    }

    /***************** GETTER *******************/
    public int getRotateSpeed() {
        return rotateSpeed;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getSpeed() {
        return this.speed;
    }

    /***************** SETTER *******************/
    public int setSpeed(int speed) {
        return this.speed = speed;
    }

    public int setRotateSetting(int rotateSetting) {
        return this.rotateSetting = rotateSetting;
    }

    public Direction setDirection(Direction direction) {
        return this.direction = direction;
    }

    /***************** ACTIONS *******************/
    public void speedUp() {
        if (rotateSpeed == 3) {
            rotateSpeed = TurnOff;
        } else {
            rotateSpeed++;
        }
    }

    public int rotateSpeedUpSetting() {
        if (rotateSetting == 1) {
            speed ++;
        } else if (rotateSetting == 2) {
            speed += 2;
        } else {
            speed = TurnOff;
        }

        return speed;
    }


    public void reverseDirection() {
        direction = (direction == Direction.FORWARD) ? Direction.BACKWARD : Direction.FORWARD;
    }

    public String speedInstruction() {
        return String.format("The Fan is now rotating in a speed of %d (rpm) ", speed);
    }

    public String toString() {
        return String.format("The fan is working on a speed of %d (rpm) in '%s' direction with the speed setting of %d.", speed, direction, rotateSetting);
    }
}

enum Direction {
    FORWARD,
    BACKWARD;
}
