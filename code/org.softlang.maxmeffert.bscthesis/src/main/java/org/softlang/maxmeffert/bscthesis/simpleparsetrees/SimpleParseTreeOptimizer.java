package org.softlang.maxmeffert.bscthesis.simpleparsetrees;

public class SimpleParseTreeOptimizer implements ISimpleParseTreeOptimizer {
    @Override
    public ISimpleParseTree optimize(ISimpleParseTree simpleParseTree) {
        ISimpleParseTreeBuilder simpleParseTreeBuilder = new SimpleParseTreeBuilder()
                .withSourceStream(simpleParseTree.getSourceStream())
                .withSourceInterval(simpleParseTree.getSourceInterval());

        for(ISimpleParseTree child : simpleParseTree.getChildren()) {
            child = optimize(child);
            if (simpleParseTree.getText().trim().equals(child.getText().trim())) {
                for(ISimpleParseTree grandChild : child.getChildren()) {
                    simpleParseTreeBuilder = simpleParseTreeBuilder.withChild(optimize(grandChild));
                }
            }
            else {
                simpleParseTreeBuilder = simpleParseTreeBuilder.withChild(child);
            }
        }

        return simpleParseTreeBuilder.build();
    }

}
