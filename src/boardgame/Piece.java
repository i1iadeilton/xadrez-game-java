package boardgame;

public class Piece {

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

	
	
}
