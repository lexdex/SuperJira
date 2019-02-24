package com.company.Interfaces;
import com.company.State;
import com.company.Task;

public interface StateMove {
	
	public default void MoveOpen(Task currentTask) {
		currentTask.currentState=State.Open;
		currentTask.tested=false;
	}

	public default void MoveInProgress(Task currentTask) {

		currentTask.currentState=State.InProgress;
	}
	public default void MoveReopen(Task currentTask) {

		currentTask.currentState=State.ReOpened;
	    currentTask.tested=false;
	}
	public default void MoveClosed(Task currentTask) {

		currentTask.currentState=State.Closed;
		currentTask.tested=true;
	}
	public default void MoveResolved(Task currentTask) {

		currentTask.currentState=State.Resolved;
	}

}
