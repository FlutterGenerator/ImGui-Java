package il2cpp.typefaces;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import il2cpp.Utils;

public class PageButton extends LinearLayout {
  Context context;

  public static interface Callback {
    public void onClick();
  }

  public Callback callback;
  View __isopen;

  LinearLayout line;

  ImageView icon; // делаем размер

  public void show() {
    __isopen.setVisibility(View.VISIBLE);

    {
      icon.setColorFilter(-8996237);

      GradientDrawable design = new GradientDrawable();
      design.setColor(-14737372);
      design.setCornerRadius(5f);
      design.setStroke(0, -13487809);
      icon.setBackgroundDrawable(design);
    }

    this.addView(line);
  }

  public int dpi(float dp) {
    float scale = context.getResources().getDisplayMetrics().density;
    return (int) (dp * scale + 0.5f);
  }

  public void hide() {
    __isopen.setVisibility(View.GONE);

    {
      icon.setColorFilter(-12237228);

      GradientDrawable design = new GradientDrawable();
      design.setColor(-15395047);
      design.setCornerRadius(5f);
      design.setStroke(0, -13487809);
      icon.setBackgroundDrawable(design);
    }

    this.removeView(line);
  }

  public void anim() {
    Utils.anim(this, 400);
  }

  public PageButton(Context context, String __src) {
    super(context);
    this.context = context;

    {
      this.setOrientation(LinearLayout.VERTICAL);
      this.setPadding(0, 0, 0, 0);
      this.setGravity(17);

      GradientDrawable design = new GradientDrawable();
      design.setColor(0);
      design.setCornerRadii(new float[] {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f});
      design.setStroke(0, -13487809);
      this.setBackgroundDrawable(design);

      LayoutParams lp = new LayoutParams(dpi(45), -1, 0);
      lp.leftMargin = 0;
      lp.topMargin = 0;
      lp.rightMargin = 0;
      lp.bottomMargin = 0;
      this.setLayoutParams(lp);
    }

    icon = new ImageView(context);
    {
      Utils.SetAssets(context, icon, "icon.png");
      icon.setColorFilter(-12237228);

      GradientDrawable design = new GradientDrawable();
      design.setColor(-15395047);
      design.setCornerRadius(5f);
      design.setStroke(0, -13487809);
      icon.setBackgroundDrawable(design);

      LayoutParams lp = new LayoutParams(-1, -1, 1);
      lp.leftMargin = 5;
      lp.topMargin = 0;
      lp.rightMargin = 5;
      lp.bottomMargin = 10;
      icon.setLayoutParams(lp);
    }
    this.addView(icon);

    line = new LinearLayout(context);
    {
      line.setOrientation(LinearLayout.VERTICAL);
      line.setPadding(0, 0, 0, 0);
      line.setGravity(51);

      GradientDrawable design = new GradientDrawable();
      design.setColor(-8996237);
      design.setCornerRadius(5f);
      design.setStroke(0, -16777216);
      line.setBackgroundDrawable(design);

      LayoutParams lp = new LayoutParams(-1, dpi(2), 0);
      lp.leftMargin = 10;
      lp.topMargin = 0;
      lp.rightMargin = 10;
      lp.bottomMargin = 0;
      line.setLayoutParams(lp);
    }

    LinearLayout _isopen = new LinearLayout(context);

    __isopen = _isopen;

    this.setOnClickListener(
        new OnClickListener() {
          public void onClick(View v) {
            anim();
            if (callback != null) callback.onClick();
          }
        });
    Utils.SetAssets(context, icon, __src);
  }
}
