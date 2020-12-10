package chess.pieces;

import boardgame.Board;
import boardgame.Position;
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
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position position = new Position(0, 0);

		// above
		position.setValues(position.getRow() - 1, position.getColumn());
		while (getBoard().positionsExists(position) && !getBoard().thereisAPiece(position)) {
			mat[position.getRow()][position.getColumn()] = true;
			position.setRow(position.getRow() - 1);
		}
		if (getBoard().positionsExists(position) && isThereOpponentPiece(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}

		// left
		position.setValues(position.getRow(), position.getColumn() - 1);
		while (getBoard().positionsExists(position) && !getBoard().thereisAPiece(position)) {
			mat[position.getRow()][position.getColumn()] = true;
			position.setColumn(position.getColumn() - 1);
		}
		if (getBoard().positionsExists(position) && isThereOpponentPiece(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}

		// right
		position.setValues(position.getRow(), position.getColumn() + 1);
		while (getBoard().positionsExists(position) && !getBoard().thereisAPiece(position)) {
			mat[position.getRow()][position.getColumn()] = true;
			position.setColumn(position.getColumn() + 1);
		}
		if (getBoard().positionsExists(position) && isThereOpponentPiece(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}

		// below
		position.setValues(position.getRow() + 1, position.getColumn());
		while (getBoard().positionsExists(position) && !getBoard().thereisAPiece(position)) {
			mat[position.getRow()][position.getColumn()] = true;
			position.setRow(position.getRow() + 1);
		}
		if (getBoard().positionsExists(position) && isThereOpponentPiece(position)) {
			mat[position.getRow()][position.getColumn()] = true;
		}
		return mat;
	}
}
