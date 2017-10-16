package PolyProject;

public class Poly {
	
	private int order;
	
	private double[] coeff;
	
	public Poly(){
		order = 0;
		coeff = null;
	}
	
	public Poly(int o){
		order = o;
		coeff = new double[o + 1];
	}
	
	public Poly(int o, double[] c){
		order = o;
		coeff = new double[o + 1];
		for(int i = 0; i <= o; i++){
			coeff[i] = c[i];
		}
	}
	
	/**
	 * evaluate polynomial at x = x
	 * @param x
	 * @return
	 */
	public double Eval(double x){
		double sum = 0.0;
		for(int i = 0; i <= order; i++){
			sum = sum * x + coeff[i]; 
		}
		return sum;
	}
	
	/**
	 * evaluates the first differential of polynomial at x = x
	 * @param x
	 * @return
	 */
	public double FDashn(double x){
		double h = 1.0e-2;
		double d1, d2;
		d1 = Eval(x + h);
		d2 = Eval(x - h);
		
		return (d1 - d2)/(2 * h);
	}
	
	/**
	 * evaluates the integral from a to b of the polynomial
	 * @param a
	 * @param b
	 * @return
	 */
	public double IntegNt(double a, double b){
		int n = 200;
		double h = (b - a)/n;
		double t = Eval(a) + Eval(b);
		double sum = 0;
		for(int i = 1; i < n; i++){
			sum += Eval(a + i * h);
		}
		return (h/2)*(t+2*sum);
	}
	
	/**
	 * sets the coefficiant's in the polynomial to the values
	 * in the array
	 * @param c
	 */
	public void SetCoeff(double[] c){
		if(c.length == order + 1){
			coeff = new double[order + 1];
			for(int i = 0; i <= order; i++){
				coeff[i] = c[i];
			}
		}
		else{
			System.out.println("error: new number of coefficiants doesn't equal origional");
		}
	}
	
	/**
	 * sets the coefficiant of the specific place to the given
	 * double. place starts at 1 from the lowest order coeff.
	 * ex: for poly of order 3 if you set place as 1 you will replace 
	 * the coeff in front of x^0 and if place = 3 then replaces coeff in 
	 * front of x^2
	 * @param place
	 * @param c
	 */
	public void SetCoeff(int place, double c){
		if(place - 1 > order){
			System.out.println("error: place is outside the array");
		}
		coeff[place - 1] = c;
	}
	
	/**
	 * returns the coeff of the given place. place starts at 1 from the 
	 * lowest order coeff.
	 * ex: for poly of order 3 if you set place as 1 you will replace 
	 * the coeff in front of x^0 and if place = 3 then replaces coeff in 
	 * front of x^2
	 * @param place
	 * @return
	 */
	public double GetCoeff(int place){
		if(place - 1 > order){
			return -1;
		}
		return coeff[place - 1];
	}
	
	/**
	 * returns array holding all coeff in order from highest order
	 * to lowest.
	 * @return
	 */
	public double[] GetCoeff(){
		return coeff;
	}
	
	/**
	 * prints the polynomial to screen
	 */
	public void PrintPoly(){
		String ans = "";
		int o = order;
		for(int i = order; i >= 0; i--){
			switch (o){
				case 0:{
					ans += coeff[i] + " ";
					break;
				}
				case 1:{
					ans += coeff[i] + "x + ";
					break;
				}
				default:{
					ans += coeff[i] + "x^" + o + " + ";
					break;
				}
			}
			o--;
		}
		System.out.println(ans);
	}
	
	/**
	 * evaluate the second derivative at x
	 * @param x
	 * @return
	 */
	public double Fdashdash(double x){
		double d1, d2;
		double h = 1.0e-2;
		d1 = Eval(x + h);
		d2 = Eval(x - h);
		
		return (d1 - (2*Eval(x)) + d2)/(h*h);
	}
	
	/**
	 * symbolical first derivative
	 */
	public void SymFdash(){
		String ans = "";
		int o = order;
		double Ncoeff;
		for(int i = order; i >= 0; i--){
			Ncoeff = coeff[i] * o;
			switch (o){
			case 0:{
				break;
			}
			case 1:{
				ans += Ncoeff + " ";
				break;
			}
			case 2:{
				ans += Ncoeff + "x + ";
				break;
			}
			default:{
				ans += Ncoeff + "x^" + (o - 1) + " + ";
				break;
			}
			}
			o--;
		}
		System.out.println(ans);
	} 
	
	/**
	 * symbolical integral
	 */
	public void SymInt(){
		double[] Npoly = new double[order + 2];
		double Ncoeff;
		int o = order;
		for(int i = order; i >= 0; i--){
			Ncoeff = coeff[i] / (o + 1.0);
			Npoly[i + 1] = Ncoeff;
			o--;
		}
		Poly n = new Poly(order + 1, Npoly);
		n.PrintPoly();
	}
	
	/**
	 * determine the real root of the polynomial
	 */
	public void RealRoot(){
		
	}
	
	/**
	 * adds this poly to poly b
	 * @param b
	 * @return
	 */
	public Poly Add(Poly b){
		Poly sum;
		double[] sumC;
		if(coeff.length < b.coeff.length){
			sumC = new double[b.order + 1];
			for(int i = 0; i <= order; i++){
				sumC[i] = coeff[i] + b.coeff[i];
			}
			for(int i = order + 1; i <= b.order; i++){
				sumC[i] = b.coeff[i];
			}
			sum = new Poly(b.order, sumC);
		}
		else{
			sumC = new double[order + 1];
			for(int i = 0; i <= b.order; i++){
				sumC[i] = coeff[i] + b.coeff[i];
			}
			for(int i = b.order + 1; i <= order; i++){
				sumC[i] = coeff[i];
			}
			sum = new Poly(order, sumC);
		}
		return sum;
	}
	
	/**
	 * Subtracts poly b from this poly
	 * @param b
	 * @return
	 */
	public Poly Sub(Poly b){
		Poly diff;
		double[] diffC;
		if(coeff.length < b.coeff.length){
			diffC = new double[b.order + 1];
			for(int i = 0; i <= order; i++){
				diffC[i] = coeff[i] - b.coeff[i];
			}
			for(int i = order + 1; i <= b.order; i++){
				diffC[i] = - b.coeff[i];
			}
			diff = new Poly(b.order, diffC);
		}
		else{
			diffC = new double[order + 1];
			for(int i = 0; i <= b.order; i++){
				diffC[i] = coeff[i] - b.coeff[i];
			}
			for(int i = b.order + 1; i <= order; i++){
				diffC[i] = coeff[i];
			}
			diff = new Poly(order, diffC);
		}
		return diff;
	}
	
	/**
	 * multiplies this poly and poly b
	 * @param b
	 * @return
	 */
	public Poly mult(Poly b){
		
		return null;
	}

}
