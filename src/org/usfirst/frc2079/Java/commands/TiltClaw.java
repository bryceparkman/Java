package org.usfirst.frc2079.Java.commands;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2079.Java.Robot;
import org.usfirst.frc2079.Java.RobotMap;

public class TiltClaw extends Command {

	char direction;

    public TiltClaw(char direction) { //Allows program to be used for two different directions
    	this.direction=direction;
        requires(Robot.climb);
    }
    
    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
    	switch(direction){
    		case 'u':	RobotMap.dsClawLift.set(Value.kForward); break; //If called with 'u' set the cylinder to go forwards
    		case 'd':	RobotMap.dsClawLift.set(Value.kReverse); break; //If called with 'd' set the cylinder to go backwards
    		default:	RobotMap.dsClawLift.set(Value.kOff); //Otherwise turn it off
    	}
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
    	RobotMap.dsClawLift.set(Value.kOff); //If it ends also turn it off
    }

    @Override
    protected void interrupted() {
    	end();
    }
}
