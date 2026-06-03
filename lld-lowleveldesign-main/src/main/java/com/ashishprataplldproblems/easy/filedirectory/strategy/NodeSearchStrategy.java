package com.ashishprataplldproblems.easy.filedirectory.strategy;


import com.ashishprataplldproblems.easy.filedirectory.AbstractNode;
import com.ashishprataplldproblems.easy.filedirectory.DirectoryNode;

import java.util.*;

public // Search strategy interface
interface NodeSearchStrategy {
    List<AbstractNode> search(DirectoryNode directory, Map<String, Object> params);
}
