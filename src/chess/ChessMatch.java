package chess;

import boardgame.Board;

import boardgame.Position;
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
	
	private void inicialSetup() {
		board.placePiece(new Rook(board, Color.WHITE), new Position(2, 1));
		board.placePiece(new King(board, Color.WHITE), new Position(0, 4));
	}
}
