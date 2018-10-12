public class CastingDemo{
	public static void main(String[] args){    
		Object object1 = new CirclaFromSimpleGeometricObject(1);
		Object object2 = new RectangleFromSimpleGeometricObject(1,1);

		displayObject(object1);
		displayObject(object2);
	}

	public static void displayObject(Object object){
		if(object instanceof CirclaFromSimpleGeometricObject){
			System.out.println("The circle area is :" +  (((CirclaFromSimpleGeometricObject)object).getArea()));
			System.out.println("The cirale diameter is :" +  (((CirclaFromSimpleGeometricObject)object).getDiameter()));

		}
		else if (object instabof RectangleFromSimpleGeometricObject){
			System.out.println("The rectangle area is :" +  (((RectangleFromSimpleGeometricObject)object).getArea()));
			

		}
	}
}