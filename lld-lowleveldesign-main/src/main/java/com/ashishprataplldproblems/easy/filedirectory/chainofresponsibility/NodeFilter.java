package com.ashishprataplldproblems.easy.filedirectory.chainofresponsibility;

import com.ashishprataplldproblems.easy.filedirectory.AbstractNode;

import java.util.Map;

public interface NodeFilter {
    boolean apply(AbstractNode node, Map<String, Object> params);
}
