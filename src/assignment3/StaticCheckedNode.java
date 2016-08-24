package assignment3;

import assignment3.dataflow.Node;
import assignment3.processors.Processor;

/**
 * Created by lucia on 8/24/2016.
 */
public class StaticCheckedNode extends Node {
    /**
     * Constructs a new node.
     *
     * @param processor The {@link Processor} of this node.
     */
    public StaticCheckedNode(Processor processor) {
        super(processor);
    }


}
