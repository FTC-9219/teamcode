package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous
public class redBack extends LinearOpMode {
    public DcMotor front_left;
    public DcMotor back_left;
    public DcMotor front_right;
    public DcMotor back_right;

    @Override
    public void runOpMode() {
        front_left = hardwareMap.get(DcMotor.class, "front_left");
        back_right = hardwareMap.get(DcMotor.class, "back_right");
        front_right = hardwareMap.get(DcMotor.class, "front_right ");
        back_left = hardwareMap.get(DcMotor.class, "back_left");



        waitForStart();
        Nothing(.5, 4000);
        Forward(.5, 200);
        SpinRight(.5, 880);
        Forward(.5, 3250);

    }
    public void Nothing(double power, long time) {
        front_left.setPower(power*0);
        back_left.setPower(power*0);
        front_right.setPower(power*0);
        back_right.setPower(power*0);
        sleep(time);

    }
    public void Backward(double power, long time) {
        front_left.setPower(power);
        back_left.setPower(power);
        front_right.setPower(power*-1);
        back_right.setPower(power);
        sleep(time);
    }

    public void Forward(double power, long time) {
        front_left.setPower(power * -1);
        back_left.setPower(power * -1);
        front_right.setPower(power);
        back_right.setPower(power * -1);
        sleep(time);
    }

    public void StrafeLeft(double power, long time) {
        front_right.setPower(power);
        back_left.setPower(power*-1);
        front_left.setPower(power);
        back_right.setPower(power);
        sleep(time);
    }

    public void StrafeRight(double power, long time) {
        front_left.setPower(power*-1);
        back_left.setPower(power);
        front_right.setPower(power * -1);
        back_right.setPower(power*-1);
        sleep(time);
    }

    public void SpinLeft(double power, long time) {
        front_left.setPower(power);
        back_left.setPower(power);
        front_right.setPower(power);
        back_right.setPower(power*-1);
        sleep(time);
    }

    public void SpinRight(double power, long time) {
        front_left.setPower(power*-1);
        back_left.setPower(power*-1);
        front_right.setPower(power * -1);
        back_right.setPower(power);
        sleep(time);
    }
}
