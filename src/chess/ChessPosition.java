package chess;

import boardgame.Position;

public class ChessPosition {

	public int row;
	public char column;
	public ChessPosition(char column, int row) {
		if(row < 1 || row > 8 || column < 'a' || column > 'h') {
			throw new ChessException("Error instantianting Chess Position. Valid values are from a1 to h8.");
		}
		this.column = column;
		this.row = row;
	}
	
	public int getRow() {
		return row;
	}
	
	public char getColumn() {
		return column;
	}
		
	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
	}
	
	protected static ChessPosition fromPosition(Position position) {
		/*Cast para char*/
		return new ChessPosition((char)('a' + position.getColumn()), 8 - position.getRow());
	}
	
	@Override 
	public String toString() {
		/*As aspas mostra para o compilador que é um concatenação de string*/
		return "" + column + row;
	}
	
}
