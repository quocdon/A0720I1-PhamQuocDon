package exercises.point;

public class PointProgram {
    public static void main(String[] args) {
        Point2D point2D = new Point2D(5, 2);
        Point3D point3D = new Point3D(point2D.getX(), point2D.getY(), 4);
        float[] arr1, arr2;
        arr1 = point2D.getXY();
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + "\t");
        }
        System.out.println();
        System.out.println(point2D.toString());
        arr2 = point3D.getXYZ();
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + "\t");
        }
        System.out.println();
        System.out.println(point3D.toString());



    }
}
