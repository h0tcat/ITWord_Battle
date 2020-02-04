package nori.game;

public class Player implements Character {

    //プレイヤーのステータス
    private int hp;
    private int wp;
    private short level;
    //攻撃力と防御力
    private short offence_power;
    private short defence_power;
    protected static long money; //ショップで使うためのお金を記録するための変数

    private long it_point;

    //プレイヤー名
    private final static String playerName;

    //Playerに命を吹き込む
    public Player() {

    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getWp() {
        return wp;
    }

    public void setWp(int wp) {
        this.wp = wp;
    }

    public short getLevel() {
        return level;
    }

    public void setLevel(short level) {
        this.level = level;
    }

    public short getOffence_power() {
        return offence_power;
    }

    public void setOffence_power(short offence_power) {
        this.offence_power = offence_power;
    }

    public short getDefence_power() {
        return defence_power;
    }

    public void setDefence_power(short defence_power) {
        this.defence_power = defence_power;
    }

    public long getIt_point() {
        return it_point;
    }

    public void setIt_point(long it_point) {
        this.it_point = it_point;
    }

    @Override
    public void Turn() {

    }

    @Override
    public void Talk(String message) {

    }

    @Override
    public int Attack() {
        return;
    }

    @Override
    public void Pass() {

    }

    @Override
    public void GiveUp() {

    }
}
