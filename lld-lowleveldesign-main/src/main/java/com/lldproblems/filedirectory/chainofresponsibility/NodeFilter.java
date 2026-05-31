package com.lldproblems.filedirectory.chainofresponsibility;

import com.lldproblems.filedirectory.AbstractNode;

import java.util.Map;

public interface NodeFilter {
    boolean apply(AbstractNode node, Map<String, Object> params);
}
