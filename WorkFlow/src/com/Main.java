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
        t.setAssign(true);


        t.reopenState();
        t.showState();

        t.resolveState();
        t.showState();
        t.setAssign(true);

        t.reopenState();
        t.showState();
        t.setAssign(true);

        t.resolveState();
        t.showState();
        t.setAssign(true);

        t.closeState();
        t.showState();
    }
}
