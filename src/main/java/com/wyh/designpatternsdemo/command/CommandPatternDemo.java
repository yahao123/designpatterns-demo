package com.wyh.designpatternsdemo.command;

/**
 * 命令模式
 *
 * @author ：WangYaHao
 * @date ：Created in 2021/10/13 4:32 下午
 */
public class CommandPatternDemo {

    /**
     * 整个main方法是下达命令的人员
     *
     * @param args
     */
    public static void main(String[] args) {
        // 接收命令角色
        AudioPlayer audioPlayer = new AudioPlayer();
        // keypad 是执行者 keypad内部的Command是命令的实现, 数据执行具体命令的角色
        Keypad keypad = new Keypad(audioPlayer);
        keypad.player();
        keypad.rewind();
        keypad.stop();
    }


    public static class AudioPlayer {

        public void play() {
            System.out.println("开始播放");
        }

        public void rewind() {
            System.out.println("倒带");
        }

        public void stop() {
            System.out.println("停止播放");
        }
    }

    public interface Command {
        public void execute();
    }

    public static class PlayCommand implements Command {

        private AudioPlayer audioPlayer;

        public PlayCommand(AudioPlayer audioPlayer) {
            this.audioPlayer = audioPlayer;
        }

        @Override
        public void execute() {
            audioPlayer.play();
        }
    }

    public static class RewindCommand implements Command {
        private AudioPlayer audioPlayer;

        public RewindCommand(AudioPlayer audioPlayer) {
            this.audioPlayer = audioPlayer;
        }

        @Override
        public void execute() {
            audioPlayer.rewind();
        }
    }

    public static class StopCommand implements Command {

        private AudioPlayer audioPlayer;

        public StopCommand(AudioPlayer audioPlayer) {
            this.audioPlayer = audioPlayer;
        }

        @Override
        public void execute() {
            audioPlayer.stop();
        }
    }

    public static class Keypad {

        public Keypad(AudioPlayer audioPlayer) {
            this.audioPlayer = audioPlayer;
        }

        private AudioPlayer audioPlayer;

        private Command command;


        public void player() {
            command = new PlayCommand(audioPlayer);
            command.execute();
        }

        public void rewind() {
            command = new RewindCommand(audioPlayer);
            command.execute();
        }

        public void stop() {
            command = new StopCommand(audioPlayer);
            command.execute();
        }

    }
}
