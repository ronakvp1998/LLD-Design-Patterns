package com.ashishprataplldproblems.filedirectory.strategy;


import com.ashishprataplldproblems.filedirectory.AbstractNode;
import com.ashishprataplldproblems.filedirectory.DirectoryNode;

import java.util.*;

public // Search strategy interface
interface NodeSearchStrategy {
    List<AbstractNode> search(DirectoryNode directory, Map<String, Object> params);
}
