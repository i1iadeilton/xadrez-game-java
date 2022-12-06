package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	public Piece piece(int row, int column) {
		return pieces[row][column];
	}
	/*Sobre carga do metodo Piece*/
	public Piece pieces(Position position) {
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		/*atribuindo na matriz 'pieces' uma peça informada*/
		pieces[position.getRow()][position.getColumn()] = piece;
		
		/*a peça sai da posição null, position é protected mas é do mesmo package*/
		piece.position = position;
	}
	
	
}
