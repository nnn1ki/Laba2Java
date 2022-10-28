public class Text {
    private String text;
    private String[] words;
    private String[] marks;
    private int totalWords = 0;

    String symbol = ".,!?";


    /*TODO
    *
    * переписать методы под массивы, это будет проще
    * сделать уже 3ю лабу, потому что горят сроки
    * метод для сборки из потрахов
    *
    * выводит нул, потому что я передаю ссылку, после выхода, сыллка ссылается в никуда
    * проверять в массиве через eqwels либо через ==*/



    public Text(String ln){ //конструктор
        text = ln;
        serchWords(); //количество слов в стороке

        words = new String[totalWords];
        marks = new String[totalWords];

        makeWordsFromText();
        show(); //должно вывести массив слов
    }

    private void serchWords(){
        for (int i = 0; i < text.length(); i++){
            for(int j = 0; j < symbol.length(); j++){
                if (text.charAt(i) == symbol.charAt(j)){
                    totalWords++;
                }
            }
        }
    }

    private void makeWordsFromText(){
        int components = 0;
        String oneWord = ""; //сохраняем сюда слово

        for(int i = 0; i < text.length(); i++){

//            for(int m = 0; m < symbol.length(); m++){
//                if (text.charAt(m) == symbol.charAt(m)){
//                    marks[i] += text.charAt(i);
//                }
//            }


            if(text.charAt(i) != ' ' || text.charAt(i) != ','){ // пока это не конец, сохраняем
                oneWord += text.charAt(i);
            }
            else {
                words[components++] = oneWord;
                //components++;
                oneWord = "";
            }
        }
    }

    private void show(){
        for(int i = 0; i < words.length; i++){
            System.out.println(words[i]);
        }
    }




    public int numberSentences(){
        int numderOfSentences = 0;
        String signsEnd = ".;!?";

        for (int i = 0; i < text.length(); i++){
            for (int s = 0; s < signsEnd.length(); s++){
                if (text.charAt(i) == signsEnd.charAt(s)){
                    numderOfSentences++;
                }
            }
        }
        return numderOfSentences;
    }


    public String popularWord(){
        int popularInt = 0;
        String popularStr = "";

        for(int i = 0; i < text.length(); i++){ //идем по символам

            int totalSimilar = 0;
            String firstWord = findONEWord(text, i);

            for (int j = i + firstWord.length(); j < text.length(); j++){
                if(firstWord == findONEWord(text, j)) {
                    totalSimilar++;
                }
            }

            if (totalSimilar > popularInt){
                popularInt = totalSimilar;
                popularStr = firstWord;
            }
        }
        return popularStr;
    }


    public String vowelOrConsonant(){
        String vowelLetter = "уеэоаыяи"; //гласные
        int vowInt = 0;
        int conInt = 0;


        for (int i = 0; i < text.length(); ){
            for (int v = 0; v < vowelLetter.length(); v++) {
                if (findONEWord(text, i).charAt(0) == vowelLetter.charAt(v)){
                    vowInt++;
                }
                else conInt++;
            }
        }
        String ans = vowInt + " " + conInt;

        return ans;
    }


    public String findONEWord(String line, int startIndex){
        String word = "";

        for (int i = startIndex; i < line.length(); i++){
            if (line.charAt(i) != ' ' || line.charAt(i) != ','){ //если это не пробел, то это все еще слово
                word += line.charAt(i);
            }
            else break;
        }

        return word;
    }

}
