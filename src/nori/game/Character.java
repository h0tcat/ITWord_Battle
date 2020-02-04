package nori.game;

public interface Character {
    void Talk(String message); //ストーリーモードの会話を演出するメソッド

    //勝負をするときに必要なメソッドたち
    int Attack();

    void Turn();
    void Pass();
    void GiveUp();
}
