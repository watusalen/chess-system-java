package application;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        ChessMatch match = new ChessMatch();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                UI.clearScreen();
                UI.printBoard(match.getPieces());
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(scanner);

                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(scanner);

                ChessPiece capturedPiece = match.performChessMove(source, target);
            } catch (ChessException e) {
                System.out.print(e.getMessage());
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.print(e.getMessage());
                scanner.nextLine();
            }
        }
    }
}