package PolyProject;

public class PolyMain {

	public static void main(String args[]){
		Poly test1 = new Poly(4);
		double[] C2 = {2, 3, 4, 1};
		double[] C1 = {1, 2, 1, 4, 1};
		Poly test2 = new Poly(3, C2);
		
		test1.PrintPoly();
		test1.SetCoeff(2, 2);
		System.out.println("should be 0 + 0 + 0 + 2 + 0");
		test1.PrintPoly();
		test1.SetCoeff(C1);
		System.out.println("should be 1 + 4 + 1 + 2 + 1");
		test1.PrintPoly();
		
		System.out.println("should be 45");
		System.out.println(test1.Eval(2));
		test1.SymFdash();
		System.out.println("should be 8");
		System.out.println(test1.FDashn(1));
		System.out.println("should be 6");
		System.out.println(test1.Fdashdash(1));
		test1.SymInt();
		System.out.println("Should be 2 - 0");
		System.out.println(test1.IntegNt(0, 2));
		
		test1.PrintPoly();
		System.out.println(" + ");
		test2.PrintPoly();
		System.out.println(" = ");
		test1.Add(test2).PrintPoly();;
		
		test1.PrintPoly();
		System.out.println(" - ");
		test2.PrintPoly();
		System.out.println(" = ");
		test1.Sub(test2).PrintPoly();;
	}
	
}
