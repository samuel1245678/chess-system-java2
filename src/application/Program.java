package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ChessMatch ChessMatch = new ChessMatch();
		
		while(true) {
			try {
			   UI.clearScreen();
			   UI.printMatch(ChessMatch);
			   System.out.println();
			   System.out.print("source: ");
			   ChessPosition source = UI.readChessPosition(sc);
			   
			   boolean[][] possibleMoves = ChessMatch.possibleMoves(source);
			   UI.clearScreen();
			   UI.printBoard(ChessMatch.getPieces(), possibleMoves);
			   System.out.println();
			   System.out.print("Target: ");
			   ChessPosition target = UI.readChessPosition(sc);
			
			   ChessPiece capturedPiece = ChessMatch.performChessMove(source, target);
			}
			catch(ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
	}
}
