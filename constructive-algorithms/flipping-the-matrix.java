// https://www.hackerrank.com/challenges/flipping-the-matrix
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.*;

public class Solution {
	private static OutputWriter out = new OutputWriter(System.out);
	private static InputReader in = new InputReader(System.in);
	
    private static void solveAux(){
        int n = in.nextInt();
        int matrix[][] = new int[2*n][2*n];
        for(int i = 0 ; i < 2*n ; i++){
            for(int j = 0; j < 2*n ; j ++){
                matrix[i][j] = in.nextInt();
            }
        }
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0; j < n ; j ++){
                sum += Math.max(Math.max(matrix[i][j],matrix[2*n-i-1][j]),Math.max(matrix[i][2*n-j-1],matrix[2*n-i-1][2*n-j-1]));
            }
        }
        out.println(sum);
	}
    
	private static void solve(){
        int cases = in.nextInt();
        for(int i = 0 ; i < cases ; i++){
            solveAux();
        }
	}

	public static void main(String args[]) {
		solve();
        out.close();
	}

}

class InputReader {
	private InputStream stream;
	private byte[] buf = new byte[1024];
	private int curChar, numChars;

	public InputReader(InputStream stream) {
		this.stream = stream;
	}

	private int read() {
		if (numChars == -1)
			throw new InputMismatchException();
		if (curChar >= numChars) {
			curChar = 0;
			try {
				numChars = stream.read(buf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (numChars <= 0)
				return -1;
		}
		return buf[curChar++];
	}

	public int nextInt() {
		return (int) nextLong();
	}

	public long nextLong() {
		int c;
		while (isSpaceChar((c = read())));
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		long res = 0;
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
		} while (!isSpaceChar((c = read())));
		return res * sgn;
	}

	public String nextString() {
		int c;
		while (isSpaceChar((c = read())));
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
		} while (!isSpaceChar((c = read())));
		return res.toString();
	}
    
    public char nextChar() {
		int c = read();

		return (char)c;
	}

	public boolean isSpaceChar(int c) {
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}

}

class OutputWriter {
	private PrintWriter writer;

	public OutputWriter(OutputStream outputStream) {
		writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
	}

	public void print(Object... objects) {
		int lenght = objects.length - 1;
		for (int i = 0; i <= lenght; i++) {
			writer.print(objects[i]);
			if (i != lenght)
				writer.print(' ');
		}
	}

	public void println(Object... objects) {
		print(objects);
		writer.println();
	}

	public void close() {
		writer.close();
	}

}
