package com.ashishprataplldproblems.easy.loggingframework.strategies.appender;

import com.ashishprataplldproblems.easy.loggingframework.entities.LogMessage;
import com.ashishprataplldproblems.easy.loggingframework.strategies.formatter.LogFormatter;

public interface LogAppender {
    void append(LogMessage logMessage);
    void close();
    LogFormatter getFormatter();
    void setFormatter(LogFormatter formatter);
}
