package chess.Move;

import chess.ChessBoard;
import chess.ChessMove;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class KnightMove implements PieceMove {

    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        List<ChessMove> combinedList = new ArrayList<>();
        combinedList.add(calculator(board, myPosition, 2, 1));
        combinedList.add(calculator(board, myPosition, 2, -1));
        combinedList.add(calculator(board, myPosition, -2, 1));
        combinedList.add(calculator(board, myPosition, -2, -1));
        combinedList.add(calculator(board, myPosition, 1, 2));
        combinedList.add(calculator(board, myPosition, -1, 2));
        combinedList.add(calculator(board, myPosition, 1, -2));
        combinedList.add(calculator(board, myPosition, -1, -2));
        combinedList.removeIf(Objects::isNull);
        return combinedList;
    }

    public static ChessMove calculator(ChessBoard board, ChessPosition position, int v, int h) {
        int row = position.getRow();
        int col = position.getColumn();
        ChessPosition start = new ChessPosition(row, col);
        ChessPiece piece = board.getPiece(start);

        int r = row + v;
        int c = col + h;
        if (PieceMove.validPosition(r, c)) {
            ChessPiece square = board.getPiece(new ChessPosition(r, c));
            if (square == null || piece.getTeamColor() != square.getTeamColor()) {
                System.out.print(r + "," + c + " ");
                return new ChessMove(start, new ChessPosition(r, c), null);

            }
        }

        return null;
    }

}
