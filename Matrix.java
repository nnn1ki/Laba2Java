public class Matrix {

    private int len;
    private int[] mass;

    public Matrix(int[] userMatr){
        len = userMatr.length;
        mass = userMatr;
    }

    public String deleteSimilar(){
        String ansStr = "";

        if (len == 0 || len == 1) {
            ansStr += mass[len];
            return ansStr;
        }

        for(int i = 0; i < len; i ++){
            boolean inMass = false;

            for(int j = i + 1; j < len; j++){
                if (mass[i] == mass[j]){
                    inMass = true;
                    break;
                }
            }

            if (inMass == false){
                ansStr += mass[i] + ' ';
            }

        }

        return ansStr;
   }
}
