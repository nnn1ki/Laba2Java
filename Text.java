public class Text {
    private String text;
    private String[] words;

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
        words = text.split("\\W+"); // \\s означает пробел, \\s+ означает несколько пробелов 2. .replaceAll("[^\\w]", ""); и .replaceAll("\\W", ""); Оба они заменят символы, кроме [a-zA-Z0-9_].

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
        String popWord = "";
        int maxCount = 0;

        for(int i = 0; i < words.length; i++){
            int count = 0;

            for(int j = i + 1; j < words.length; j++){
                if (words[i] == words[j]){
                    count++;
                }
            }

            if (maxCount < count){
                maxCount = count;
                popWord = words[i];
            }
        }
        return popWord;
    }


    public void vowelOrConsonant(){
        String vowelLetters = "eyuioa"; //гласные
        int vowInt = 0;
        int conInt = 0;

        for (int i = 0; i < words.length; i++){ // идем по псловам
            for(int j = 0; j < vowelLetters.length(); j++){ // идем по буквам

                Character chA = words[i].charAt(0);
                Character chB = vowelLetters.charAt(j);

                if (chA.compareTo(chB) == 0){
                    vowInt++;
                    break;
                }
                else {
                    conInt++;
                    break;
                }
            }
        }

        System.out.println("Количество слов с согласной = " + conInt + '\n' + "Количество слов с гласной = " + vowInt);
    }


}
