package com;

public class QuadraticEquation {
    private static final int MAX_VALUE = 50;

    private static float calcD(float a, float b, float c){
        return (float) Math.pow(b, 2) - 4 * a * c;
    }

    public static float[] calc(float a, float b, float c){
        float D = calcD(a, b , c);

        float x1;
        float x2 = 0;

        if ( D >= 0){
            if (D == 0) {
                x1 = -b / (2 * a);
            } else {
                x1 = (float) ((-b - Math.sqrt(D)) / (2 * a));
                x2 = (float) ((-b + Math.sqrt(D)) / (2 * a));
            }
            return new float[]{x1, x2};
        }
        return null;
    }

    public static float random(){
        float result = (float) (int) (Math.random() * MAX_VALUE);
        return (int) (Math.random() * 2) == 0 ? -result : result;
    }
}
