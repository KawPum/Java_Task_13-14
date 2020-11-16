package com.company.Controllers;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class InterfaceController {
    public char[][] gameField = {{'a','b','c','d'},{'e','f','g','h'},{'i','j','k','l'},{'m','n','o','p'}};
    public GridPane grid;
    public int count = 0;


    public void checkWin(int cellCount, int winCount){
        if(checkWinDiag(1)){
            System.out.println("Win!");
            return;
        }
        if(checkWinDiag(-1)){
            System.out.println("Win!");
            return;
        }
        for (int i = cellCount%4; i<4;i++){ //column
            if( checkWinHor(i,1)){
                System.out.println("Win!");
                return;
            }
            for (int j = cellCount/4; j<4; j++){ //row
                if(checkWinVer(1,j)){
                    System.out.println("Win!");
                    return;
                }
                cellCount++;
            }
        }
        return;
    }

    public boolean checkWinVer(int i, int j){
        for (int ii = i; ii < 4; ii ++){
            if (gameField[ii-1][j] == gameField[ii][j]) checkWinVer(ii+1,j);
            else return false;
        }
        return true;
    }

    public boolean checkWinHor(int i, int j){
        for (int jj = j; jj<4; jj++){
            if (gameField[i][jj-1] == gameField[i][jj]) checkWinHor(i,jj+1);
            else return false;
        }
        return true;
    }

    public boolean checkWinDiag(int i){
        if (i > 0) {
            for (int ii = i; ii < 4; ii++) {
                if (gameField[ii - 1][ii - 1] == gameField[ii][ii]) checkWinDiag(ii + 1);
                else return false;
            }
        }else{
            for (int ii = i; ii > -4; ii--) {
                if (gameField[3+ii+1][-ii - 1] == gameField[3+ii][-ii]) checkWinDiag(ii - 1);
                else return false;
            }
        }
        return true;
    }

    public void onMouseClick(MouseEvent mouseEvent) {
        Button button = (Button) mouseEvent.getSource();
        int cell = Integer.parseInt(button.getId().substring(button.getId().length()-2));
        System.out.println(cell);
        if (button.getText().isEmpty()) {
            if (count % 2 == 0) {
                gameField[cell / 10][cell % 10] = 'X';
                button.setText("X");
            } else {
                gameField[cell / 10][cell % 10] = 'O';
                button.setText("O");
            }
            count = (count + 1) % 2;
        }
        checkWin(0,0);
    }
}
