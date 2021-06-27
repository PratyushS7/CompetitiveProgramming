import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int z = in.nextInt();
		in.nextLine();
		for (int d = 1; d <= z; d++) {
			String[] inp = in.nextLine().trim().split(" ");
			int s = Integer.parseInt(inp[0]);
			int ra = Integer.parseInt(inp[1])-1;
			int pa = Integer.parseInt(inp[2])-1;
			int rb = Integer.parseInt(inp[3])-1;
			int pb = Integer.parseInt(inp[4])-1;
			int c = Integer.parseInt(inp[5]);
			char[][] status = new char[s][2 * s - 1];
			for (int a = 0; a < s; a++) {
				for (int b = 0; b < 2 * s - 1; b++)
					status[a][b] = 'u';
			}
			for (int a = 0; a < c; a++) {
				inp = in.nextLine().trim().split(" ");
				status[Integer.parseInt(inp[0])-1][Integer.parseInt(inp[1])-1] = 'p';
			}
			status[ra][pa] = 'a';
			status[rb][pb] = 'b';
			System.out.println("Case #" + d + ": " + bestScore(status, ra, pa, rb, pb, true));
		}
		in.close();
	}

	private static int bestScore(char[][] curr, int ra, int pa, int rb, int pb, boolean otherMightMove) {
		boolean couldMove = false;
		int best = Integer.MIN_VALUE;
		if (pa > 0 && curr[ra][pa-1] == 'u') {
			curr[ra][pa] = 'p';
			curr[ra][pa-1] = 'a';
			best = Math.max(best, otherMightMove ? worstScore(curr, ra, pa-1, rb, pb, true) : bestScore(curr, ra, pa-1, rb, pb, false));
			curr[ra][pa] = 'a';
			curr[ra][pa-1] = 'u';
			couldMove = true;
		}
		if (pa < 2 * ra && curr[ra][pa+1] == 'u') {
			curr[ra][pa] = 'p';
			curr[ra][pa+1] = 'a';
			best = Math.max(best, otherMightMove ? worstScore(curr, ra, pa+1, rb, pb, true) : bestScore(curr, ra, pa+1, rb, pb, false));
			curr[ra][pa] = 'a';
			curr[ra][pa+1] = 'u';
			couldMove = true;
		}
		if (pa % 2 == 0 && ra < curr.length - 1 && curr[ra+1][pa+1] == 'u') {
			curr[ra][pa] = 'p';
			curr[ra+1][pa+1] = 'a';
			best = Math.max(best, otherMightMove ? worstScore(curr, ra+1, pa+1, rb, pb, true) : bestScore(curr, ra+1, pa+1, rb, pb, false));
			curr[ra][pa] = 'a';
			curr[ra+1][pa+1] = 'u';
			couldMove = true;
		}
		if (pa % 2 == 1 && ra > 0 && curr[ra-1][pa-1] == 'u') {
			curr[ra][pa] = 'p';
			curr[ra-1][pa-1] = 'a';
			best = Math.max(best, otherMightMove ? worstScore(curr, ra-1, pa-1, rb, pb, true) : bestScore(curr, ra-1, pa-1, rb, pb, false));
			curr[ra][pa] = 'a';
			curr[ra-1][pa-1] = 'u';
			couldMove = true;
		}
		if (couldMove)
			return best + 1;
		else if (otherMightMove)
			return worstScore(curr, ra, pa, rb, pb, false);
		else
			return 0;
	}
	
	private static int worstScore(char[][] curr, int ra, int pa, int rb, int pb, boolean otherMightMove) {
		int option = Integer.MAX_VALUE;
		boolean couldMove = false;
		if (pb > 0 && curr[rb][pb-1] == 'u') {
			curr[rb][pb] = 'p';
			curr[rb][pb-1] = 'b';
			option = Math.min(option, otherMightMove ? bestScore(curr, ra, pa, rb, pb-1, true) : worstScore(curr, ra, pa, rb, pb-1, false));
			curr[rb][pb] = 'b';
			curr[rb][pb-1] = 'u';
			couldMove = true;
		}
		if (pb < 2 * rb && curr[rb][pb+1] == 'u') {
			curr[rb][pb] = 'p';
			curr[rb][pb+1] = 'b';
			option = Math.min(option, otherMightMove ? bestScore(curr, ra, pa, rb, pb+1, true) : worstScore(curr, ra, pa, rb, pb+1, false));
			curr[rb][pb] = 'b';
			curr[rb][pb+1] = 'u';
			couldMove = true;
		}
		if (pb % 2 == 0 && rb < curr.length - 1 && curr[rb+1][pb+1] == 'u') {
			curr[rb][pb] = 'p';
			curr[rb+1][pb+1] = 'b';
			option = Math.min(option, otherMightMove ? bestScore(curr, ra, pa, rb+1, pb+1, true) : worstScore(curr, ra, pa, rb+1, pb+1, false));
			curr[rb][pb] = 'b';
			curr[rb+1][pb+1] = 'u';				
			couldMove = true;
		}
		if (pb % 2 == 1 && rb > 0 && curr[rb-1][pb-1] == 'u') {
			curr[rb][pb] = 'p';
			curr[rb-1][pb-1] = 'b';
			option = Math.min(option, otherMightMove ? bestScore(curr, ra, pa, rb-1, pb-1, true) : worstScore(curr, ra, pa, rb-1, pb-1, false));
			curr[rb][pb] = 'b';
			curr[rb-1][pb-1] = 'u';				
			couldMove = true;
		}
		if (couldMove)
			return option - 1;
		else if (otherMightMove)
			return bestScore(curr, ra, pa, rb, pb, false);
		else
			return 0;
	}
}
