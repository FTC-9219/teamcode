package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class teleOp extends LinearOpMode {

    public DcMotor frontRight;
    public DcMotor frontLeft;
    public DcMotor backLeft;
    public DcMotor backRight;
    public DcMotor hookLifter;
    public Servo clawGrabber;
    public DcMotor clawWrist;
    public DcMotor clawArm;

    public Servo droneLauncher;

    @Override
    public void runOpMode() {

        frontRight = hardwareMap.get(DcMotor.class, "frontRight");

        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");

        backLeft = hardwareMap.get(DcMotor.class, "backLeft");

        backRight = hardwareMap.get(DcMotor.class, "backRight");


        clawGrabber = hardwareMap.get(Servo.class, "clawGrabber");

        clawWrist = hardwareMap.get(DcMotor.class, "clawWrist");

        hookLifter = hardwareMap.get(DcMotor.class, "hookLifter");

        clawArm = hardwareMap.get(DcMotor.class, "clawArm");

        // airplaneLauncher?!!!
        droneLauncher = hardwareMap.get(Servo.class, "airplaneLauncher");
        

        waitForStart();

        while (opModeIsActive()) {

            double speed = -gamepad1.left_stick_y;
            double strafe = -gamepad1.left_stick_x;
            double turn = -gamepad1.right_stick_x;

            frontLeft.setPower    (speed + turn - strafe);
            frontRight.setPower   (speed - turn + strafe);
            backLeft.setPower     (speed + turn + strafe);
            backRight.setPower    (speed - turn - strafe);

            if (gamepad1.right_bumper) {
                frontLeft.setPower(-1);
                frontRight.setPower(-1);
                backLeft.setPower(-1);
                backRight.setPower(1);
            }
            if (!gamepad1.right_bumper) {
                frontLeft.setPower(0);
                frontRight.setPower(0);
                backLeft.setPower(0);
                backRight.setPower(0);
            }
            if (gamepad1.left_bumper) {
                frontLeft.setPower(1);
                frontRight.setPower(1);
                backLeft.setPower(1);
                backRight.setPower(-1);
                            }
            if (!gamepad1.left_bumper) {
                frontLeft.setPower(0);
                frontRight.setPower(0);
                backLeft.setPower(0);
                backRight.setPower(0);
            }

//            if (gamepad1.left_stick_y == 1) {
//                frontLeft.setPower(0.5);
//                frontRight.setPower(-0.5);
//                backLeft.setPower(0.5);
//                backRight.setPower(0.5);
//            }
//            if (gamepad1.left_stick_y == -1) {
//                frontLeft.setPower(-1);
//                frontRight.setPower(1);
//                backLeft.setPower(-1);
//                backRight.setPower(-1);
//            }
//            if (gamepad1.left_stick_y == 0) {
//                frontLeft.setPower(0);
//                frontRight.setPower(0);
//                backLeft.setPower(0);
//                backRight.setPower(0);
//            }
//            if (gamepad1.left_stick_x == 1) {
//                frontLeft.setPower(-1);
//                frontRight.setPower(-1);
//                backLeft.setPower(1);
//                backRight.setPower(-1);
//            }
//            if (gamepad1.left_stick_x == -1) {
//                frontLeft.setPower(1);
//                frontRight.setPower(1);
//                backLeft.setPower(-1);
//                backRight.setPower(1);
//            }
//            if (gamepad1.left_stick_x == 0) {
//                frontLeft.setPower(0);
//                frontRight.setPower(0);
//                backLeft.setPower(0);
//                backRight.setPower(0);

            if (gamepad1.a) {
                hookLifter.setPower(2);
            } else {
                hookLifter.setPower(0);
            }
            if (gamepad1.b) {
                hookLifter.setPower(-2);
            } else {
                hookLifter.setPower(0);
            }
            if (gamepad2.dpad_up) {
                clawArm.setPower(2);
            }
            if (gamepad2.dpad_down) {
                clawArm.setPower(-2);
            }

            if (gamepad2.left_stick_y == 1) {
                clawWrist.setPower(2);
            } else if (gamepad2.left_stick_y == -1) {
                clawWrist.setPower(-2);
            } else {
                clawWrist.setPower(0);
            }

            // set position? .25?
            if (gamepad2.right_stick_x == 1) {
                clawGrabber.setPosition(1);
            }
            if (gamepad2.right_stick_x == 0) {
                clawGrabber.setPosition(0);
            }
            if (gamepad2.right_stick_x == -1) {
                clawGrabber.setPosition(-1);
            }
            if (gamepad2.y) {
                droneLauncher.setPosition(-1);
            }
            if (gamepad2.x) {
                droneLauncher.setPosition(0);
            }
        }

    }
}
