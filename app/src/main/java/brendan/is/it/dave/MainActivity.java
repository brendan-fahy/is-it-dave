package brendan.is.it.dave;

import android.animation.Animator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    private static final int NINETEEN_EIGHTY_SEVEN = 1987;
    private static final int MONTH_FEBRUARY = 1;
    private static final int DAY_OF_MONTH_FIFTH = 5;
    private static final Calendar DAVID_BIRTHDAY = new GregorianCalendar(NINETEEN_EIGHTY_SEVEN,
            MONTH_FEBRUARY, DAY_OF_MONTH_FIFTH);

    private TextView textView;

    private ImageView daveHead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        daveHead = (ImageView) findViewById(R.id.daveHead);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.main_activity_title);
        }

        initAnimateDave(3000);
    }

    private void initAnimateDave(long startDelay) {
        daveHead.animate()
                .alpha(1f)
                .setStartDelay(startDelay)
                .setListener(new Animator.AnimatorListener() {

                    @Override
                    public void onAnimationEnd(Animator animator) {daveHead.setAlpha(0f);

                    }

                    @Override public void onAnimationStart(Animator animator) {}
                    @Override public void onAnimationCancel(Animator animator) {}
                    @Override public void onAnimationRepeat(Animator animator) {}
                });
    }

    @Override
    protected void onResume() {
        super.onResume();

        textView.setText(isItDavesBirthday() ? R.string.yes: R.string.no);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initAnimateDave(0);
            }
        });

        initAnimateDave(3000);
    }

    private boolean isItDavesBirthday() {
        Calendar now = Calendar.getInstance();

        return now.get(Calendar.MONTH) == DAVID_BIRTHDAY.get(Calendar.MONTH)
                && now.get(Calendar.DAY_OF_MONTH) == DAVID_BIRTHDAY.get(Calendar.DAY_OF_MONTH);
    }
}
