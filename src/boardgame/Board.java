package boardgame;

public class Board {
    private int rows;
    private int columns;
    private final Piece[][] pieces;

    public Board(int rows, int columns) {
        if (rows < 1 | columns < 1) {
            throw new BoardException("Error creating board: there must be at leat 1 row and 1 column.");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece piece(int row, int column) {
        if (!positionExists(row, column)) {
            throw new BoardException("Position not on the board.");
        }
        return pieces[row][column];
    }

    public Piece piece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board.");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position) {
        if (thereIsAPiece(position)) {
            throw new BoardException("There is already a piece on a position: " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    public Piece removePiece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board.");
        }
        if (piece(position) == null) {
            return null;
        }
        Piece piece = piece(position);
        piece.position = null;
        pieces[position.getRow()][position.getColumn()] = null;
        return piece;
    }

    public boolean positionExists(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean positionExists(Position position) {
        return position.getRow() >= 0 && position.getRow() < rows && position.getColumn() >= 0 && position.getColumn() < columns;
    }

    public boolean thereIsAPiece(int row, int column) {
        if (!positionExists(row, column)) {
            throw new BoardException("Position not on the board.");
        }
        return piece(row, column) != null;
    }

    public boolean thereIsAPiece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board.");
        }
        return piece(position) != null;
    }
}