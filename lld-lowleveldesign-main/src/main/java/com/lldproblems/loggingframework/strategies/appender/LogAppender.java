package com.lldproblems.loggingframework.strategies.appender;

import com.lldproblems.loggingframework.entities.LogMessage;
import com.lldproblems.loggingframework.strategies.formatter.LogFormatter;

public interface LogAppender {
    void append(LogMessage logMessage);
    void close();
    LogFormatter getFormatter();
    void setFormatter(LogFormatter formatter);
}
