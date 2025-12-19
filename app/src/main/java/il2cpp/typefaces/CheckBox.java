package il2cpp.typefaces;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import il2cpp.Utils;
import android.animation.TypeConverter;
import android.graphics.Typeface; // 8996237

public class CheckBox extends LinearLayout {
  Context context;

  public LinearLayout checkbox, main;
  public TextView title;
  public LinearLayout expand;

  public boolean isChecked = false;
  public Callback callback;

  public static interface Callback {
    public void onChanged(boolean checked);
  }

  public void setChecked(boolean isch) {
    isChecked = isch;
    if (callback != null) callback.onChanged(isChecked);

    if (isChecked) {
      title.setTextColor(-1);
      setColor(Color.parseColor("#00ffff"));
      Utils.anim(checkbox, 200);
    } else {
      title.setTextColor(Color.GRAY);
      setColor(Color.DKGRAY);
      Utils.disanim(checkbox, 200);
      new Handler()
          .postDelayed(
              new Runnable() {
                public void run() {
                  Utils.anim(checkbox, 300);
                }
              },
              200);
    }
  }

  public void setCallback(Callback call) {
    callback = call;
  }

  public void setText(String t) {
    title.setText(t);
  }

  public void setColor(int c) {
    GradientDrawable grad = new GradientDrawable();
    grad.setColor(c);
    grad.setCornerRadius(360f);
    grad.setStroke(0, 0);

    checkbox.setBackgroundDrawable(grad);
  }

  public CheckBox(Context ctx) {
    super(ctx);
    context = ctx;

    main = new LinearLayout(context);
    {
      main.setPadding(10, 0, 10, 0);
      GradientDrawable design = new GradientDrawable();
      design.setColor(-15592942);
      design.setCornerRadius(10f);
      main.setBackgroundDrawable(design);
      LayoutParams lp = new LayoutParams(-1, -1, 1);
      lp.bottomMargin = 5;
      main.setLayoutParams(lp);
    }
    addView(main);

    setOrientation(LinearLayout.VERTICAL);

    checkbox = new LinearLayout(context);
    { // CheckBox create
      setColor(Color.DKGRAY);
      checkbox.setPadding(4, 4, 4, 4);
    }
    expand = new LinearLayout(context);
    { // Expand line
      expand.setPadding(0, 0, 0, 0);
      expand.setGravity(Gravity.CENTER | Gravity.RIGHT);

      expand.addView(checkbox, Utils.dp(ctx, 13), Utils.dp(ctx, 13));
    }

    title = new TextView(context);
    { // Checkbox text
      title.setTextSize(10f);
      title.setTypeface(Typeface.DEFAULT_BOLD);
      title.setTextColor(Color.GRAY);
      title.setGravity(Gravity.CENTER | Gravity.LEFT);
    }

    OnClickListener clck;
    { // Click lsitener
      clck =
          new OnClickListener() {
            public void onClick(View v) {
              setChecked(!isChecked);
            }
          };
      checkbox.setOnClickListener(clck);
      title.setOnClickListener(clck);
      setOnClickListener(clck);
    }

    main.addView(title, -2, -1);

    main.addView(expand, -1, -1);

    setPadding(0, 0, 0, 0);
    setGravity(17);

    setLayoutParams(new LinearLayout.LayoutParams(-1, Utils.dp(context, 26)));

    setChecked(false);
  }
}
