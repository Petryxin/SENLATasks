package com.senla.tasks.task3;

import javax.vecmath.Vector2d;
import javax.vecmath.Vector3d;

public class Main {
    /**
     * 1.
     * the cross product is a binary operation on two vectors in a three-dimensional Euclidean space
     * that results in another vector which is perpendicular to the plane containing the two input vectors.
     * But in task we have only 2D, and you can't do a cross product with vectors in 2D space.
     * We can find vector length and dot product of 2 vectors.
     * 2.
     * Another way to use library - Java3D
     */
    //n = 3 because we have 3D space.
    static int n = 3;

    static double getLengthVector(int vect_C[]){
        int x = vect_C[0];
        int y = vect_C[1];
        int z = 0;
        if (vect_C.length == 3){
            z = vect_C[2];
        }
        double length = Math.sqrt(x * x + y * y + z * z);
        return length;
    }

    // dot product of two vector array.
    static int dotProduct(int vect_A[], int vect_B[]) {
        int product = 0;
        for (int i = 0; i < n; i++)
            product = product + vect_A[i] * vect_B[i];
        return product;
    }

    // cross product of two vector array.
    static void crossProduct(int vect_A[], int vect_B[], int cross_P[]){
        cross_P[0] = vect_A[1] * vect_B[2]
                - vect_A[2] * vect_B[1];
        cross_P[1] = vect_A[2] * vect_B[0]
                - vect_A[0] * vect_B[2];
        cross_P[2] = vect_A[0] * vect_B[1]
                - vect_A[1] * vect_B[0];
    }

    public static void main(String[] args)
    {
        int vect_A[] = { 3, -5, 4 };
        int vect_B[] = { 2, 6, 5 };
        int cross_P[] = new int[n];

        Vector2d vector2d = new Vector2d(3,-5 );
        Vector2d vector2d1 = new Vector2d(2,6);

        Vector3d vector3d1 = new Vector3d(3, -5, 4);
        Vector3d vector3d2 = new Vector3d(2, 6, 5);

        System.out.print("Vector length 3d: ");
        System.out.println(getLengthVector(vect_A));

        System.out.print("Vector length 3d (using the library): ");
        System.out.println(vector3d1.length());


        System.out.print("Dot product 3d:");
        System.out.println(dotProduct(vect_A, vect_B));

        System.out.print("Dot product 3d (using the library):");
        System.out.println(vector3d1.dot(vector3d2));

        System.out.print("Dot product 2d (using the library):");
        System.out.println(vector2d.dot(vector2d1));

        System.out.print("Cross product 3d:");
        crossProduct(vect_A, vect_B, cross_P);
        for (int i = 0; i < n; i++){
            System.out.print(cross_P[i] + " ");
        }
        System.out.println("swap vectors A and B ");
        crossProduct(vect_B, vect_A, cross_P);
        for (int i = 0; i < n; i++){
            System.out.print(cross_P[i] + " ");
        }
        System.out.println();

        System.out.print("Cross product 3d (using the library):");
        Vector3d vector3d3 = new Vector3d();
        vector3d3.cross(vector3d1, vector3d2);
        System.out.print(vector3d3.getX() + " " + vector3d3.getY() + " " + vector3d3.getZ());
        System.out.println(" swap vectors A and B ");
        vector3d3.cross(vector3d2, vector3d1);
        System.out.println(vector3d3.getX() + " " + vector3d3.getY() + " " + vector3d3.getZ());
    }
}
