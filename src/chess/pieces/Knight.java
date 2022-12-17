package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece{

	public Knight(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "N";
	}

	public boolean canMove(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}
	
	@Override
	public boolean[][] possibleMove() {
		/*por padrão todas posições da matriz começam com false, como se a peça tivesse presa*/
		boolean[][] matriz = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0, 0);
		
		
		p.setValue(position.getRow() - 1, position.getColumn() - 2);
		if(getBoard().positionExists(p) && canMove(p)){
			matriz[p.getRow()][p.getColumn()] = true;
		}
		
		
		p.setValue(position.getRow() - 2, position.getColumn() - 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			matriz[p.getRow()][p.getColumn()] = true;
		}
		
		//left
		p.setValue(position.getRow() - 2, position.getColumn() + 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			matriz[p.getRow()][p.getColumn()] = true;
		}
		
		//right
		p.setValue(position.getRow() - 1, position.getColumn() + 2);
		if(getBoard().positionExists(p) && canMove(p)) {
			matriz[p.getRow()][p.getColumn()] = true;
		}
		
		//northwest
		p.setValue(position.getRow() + 1, position.getColumn() + 2);
		if(getBoard().positionExists(p) && canMove(p)) {
			matriz[p.getRow()][p.getColumn()] = true;
		}
		
		//NortEst
		p.setValue(position.getRow() + 2, position.getColumn() + 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			matriz[p.getRow()][p.getColumn()] = true;
		}
		
		//southWest
		p.setValue(position.getRow() + 2, position.getColumn() - 1);
		if(getBoard().positionExists(p) && canMove(p)) {
			matriz[p.getRow()][p.getColumn()] = true;
		}
		
		//suthEst
		p.setValue(position.getRow() + 1, position.getColumn() - 2);
		if(getBoard().positionExists(p) && canMove(p)) {
			matriz[p.getRow()][p.getColumn()] = true;
		}
				
		return matriz;
	}
}
