package kolesov93.RunnerPlayer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class MyActivity extends Activity {
    private SeekBar speedBar;
    private TextView headerText;
    private TextView summaryText;
    private Activity thisActivity;

    private int speed;
    private String songName;
    private int bpm;

    

    private void refreshText() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ваш темп: ");
        if (speed < 3) {
            sb.append("прогулочный");
        } else if (speed > 8) {
            sb.append("Усейн Болт");
        } else {
            sb.append("пробежка");
        }

        headerText.setText(sb.toString());

        sb = new StringBuilder();
        sb.append("Ваша скорость: ").append(speed).append(" м/c\n");
        sb.append("Сейчас играет: ").append(songName).append("\n");
        sb.append("Темп трека: ").append(bpm).append(" ударов в минуту\n");

        summaryText.setText(sb.toString());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        thisActivity = this;

        speedBar = (SeekBar) findViewById(R.id.speedBar);
        headerText = (TextView) findViewById(R.id.headerText);
        summaryText = (TextView) findViewById(R.id.summaryText);

        refreshText();

        speedBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int value, boolean b) {
                speed = value;
                refreshText();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
