package com.company.Interfaces;
import com.company.State;
import com.company.Task;

public interface StateMove {
	
	default void moveOpen(Task currentTask) {
		currentTask.setCurrentState(State.OPEN);
		currentTask.setTested(false);
	}

	default void moveInProgress(Task currentTask) {
		currentTask.setCurrentState(State.IN_PROGRESS);
	}

	default void moveReopen(Task currentTask) {
		currentTask.setCurrentState(State.REOPENED);
	    currentTask.setTested(false);
	}

	default void moveClosed(Task currentTask) {
		currentTask.setCurrentState(State.CLOSED);
		currentTask.setTested(true);
	}

	default void moveResolved(Task currentTask) {
		currentTask.setCurrentState(State.RESOLVED);
	}
}
