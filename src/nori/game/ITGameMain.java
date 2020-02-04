package nori.game;

import java.io.*;
import java.util.Properties;

import nori.helper.Audio;

public class ITGameMain {

    private String Savefilepath = "Resource/save.properties";
    private Properties prop;

    //一番最初
    public void GameTitle() {
        this.prop = new Properties();
        if (!(new File(this.Savefilepath).exists())) {
            this.Init();
        } else {
            try {
                this.GameMenu();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void GameMenu() throws IOException {

        System.out.println("***************************");
        System.out.println("|       IT用語バトル        |");
        System.out.println("***************************");

        prop.load(new FileReader(this.Savefilepath));

        this.ModeSelect();
    }


    //効果音と音楽を扱う変数
    private Audio bgm;
    private Audio se;

    private Player firstPlayer;
    private Player secondPlayer;

    //プレイするモードを選択
    public void ModeSelect() {
        //モード選択でBgm再生する
        this.bgm = new Audio("Resource/titlebgm.wav");
        this.bgm.start(true);

        System.out.println("ようこそ。 " + prop.getProperty("player_name") + "さん。\n");
        System.out.println("番号を入力してモードを選択してください(デフォルト=0)。\n\n[0] ストーリーモード\n[1] マルチプレイモード(インターネット環境必須)\n[2] 設定\n[3] おわる");
        try {
            String ModeNumber = new java.util.Scanner(System.in).nextLine();

            int mode = Integer.parseInt(ModeNumber);
            switch (mode) {
                case (0):
                    this.StoryMode();
                case (1):
                    this.MultiBattleMode();
                case (2):
                    this.GameConfigMode();
                case (3):
                    this.ExitGame();
            }
        } catch (NumberFormatException NumFormatE) {

        }
    }

    private void ExitGame() {
        System.out.println("終了します...");
        this.bgm.close();
    }

    private void GameConfigMode() {
    }

    private void MultiBattleMode() {
    }

    private void StoryMode() {

    }

    public void Save() {
        this.prop.setProperty("level", String.valueOf(this.firstPlayer.getLevel()));
        this.prop.setProperty("it_point", String.valueOf(this.firstPlayer.getIt_point()));
        this.prop.setProperty("offence_power", String.valueOf(this.firstPlayer.getOffence_power()));
        this.prop.setProperty("defence_power", String.valueOf(this.firstPlayer.getDefence_power()));
        this.prop.setProperty("hp", String.valueOf(this.firstPlayer.getHp()));
        this.prop.setProperty("wizard_point", String.valueOf(this.firstPlayer.getWp()));
        this.prop.setProperty("money", String.valueOf(this.firstPlayer.money));
    }


    //一番最初に起動した時の簡単な設定
    public void Init() {

        this.bgm = new Audio("Resource/init.wav");
        this.bgm.start(true);

        System.out.print("このゲームを始めるために、プレイヤー名として使う名前を入力してください > ");
        String player_name = new java.util.Scanner(System.in).nextLine();
        System.out.println("[ OK! ]");

        try {
            //設定を保存する
            this.prop = new Properties();
            this.prop.setProperty("player_name", player_name);
            this.prop.setProperty("level", "1");
            this.prop.setProperty("it_point", "0");
            this.prop.setProperty("offence_power", "7");
            this.prop.setProperty("defence_power", "5");
            this.prop.setProperty("hp", "40");
            this.prop.setProperty("wizard_point", "25");
            this.prop.setProperty("money", "0");

            this.prop.store(new FileWriter("Resource/save.properties"), "ユーザーデータ");
            Thread.sleep(300);

            this.GameMenu();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        } catch (IOException IOe) {
            IOe.printStackTrace();
        }
    }


}
