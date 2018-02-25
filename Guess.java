/*
 *《程式語言教學誌》的範例程式
 * http://kaiching.org/
 * 檔名：Guess.java
 * 功能：猜數字遊戲的 Model 類別
 * 作者：張凱慶
 */

package guessgame;

public class Guess {
    public int number;

    public Guess() {
        number = (int) (Math.random() * 10);
    }

    public int answer(int guess) {
        if (number == guess) {
            return 0;
        }
        else {
            if (number > guess) {
                return 1;
            }
            else {
                return 2;
            }
        }
    }
}
