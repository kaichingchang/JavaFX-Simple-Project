/*
 *《程式語言教學誌》的範例程式
 * http://kaiching.org/
 * 檔名：Guess.java
 * 功能：猜數字遊戲的 Controller 類別
 * 作者：張凱慶
 */

package guessgame;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class FXMLDocumentController implements Initializable {
    Guess g;
    int count;
    int flag;

    @FXML
    private Label label;

    @FXML
    private TextField input;

    @FXML
    private Button button1;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        count += 1;
        int result = g.answer(Integer.parseInt(input.getText()));
        switch (result) {
            case 0:
                label.setText("答對！你猜了" + String.valueOf(count) + "次。");
                flag = 1;
                button1.setDisable(true);
                break;
            case 1:
                label.setText("比" + input.getText() + "大一點！");
                break;
            case 2:
                label.setText("比" + input.getText() + "小一點！");
                break;
            default:
                label.setText("不正確的輸入...");
        }

        if (flag == 0 && count == 3) {
            label.setText("猜了三次也沒猜對，答案是" + String.valueOf(g.number) + "。");
            button1.setDisable(true);
        }

        input.setText("");
    }

    @FXML
    private void handleButtonAction2(ActionEvent event) {
        g = new Guess();
        count = 0;
        flag = 0;
        button1.setDisable(false);
        input.setText("");
        label.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        g = new Guess();
        count = 0;
        flag = 0;
    }

}
