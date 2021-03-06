package submit;

import flow.Flow;
import flow.FlowSolver;
import joeq.Class.jq_Class;
import joeq.Main.Helper;

public class FindRedundantNullChecks {

    /**
     * Main method of FindRedundantNullChecks.
     * This method should print out a list of quad ids of redundant null checks for each function.
     * The format should be "method_name id0 id1 id2", integers for each id separated by spaces.
     *
     * @param args an array of class names
     */
    public static void main(String[] args) {
        // TODO: Fill in this, like:
        FlowSolver solver = new FlowSolver();
        for (String name : args) {
            jq_Class clazz = (jq_Class) Helper.load(name);
            Flow.Analysis analysis = new HandleNullCheck(0);
            solver.registerAnalysis(analysis);
            Helper.runPass(clazz, solver);
        }
    }
}
