package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	private ChessMatch chessMatch;
	
	public Pawn(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}

	@Override
	public boolean[][] possibleMove() {
		boolean[][] matriz = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0, 0);
		
		//movimento do peão branco
		if(getColor() == Color.WHITE) {
			p.setValue(position.getRow() - 1, position.getColumn());
			if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				matriz[p.getRow()][p.getColumn()] = true;
			}
			p.setValue(position.getRow() - 2, position.getColumn());
			
			//VALIDANDO SE A PRIMEIRA CASA TA LIVRE
			Position p2 = new Position(position.getRow() - 1, position.getColumn());
			
			//getMoveCount() == 0 SIGUINIFICA VERDADEIRO
			if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
				matriz[p.getRow()][p.getColumn()] = true;
			}
			p.setValue(position.getRow() - 1, position.getColumn() -1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				matriz[p.getRow()][p.getColumn()] = true;
			}
			p.setValue(position.getRow() - 1, position.getColumn() +1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				matriz[p.getRow()][p.getColumn()] = true;
			}
			
			// #enPassant white left
			if(position.getRow() == 3) {
				//testando se tem um piece adversário do lado
				Position left = new Position(position.getRow(), position.getColumn() - 1);
				if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
					matriz[left.getRow() - 1][left.getColumn()] = true;
				}
				//right
				Position right = new Position(position.getRow(), position.getColumn() + 1);
				if(getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
					matriz[right.getRow() - 1][right.getColumn()] = true;
				}
			}
		}
		else {
			p.setValue(position.getRow() + 1, position.getColumn());
			if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				matriz[p.getRow()][p.getColumn()] = true;
			}
			p.setValue(position.getRow() + 2, position.getColumn());
			
			Position p2 = new Position(position.getRow() + 1, position.getColumn());
			
			if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
				matriz[p.getRow()][p.getColumn()] = true;
			}
			p.setValue(position.getRow() + 1, position.getColumn() -1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				matriz[p.getRow()][p.getColumn()] = true;
			}
			p.setValue(position.getRow() + 1, position.getColumn() +1);
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				matriz[p.getRow()][p.getColumn()] = true;
			}
			
			// #enPassant black left
			if(position.getRow() == 4) {
				//testando se tem um piece adversário do lado
				Position left = new Position(position.getRow(), position.getColumn() - 1);
				if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
					matriz[left.getRow() + 1][left.getColumn()] = true;
				}
				//right
					Position right = new Position(position.getRow(), position.getColumn() + 1);
					if(getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
						matriz[right.getRow() + 1][right.getColumn()] = true;
					}
				}
}
		
		return matriz;
	}
	
	@Override
	public String toString() {
		return "P";
	}
}
