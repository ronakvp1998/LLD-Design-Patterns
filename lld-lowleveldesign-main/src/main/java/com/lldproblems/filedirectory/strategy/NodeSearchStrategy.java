package com.lldproblems.filedirectory.strategy;


import com.lldproblems.filedirectory.AbstractNode;
import com.lldproblems.filedirectory.DirectoryNode;

import java.util.*;

public // Search strategy interface
interface NodeSearchStrategy {
    List<AbstractNode> search(DirectoryNode directory, Map<String, Object> params);
}
