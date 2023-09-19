package lk.ijse.dep11;

import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class MainFormController implements Initializable {
    public Label txtHead;


    static int player=0;
    public GridPane map;

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

    void update(char[][] grid){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(grid[i][j]=='X') {
                    ImageView Imv = (ImageView)getNode(i, j, map);
                    Imv.setImage(new Image(getURL("x_blue.png")));

                } else if (grid[i][j] == 'O') {
                    ImageView Imv = (ImageView)getNode(i, j, map);
                    Imv.setImage(new Image(getURL("o_red.png")));
                } else if (grid[i][j]=='.') {
                    ImageView Imv = (ImageView)getNode(i, j, map);
                    Imv.setImage(new Image(getURL("empty.png")));
                } else if (grid[i][j]=='1') {
                    ImageView Imv = (ImageView)getNode(i, j, map);
                    Imv.setImage(new Image(getURL("x_yellow.png")));
                } else if (grid[i][j]=='2') {
                    ImageView Imv = (ImageView)getNode(i, j, map);
                    Imv.setImage(new Image(getURL("o_yellow.png")));
                }
            }
        }
    }

}
