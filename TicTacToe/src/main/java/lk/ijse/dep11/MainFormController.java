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

        Player p1 = new Player('X');
        Player p2 = new Player('O');

        Board board = new Board();
        Player.board=board;

        for (int i = 0; i <3; i++) {
            for (int j = 0; j < 3; j++) {
                ImageView imageView = new ImageView(getURL("empty.png"));
                final int col = i;
                final int row = j;

                imageView.setOnMouseClicked(e->{
                    if(player==0){
                        if(Player.board.isEmpty(row,col)){
                            p1.play(row,col);
                            player=1;

                            if(Player.board.detectWin()!=null){
                                txtHead.setText("player X is win");

                                String []positions = Player.board.detectWin();

                                for (String pos : positions){
                                    int x = Integer.parseInt(pos.split(",")[0]);
                                    int y = Integer.parseInt(pos.split(",")[1]);

                                    p1.setMark('1');
                                    p1.play(x,y);

                                }
                                player=-1;
                            } else {
                                if(Player.board.isFull()){
                                    txtHead.setText("Game is over");
                                    player=-1;
                                } else {
                                    txtHead.setText("Player O turn");
                                }
                            }
                        }
                    } else{
                        if(player!=-1){
                            if(Player.board.isEmpty(row,col)){
                                p2.play(row,col);
                                player=0;

                                if(Player.board.detectWin()!=null){
                                    txtHead.setText("player O is win");
                                    String []positions = Player.board.detectWin();

                                    for (String pos : positions){
                                        int x = Integer.parseInt(pos.split(",")[0]);
                                        int y = Integer.parseInt(pos.split(",")[1]);

                                        p1.setMark('2');
                                        p1.play(x,y);

                                    }
                                    player=-1;
                                } else {
                                    if(Player.board.isFull()){
                                        txtHead.setText("game over");
                                        player=-1;
                                    } else {
                                        txtHead.setText("Player X turn");
                                    }
                                }

                            }
                        }
                    }
                    update(Player.board.grid);
                });
                map.add(imageView,i,j);
            }
        }
        txtHead.setText("Player X turn");
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
        File file1 = new File("/home/pubudu/Documents/dep-11/phase-1/myApps/Tic-Tac-Toe/images/"+name);
        return "file:"+file1;

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
