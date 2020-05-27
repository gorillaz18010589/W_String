package com.example.string;
//跳過getByte(),intern(),matches(String regex),	regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len),regionMatches(int toffset, String other, int ooffset, int len)
//想要明白hashCode的作用，你必須要先知道Java中的集合。總的來說，Java中的集合（Collection）有兩類，一類是List，再有一類是Set。你知道它們的區別嗎？前者集合內的元
//        素是有序的，元素可以重複；後者元素無序，但元素不可重複。那麼這裡就有一個比較嚴重 的問題了：要想保證元素不重複，可兩個元素是否重複應該依據什麼來判斷呢？這就是
//        Object.equals方法了。但是，如果每增加一個元素就檢查一次，那麼當元素很多時，後添加到 集合中的元素比較的次數就非常多了。也就是說，如果集合中現在已經有1000個元素，那麼 第1001個元素加入集合時，它就要調用1000次equals方法。這顯然會大大降低效率。於是，Java採用了哈希表的原理。
//        哈希（Hash）實際上是個人名，由於他提出一哈希算法的概念，所以就以他的名字命名了。哈希算法也稱為散列算法，是將數據依特定算法直接指定到一個地址上。如果詳細講解哈希 算法，那需要更多的文章篇幅，我在這裡就不介紹了。初學者可以這樣理解，hashCode方法
//        它應該放置的物理位置上。如果這個位置上沒有元素，它就可以直接存儲在這個位置上，不 用再進行任何比較了；如果這個位置上已經有元素了，就調用它的equals方法與新元素進行比
//        較，相同的話就不存了，不相同就散列其它的地址。所以這裡存在一個衝突解決的問題。這 樣一來實際調用equals方法的次數就大大降低了，幾乎只需要一兩次。所以，Java對於eqauls
//        方法和hashCode方法是這樣規定的：1、如果兩個對象相同，那麼它們的hashCode值一定要相 同；2、如果兩個對象的hashCode相同，它們並不一定相同上面說的對象相同指的是用eqauls
//        方法比較。 你當然可以不按要求去做了，但你會發現，相同的對象可以出現在Set集合中。同 時，增加新元素的效率會大大下降。
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

//charAt(int index):抓取指定字串位置的質(質的位置)(回傳值native char)
public class MainActivity extends AppCompatActivity {
    String data = "jasonkidd";
    String str1 = "kidd";
    String str2 = "leb";
    String str3 = "jasonkidd";
    String str4 = "kidd";
    String str5 = "leb";
    String str6 = "jasOnkidd";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //    String data = "jasonkidd";
    public void StringVoid(View view) {
        //charAt(int index):取出指定字串位置的質(質的位置)(回傳值native char)
        char charAt = data.charAt(1);
        showLog("charAt:" + charAt); // charAt:a

        //codePointAt(int index):取出指定位置字串的Unicode代碼(回傳int)
        int codePointAt = data.codePointAt(1);
        showLog("codePointAt:" + codePointAt); //codePointAt:97

        //codePointBefore(int index):取出你指定的字元在前面一位的Char(指定位置)(回傳int)
        int codePointBefore = data.codePointBefore(1);
        showLog("codePointBefore:" + codePointBefore); //codePointBefore:106 ,因為取得a的前一位置,所以是j,j的char就是106

        //codePointCount(int beginIndex, int endIndex):取得Unicode代碼指定範圍的長度(1.起始位置,2.結束位置)(回傳int)
        int codePointCount = data.codePointCount(0, 8);
        showLog("codePointCount:" + codePointCount); //codePointCount:8

        //compareTo(String anotherString):(回傳native int):把這個字串跟參數字串比較ASCI(要比較ASCI瑪的字串),如果一樣回傳0,如果此字串小於參數字串的話,回傳小於0的質,反之
        int a = data.compareTo(str1);
        int b = data.compareTo(str2);
        int c = data.compareTo(str3);
        showLog("kidd:" + a + "/leb:" + b + "/jasonkidd:" + c);//kidd:-1/leb:-2/jasonkidd:0

        //compareToIgnoreCase(String str):(不管大小寫)把這個字串跟參數字串比較ASCI,如果一樣回傳0(回傳int,0代表一樣,-數:代表字串的ASCI小於參數,反之)
        int d = data.compareToIgnoreCase(str4);
        int e = data.compareToIgnoreCase(str5);
        int f = data.compareToIgnoreCase(str6);
        showLog("kidd:" + a + "/leb:" + b + "/jasOnkidd:" + c);//kidd:-1/leb:-2/jasonkidd:0 ,這邊的JsOnKidd有大小寫區別但用這招不管大小寫

        //concat(String str):將參數字串接到此字串的後面(要接在後面的字串)(回傳native String)
        String google = "古歌:";
        String url = "www.google.com";
        String concat = google.concat(url);
        showLog("concat:" + concat); //concat:古歌:www.google.com


        //contains(CharSequence s):判斷此字串是否包某一個字串(要查詢是否有包含的字串)(回傳boolean)
        String aa = "Imagination is more important than knowledge.";
        String bb = "He who has hope has everything.";
        String cc = "台上一分鐘，台下十年功。";
        showLog("containsaa:" + aa.contains("is")); //containsaa:true
        showLog("containsbb:" + bb.contains("H"));  //containsbb:true
        showLog("containscc:" + cc.contains("火")); //containsbb:false


        //contentEquals(StringBuffer sb):判斷此字串是否與指定的參數StringBuffer一模一樣,("要比較是否一樣的字串Buffer")(回傳true一樣/false不一樣)
        String str1 = "String1";
        String str2 = "String2";
        StringBuffer str3 = new StringBuffer("String1");
        showLog("contentEquals:" + str1.contentEquals(str3));//String1:true
        showLog("contentEquals:" + str2.contentEquals(str3));//String2:false


        //copyValueOf(指定 data[]):將指定的字元陣列組複製貼上取代原本的字串(要複製的字元陣列)(回傳static String)
        char[] str4 = {'h', 'e', 'l', 'l', 'o', ' ', 'r', 'u', 'n', 'o', 'o', 'b'};
        String str5 = "eddwe";
        String copyValueOf = str5.copyValueOf(str4);
        showLog("copyValueOf:" + copyValueOf); //copyValueOf:hello runoob

        //copyValueOf((可指定偏移量,跟要複製的字數)將指定的字元陣列組,複製並貼上取代(回傳String)
        // char data[],//1.要複製的資料
        // int offset, //2.偏移量
        // int count): //3.要複製字元的個數
        String copyValueOfOffset = str5.copyValueOf(
                str4, //1.要複製的資料
                2, //2.偏移量
                6); //3.要複製字元的個數
        showLog("copyValueOfOffset:" + copyValueOfOffset); //copyValueOfOffset:llo ru ,補充:空字串也算一個數量


        //endsWith(String suffix):字串的結尾是否跟指定字串一樣(回傳boolean)
        String str6 = "www.yahoo.com.tw";
        boolean tw = str6.endsWith("tw");
        boolean aw = str6.endsWith("aw");
        showLog("ecndsWith=>tw結尾的話:" + tw);//ecndsWith=>tw結尾的話:true
        showLog("ecndsWith=>aw結尾的話:" + aw);//ecndsWith=>aw結尾的話:false


        //equals(Object anObject):字串與參數字串是否一樣(有大小寫區分)(要比較相等的字串,物件都可)(回傳boolean)
        String str7 = "hank";
        String str8 = "Hank";
        showLog("equals:" + str7.equals(str8));//equals:false


        //equalsIgnoreCase(String anotherString):字串與參數字串是否一樣(大小寫不管英文字相符即可)(要比較相等的字串)(回傳boolean)
        showLog("equalsIgnoreCase:" + str7.equalsIgnoreCase(str8));//equalsIgnoreCase:true

        //format(String format, Object... args):格式化取代字串(1.要取代的String + 轉換符號%s等,2.被取代的String)(回傳String)
        String format = String.format("溫", str7);
        showLog("format:" + format);//format:溫

        String str = null;
        String formatS = String.format("Hi,%s", "王力");//formatS:Hi,王力 ,%s => String
        showLog("formatS:" + formatS);

        String formatThreeS = String.format("桃園三結義:%s,%s,%s", "劉備", "關羽", "張飛");//桃園三結義:劉備,關羽,張飛
        showLog("formatThreeS:" + formatThreeS);

        String formatB = String.format("3<7的結果是: %b %n", 3 < 7);//3<7的結果是: true, %b:判斷是否正確 , %n:換行
        showLog("formatB:" + formatB);

        String fomatC = String.format("字母a的大寫是: %c", 'A'); //字母a的大寫是: A, %c:字元 'm'
        showLog("fomatC:" + fomatC);

        String fomatD = String.format("100的一半是: %d", 100 / 2); //fomatD:100的一半是: 50 , %d
        showLog("fomatD:" + fomatD);

        String fomatN = String.format("100的16進位數是:%x", 100);//fomatN:100的16進位數是:64
        showLog("fomatN:" + fomatN);

        String fomatO = String.format("100的8進位數是:%o", 100);//fomatO:100的8進位數是:144
        showLog("fomatO:" + fomatO);

//        System.out.printf("50元的书打8.5折扣是：%f 元%n", 50*0.85);：42.500000 元
//        System.out.printf("上面价格的16进制数是：%a %n", 50*0.85);0x1.54p5
//        System.out.printf("上面价格的指数表示：%e %n", 50*0.85);4.250000e+01
//        System.out.printf("上面价格的指数和浮点数结果的长度较短的是：%g %n", 50*0.85);42.5000
//        System.out.printf("上面的折扣是%d%% %n", 85);85%
//        System.out.printf("字母A的散列码是：%h %n", 'A');41

        //hashCode()用於比較set的重複元素,比equasl更快(回傳int)
        String str9 = "www.runoob.com";
        int hashCode = str9.hashCode();
        showLog("hashCode:" + hashCode); //hashCode:321005537

        //indexOf(String str):找指定字元在第幾個位置,會報第一個相符合的位置(要找尋的字元)(傳回int,-1:代表不到 ,從0開始算起4代表在字串裡的第5個位置)
        String str10 = "aaa456ac";
        int indexOfStr = str10.indexOf("5");//indexOfStr:4 //從0開始算起4代表在字串裡的第5個位置
        showLog("indexOfStr:" + indexOfStr);

        //indexOf(//可以設定從第幾個位置後開始找指定字元(回傳int從0開始包含自己的位置)
        // String str,//1.要找尋的字元
        // int fromIndex //2.從第幾個位置開始找
        // ):
        int indexOfTwo =  str10.indexOf(
                "6",//1.要找尋的字元
                3//2.從第幾個位置開始找
        );
        showLog("indexOfTwo:" + indexOfTwo);//indexOfTwo:5 => 從0123第四個位置開始找起,找的字元是6,6的位置在0,1,2,3,4,5的第包含當前位置的5

        //int indexOf(int ch):找尋指定的unicode位置(Unicode編碼)(回傳int被找到的位置)
        int indexOfInt = str10.indexOf(99);
        showLog("indexOfInt:" + indexOfInt);//indexOfInt:7 => c的Unicdoe是99,c在地7個位置

        // indexOf(//(回傳找到的字元int位置)可以設定從第幾個位置後開始找指定字元
        // int ch, //1.要找的字元
        // int fromIndex //2.從第幾個位置開始找
        // ):
        int indexOfIntTwo = str10.indexOf(97, 3);
        showLog("indexOfIntTwo:" + indexOfIntTwo); //indexOfIntTwo:6 從第四個位置開始找97,97是a,a的位置在地7個所以是6


        //isEmpty():判斷值是否存在,必須要有記憶體位置的才能判斷,如果是null值會抱錯(回傳boolean)
        String j = ""; //印出來是空的,就等於 ""的意思
        String k = new String(); //印出來是空的,就等於 ""的意思
        String l = null; //null沒有記憶體位置,所以無會抱錯
        showLog("空值為:" + j);//空值為:
        showLog("new String():" + k);//new String():
        showLog("null:" + l);//null抱錯
        showLog("j:" + j.isEmpty());
//        textIsEmpty(j); // isEmpty == ""
//        textIsEmpty(k);   // isEmpty == ""
//          textIsEmpty(l); //null抱錯,因為沒有記憶體位置,無法判斷



        //join( //可以在字串的間隔中加入String,適用於一堆文字要加符號之類的 (回傳String)
        // CharSequence delimiter,//1.間隔要加入的字串
        // Iterable<? extends CharSequence> elements //要被加入的String資料結構
        //)
        String text ="=>:";
        List<String> list = new ArrayList<>();
        list.add("紅髮");
        list.add("魯夫");
        list.add("喬八");
        showLog("list:" + list);//list:[紅髮, 魯夫, 喬八]
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            String joinStr = String.join(text, list);//joinStr:紅髮=>:魯夫=>:喬八
            showLog("joinStr:" + joinStr);
        }


        //static.String.join(//可以在字串的間隔中加入String,適用於一堆文字要加符號之類的
        // CharSequence delimiter,
        // CharSequence... elements
        // ):
        String date = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            date = String.join(
                    "/", //1.間隔要加入的字串
                    "1990","04","05" //要被加入的字串
            );
            showLog("date:" +date);
        }


        String Str = "菜鸟教程:www.runoob.com";
        String SubStr1 = "runoob";
        String SubStr2 = "com";
        //lastIndexOf(int ch):找尋指定字元最後出現的位置(要找尋的字元)(回傳int位置)
        showLog(("查找字符 o 最后出现的位置 :" +Str.lastIndexOf( 'o' )));//查找字符 o 最后出现的位置 :17

        //lastIndexOf(int ch, int fromIndex):回傳formindex之前最後一個指定的字原位置(1.要查詢的字元,2.從哪個位置前開始找起第一個字元)(回傳int位置)
        showLog(("从第14个位置之前查找字符 o 最后出现的位置 :" +Str.lastIndexOf( 'o',14 )));//从第14个位置之前查找字符 o 最后出现的位置 :13

        //lastIndexOf(String str)//回傳最後一個子字串 str 開始的的索引值位置
        showLog("回傳最後一個子字串 str 開始的的索引值:" + Str.lastIndexOf("教程"));//回傳最後一個子字串 str 開始的的索引值位置:2

        //length():計算字串內的字元個數(回傳個數int)
        String az = "台上一分鐘，台下十年功。"; //12個字
        int lenth = az.length();
        showLog("lenth:" + lenth);



        //offsetByCodePoints(int index, int codePointOffset):可以設定index跟偏移量取得指定位置的index(1.要開始的index,2.偏移量)(回傳int總和的位置)
        String strd = "aacdefaa";
        showLog("string = " + strd);//string = aacdefaa
        int retval = strd.offsetByCodePoints(2, 4); //index = 6
        showLog("index = " + retval);


        //replace(CharSequence target, CharSequence replacement) 更改字串char,CharSequence(1.要被更改的目標,2要替代的內容)(回傳String)
        String name ="JasonKidd";
        String replace = name.replace("Kidd","Terry");//JasonKidd => JasonTerry
        showLog("replace:" + replace);

        //replaceAll(String regex, String replacement):可以用正規表示法替代指定字串(1.用正規表示法替代的目標,2.替代後的字串)(回傳String)
        String yy = "BBBBBBYYYYYY";
        String replaceRegx =  yy.replaceAll("\\D","*"); //BBBBBBYYYYYY => ************
        showLog("replaceAllRegx:" + replaceRegx);


        //split(String regex):將原有的字串利用regex拆開(*String正規表示法)(回傳到String陣列)
        String aaaaa = "IOException";
        String[] strs = aaaaa.split("Exce"); //切割了Exce

        showLog(""+ strs.toString());
        for(String msg: strs){
            showLog("msg:" + msg); //msg:IO msg:ption
        }




    }

    private void textIsEmpty(String str){
        if(str == null){
            showLog("null:時報錯");
        }
        if(str.isEmpty()){
            showLog("isEmpty");
        }
        if(str.equals("")){
            showLog("\"\"");
        }
    }

    private void showLog(String msg) {
        Log.v("hank", msg.toString());
    }

}
