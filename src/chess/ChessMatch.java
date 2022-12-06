package chess;

import boardgame.Board;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {

	private Board board;
	
	public ChessMatch() {
		/*classe responsável pelas dimensões do tabuleiro*/
		board = new Board(8, 8);
		inicialSetup(); 
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
	
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		/*toPosition para converter para posição de matriz*/
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	private void inicialSetup() {
		placeNewPiece('b', 6, new Rook(board, Color.WHITE));
		placeNewPiece('e', 8, new King(board, Color.WHITE));
	}
}