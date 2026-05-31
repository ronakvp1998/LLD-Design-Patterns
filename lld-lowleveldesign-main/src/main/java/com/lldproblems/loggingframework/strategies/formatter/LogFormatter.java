package com.lldproblems.loggingframework.strategies.formatter;

import com.lldproblems.loggingframework.entities.LogMessage;

public interface LogFormatter {
    String format(LogMessage logMessage);
}
