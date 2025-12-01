import java.io.*;
import java.util.*;

public class SudokuBoard {
        private final int[][] board = new int[9][9];


        public SudokuBoard(String path) throws IOException {
            List<String> lines = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                String l;
                while ((l = br.readLine()) != null) {
                    if (!l.trim().isEmpty()) lines.add(l.trim());
                }
            }
            if (lines.size() != 9) throw new IOException("Input must have 9 rows");

            for (int r = 0; r < 9; r++) {
                String[] parts = lines.get(r).split("\\s*,\\s*|\\s+");
                if (parts.length != 9) throw new IOException("Each row must have 9 values");
                for (int c = 0; c < 9; c++) {
                    board[r][c] = Integer.parseInt(parts[c]);
                }
            }
        }

        public int get(int r, int c) {
            return board[r][c];
        }
    }


