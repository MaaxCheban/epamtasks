package com;

import com.WorkFlow.Closed;
import com.WorkFlow.Reopened;
import com.WorkFlow.Resolved;
import com.WorkFlow.Task;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Task t = new Task();
        t.showState();

        t.changeState(new Reopened());
        t.showState();

        t.changeState(new Resolved());
        t.showState();

        t.changeState(new Reopened());
        t.showState();

        t.changeState(new Resolved());
        t.showState();

        t.changeState(new Closed());
        t.showState();
    }
}
