package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

	public Rook(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "R";
	}

	@Override
	public boolean[][] possibleMove() {
		/*por padrão todas posições da matriz começam com false, como se a peça tivesse presa*/
		boolean[][] matriz = new boolean[getBoard().getRows()][getBoard().getColumns()];
		return matriz;
	}
}
