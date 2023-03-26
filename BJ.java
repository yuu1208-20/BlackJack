import java.util.Scanner;
import java.util.Random;
public class Game1 {
    public static void main(String[] args){
        int[] suuji = {1,2,3,4,5,6,7,8,9,10,11};
        Scanner scanner = new Scanner(System.in);
        Random ra = new Random();
        int sum1 = 0;
        int sum2 = 0;

        //自分のカード1
        int card1_1 = (int)(Math.random()*(suuji.length)) + 1;
        System.out.println("自分");
        System.out.println("最初のカード" + ":" + card1_1);
        sum1 = sum1 + card1_1;
        System.out.println();
        
        //相手のカード1
        int card2_1 = (int)(Math.random()*(suuji.length)) + 1;
        if(card2_1==card1_1){
            card2_1 = (int)(Math.random()*(suuji.length)) + 1;
        }
        System.out.println("相手");
        sum2 = sum2 + card2_1;
        System.out.println("最初のカード" + ":" + card2_1);
        System.out.println();
        
        //自分のカード2
        int card1_2 = (int)(Math.random()*(suuji.length)) + 1;
        if(card1_2==card1_1 || card1_2==card2_1){
            card1_2 = (int)(Math.random()*(suuji.length)) + 1;
        }
        System.out.println("自分");
        System.out.println("2枚目のカード" + ":" + card1_2);
        sum1 = sum1 + card1_2;
        System.out.println("現在の合計" + ":" + sum1);
        System.out.println();

        //相手のカード2
        int card2_2 = (int)(Math.random()*(suuji.length)) + 1;
        if(card2_2==card1_1 || card2_2==card2_1 || card2_2==card1_2){
            card1_2 = (int)(Math.random()*(suuji.length)) + 1;
        }
        System.out.println("相手");
        sum2 = sum2 + card2_2;
        System.out.println("2枚目のカード" + ":" + "隠す");
        System.out.println();

        //自分のターン
        System.out.println();
        int card1_3 = (int)(Math.random()*(suuji.length)) + 1;
        while(sum1 < 21){
            System.out.print("カードを引く場合は１" + "," + "引かない場合は２" + ":");
            int select = scanner.nextInt();
            System.out.println();
            
            if(select==1){
                card1_3 = (int)(Math.random()*(suuji.length)) + 1;
                if(card1_3==card1_1 || card1_3==card1_2 || card1_3==card2_1 || card1_3==card2_2){
                    card1_3 = (int)(Math.random()*(suuji.length)) + 1;
                }
                System.out.println("次のカード" + ":" + card1_3);
                sum1 += card1_3;
                    if(sum1 > 21){
                        System.out.println("バーストしました。あなたの負けです。");
                        return;
                    }
                } else if(select==2){
                    System.out.println("引かない");
                    break;
                } else {
                    System.out.println("無効な選択です。再度お試しください。");
                }
            }

        //相手のターン
        System.out.println();
        System.out.println("相手");
        while(sum2 < 17){
            int card2_3 = (int)(Math.random()*(suuji.length)) + 1;
            if(card2_3==card1_1 || card2_3==card1_2 || card2_3==card2_1 || card2_3==card2_2 || card2_3==card1_3){
                card2_3 = (int)(Math.random()*(suuji.length)) + 1;
            }
            System.out.println("次のカード" + ":" + card2_3);
            sum2 += card2_3;
            System.out.println();
        }
        if(sum2 > 21){
            System.out.println("バーストしました。あなたの勝ちです。");
            return;
        } 

        //結果
        System.out.println("自分の合計" + ":" + sum1);
        System.out.println("相手の合計" + ":" + sum2);
        if(sum1 < sum2){
            System.out.println("あなたの負けです。");
        } else if(sum2 < sum1){
            System.out.println("あなたの勝ちです。");
        } else {
            System.out.println("引き分けです。");
        }
    }
}