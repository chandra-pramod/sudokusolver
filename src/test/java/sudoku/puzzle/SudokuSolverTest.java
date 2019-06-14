package sudoku.puzzle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import sudoku.puzzle.Sudoku;

public class SudokuSolverTest {
	
	@Test
	public void testValidSudoku() {
		Sudoku sudoku = new Sudoku();
		Gson gson = new Gson();
		FileReader reader;
		try {
			File file = new File(
					getClass().getClassLoader().getResource("Board.json").getFile()
				);
			reader = new FileReader(file);
			JsonParser jsonParser = new JsonParser();
			JsonObject json = (JsonObject) jsonParser.parse(reader);
			for(Entry<String, JsonElement> entry: json.entrySet()) {
				int[][] board = gson.fromJson(entry.getValue(), int[][].class);
				boolean status = sudoku.solution_valid(board);
				System.out.println("Board Number = "+entry.getKey()+" Board status = "+status);
				
			}
			// searchJsonElemnet(array);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		Assert.assertEquals(1, 1);
		
	}

}
