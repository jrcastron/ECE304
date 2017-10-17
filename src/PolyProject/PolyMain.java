package PolyProject;

public class PolyMain {

	public static void main(String args[]){
		double[] C2 = {2, 3, 4, 1};
		double[] C1 = {6, 11, 6, 2, 1};
		Poly test1 = new Poly(4);
		Poly test2 = new Poly(3, C2);
		
		System.out.println("============ test1 ===============");
		test1.PrintPoly();
		test1.SetCoeff(2, 2);
		System.out.print("Poly 1 after set coeff: ");
		test1.PrintPoly();
		test1.SetCoeff(3, 4);
		System.out.print("Poly 1 after set coeff: ");
		test1.PrintPoly();
		test1.SetCoeff(C1);
		System.out.print("Poly 1: ");
		test1.PrintPoly();
		
		System.out.print("Eval: ");
		System.out.println(test1.Eval(2));
		System.out.print("derivative: ");
		test1.SymFdash();
		System.out.print("integral: ");
		test1.SymInt();
		System.out.print("first derivative: ");
		System.out.println(test1.FDashn(2));
		System.out.print("second derivative:"
				+ " ");
		System.out.println(test1.Fdashdash(2));
		System.out.print("Integral: ");
		System.out.println(test1.IntegNt(0, 8));
		System.out.print("real root: ");
		System.out.println(test1.RealRoot(-4));

		System.out.println("============= test 2 ===========");
		test2.PrintPoly();
		System.out.print("Eval: ");
		System.out.println(test2.Eval(2));
		System.out.print("derivative: ");
		test2.SymFdash();
		System.out.print("integral: ");
		test2.SymInt();
		System.out.print("first derivative: ");
		System.out.println(test2.FDashn(2));
		System.out.print("second derivative:"
				+ " ");
		System.out.println(test2.Fdashdash(2));
		System.out.print("Integral: ");
		System.out.println(test2.IntegNt(0, 8));
		System.out.print("real root: ");
		System.out.println(test2.RealRoot(-2));
		
		
		System.out.println("================ add/sub/mult ===========");
		System.out.println("test1 + test2 = ");
		test1.Add(test2).PrintPoly();
		
		System.out.println("test1 - test2 = ");
		test1.Sub(test2).PrintPoly();
		
		System.out.println("test1 * test2 = ");
		test1.mult(test2).PrintPoly();
		
		System.out.println("test2 + test1 = ");
		test2.Add(test1).PrintPoly();
		
		System.out.println("test2 - test1 = ");
		test2.Sub(test1).PrintPoly();
		
		System.out.println("test2 * test1 = ");
		test2.mult(test1).PrintPoly();
	}
	
}
