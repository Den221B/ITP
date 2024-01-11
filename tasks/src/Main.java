import java.sql.Array;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static double convert(int gallons) {
        return gallons * 3.785;
    }
    public static int fitCalc(int k, int h){
        return k*h;
    }
    public static int containers(int k, int m, int b){
        return k*20 + m*50 + b*100;
    }
    public static String TriangleType(int a, int b, int c){
        int[] arr={a,b, c};
        Arrays.parallelSort(arr);
        if (arr[2]>=(arr[0]+arr[1])) {
            return "Not a triangle";
        } else if (a==b && b==c){
                return "Isosceles";
        } else if (arr[0]==arr[1] || arr[1]==arr[2]) {
                return "Equilateral";
        } else {
            return "different-sided";
        }
    }
    public static int ternaryEvaluation(int b, int c){
        return b>c?b:c;
    }
    public static int howManyItems(int n, double w, double h){
        double s=n;
        int count=0;
        while (s > w*h*2) {
            count += 1;
            s -= w * h * 2;
        }
        return count;
    }
    public static int factorial(int a){
        int rez=1;
        while (a>1){
            rez*=a;
            a-=1;
        }
        return rez;
    }
    public static int gcd(int a, int b){
        int rez=1;
        for (int m=a<b?a:b; m>0; m--){
            if (a%m==0 && b%m==0){
                rez=m;
                break;
                //return m; ?
            }
        }
        return rez;
    }
    public static double ticketSaler(int a, int b){
        double tax = 0.28;
        return a*b*(1-tax);
    }
    public static int tables(int s, int t){
        int counter=0;
        while (s>=t*2){
            counter+=1;
            s-=2;
        }
        return counter;
    }
    public static boolean duplicateChars(String s){
        boolean Dupl=false;
        s=s.toLowerCase(Locale.ROOT);
        char[] chars = s.toCharArray();
        for (int i = 0; i<chars.length;i++){
            char ch1= chars[i];
            for (int j = i+1; j<chars.length; j++){
                if(ch1==chars[j]){
                    Dupl=true;
                }
            }
        }
        return Dupl;
    }
    public static String getInitials(String s){
        String[] IN1=s.split(" ");
        return "" + IN1[0].charAt(0) + IN1[1].charAt(0);
    }
    public static int differenceEvenOdd(int[] arr){
        int rez=0;
        for (int i =0;i<arr.length;i++){
            if (arr[i]%2==0) {
                rez+=arr[i];
            }else {
                rez-=arr[i];
            }
        }
        return Math.abs(rez);
    }
    public static boolean equalToAvg(int[] arr){
        boolean diff=false;
        int summ=0;
        for (int i =0;i<arr.length;i++){
            summ+=arr[i];
        }
        if (summ%arr.length!=0){
            return diff;
        }
        int sa=summ/arr.length;
        for (int i =0;i<arr.length;i++){
            if (arr[i]==sa){
                diff=true;
            }
        }
        return diff;
    }
    public static int[]  indexMult(int[] arr){
        for (int i =0;i<arr.length;i++){
            arr[i]*=i;
        }
        return arr;
    }
    public static String reverse(String s){
        String rez="";
        char[] chars = s.toCharArray();
        for (int i = chars.length-1; i>=0; i--){
            rez+=chars[i];
        }
        return rez;
    }
    public static int Tribonacci(int n){
        int t1=0;
        int t2=0;
        int t3=1;
        int res=t3;
        if (n==1){
            return 0;
        }
        if (n==2){
            return 0;
        }
        if (n==3){
            return 1;
        }
        n-=3;
        while (n>0){
            res=t3+t2+t1;
            t1=t2;
            t2=t3;
            t3=res;
            n-=1;
        }
        return res;
    }
    public static String pseudoHash(int n){
        int asciibase = 97;
        String rez="";
        while (n>0){
            int random = (int) Math.round(Math.random()*10);
            if (random%2==0){
                int digit =  (int) Math.round(Math.random()*10);
                rez+=digit;
            } else {
                int a = (int) Math.round(Math.random()*100)%26;
                a+=asciibase;
                rez+=(char) a;
            }
            n--;
        }
        return rez;
    }
    public static String botHelper(String s){
        boolean ans = false;
        String msg1 = "Calling for a staff member";
        String msg2 = "Keep waiting";
        s=s.toLowerCase(Locale.ROOT);
        s=s.replace(","," ");
        s=s.replace("  "," ");
        String[] words = s.split(" ");
        for (int i =0; i<words.length; i++){
            if (words[i].equals("help")){
                ans=true;
            }
        }
        if (ans) {
            return msg1;
        } else {
            return msg2;
        }
    }
    public static boolean isAnagram(String s1, String s2){
        s1=s1.replace(" ", "");
        s2=s2.replace(" ", "");
        char[] chars1= s1.toLowerCase().toCharArray();
        char[] chars2= s2.toLowerCase().toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1,chars2);

    }
    public static String replaceVovels(String s){
        char[] vovel=new char[] {'a','e','y','u','i','o','A','E','Y','U','I','O'};
        for (int i =0; i<=11; i++){
            s=s.replace(""+vovel[i],"*");
        }
        return s;
    }
    public static String stringTransform(String s){
        char[] chars=s.toCharArray();
        String ret="";
        int k=0;
        for (int i = 0; i<chars.length-1;i++){
            if(chars[i]==chars[i+1]){
                ret+="Double"+(""+chars[i]).toUpperCase();
                i++;
            }else {
                ret+=""+chars[i];
            }
            k=i;
        }
        if (k==chars.length){
            ret+="";
        } else {
            ret+=chars[chars.length - 1];
        }
        return ret;
    }
    public static boolean doesBlockkFit(int[] a){
        int[] obj={a[0],a[1],a[2]};
        int[] ho={a[3],a[4]};
        Arrays.parallelSort(obj);
        Arrays.parallelSort(ho);
        return (!(obj[0]>ho[0] || obj[1]>ho[1]));
    }
    public static boolean numCheck(int n){
        String s = "" + n;
        char[] chars = s.toCharArray();
        int m=0;
        for (int i =0; i<chars.length; i++){
            m+=chars[i]*chars[i];
        }
        return n%2==m%2;
    }
    public static int countRoots(int[] a){
        int d = a[1]*a[1]-4*a[0]*a[2];
        int rez=0;
        if (d<0){
            return rez;
        } else if(d==0 && ((-a[1])%(2*a[0])==0) ){
            rez+=1;
        } else {
            if ((-a[1] + Math.sqrt(d)) % (2 * a[0]) == 0) {
                rez += 1;
            }
            if ((-a[1] - Math.sqrt(d)) % (2 * a[0]) == 0) {
                rez += 1;
            }
        }
        return rez;
    }
    public static String[] salesData(String[][] m) {
        int max_col = m[0].length;
        List<String> ans = new ArrayList<>();
        ans.add(m[0][0]);

        for (int i = 1; i < m.length; i++) {
            if (max_col < m[i].length) {
                ans = new ArrayList<>();
                ans.add(m[i][0]);
                max_col = m[i].length;
            } else if (max_col == m[i].length) {
                ans.add(m[i][0]);
            }
        }

        return ans.toArray(new String[ans.size()]);
    }
    public static boolean validSplit(String s){
        String Fc="";
        String Lc="";
        String[] stringsss = s.split(" ");
        for (int i=0; i<stringsss.length-1;i++){
            Fc+=""+stringsss[i].charAt(stringsss[i].length()-1);
        }
        for (int i=1; i<stringsss.length;i++){
            Lc+=""+stringsss[i].charAt(0);
        }
        return Fc.equals(Lc);
    }
    public static boolean waveForm(int[] a){
        boolean rez=true;
        boolean rez_in_w=(a[0]>a[1]);
        for (int i = 1; i<a.length-1; i++){
            if ((a[i]>a[i+1])==rez_in_w){
                rez=false;
                break;
            } else {
                rez_in_w=!rez_in_w;
            }
        }
        return rez;
    }
    public static String commonVovel(String s){
        int[] arrint={0,0,0,0,0,0};
        char[] arrchar={'a','e','y','u','i','o'};
        s=s.toLowerCase();
        char[] chars = s.toCharArray();
        for (int i = 0; i<chars.length ;i++){
            for (int j = 0; j<arrchar.length ; j++){
                if(chars[i]==arrchar[j]){
                    arrint[j]+=1;
                }
            }
        }
        int max=0;
        for (int m = 1; m<arrint.length;m++){
            if (arrint[m]>arrint[max]){
                max=m;
            }
        }
        return ""+arrchar[max];
    }
    public static int[][] dataScience(int[][] m){
        int n=m.length;
        for (int i=0; i<n; i++){
            float count=0;
            for (int j =0;j<n;j++){
                if (i!=j){
                    count+=m[j][i];
                }
            }
            m[i][i]=Math.round(count/(n-1));
        }
        return m;
    }
    public static String nonRepeatable(String str) {
        if (str.isEmpty()) {
            return str;
        }
        char currentChar = str.charAt(0);
        String Rs= str.replaceAll(String.valueOf(currentChar), "");
        return currentChar + nonRepeatable(Rs);
    }
    private static void generBr(int open, int close, String s, List<String> ans) {
        if (open == close && close == 0) {
            ans.add(s);
            return;
        }
        if (open > 0) {
            generBr(open - 1, close, s + "(", ans);
        }
        if (open < close) {
            generBr(open, close - 1, s + ")", ans);
        }
    }
    public static ArrayList<String> generateBrackets(int n) {
        ArrayList<String> ans = new ArrayList<>();
        generBr(n, n, "", ans);
        return ans;
    }
    private static void generateBinary(String prefix, int length, List<String> result) {
        if (prefix.length() == length ) {
            if (!prefix.contains("00"))
                result.add(prefix);
            return;
        }
        generateBinary(prefix + "0", length, result);
        generateBinary(prefix + "1", length, result);
    }
    public static List<String> binarySystem(int n) {
        List<String> result = new ArrayList<>();
        generateBinary("", n, result);
        return result;
    }
    public static String alphabeticRow(String s) {
        char[] chars = s.toCharArray();
        String rez=""+chars[0];
        String trez=rez;
        for (int i=0; i<chars.length-1;i++){
            if ((int) chars[i]-1==(int) chars[i+1]){
                trez+=chars[i+1];
            } else {
                if (trez.length()>rez.length()){
                    rez=trez;
                    trez=""+chars[i+1];
                }
                else{
                    trez=""+chars[i+1];
                }
            }
        }
        if (trez.length()>rez.length()) {
            rez = trez;
            trez = "";
        } else {
            trez=""+chars[0];
        }
        for (int i=0; i<chars.length-1;i++){
            if ((int) chars[i]+1==(int) chars[i+1]){
                trez+=chars[i+1];
            } else {
                if (trez.length()>rez.length()){
                    rez=trez;
                    trez=""+chars[i+1];
                }
                else{
                    trez=""+chars[i+1];
                }
            }
        }
        if (trez.length()>rez.length()){
            rez=trez;
        }
        return rez;
    }
    public static int CountInString(char n, String s){
        int rez=0;
        char[] chars = s.toCharArray();
        for (int i =0; i<chars.length;i++){
            if (n==chars[i]){
                rez+=1;
            }
        }
        return rez;
    }
    public static String Preobraz(String s) {
        char[] chars = s.toCharArray();
        List<String> temps= new ArrayList<>();
        List<Integer> tempi= new ArrayList<>();
        List<Integer> tempis = new ArrayList<>();
        int ite=1;
        for (int i=0;i<s.length()-1;i++){
            if (chars[i]==chars[i+1]){
                ite+=1;
            } else {
                temps.add(""+chars[i]);
                tempi.add(ite);
                tempis.add(ite);
                ite=1;
            }
            if (s.length()-2==i){
                temps.add(""+chars[i]);
                tempi.add(ite);
                tempis.add(ite);
            }
        }
        Collections.sort(tempis);
        String rez="";
        for (int i = 0; i<tempis.size();i++){
            for(int j=0;j<tempi.size();j++){
                if (tempis.get(i)==tempi.get(j)){
                    rez+=""+temps.get(j)+tempi.get(j);
                    temps.remove(j);
                    tempi.remove(j);
                    break;
                }
            }
        }
        return rez;
    }
    private static int convertToNum(String str) {
        int solution = 0;
        String[] array = str.split(" ");
        for (String current : array) {
            switch (current) {
                case("one") -> solution += 1;
                case("two") -> solution += 2;
                case("three") -> solution += 3;
                case("four") -> solution += 4;
                case("five") -> solution += 5;
                case("six") -> solution += 6;
                case("seven") -> solution += 7;
                case("eight") -> solution += 8;
                case("nine") -> solution += 9;
                case("ten") -> solution += 10;
                case("eleven") -> solution += 11;
                case("twelve") -> solution += 12;
                case("thirteen") -> solution += 13;
                case("fourteen") -> solution += 14;
                case("fifteen") -> solution += 15;
                case("sixteen") -> solution += 16;
                case("seventeen") -> solution += 17;
                case("eighteen") -> solution += 18;
                case("nineteen") -> solution += 19;
                case("twenty") -> solution += 20;
                case("thirty") -> solution += 30;
                case("forty") -> solution += 40;
                case("fifty") -> solution += 50;
                case("sixty") -> solution += 60;
                case("seventy") -> solution += 70;
                case("eighty") -> solution += 80;
                case("ninety") -> solution += 90;
                case("hundred") -> solution *= 100;
            }
        }
        return solution;
    }
    private static int shortestWay(int[][] matrix) {
        ArrayList<Integer> solutions = new ArrayList<>();
        shortestWayRecursion(matrix, solutions, 0, 0, 0);
        Collections.sort(solutions);
        return solutions.get(0);
    }

    private static void shortestWayRecursion(int[][] matrix, ArrayList<Integer> solutions, int sum, int firstIndex, int secondIndex) {
        if (firstIndex + secondIndex == matrix.length + matrix[0].length - 1 - 1) {
            solutions.add(sum + matrix[matrix.length - 1][matrix[0].length - 1]);
        }
        else {
            if (firstIndex < matrix.length - 1)
                shortestWayRecursion(matrix, solutions, sum + matrix[firstIndex][secondIndex], firstIndex + 1, secondIndex);
            if (secondIndex < matrix[0].length - 1)
                shortestWayRecursion(matrix, solutions, sum + matrix[firstIndex][secondIndex], firstIndex, secondIndex + 1);
        }
    }
    public static String numericOrder(String s){
        String[] words = s.split(" ");
        String ns="";
        for (int i =0;i<words.length;i++){
            for (int j=0;j<words.length;j++){
                if (words[j].contains(""+(i+1))){
                    ns+=words[j].replace(""+(i+1),"")+" ";
                }
            }
        }
        return ns;
    }
    public static String switchNums(int a, int b){
        String as=""+a;
        String bs=""+b;
        char[] chas = as.toCharArray();
        Arrays.parallelSort(chas);
        char[] reversedChars = new char[as.length()];
        for (int i = 0; i < as.length(); i++) {
            reversedChars[i] = chas[chas.length - 1 - i];
        }
        char[] chbs=bs.toCharArray();
        for (int j=0;j<reversedChars.length;j++){
            for (int i=0;i<bs.length();i++){
                if (reversedChars[j]>chbs[i]){
                    chbs[i]=reversedChars[j];
                    break;
                }
            }
        }
        String rs = new String(chbs);
        return rs;
    }
    public static boolean sameLetterPattern(String str1, String str2){
        if (str1.length() != str2.length()){
            return false;
        }

        for (int i = 0; i < str1.length(); i++){
            if (Character.isLetter(str1.charAt(i)) &&
                    Character.isLetter(str2.charAt(i))) {
                str1 = str1.replaceAll(String.valueOf(str1.charAt(i)),
                        Integer.toString(i));
                str2 = str2.replaceAll(String.valueOf(str2.charAt(i)),
                        Integer.toString(i));
            }
        }

        return str1.equals(str2);
    }
    public static int digitsCount(long i){
        return i/10 != 0 ? 1 + digitsCount(i/10) : 1;
    }
    public static int totalPoints(String[] scramble_worlds, String origin_word) {
        int c = 0;
        for (String word : scramble_worlds) {
            boolean f = true;
            String origin_copy = origin_word;
            for (int i = 0; i < word.length(); i++) {

                if (origin_copy.contains(String.valueOf(word.charAt(i)))) {
                    origin_copy = origin_copy.replace(word.charAt(i), ' ');
                } else {
                    f = false;
                    break;
                }
            }
            if (f) {
                switch (word.length()) {
                    case 3:
                        c += 1;
                        break;
                    case 4:
                        c += 2;
                        break;
                    case 5:
                        c += 3;
                        break;
                    case 6:
                        c += 54;
                }

            }
        }
        return c;
    }
    public static int[][] sumsUp(int[] nums) {
        int[][] result = new int[nums.length][2];
        int indx = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] + nums[j] == 8)  {
                    if (nums[i] > nums[j]) {
                        result[indx][0] = nums[j];
                        result[indx][1] = nums[i];
                    }
                    else {
                        result[indx][0] = nums[i];
                        result[indx][1] = nums[j];
                    }
                    indx += 1;
                }
            }
        }
        int[][] newResult = new int[indx][2];
        System.arraycopy(result, 0, newResult, 0, indx);

        return newResult;
    }
    public static String takeDownAverage(String[] scores) {
        int sum = 0;
        for (String s : scores) {
            String score = s.replace("%", "");
            sum += Integer.parseInt(score);
        }
        int result = (int) Math.round((scores.length + 1) * ((double) sum / scores.length - 5) - sum);
        return String.format("%d%%", result);
    }
    public static int setSetup(int n, int k) {
        int chisl = factorial2(n);
        int znam = factorial2(n - k);
        return chisl / znam;
    }
    public static int factorial2(int n){
        if (n<=1) {
            return 1;
        }
        else{
            return n*factorial2(n-1);
        }

    }
    public static String timeDifference(String cityA, String timestamp, String cityB) {
        HashMap<String, String> greenwich = new HashMap<>();
        greenwich.put("Los Angeles", "America/Los_Angeles");
        greenwich.put("New York", "America/New_York");
        greenwich.put("Caracas", "America/Caracas");
        greenwich.put("Buenos Aires", "America/Argentina/Buenos_Aires");
        greenwich.put("London", "Europe/London");
        greenwich.put("Rome", "Europe/Rome");
        greenwich.put("Moscow", "Europe/Moscow");
        greenwich.put("Tehran", "Asia/Tehran");
        greenwich.put("New Delhi", "Asia/Kolkata");
        greenwich.put("Beijing", "Asia/Shanghai");
        greenwich.put("Canberra", "Australia/Canberra");
        DateTimeFormatter form = DateTimeFormatter.ofPattern("MMMM d, yyyy HH:mm", Locale.UK);
        ZonedDateTime time = ZonedDateTime.parse(timestamp, form.withZone(ZoneId.of(cityA, greenwich)));
        return time.withZoneSameInstant(ZoneId.of(cityB, greenwich)).format(DateTimeFormatter.ofPattern("yyyy-M-d HH:mm"));

    }
    public static boolean isNew(int int_n){
        String n = String.valueOf(int_n);
        for(int i = 1; i < n.length();i++){
            if (n.charAt(i) < n.charAt(0) && n.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }
    public static String caesarCipher(String mode, String word, int n) {
        word = word.toUpperCase();
        StringBuilder result = new StringBuilder();
        char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
                'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        for (int i = 0; i < word.length(); i++) {
            if (Character.isLetter(word.charAt(i))) {
                int index = word.charAt(i) - 'A';
                if (mode.equals("encode")) {
                    index = (index + n) % 26;
                } else {
                    index = (index - n + 26) % 26;
                }
                result.append(letters[index]);
            } else {
                result.append(word.charAt(i));
            }
        }
        return result.toString();
    }
    public static String spiderVsFly(String spider, String fly) {
        if (spider.charAt(0) == fly.charAt(0)){
            StringBuilder path = new StringBuilder();
            int mn = 1;
            int i = Character.getNumericValue(spider.charAt(1));
            if (i > Character.getNumericValue(fly.charAt(1))) {
                mn = -1;
            }
            while (i != Character.getNumericValue(fly.charAt(1))){
                path.append(spider.charAt(0)).append(i).append("-");
                i += mn;
            }
            path.append(spider.charAt(0)).append(fly.charAt(1));
            return path.toString();
        }
        else {
            int min = Character.getNumericValue(spider.charAt(1)) + Character.getNumericValue(fly.charAt(1));
            int radDif = Math.abs(spider.charAt(0) - fly.charAt(0));

            if (radDif > 8 - radDif) {
                radDif = 8 - radDif;
            }
            double way = Math.abs(Character.getNumericValue(spider.charAt(1)) - Character.getNumericValue(fly.charAt(1)));
            int i = Math.abs(Character.getNumericValue(spider.charAt(1)) - (int) way);
            way += radDif * Math.sqrt(i * i * 2 - 2 * i * i * Math.cos(Math.toRadians(45.0)));

            if (min < way) {
                StringBuilder path = new StringBuilder();
                int j = Character.getNumericValue(spider.charAt(1));
                while (j >= 0) {
                    path.append(spider.charAt(0)).append(j).append("-");
                    j--;
                }
                j += 2;
                while (j < Character.getNumericValue(fly.charAt(1))) {
                    path.append(fly.charAt(0)).append(j).append("-");
                    j++;
                }
                path.append(fly.charAt(0)).append(j);
                return path.toString();
            }
            else {
                char x = spider.charAt(0);
                int length = 0;
                while (x != fly.charAt(0)) {
                    if ((char) (x + 1) != 'I') {
                        x++;
                    }
                    else {
                        x = 'A';
                    }
                    length += 1;
                }
                if (length == radDif) {
                    int j = Character.getNumericValue(spider.charAt(1));
                    int mn = 1;
                    if (j > Character.getNumericValue(fly.charAt(1))) {
                        mn = -1;
                    }
                    StringBuilder path = new StringBuilder();
                    while (j != Character.getNumericValue(fly.charAt(1))) {
                        path.append(spider.charAt(0)).append(j).append("-");
                        j += mn;
                    }
                    path.append(spider.charAt(0)).append(j).append("-");
                    x = spider.charAt(0);
                    while (x != fly.charAt(0)) {
                        if ((char) (x + 1) != 'I') {
                            x++;
                        } else {
                            x = 'A';
                        }
                        if (x != fly.charAt(0)) {
                            path.append(x).append(fly.charAt(1)).append("-");
                        }
                        else {
                            path.append(x).append(fly.charAt(1));
                        }
                    }
                    return path.toString();
                }
                else {
                    int j = Character.getNumericValue(spider.charAt(1));
                    int mn = 1;
                    if (j > Character.getNumericValue(fly.charAt(1))) {
                        mn = -1;
                    }
                    StringBuilder path = new StringBuilder();
                    while (j != Character.getNumericValue(fly.charAt(1))) {
                        path.append(spider.charAt(0)).append(j).append("-");
                        j += mn;
                    }
                    path.append(spider.charAt(0)).append(j).append("-");
                    x = spider.charAt(0);
                    while (x != fly.charAt(0)) {
                        if ((char) (x - 1) != '@') {
                            x--;
                        } else {
                            x = 'H';
                        }
                        if (x != fly.charAt(0)) {
                            path.append(x).append(fly.charAt(1)).append("-");
                        }
                        else {
                            path.append(x).append(fly.charAt(1));
                        }
                    }
                    return path.toString();
                }
            }
        }

    }
    public static String Charsssss(String s){
    char[] chars = s.toCharArray();
    String rez="";
    for (int i=0; i<chars.length;i++){
        rez+=""+(char) ((int) chars[i] +1);
    }
    return rez;
    }
    public static String hiddenAnagram(String s1, String s2){
        String rez="Not Found";
        s1=s1.replaceAll("[^a-zA-Zа-яА-Я]","").toLowerCase();
        s2=s2.replaceAll("[^a-zA-Zа-яА-Я]","").toLowerCase();
        char[] chars1=s1.toCharArray();
        char[] chars2=s2.toCharArray();
        Arrays.parallelSort(chars2);
        for (int i1=0; i1 <= (chars1.length - chars2.length); i1++){
            char[] copyedArr = Arrays.copyOfRange(chars1,i1,i1+chars2.length);
            Arrays.parallelSort(copyedArr);
            if (Arrays.equals(copyedArr,chars2)){
                rez=s1.substring(i1,(i1+chars2.length));
                break;
            }
        }
        return rez;
    }
    public static String[] collect(String s, int n){
        int k =s.length()/n;
        String[] rez=new String[k];
        for (int i=0; i<k; i++){
            rez[i]=s.substring(i*n,(i+1)*n);
        }
        return rez;
    }
    public static String nicoCipher(String message, String key) {
        int[] order = new int[key.length()];
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < key.length(); i++) {
            map.put(key.charAt(i), i);
        }
        Character[] keyArr = map.keySet().toArray(new Character[0]);
        Arrays.sort(keyArr);
        for (int i = 0; i < keyArr.length; i++) {
            order[i] = map.get(keyArr[i]);
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < Math.ceil((double) message.length() / key.length()); i++) {
            for (int column : order) {
                int idx = i * key.length() + column;
                if (idx >= message.length()) {
                    result.append(" ");
                    continue;
                }
                result.append(message.charAt(i * key.length() + column));
            }
        }

        return result.toString();
    }
    public static int[] twoProduct(int[] arr, int n) {
//        for (int i=0;i<arr.length/2;i++){
//            int temp=arr[i];
//            arr[i]=arr[arr.length-1-i];
//            arr[arr.length-1-i]=temp;
//        }
        int[] rez = new int[0];
        boolean br=false;
        int[] r2 = new int[2];
        for (int i=0; i<arr.length;i++){
            for (int j=i+1; j<arr.length;j++){
                if (arr[i]*arr[j]==n){
                    r2[0]=arr[i];
                    r2[1]=arr[j];
                    
                    br=true;
                }
            }
        }
        if (br){
            return r2;
        }
        return rez;
    }
    public static int[] isExact(int num) {
        return isExact(num, 2, 1);
    }
    public static int[] isExact(int num, int factor, int cur) {
        cur *= factor;
        if (num == cur) {
            return new int[]{num, factor};
        }
        if (num < cur) {
            return new int[0];
        }

        return isExact(num, factor + 1, cur);
    }
    public static String fractions(String s){
        int chisl =0;
        int znam = 1;
        int i1=0;
        int i2=0;
        String s1="";
        String s2="";
        s=s.replace(".","");
        s=s.replace(")","");
        char[] chars=s.toCharArray();
        boolean br=false;
        for (int i=0; i<chars.length;i++){
            if (br) {
                s2+=chars[i];
                i2+=1;
            }else if (chars[i]=='('){
                br=true;
            } else if (!br) {
                s1+=chars[i];
                i1+=1;
            }
        }
        i1=(int) Math.pow(10,i1-1);
        i2=(int) Math.pow(10,i2) - 1;
        chisl=Integer.parseInt(s2);
        znam=i1*i2;
        chisl+=(Integer.parseInt(s1) * i2);
        int nod = gcd(znam,chisl);
        znam/=nod;
        chisl/=nod;
//                        0.192367=x
//                        0.002367=x-0.19
//                        0.2367=i1(x-s2)
//                        2367.2367=10000(100x-19)
//                        2367=9999(100x-19)
//                        s2/i2*i1=x-19

        return chisl+"/"+znam;
    }
    public static String pilish_string(String s) {
        String rez="";
        if(s==rez){
            return rez;
        }
        String pi="314159265358979";
        int numberpi=0;
        int localnumber=Integer.parseInt(""+pi.charAt(numberpi));
        for (int i=0; i<s.length();i++){
            if (localnumber>0){
                rez+=s.charAt(i);
                localnumber-=1;
            }else if(localnumber==0){
                numberpi+=1;
                if(numberpi == 15){
                    return rez;
                }
                localnumber=Integer.parseInt(""+pi.charAt(numberpi));
                rez+=" ";
            }
        }
        while (localnumber>0){
            rez+=s.charAt(s.length()-1);
            localnumber-=1;
        }
        return rez;
    }

    public static double generateNonconsecutive(String s) {
        try {
            String[] tokens = s.split(" ");
            Stack<Double> numbers = new Stack<>();
            Stack<Character> operations = new Stack<>();

            for (String token : tokens) {
                if (token.matches("-?\\d+(\\.\\d+)?")) {
                    numbers.push(Double.parseDouble(token));
                } else if (token.equals("(")) {
                    operations.push(token.charAt(0));
                } else if (token.equals(")")) {
                    while (operations.peek() != '(') {
                        numbers.push(applyOperation(operations.pop(), numbers.pop(), numbers.pop()));
                    }
                    operations.pop();
                } else if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                    while (!operations.isEmpty() && hasPrecedence(token.charAt(0), operations.peek())) {
                        numbers.push(applyOperation(operations.pop(), numbers.pop(), numbers.pop()));
                    }
                    operations.push(token.charAt(0));
                }
            }

            while(!operations.isEmpty()) {
                numbers.push(applyOperation(operations.pop(), numbers.pop(), numbers.pop()));
            }

            return numbers.pop();
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }
    public static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) return false;
        return true;
    }

    public static double applyOperation(char operation, double b, double a) {
        switch (operation) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) throw new ArithmeticException("Деление на ноль");
                return a / b;
        }
        return 0;
    }
    public static String isValid(String s){
        String rez="NO";
        s.toLowerCase();
        Map<Character, Integer> letterCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            letterCount.put(c, letterCount.getOrDefault(c, 0) + 1);
        }
//        System.out.println(letterCount);
//        System.out.println(letterCount.size()+" "+s.length());
        int min=Integer.MAX_VALUE;
        int max=0;
        for (Map.Entry<Character, Integer> entry : letterCount.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
            }
            if (entry.getValue() < min) {
                min = entry.getValue();
            }
        }
        if ((max-min)>1){
            return rez;
        }
        if (s.length() % letterCount.size()==0){
            rez="Yes";
        }
        if ((s.length()-1) % letterCount.size()==0){
            rez="Yes";
        }
        return rez;
    }
    public static String findLCS(String s1, String s2)
    {
        int[][] arr = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                }
                else {
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        int i = s1.length();
        int j = s2.length();
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                builder.insert(0, s1.charAt(i - 1));
                i--;
                j--;
            } else if (arr[i - 1][j] > arr[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return builder.toString();
    }
    public static void main(String[] args) {
        //1/6
        System.out.println(convert(5));
        System.out.println(convert(3));
        System.out.println(convert(8));
        System.out.println(fitCalc(15,1));
        System.out.println(fitCalc(24,2));
        System.out.println(fitCalc(41,3));
        System.out.println(containers(3,4,2));
        System.out.println(containers(5,0,2));
        System.out.println(containers(4,1,4));
        System.out.println(TriangleType(5,5,5));
        System.out.println(TriangleType(5,4,5));
        System.out.println(TriangleType(3,4,5));
        System.out.println(TriangleType(5,1,1));
        System.out.println(ternaryEvaluation(8,4));
        System.out.println(ternaryEvaluation(1,11));
        System.out.println(ternaryEvaluation(5,9));
        System.out.println(howManyItems(22,1.4, 2));
        System.out.println(howManyItems(45,1.8, 1.9));
        System.out.println(howManyItems(100,2, 2));
        System.out.println(factorial(3));
        System.out.println(factorial(5));
        System.out.println(factorial(7));
        System.out.println(gcd(48,18));
        System.out.println(gcd(52,8));
        System.out.println(gcd(259,28));
        System.out.println(ticketSaler(70,1500));
        System.out.println(ticketSaler(24,950));
        System.out.println(ticketSaler(53,1250));
        System.out.println(tables(5,2));
        System.out.println(tables(31,20));
        System.out.println(tables(123,58));
        //2/6
        System.out.println(duplicateChars("Donald"));
        System.out.println(duplicateChars("orange"));
        System.out.println(getInitials("Ryan Gosling"));
        System.out.println(getInitials("Barack Obama"));
        int[] a1  = {44, 32, 86, 19};
        int[] a2 = {22, 50, 16, 63, 31, 55};
        System.out.println(differenceEvenOdd(a1));
        System.out.println(differenceEvenOdd(a2));
        int[] a3 = {1,2,3,4,5};
        int[] a4 = {1,2,3,4,6};
        System.out.println(equalToAvg(a3));
        System.out.println(equalToAvg(a4));
        int[] a5= {1,2,3};
        int[] a6 = {3, 3, -2, 408, 3, 31};
        System.out.println(Arrays.toString(indexMult(a5)));
        System.out.println(Arrays.toString(indexMult(a6)));
        System.out.println(reverse("Hello World"));
        System.out.println(reverse("The quick brown fox."));
        System.out.println(Tribonacci(7));
        System.out.println(Tribonacci(11));
        System.out.println(pseudoHash(5));
        System.out.println(pseudoHash(10));
        System.out.println(pseudoHash(0));
        System.out.println(botHelper("Hello, I’m under the water, please help me"));
        System.out.println(botHelper("Two pepperoni pizzas please"));
        System.out.println(isAnagram("listen", "silent"));
        System.out.println(isAnagram("eleven plus two", "twelve plus one"));
        System.out.println(isAnagram("hello", "world"));
        //3/6
        System.out.println(replaceVovels("apple"));
        System.out.println(replaceVovels("Even if you did this task not by yourself, you have to understand every single line of code."));
        System.out.println(stringTransform("hello"));
        System.out.println(stringTransform("bookkeeper"));
        System.out.println(stringTransform("booKKKeeper"));
        System.out.println(doesBlockkFit((new int[] {1,3,5,4,5})));
        System.out.println(doesBlockkFit((new int[] {1,8,1,1,1})));
        System.out.println(doesBlockkFit((new int[] {1,2,2,1,1})));
        System.out.println(numCheck(243));
        System.out.println(numCheck(52));
        System.out.println(countRoots(new int[] {1, -3, 2}));
        System.out.println(countRoots(new int[] {2, 5, 2}));
        System.out.println(countRoots(new int[] {1, -6, 9}));
        System.out.println(Arrays.toString(salesData(new String[][] {{"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},{"Banana", "Shop2", "Shop3", "Shop4"},{"Orange", "Shop1", "Shop3", "Shop4"},{"Pear", "Shop2", "Shop4"}})));
        System.out.println(Arrays.toString(salesData(new String[][] {{"Fridge", "Shop2", "Shop3"},{"Microwave", "Shop1", "Shop2", "Shop3", "Shop4"},{"Laptop", "Shop3", "Shop4"},{"Phone", "Shop1", "Shop2", "Shop3", "Shop4"}})));
        System.out.println(validSplit("apple eagle egg goat"));
        System.out.println(validSplit("cat dog goose fish"));
        System.out.println(waveForm(new int[] {3,1,4,2,7,5}));
        System.out.println(waveForm(new int[] {1, 2, 3, 4,5}));
        System.out.println(waveForm(new int[] {1, 2, -6, 10, 3}));
        System.out.println(commonVovel("Hello world"));
        System.out.println(commonVovel("Actions speak louder than words."));
        System.out.println(Arrays.deepToString(dataScience(new int[][] {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {5, 5, 5, 5, 5}, {7, 4, 3, 14, 2}, {1, 0, 11, 10, 1}})));
        System.out.println(Arrays.deepToString(dataScience(new int[][] {{6, 4, 19, 0, 0}, {81, 25, 3, 1, 17}, {48, 12, 60, 32, 14}, {91, 47, 16, 65, 217}, {5, 73, 0, 4, 21}})));
        //4/6
        System.out.println(nonRepeatable("abracadabra"));
        System.out.println(nonRepeatable("paparazzi"));
        System.out.println(generateBrackets(2));
        System.out.println(generateBrackets(3));
        System.out.println(binarySystem(3));
        System.out.println(binarySystem(4));
        System.out.println(alphabeticRow("abcdjuwx"));
        System.out.println(alphabeticRow("klmabzyxw"));
        System.out.println(Preobraz("aaabbcdd"));
        System.out.println(Preobraz("vvvvaajaaaaajj"));
        System.out.println(convertToNum("eight"));
        System.out.println(convertToNum("five hundred sixty seven"));
        System.out.println(convertToNum("thirty one"));
        System.out.println(alphabeticRow("123412324"));
        System.out.println(alphabeticRow("111111"));
        System.out.println(alphabeticRow("77897898"));
        System.out.println(alphabeticRow("12312345"));
        System.out.println(shortestWay(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        }));
        System.out.println(shortestWay(new int[][]{
                {2, 7, 3},
                {1, 4, 8},
                {4, 5, 9}
        }));
        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng"));
        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));
        System.out.println(switchNums(519, 723));
        System.out.println(switchNums(491, 3912));
        System.out.println(switchNums(6274, 71259));
        System.out.println(sameLetterPattern("ABAB", "CDCD"));
        System.out.println(sameLetterPattern("ABCBA", "BCDCB"));
        System.out.println(sameLetterPattern("FFGG", "CDCD"));
        System.out.println(sameLetterPattern("FFFF", "ABCD"));
        System.out.println(digitsCount(4666));
        System.out.println(digitsCount(544));
        System.out.println(digitsCount(121317));
        System.out.println(digitsCount(0));
        System.out.println(digitsCount(12345));
        System.out.println(digitsCount(1289396387328L));
        System.out.println(totalPoints(new String[]{"cat", "create", "sat"}, "caster"));
        System.out.println(totalPoints(new String[]{"trance", "recant"}, "recant"));
        System.out.println(totalPoints(new String[]{"dote", "dotes", "toes", "set", "dot", "dots", "sted"}, "tossed"));
        System.out.println(Arrays.deepToString(sumsUp(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.deepToString(sumsUp(new int[]{1, 2, 3, 7, 9})));
        System.out.println(Arrays.deepToString(sumsUp(new int[]{10, 9, 7, 2, 8})));
        System.out.println(Arrays.deepToString(sumsUp(new int[]{1, 6, 5, 4, 8, 2, 3, 7})));
        System.out.println(takeDownAverage(new String[]{"95%", "83%", "90%", "87%", "88%", "93%"}));
        System.out.println(takeDownAverage(new String[]{"10%"}));
        System.out.println(takeDownAverage(new String[]{"53%", "79%"}));
        System.out.println(setSetup(5, 3));
        System.out.println(setSetup(7, 3));
        System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome"));
        System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing"));
        System.out.println(isNew(3));
        System.out.println(isNew(30));
        System.out.println(isNew(321));
        System.out.println(isNew(123));
        System.out.println(caesarCipher("encode", "hello world", 3));
        System.out.println(caesarCipher("decode", "EPQSWX PEWX XEWO!", 4));
        System.out.println(caesarCipher("encode", "almost last task!", 4));
        System.out.println(spiderVsFly("H3", "E2"));
        System.out.println(spiderVsFly("A4", "B2"));
        System.out.println(spiderVsFly("A4", "C2"));
        System.out.println(Charsssss("hello"));
        System.out.println(hiddenAnagram("My world evolves in a beautiful space called Tesh.", "sworn love lived"));
        System.out.println(hiddenAnagram("An old west action hero actor", "Clint Eastwood"));
        System.out.println(hiddenAnagram("Mr. Mojo Rising could be a song title", "Jim Morrison"));
        System.out.println(hiddenAnagram("Banana? margaritas", "ANAGRAM"));
        System.out.println(hiddenAnagram("D  e b90it->?$ (c)a r...d,,#~", "bad credit"));
        System.out.println(hiddenAnagram("Bright is the moon", "Bongo mirth"));
        System.out.println(Arrays.toString(collect("intercontinentalisationalism", 6)));
        System.out.println(Arrays.toString(collect("strengths", 3)));
        System.out.println(Arrays.toString(collect("pneumonoultramicroscopicsilicovolcanoconiosis", 15)));
        System.out.println(nicoCipher("myworldevolvesinhers", "tesh"));
        System.out.println(nicoCipher("andiloveherso", "tesha"));
        System.out.println(nicoCipher("mubashirhassan", "crazy"));
        System.out.println(nicoCipher("edabitisamazing", "matt"));
        System.out.println(nicoCipher("iloveher", "612345"));
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, 3, 9, 4, 5, 15}, 45)));
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, 3, 9, 4, 15, 3, 5}, 45)));
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, -1, 4, 5, 6, 10, 7}, 20)));
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10)));
        System.out.println(Arrays.toString(twoProduct(new int[]{100, 12, 4, 1, 2}, 15)));
        System.out.println(Arrays.toString(isExact(6)));
        System.out.println(Arrays.toString(isExact(24)));
        System.out.println(Arrays.toString(isExact(125)));
        System.out.println(Arrays.toString(isExact(720)));
        System.out.println(Arrays.toString(isExact(1024)));
        System.out.println(Arrays.toString(isExact(40320)));
        System.out.println(fractions("0.(6)"));
        System.out.println(fractions("1.(1)"));
        System.out.println(fractions("3.(142857)"));
        System.out.println(fractions("0.19(2367)"));
        System.out.println(fractions("0.1097(3)"));
        System.out.println(pilish_string("33314444"));
        System.out.println(pilish_string("TOP"));
        System.out.println(pilish_string("X"));
        System.out.println(generateNonconsecutive("3 + 5 * ( 2 - 6 )"));
        System.out.println(generateNonconsecutive("6 - 18 / ( -1 + 4 )"));
        System.out.println(isValid("aabbcd"));
        System.out.println(isValid("aabbccddeefghi"));
        System.out.println(isValid("abcdefghhgfedecba"));
        System.out.println((findLCS("abcd", "bd")));
        System.out.println((findLCS("aggtab", "gxtxamb")));
    }
}