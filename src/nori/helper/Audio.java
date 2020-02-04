package nori.helper;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;


//簡易音楽再生ライブラリ

public class Audio {
    private AudioInputStream audiostream;
    private Clip audioclip;

    public Audio(String audiofilepath) {

        //最初の読み込み
        try {
            this.audiostream = AudioSystem.getAudioInputStream(new File(audiofilepath));
            DataLine.Info dataline_info = new DataLine.Info(Clip.class, this.audiostream.getFormat());

            this.audioclip = (Clip) AudioSystem.getLine(dataline_info);
            this.audioclip.open(this.audiostream);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }

    }

    //音源を変更する
    public void changeAudio(String audiofilepath) {
        try {
            this.audiostream = AudioSystem.getAudioInputStream(getClass().getResource(audiofilepath));
            DataLine.Info dataline_info = new DataLine.Info(Clip.class, this.audiostream.getFormat());

            this.audioclip = (Clip) AudioSystem.getLine(dataline_info);
            this.audioclip.open(this.audiostream);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

    //再生
    public void start(boolean isloopPlay) {

        //再生位置を最初に戻してからスタート
        this.audioclip.setFramePosition(0);
        if (isloopPlay) { //ループで再生する場合
            this.audioclip.setLoopPoints(0, -1);
        }
        this.audioclip.start();
    }

    public void restart() {
        this.audioclip.start();
    }

    public void stop() {
        this.audioclip.stop();
    }

    //お片づけ
    public void close() {
        try {
            this.audioclip.stop();
            this.audioclip.close();
            this.audiostream.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
