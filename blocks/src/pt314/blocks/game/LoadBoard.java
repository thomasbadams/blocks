package pt314.blocks.game;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoadBoard{
	private String fileName;
	public LoadBoard(String file){
		fileName = file;
	}
	public GameBoard load() throws Exception{
		BufferedReader file = new BufferedReader(new FileReader(fileName));
		String rowCol[] = file.readLine().split(" ");
		int rows = Integer.parseInt(rowCol[0]);
		int cols = Integer.parseInt(rowCol[1]);
		if(rows < 1 || cols < 1){
			file.close();
			throw new IllegalStateException();
		}
		
		GameBoard gb = new GameBoard(rows, cols);
		boolean hasTarget = false;
		for(int i = 0; i < rows; ++i){
			String line = file.readLine();
			boolean rightMost = false;
			for(int j = 0; j < cols; ++j){
				if(line.charAt(j)=='H'){
					if(rightMost){
						file.close();
						throw new IllegalStateException();
					}
					gb.placeBlockAt(new HorizontalBlock(), i, j);
				}
				if(line.charAt(j)=='V')
					gb.placeBlockAt(new VerticalBlock(), i, j);
				if(line.charAt(j)=='T'){
					gb.placeBlockAt(new TargetBlock(), i, j);
					rightMost = true;
					if(hasTarget){
						file.close();
						throw new IllegalStateException();
					}
					else{
						hasTarget = true;
					}
				}
			}
		}
		file.close();
		return gb;
	}
}
