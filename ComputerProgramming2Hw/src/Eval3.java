import java.util.Stack;
import java.util.StringTokenizer;
public class Eval3 {
	
	double result = 0;
	private String num = "";
	private Stack<String> Stack = new Stack<String>();

	public double fullTextParsing(String fullText) {
		StringTokenizer st = new StringTokenizer(fullText, "+-*/", true);

		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			Stack.push(token);
		}

		int i = 1;
		for (i = 1; i < Stack.size(); i = i + 2) {
			switch (Stack.get(i)) {
			case "*":
				result = Double.valueOf(Stack.get(i - 1)) * Double.valueOf(Stack.get(i + 1));
				Stack.add(i - 1, String.valueOf(result));
				Stack.remove(i);
				Stack.remove(i);
				Stack.remove(i);
				i = i - 2;
				break;
			case "/":
				result = Double.valueOf(Stack.get(i - 1)) / Double.valueOf(Stack.get(i + 1));
				Stack.add(i - 1, String.valueOf(result));
				Stack.remove(i);
				Stack.remove(i);
				Stack.remove(i);
				i = i - 2;
				break;
			default:
				break;
			}
		}

		i = 1;
		for (i = 1; i < Stack.size(); i = i + 2) {
			if (i == 1) {
				result = 0; // + - ����� �� ��� ����� �ʱ�ȭ(������ * / �� ���� ��� �ʱ�ȭ���� �ʰ� ������� �״�� �������Ͽ�)
				result = result + Double.valueOf(Stack.get(i - 1));
			}
			switch (Stack.get(i)) {
			case "+":
				result = result + Double.valueOf(Stack.get(i + 1));
				break;
			case "-":
				result = result - Double.valueOf(Stack.get(i + 1));
				break;
			}
		}
		return result;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Eval3();
	}

}
