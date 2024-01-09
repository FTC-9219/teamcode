package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
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
    public Servo airplaneLauncher;

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

        airplaneLauncher = hardwareMap.get(Servo.class, "airplaneLauncher");

        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);


        double drivespeed = 0.8;


        waitForStart();

        while (opModeIsActive()) {
//            if (gamepad1.right_bumper) {
//                frontLeft.setPower(-drivespeed);
//                frontRight.setPower(drivespeed);
//                backLeft.setPower(-drivespeed);
//                backRight.setPower(drivespeed);
//            }
//            else if (gamepad1.left_bumper) {
//                frontLeft.setPower(drivespeed);
//                frontRight.setPower(-drivespeed);
//                backLeft.setPower(drivespeed);
//                backRight.setPower(-drivespeed);
//            }
//
//            else if (gamepad1.left_stick_y > 0.9) {
//                frontLeft.setPower(drivespeed);
//                frontRight.setPower(drivespeed);
//                backLeft.setPower(drivespeed);
//                backRight.setPower(drivespeed);
//            }
//            else if (gamepad1.left_stick_y < -0.9) {
//                frontLeft.setPower(-drivespeed);
//                frontRight.setPower(-drivespeed);
//                backLeft.setPower(-drivespeed);
//                backRight.setPower(-drivespeed);
//            }
//
//            else if (gamepad1.left_stick_x > 0.9) {
//                frontLeft.setPower(-drivespeed);
//                frontRight.setPower(drivespeed);
//                backLeft.setPower(drivespeed);
//                backRight.setPower(-drivespeed);
//            }
//            else if (gamepad1.left_stick_x < -0.9) {
//                frontLeft.setPower(drivespeed);
//                frontRight.setPower(-drivespeed);
//                backLeft.setPower(-drivespeed);
//                backRight.setPower(drivespeed);
//            }
//            else {
//                frontLeft.setPower(0);
//                frontRight.setPower(0);
//                backLeft.setPower(0);
//                backRight.setPower(0);
//            }

            double speed = gamepad1.left_stick_y;
            double turn = gamepad1.right_stick_x;
            double strafe = gamepad1.left_stick_x;
            frontLeft.setPower(-speed + turn + strafe);
            frontRight.setPower(-speed - turn - strafe);
            backLeft.setPower(-speed + turn - strafe);
            backRight.setPower(-speed - turn + strafe);

            //hookLifter
            if (gamepad1.a) {
                hookLifter.setPower(1);
            } else if (gamepad1.b) {
                hookLifter.setPower(-1);
            } else {
                hookLifter.setPower(0);
            }

            //clawArm
            if (gamepad2.dpad_up) {
                clawArm.setPower(.5);
            } else if (gamepad2.dpad_down) {
                clawArm.setPower(-.5);
            } else {
                clawArm.setPower(0);
            }

            //clawWrist
            if (gamepad2.left_stick_y > .9) {
                clawWrist.setPower(.5);
            } else if (gamepad2.left_stick_y < -0.9) {
                clawWrist.setPower(-.5);
            } else {
                clawWrist.setPower(0);
            }

            //clawGrabber
            if (gamepad2.right_stick_x > 0.9) {
                clawGrabber.setPosition(.25);
            } else if (gamepad2.right_stick_x < -0.9) {
                clawGrabber.setPosition(-.25);
            } else {
                clawGrabber.setPosition(0);
            }

            //airplaneLauncher
            if (gamepad2.x) {
                airplaneLauncher.setPosition(1);
            } else {
                airplaneLauncher.setPosition(0);
            }
        }
    }
}
