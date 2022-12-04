package application;

import chess.ChessMatch;

public class Program {

	public static void main(String[] args) {

		ChessMatch chessMatch = new ChessMatch();
		//metodo para imprimir o tabuleito
		UI.printBoard(chessMatch.getPieces());
	}

}
