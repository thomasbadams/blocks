package pt314.blocks.game;

import static org.junit.Assert.*;

import org.junit.Test;

public class MoveBlockTest {
	GameBoard gb = new GameBoard(5,5);
	@Test
	public void testValidMove() {
		gb.placeBlockAt(new TargetBlock(), 2, 2);
		assertTrue(gb.moveBlock(2, 2, Direction.RIGHT, 1));
		assertTrue(gb.getBlockAt(2,3)instanceof TargetBlock);
		assertFalse(gb.getBlockAt(2,2)instanceof TargetBlock);
		
		gb.placeBlockAt(new HorizontalBlock(), 3, 3);
		assertTrue(gb.moveBlock(3, 3, Direction.LEFT, 1));
		assertTrue(gb.getBlockAt(3,2)instanceof HorizontalBlock);
		assertFalse(gb.getBlockAt(3,3)instanceof HorizontalBlock);
		
		gb.placeBlockAt(new VerticalBlock(), 0, 0);
		assertTrue(gb.moveBlock(0, 0, Direction.DOWN, 1));
		assertTrue(gb.getBlockAt(1,0)instanceof VerticalBlock);
		assertFalse(gb.getBlockAt(0,0)instanceof VerticalBlock);
	}
	@Test
	public void testInValidMove() {
		gb.placeBlockAt(new TargetBlock(), 2, 2);
		assertFalse(gb.moveBlock(2, 2, Direction.UP, 1));
		assertFalse(gb.getBlockAt(1,2)instanceof TargetBlock);
		assertTrue(gb.getBlockAt(2,2)instanceof TargetBlock);
		
		gb.placeBlockAt(new HorizontalBlock(), 3, 3);
		assertFalse(gb.moveBlock(3, 3, Direction.DOWN, 1));
		assertFalse(gb.getBlockAt(2,3)instanceof HorizontalBlock);
		assertTrue(gb.getBlockAt(3,3)instanceof HorizontalBlock);
		
		gb.placeBlockAt(new VerticalBlock(), 0, 0);
		assertFalse(gb.moveBlock(0, 0, Direction.RIGHT, 1));
		assertFalse(gb.getBlockAt(0,1)instanceof VerticalBlock);
		assertTrue(gb.getBlockAt(0,0)instanceof VerticalBlock);
	}
	@Test
	public void testOutOfBoundsMove() {
		gb.placeBlockAt(new TargetBlock(), 2, 0);
		assertFalse(gb.moveBlock(2, 0, Direction.LEFT, 1));
		assertTrue(gb.getBlockAt(2,0)instanceof TargetBlock);
		
		gb.placeBlockAt(new HorizontalBlock(), 2, 4);
		assertFalse(gb.moveBlock(2, 4, Direction.RIGHT, 1));
		assertTrue(gb.getBlockAt(2,4)instanceof HorizontalBlock);
		
		gb.placeBlockAt(new VerticalBlock(), 0, 0);
		assertFalse(gb.moveBlock(0, 0, Direction.UP, 1));
		assertTrue(gb.getBlockAt(0,0)instanceof VerticalBlock);
		
		gb.placeBlockAt(new VerticalBlock(), 4, 0);
		assertFalse(gb.moveBlock(4, 0, Direction.DOWN, 1));
		assertTrue(gb.getBlockAt(4,0)instanceof VerticalBlock);
	}
	
	@Test
	public void testBlockInWay() {
		gb.placeBlockAt(new TargetBlock(), 2, 0);
		gb.placeBlockAt(new VerticalBlock(), 2, 1);
		assertFalse(gb.moveBlock(2, 0, Direction.RIGHT, 1));
		assertTrue(gb.getBlockAt(2,0)instanceof TargetBlock);
		
	}

}
/*
Add unit tests to test the moveBlock method in the GameBoard class.
Make sure you test all important cases, including trying to move in an invalid direction, trying to move out
of bounds, and trying to move with a block in the way. The tests should be in the “test” folder, and not in
the “src” folder.
*/