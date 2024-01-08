import ModelJSON.ModelJSONTopUP;
import NodeData.NodeDataTopUP;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<NodeDataTopUP> listTopUP = new ArrayList<>();
        listTopUP.add(new NodeDataTopUP("Maulana","ML",2000,1));

        ModelJSONTopUP modelJSONTopUP = new ModelJSONTopUP();
        modelJSONTopUP.writeJSON(listTopUP);
    }
}