package com.ashishprataplldproblems.loggingframework.strategies.formatter;

import com.ashishprataplldproblems.loggingframework.entities.LogMessage;

public interface LogFormatter {
    String format(LogMessage logMessage);
}
