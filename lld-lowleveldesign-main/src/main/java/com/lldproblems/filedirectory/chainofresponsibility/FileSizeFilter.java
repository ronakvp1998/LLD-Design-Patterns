package com.lldproblems.filedirectory.chainofresponsibility;

import com.lldproblems.filedirectory.AbstractNode;
import com.lldproblems.filedirectory.FileNode;
import com.lldproblems.filedirectory.chainofresponsibility.NodeFilter;

import java.util.Map;

public class FileSizeFilter implements NodeFilter {
    @Override
    public boolean apply(AbstractNode node, Map<String, Object> params) {
        if (!(node instanceof FileNode)) return true;
        if (!params.containsKey("minSize") || !params.containsKey("maxSize")) return true;

        int minSize = (int) params.get("minSize");
        int maxSize = (int) params.get("maxSize");
        int size = ((FileNode) node).getSize();

        return size >= minSize && size <= maxSize;
    }
}