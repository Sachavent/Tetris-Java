package GestionFichierTest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import GestionFichier.Pieces;

public class PiecesTest {

	private Pieces pieces;
	
	@Before
	public void allocation(){
		pieces= new Pieces();
	}
	
	// Test pour v�rifier l'exactitude de la piece 1
	@Test
	public void shouldReturnPieceChoose() {
		int[][] Piece1 = { {0,1,0,0,0,1,1,0,0,1,0,0,0,0,0,0},{0,0,0,0,0,0,1,0,0,1,1,1,0,0,0,0},{0,0,0,1,0,0,1,1,0,0,0,1,0,0,0,0},{0,1,1,1,0,0,1,0,0,0,0,0,0,0,0,0} };
		assertEquals(Piece1,pieces.get_piece(1));
		
	}


}
