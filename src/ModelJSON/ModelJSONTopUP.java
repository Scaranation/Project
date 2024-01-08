package ModelJSON;
import NodeData.NodeDataTopUP;
import NodeJSON.NodeJSONTopUP;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ModelJSONTopUP {
    public String fname;
    public NodeJSONTopUP nodeJSONTopUP = new NodeJSONTopUP();

    public ModelJSONTopUP(){
        this.fname = "src/Database/topup.json";
    }
    public boolean cekFile(){
        boolean cek = false;
        File file = new File(this.fname);
        if (file.exists()){
            cek = true;
        }
        return cek;
    }
    public JSONArray convertArrayListToArrayJSON(ArrayList<NodeDataTopUP> listTopUp){
        if (listTopUp == null){
            return null;
        }else{
            JSONArray array = new JSONArray();
            for (int i = 0; i < listTopUp.size();i++){
                JSONObject detTopup = new JSONObject();
                detTopup.put(nodeJSONTopUP.game, listTopUp.get(i).game);
                detTopup.put(nodeJSONTopUP.harga, listTopUp.get(i).harga);
                detTopup.put(nodeJSONTopUP.jumlah, listTopUp.get(i).jumlah);
                detTopup.put(nodeJSONTopUP.namaUser, listTopUp.get(i).namaUser);
                array.add(detTopup);
            }
            return array;
        }
    }
    public void writeJSON(ArrayList<NodeDataTopUP>listTopUp){
        JSONArray array = convertArrayListToArrayJSON(listTopUp);
        if (array != null){
            try {
                FileWriter file = new FileWriter(this.fname);
                file.write(array.toJSONString());
                file.flush();
                file.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
