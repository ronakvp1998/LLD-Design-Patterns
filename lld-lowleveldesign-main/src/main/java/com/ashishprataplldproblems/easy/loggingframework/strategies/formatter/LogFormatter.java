package com.ashishprataplldproblems.easy.loggingframework.strategies.formatter;

import com.ashishprataplldproblems.easy.loggingframework.entities.LogMessage;

public interface LogFormatter {
    String format(LogMessage logMessage);
}
