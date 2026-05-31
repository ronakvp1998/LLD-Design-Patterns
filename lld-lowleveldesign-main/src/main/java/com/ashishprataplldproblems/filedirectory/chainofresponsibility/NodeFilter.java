package com.ashishprataplldproblems.filedirectory.chainofresponsibility;

import com.ashishprataplldproblems.filedirectory.AbstractNode;

import java.util.Map;

public interface NodeFilter {
    boolean apply(AbstractNode node, Map<String, Object> params);
}
