package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.opmodes.auto.AutoOpMode;

/**
 * This class serves the purpose of stalling the robot on the lander
 * @author Henry
 * @version 1.0
 */
@TeleOp(name = "Stall Test", group = "test")
public class StallTest extends AutoOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        super.runOpMode();

        while (!isStarted()) {
            telemetry.addData(">", "waiting for start...");
            telemetry.update();
        }

        while (opModeIsActive()) {
            robot.setStallPower(0.2, 5, 2);
        }
    }
}
