package boardgame;

public abstract class Piece {

	protected Position position;
	private Board board;
	
	public Piece(Board board) {
		this.board = board;
		//posição inicial da peça no tabuleiro é nula
		position = null;
	}

	/*só as classes do mesmo package e subclasses podem acessar o tabuleiro de uma peça*/
	protected Board getBoard() {
		return board;
	}
	
	public abstract boolean[][] possibleMove();

	/*rook methods*/
	public boolean possibleMove(Position position) {
		return possibleMove()[position.getRow()][position.getColumn()];
	}
	
	/*implementação concreta que depende de um metodo abstract*/
	public boolean isThereAnyPossibleMove() {
		boolean[][] matriz = possibleMove();
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz.length; j++) {
				if(matriz[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
	
	
}
