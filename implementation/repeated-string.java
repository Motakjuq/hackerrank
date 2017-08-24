// https://www.hackerrank.com/challenges/repeated-string
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
	
	private static void solve(){
        int amount = 0;
        List<Integer> position = new ArrayList<>();
        char c;
        int length = 0;
		for( ; !in.isSpaceChar((c = in.nextChar())) ; length++){
            if(c == 'a'){
                amount++;
                position.add(length+1);
            }
        }
        long letters = 0;
        if(amount != 0){
            long n = in.nextLong();
            if(length < n){
                letters = (n / length) * amount;
            }
            n = (n % length) ;
            for(Integer pos : position) {
                if(n >= pos)
                    letters++;
                else
                    break;
            }
        }
        out.println(letters);
        out.close();
	}

	public static void main(String args[]) {
		solve();
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
