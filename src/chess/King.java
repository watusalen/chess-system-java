package chess;

import boardgame.Board;
import boardgame.Position;

public class King extends ChessPiece {
    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean canMove(Position position) {
        ChessPiece piece = (ChessPiece) getBoard().piece(position);
        return piece == null || piece.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0);

        // cima
        p.setValues(position.getRow() - 1, position.getColumn());
        if(getBoard().positionExists(p) && canMove(p)){
            matrix[p.getRow()][p.getColumn()] = true;
        }

        // noroeste
        p.setValues(position.getRow() - 1, position.getColumn() - 1);
        if(getBoard().positionExists(p) && canMove(p)){
            matrix[p.getRow()][p.getColumn()] = true;
        }

        // esquerda
        p.setValues(position.getRow(), position.getColumn() - 1);
        if(getBoard().positionExists(p) && canMove(p)){
            matrix[p.getRow()][p.getColumn()] = true;
        }

        // sudoeste
        p.setValues(position.getRow() + 1, position.getColumn() - 1);
        if(getBoard().positionExists(p) && canMove(p)){
            matrix[p.getRow()][p.getColumn()] = true;
        }

        // baixo
        p.setValues(position.getRow() + 1, position.getColumn());
        if(getBoard().positionExists(p) && canMove(p)){
            matrix[p.getRow()][p.getColumn()] = true;
        }

        // sudeste
        p.setValues(position.getRow() + 1, position.getColumn() + 1);
        if(getBoard().positionExists(p) && canMove(p)){
            matrix[p.getRow()][p.getColumn()] = true;
        }

        // direita
        p.setValues(position.getRow(), position.getColumn() + 1);
        if(getBoard().positionExists(p) && canMove(p)){
            matrix[p.getRow()][p.getColumn()] = true;
        }

        // nordeste
        p.setValues(position.getRow() - 1, position.getColumn() + 1);
        if(getBoard().positionExists(p) && canMove(p)){
            matrix[p.getRow()][p.getColumn()] = true;
        }

        return matrix;
    }
}