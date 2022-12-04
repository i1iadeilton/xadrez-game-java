package chess;

import boardgame.Board;

public class ChessMatch {

	private Board board;
	
	public ChessMatch() {
		/*classe responsável pelas dimensões do tabuleiro*/
		board = new Board(8, 8);
	}
	
	/*[ camada de chess ->Peças do xadrez] != [ camada de board -> peças tabuleiro]*/
	public ChessPiece[][] getPieces(){
		//var temporaria
		ChessPiece[][] matriz = new ChessPiece[board.getRows()][board.getColumns()];
		for(int i=0; i<board.getRows(); i++) {
			for(int j=0; j<board.getColumns(); j++) {
				//dowcast
				matriz[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return matriz;
	}
}
