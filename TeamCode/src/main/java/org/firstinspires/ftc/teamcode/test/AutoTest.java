package org.firstinspires.ftc.teamcode.test;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.robot.AutoBot;
import org.firstinspires.ftc.teamcode.robot.sensor.BotSensor;

@Autonomous(name = "Auto Test", group = "Test")
public class AutoTest extends LinearOpMode {

    private AutoBot robot = new AutoBot();
    private boolean foundColor = false;

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap, telemetry);
        waitForStart();

        // Attempt to knock off the opposite alliance jewel
        robot.getMotorSlider().setPower(-0.2);
        sleep(3050);
        robot.getMotorSlider().setPower(0);
        sleep(500);

        robot.getServoJewelArm().setPower(0.5);
        sleep(500
        );
        robot.getServoJewelArm().setPower(0.0);

        sleep(500);
        robot.getMotorSlider().setPower(-0.2);
        sleep(2900);
        robot.getMotorSlider().setPower(0);

        // Swing the red
        switch (robot.isJewel(BotSensor.Jewel.RED, 5)) {
            case BLUE:
                robot.getServoJewelArm().setPower(0.5);
                sleep(575);
            case RED:
                robot.getServoJewelArm().setPower(-0.5);
                sleep(575);
        }
        robot.getServoJewelArm().setPower(0);


        /*if (robot.getSensor().getColorSensor().red() > robot.getSensor().getColorSensor().blue()) {
            robot.getServoJewelArm().setPower(0.5);
            sleep(500);
        } else if (robot.getSensor().getColorSensor().blue() > robot.getSensor().getColorSensor().red()) {
            robot.getServoJewelArm().setPower(-0.5);
            sleep(500);
        }
        robot.getServoJewelArm().setPower(0);*/

        /*robot.moveJewelSlider(0.2, 1500);
        robot.moveJewelArm(0.2, 1000);
        robot.moveJewelSlider(0.2, 1000);

        switch (robot.isJewel(BotSensor.Jewel.BLUE, 5)) {
            case BLUE:
                robot.moveJewelArm(-0.2, 500);
                break;
            case RED:
                robot.moveJewelArm(0.2, 500);
                break;
        }

        robot.moveJewelArm(0.2, 750);
        robot.moveJewelSlider(-0.2, 2000);

        if (isStopRequested()) {
            robot.close();
        }*/
    }
}