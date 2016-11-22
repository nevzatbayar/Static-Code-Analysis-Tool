package MissingResource;

import java.io.FileInputStream;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.CompilationUnit;

public class MissingResourceDemo {

	public static void main(String[] args) throws Exception {
		// Parse file
		FileInputStream in = new FileInputStream("C:\\Users\\�mer\\workspace\\Copy of static-analiz\\src\\sca\\fxsd.java");

		CompilationUnit cu = null;
		try {
			// parse the file
			cu = JavaParser.parse(in);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		} finally {
			in.close();
		}
		if (cu != null) {
			MissingResourceVisitor visitor = new MissingResourceVisitor();
			visitor.visitDepthFirst(cu);
			// Table<String, Node, Symbol> st = visitor.st;
			// System.out.print("De�i�ken ismi" + "\t");
			// System.out.print("Tan�mland��� sat�r" + "\t");
			// System.out.print("De�itirildi�i sat�r" + "\t");
			// System.out.print("Kullan�ld�� sat�r" + "\t");
			// System.out.print("De�i�ken tipi" + "\t");
			// System.out.print("ilk de�er" + "\t");
			// System.out.println("De�i�ken t�r�");
			// for (Cell<String, Node, Symbol> cell : st.cellSet()) {
			// // System.out.print(cell.getRowKey()+"\t"+
			// // cell.getValue().getName()+"\t");
			//
			//// if (!(cell.getValue().getInitialize())) {
			//
			// System.out.print(cell.getValue().getName() + "\t");
			// System.out.print(cell.getValue().getDeclaretedline() + "\t");
			// System.out.print(cell.getValue().getChangedline() + "\t");
			// System.out.print(cell.getValue().getReferencedline() + "\t");
			// System.out.print(cell.getValue().getType() + "\t");
			// System.out.print(cell.getValue().getInitialize() + "\t");
			// System.out.print(cell.getValue().getKind());
			// System.out.println(cell.getValue().getVartype());
			//// if (cell.getValue().getName().equals("br")) {
			//// System.out.println(cell.getValue().getParentBlock());
			////// }
			//// }
			// }

			for (String str : MissingResourceHelper.getMessages()) {
				System.out.println(str);
			}
		}
	}
}
