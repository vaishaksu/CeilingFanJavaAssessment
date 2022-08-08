package mavenproject;

import java.util.Scanner;

public class App {
    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        String pullCordDirection = "";

        System.out.println("/*******************************************************************************/");
        System.out.println("*");
        System.out.println("* Welcome to the Ceiling fan Problem * ");
        System.out.println(
            "* Here are some of the game rules. Regardless of the fan rotation when you enter 3 the fan will be turned off! *"
            );
        System.out.println("* Enjoy the game!!! *");
        System.out.println("*");
        System.out.println("/******************************************************************************/");
        System.out.println();
        System.out.println();

        // Pulling the cord direction either Forward/ Backward
        System.out.println("Which direction would you like to pull (Forward/Backward)? ");
        Scanner scan = new Scanner(System.in);
        pullCordDirection = scan.nextLine();
        System.out.println();
        System.out.println();

        // Initialising the variable
        int speedSetting = 0;
        int oldSpeedSetting = 0;
        int maxSpeedLimitSetting1 = 20;
        int maxSpeedLimitSetting2 = 40;
        String rotateSameSpeed = "Yes";
        boolean userSpeedQuestion = true;
        String userDirectionQuestion = "Yes";
        boolean cordDirectionFlag = true;
        Direction fanRotateDirection;

        // Create an object from the baseclass
        CeilingFan ceilingFan = new CeilingFan();

        // Checks whether the users enter the right cord either Forward or backward
        while (!pullCordDirection.equalsIgnoreCase("Forward") && !pullCordDirection.equalsIgnoreCase("Backward")) {
            System.out.println("Please enter the right direction (Forward/Backward): ");
            pullCordDirection = scan.nextLine();
        }

        // Converting the string to Enum
        fanRotateDirection = pullCordDirection.equalsIgnoreCase("Forward") ? Direction.FORWARD : Direction.BACKWARD;

        // Important: 
        while (cordDirectionFlag) {
            while (userSpeedQuestion) {
                oldSpeedSetting = speedSetting; // Storing oldvalue, so it is used for validation
                System.out.println(String.format("The fan is rotating in %s direction.", fanRotateDirection));

                System.out.println("Which speed would you like to rotate (1, 2, 3)? ");
                speedSetting = scan.nextInt();

                // Loops until and unless the correct speed setting is entered
                while (speedSetting != 1 && speedSetting != 2 && speedSetting != 3) {
                    System.out.println("Please enter the correct speed settings, either 1 or 2 or 3");
                    speedSetting = scan.nextInt();
                }

                System.out.println();
                scan.nextLine();

                // Set the direction of the fan
                ceilingFan.setDirection(fanRotateDirection);

                if (speedSetting == 1) { // Fan speed settings 1
                    if (oldSpeedSetting == 2) { // From fan speed settings 2 to 1
                        ceilingFan.setSpeed(ceilingFan.TurnOff); 
                    }
                    fanSpeeding(rotateSameSpeed, speedSetting, ceilingFan, maxSpeedLimitSetting1, speedSetting);
                    System.out.println(ceilingFan);
                } else if (speedSetting == 2) { // Fan speed settings 1
                    fanSpeeding(rotateSameSpeed, speedSetting, ceilingFan, maxSpeedLimitSetting2, speedSetting);
                    System.out.println(ceilingFan);
                } else if (speedSetting == 3) { // Fan speed settings 3
                    ceilingFan.setSpeed(ceilingFan.TurnOff);
                    
                    System.out.println("Fan is turned off!");

                    System.out.println();
                    userSpeedQuestion = false;
                    System.exit(0);
                }

                System.out.println("------------------------------------------------------------------------");
                System.out.println(String.format(
                    "Would you still like to rotate in '%s' (Yes/No) direction or you can hit 'exit' to exit the game",
                    fanRotateDirection));
                userDirectionQuestion = scan.nextLine();

                // When user hits exit, just exit the code
                if (userDirectionQuestion.equalsIgnoreCase("no")) {
                    break;
                } else if (userDirectionQuestion.equalsIgnoreCase("exit")) { // Provide all the information
                    System.out.println(ceilingFan);
                    System.exit(1);
                    break;
                }
            }

            // Rotate the speed in the reverse direction when user wants to rotate the fan in the opposite direction
            ceilingFan.reverseDirection();
            ceilingFan.setDirection(ceilingFan.getDirection()); // Setting the direction of the fan in the opposite direction
            fanRotateDirection = ceilingFan.getDirection(); 
            cordDirectionFlag = true; // Start the parent loop

            System.out.println(ceilingFan);

            System.out.println("****************************************************************************************");
            System.out.println();
        }

        scan.close();
    }

    /**
     * Question the user whether they want to rotate in the same speed
     * @param rotateSameSpeed Questioning the user whether they want to rotate in the same speed
     * @param speedSetting Setting the speed whether 1,2,3
     * @param ceilingFan Is a class 
     * @param maxCount counting the no.of.times it needs to loop
     * @param rotateSetting setting the rotation for certain amount
     */

    public static void fanSpeeding(String rotateSameSpeed, int speedSetting, CeilingFan ceilingFan, int maxCount,
        int rotateSetting) {
        rotateSameSpeed = "yes";
        Scanner scan = new Scanner(System.in);
        while (rotateSameSpeed.equalsIgnoreCase("yes")) {
            for (int j = ceilingFan.getSpeed(); j < maxCount; j += 2) {
                ceilingFan.setRotateSetting(rotateSetting);
                ceilingFan.setSpeed(j);
                ceilingFan.rotateSpeedUpSetting();
                System.out.println(ceilingFan.speedInstruction());
            }

            System.out.println();
            String message = "Would you still like to rotate in the same speed? (Yes/ No) ";
            System.out.println(String.format("Right now %s ", ceilingFan));
            System.out.println(message);
            rotateSameSpeed = scan.nextLine();

            while (!rotateSameSpeed.equalsIgnoreCase("yes") && !rotateSameSpeed.equalsIgnoreCase("no")) {
                System.out.println("Please enter the correct answer. " + message);
                rotateSameSpeed = scan.nextLine();
            }

            if (rotateSameSpeed.equalsIgnoreCase("No")) {
                break;
            }
        }
    }
}
