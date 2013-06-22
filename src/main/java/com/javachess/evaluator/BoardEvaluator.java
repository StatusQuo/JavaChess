package com.javachess.evaluator;

import java.util.ArrayList;
import java.util.List;

import com.javachess.board.Board;
import com.javachess.board.Square;
import com.javachess.move.Move;
import com.javachess.piece.Color;
import com.javachess.piece.Piece;
import com.javachess.piece.PieceType;

public class BoardEvaluator {

	public boolean isCheck(Color color, Board board) {
		return isThreatened(findKing(color, board), board);
	}

	public boolean isCheckMate(Color color, List<Move> ctxMoves, Board board) {
		return isCheck(color, board) && legalMoves(color, ctxMoves, board).size() == 0;
	}

	public boolean isStaleMate(Color color, List<Move> ctxMoves, Board board) {
		return !isCheck(color, board) && legalMoves(color, ctxMoves, board).size() == 0;
	}

	public List<Move> legalMoves(Color color, List<Move> ctxMoves, Board board) {
		List<Move> legalMoves = new ArrayList<Move>();
		ctxMoves.addAll(semiLegalMoves(color, board));
		
		for (Move move : ctxMoves) {
			move.execute();

			if (!isCheck(color, board))
				legalMoves.add(move);

			move.undo();
		}

		return legalMoves;
	}

	public boolean isThreatened(Square square, Board board) {
		return false;
	}

	private List<Move> semiLegalMoves(Color color, Board board) {
		List<Move> moveList = new ArrayList<Move>();

		for (Square square : board.allSquares()) {
			Piece piece = board.at(square);

			if (piece.isColor(color));
				//moveList.addAll(piece.availableMoves(square, board));
		}

		return moveList;
	}

	public Square findKing(Color color, Board board) {
		for (Square square : board.allSquares()) {
			Piece piece = board.at(square);

			if (piece.isType(PieceType.KING) && piece.isColor(color)) {
				return square;
			}
		}

		throw new IllegalStateException("The king is missing!");
	}
}