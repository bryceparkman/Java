package org.usfirst.frc2079.Java.commands;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc2079.Java.Robot;
import org.usfirst.frc2079.Java.RobotMap;

public class ControlCamera extends Command {
	double cameraInit;
    public ControlCamera() {
    	
    }
    
    @Override
    protected void initialize() {
    	RobotMap.camera.set(0);
    	cameraInit = (Robot.oi.getManipAxis(3)+1)*0.5;
    }

    @Override
    protected void execute() {
    	SmartDashboard.putNumber("Angle",RobotMap.camera.getAngle());
    	if (Robot.oi.cameraPresetPressed() && RobotMap.camera.getAngle() == 150) { //If preset camera angle is down switch views
    		RobotMap.camera.setAngle(30);
    	} 
    	else if(Robot.oi.cameraPresetPressed() && RobotMap.camera.getAngle() == 30) { //If camera angle is up switch views
    		RobotMap.camera.setAngle(150);
    	} 
    	else if(Robot.oi.cameraPresetPressed()) { //Default to cube view if neither
    		RobotMap.camera.setAngle(150);
    	}
    	else if((Robot.oi.getManipAxis(3)+1)*0.5 <= cameraInit-0.05 || (Robot.oi.getManipAxis(3)+1)*0.5 >= cameraInit+0.05){ //Manual control
    		RobotMap.camera.set((Robot.oi.getManipAxis(3)+1)*0.5);
    		cameraInit = (Robot.oi.getManipAxis(3)+1)*0.5;
    	}
    	
    }

    @Override
    protected void end() {
    	
    }

	@Override
	protected boolean isFinished() {
		return false;
	}
	
}
