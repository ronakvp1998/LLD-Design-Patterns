package com.ashishprataplldproblems.loggingframework.strategies.appender;

import com.ashishprataplldproblems.loggingframework.entities.LogMessage;
import com.ashishprataplldproblems.loggingframework.strategies.formatter.LogFormatter;

public interface LogAppender {
    void append(LogMessage logMessage);
    void close();
    LogFormatter getFormatter();
    void setFormatter(LogFormatter formatter);
}
