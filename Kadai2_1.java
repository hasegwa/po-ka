package ぽーか;

	import java.util.Scanner;

	/*
	★入力例★　実行して、コンソールウインドウから以下のように入力して動作確認しましょう。（行末でEnterキー）
	0 01
	3 06
	3 10
	3 01
	1 01

	★出力例★　上記のテストデータでは、以下の結果が出たら正解です。
	SA H6 H10 HA CA
	スリーカード
	*/


	public class Kadai2_1 {
	    static String[] SUIT_STRING = {"S", "C", "D", "H"};
	    static String[] NUMBER_STRING = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

	    private int[] suit = new int[5];
	    private int[] number = new int[5];

	    private int[]  suitCount = { 0, 0, 0, 0 };  // スーツごとの枚数
	    private  int[] numberCount = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	    public static void main(String[] args) {
	        new Kadai2_1();
	    }

	    public Kadai2_1() {
	        cardYomu();        // カード情報をコンソールから読み、
	        cardStringKaku();  // カードの絵柄と番号を書いて、
	        hanteiJunbi();     // 役判定のために準備して、
	        yakuhantei();      // 役を判定する。
	    }

	    private void cardYomu() {
	        try {
	            Scanner sc = new Scanner(System.in); // コンソールを入力元として指定
	            for (int i = 0; i < 5; ++i) {  // 5枚のカードを読むよ
	                suit[i] = sc.nextInt();   // スート（スペードが0、クラブが1、…）を読んで代入
	                number[i] = sc.nextInt(); // 番号（01～13）を読んで代入
	            }
	        } catch (Exception e) {
	            System.out.println(e.toString());
	        }
	    }

	    private void hanteiJunbi() {
	        // スーツと数字のそれぞれの個数を数える
	        for (int i = 0; i < 5; ++i) {
	            suitCount[ suit[i] ] += 1; // 同じスーツが何枚あるのか
	            numberCount[ number[i] - 1 ] += 1; // 同じ数字がそれぞれ何枚あるのか
	        }
	        // 他の前準備が必要ならここに書きましょう

	    }

	    private void cardStringKaku() {
	        for (int i = 0; i < 4; ++i) {
	            System.out.print(SUIT_STRING[suit[i]] + NUMBER_STRING[number[i] - 1] + " ");
	        }
	        System.out.println(SUIT_STRING[suit[4]] + NUMBER_STRING[number[4] - 1]);
	    }

	    private void yakuhantei() {
	        // ロイヤル(ストレート)フラッシュ！！！
	        if ((suit[0] == suit[1] && suit[0] == suit[2] && suit[0] == suit[3] && suit[0] == suit[4])
	                && ((number[0] + number[1] + number[2] + number[3] + number[4]) == 47)
	                && (number[0] == 1 || number[1] == 1 || number[2] == 1 || number[3] == 1 || number[4] == 1)) {
	            System.out.println("ロイヤルフラッシュ");
	        }

	        // ストレートフラッシュの判定

	        // フォーカードの判定

	        // フルハウスの判定

	        // フラッシュの判定
	        else if (suitCount[0] == 5 || suitCount[1] == 5 || suitCount[2] == 5 || suitCount[3] == 5) {
	            System.out.println("フラッシュ");
	        }

	        // スリーカードの判定

	        // 他にも役はいっぱいあるよ～～～！


	    }

	}


