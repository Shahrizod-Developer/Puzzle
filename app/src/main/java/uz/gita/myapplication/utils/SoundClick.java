package uz.gita.myapplication.utils;

import android.content.Context;
import android.media.MediaPlayer;

import uz.gita.myapplication.R;

public class SoundClick {

    public static MediaPlayer mediaPlayer = new MediaPlayer();

    public static void create(Context context) {
        mediaPlayer = MediaPlayer.create(context, R.raw.burron);
        mediaPlayer.start();
    }
}
