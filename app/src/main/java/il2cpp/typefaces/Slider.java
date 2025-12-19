package il2cpp.typefaces;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import il2cpp.Utils;
import android.graphics.Typeface;

// 1 line
public class Slider extends LinearLayout {
  Context context;
  public LinearLayout topLine, bottomLine;
  public TextView title, valueText;

  public SeekBar slider;

  public int max, current, value;
  public Callback callback;
  public int mainColor = 0;

  public static interface Callback {
    public void onChange(int value);
  }

  public void setCallback(Callback call) {
    callback = call;
  }

  public void setValue(int val, String name) {
    if (val > max) val = max;
    if (val < 0) val = 0;

    value = val;
    title.setText(name + " " + Integer.toString(value));
    slider.setProgress(value);
    if (callback != null) callback.onChange(value);
  }

  public Slider(Context ctx, final String name, int max1, int current1) {
    super(ctx);
    context = ctx;

    { // Other
      max = max1;
      current = current1;
      value = current;
    }

    mainColor = Color.parseColor("#00ffff");
    setOrientation(LinearLayout.VERTICAL);

    bottomLine = new LinearLayout(context);
    { // Bottom line (Decrease, Slider, Increase)
      bottomLine.setOrientation(LinearLayout.VERTICAL);
      bottomLine.setGravity(Gravity.CENTER);
      slider = new SeekBar(context);
      { // Slider
        slider.getThumb().mutate().setAlpha(0);
        slider.setBackgroundDrawable(null);
        GradientDrawable thumbr = new GradientDrawable();
        thumbr.setColor(Color.WHITE);
        thumbr.setCornerRadius(1);
        slider.setMax(max);
        slider.setProgress(current);
        GradientDrawable thumb = new GradientDrawable();
        thumb.setColor(mainColor);
        thumb.setSize(0, 0);
        thumb.setCornerRadius(100);

        thumb.setTintMode(PorterDuff.Mode.MULTIPLY);

        slider.setThumb(thumb);

        slider.getProgressDrawable().setColorFilter(mainColor, PorterDuff.Mode.MULTIPLY);

        {
          slider.setOnSeekBarChangeListener(
              new OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar sl, int v, boolean b) {
                  setValue(v, name);
                }

                @Override
                public void onStopTrackingTouch(SeekBar sl) {}

                @Override
                public void onStartTrackingTouch(SeekBar sl) {}
              });
        }
      }

      bottomLine.setPadding(5, 0, 0, 0);

      title = new TextView(context);
      { // Title slider
        title.setText(name + " " + Integer.toString(current));
        title.setTextSize(8f);
        title.setTypeface(Typeface.DEFAULT_BOLD);
        title.setTextColor(Color.WHITE);
        title.setGravity(Gravity.CENTER);
        // title.setPadding(0,5,0,5);
      }

      bottomLine.addView(title, new LayoutParams(-1, -2));
      bottomLine.addView(slider, -1, -1);
      // bottomLine.addView(valueText, -1, -1);
    }
    GradientDrawable da = new GradientDrawable();
    da.setColor(-15592942);
    da.setCornerRadius(10f);
    setBackgroundDrawable(da);
    setPadding(5, 0, 5, 10);
    LayoutParams lp = new LayoutParams(-1, Utils.dp(ctx, 26));
    lp.bottomMargin = 5;
    setLayoutParams(lp);
    addView(bottomLine, -1, -1);
  }
}
