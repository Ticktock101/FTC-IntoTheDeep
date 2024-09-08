package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp (name = "MecanumDrive")
public class Drive extends LinearOpMode {

    DcMotor rightFront;
    DcMotor rightBack;
    DcMotor leftFront;
    DcMotor leftBack;




    @Override
    public void runOpMode() throws InterruptedException {

        rightFront = hardwareMap.get(DcMotor.class, "frontRight");
        rightBack = hardwareMap.get(DcMotor.class, "backRight");
        leftFront = hardwareMap.get(DcMotor.class, "frontLeft");
        leftBack = hardwareMap.get(DcMotor.class, "backLeft");


        waitForStart();

        while (opModeIsActive())
        {
            double y = -gamepad1.left_stick_y;
            double x = gamepad1.left_stick_x;

            double rx = gamepad1.right_stick_x;



            telemetry.update();


            double wheelSpeed = 1; //0.0 - 1


            leftFront.setPower(-(y + x + rx) * wheelSpeed);
            leftBack.setPower(-(y - x + rx) * wheelSpeed);
            rightFront.setPower((y - x - rx) * wheelSpeed);
            rightBack.setPower((y + x - rx) * wheelSpeed);


        }
    }
}
