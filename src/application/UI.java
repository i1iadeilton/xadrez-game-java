package application;

import chess.ChessPiece;

public class UI {

	public static void printBoard(ChessPiece[][] pieces) {
		for (int i=0; i < pieces.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j=0; j < pieces.length; j++) {
				printPiece(pieces[i][j]);
			}
			/*quebra de linha do tabuleiro*/
			System.out.println();
		}
		System.out.println(" a b c d e f g h");
	}
	
	/*metodo auxiliar para imprimir uma peça*/
	private static void printPiece(ChessPiece piece) {
		if(piece == null) {
			/*se não tiver peça*/
			System.out.print("-");
		}
		else {
			System.out.print(piece);
		}
		/*espaço para separar*/
		System.out.print(" ");
	}
}
