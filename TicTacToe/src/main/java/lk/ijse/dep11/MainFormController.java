package lk.ijse.dep11;

import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class MainFormController implements Initializable {
    public Label txtHead;
    public GridPane grid;

    static int player=0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public static Node getNode( int row, int column, GridPane gridPane){
        Node result = null;
        ObservableList<Node> children = gridPane.getChildren();
        for(Node node : children){
            if(gridPane.getRowIndex(node)==row && gridPane.getColumnIndex(node)==column){
                result=node;
                break;
            }
        }
        return result;
    }

    public String getURL (String name){
        File file = new File(name);
        String absolute = file.getAbsolutePath();
        absolute=absolute.substring(0,absolute.length()-name.length());
        return "file:\\"+absolute+"src\\main\\resources\\view\\images\\"+name;
    }



}
