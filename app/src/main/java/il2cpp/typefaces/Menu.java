package il2cpp.typefaces;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import il2cpp.Utils;
import java.util.ArrayList;

class ColorList {
  public static int get_colorWhite() {
    return Color.parseColor("#91000000");
  }

  public static int get_colorLeft() {
    return Color.parseColor("#91000000");
  }

  public static int get_colorBlue() {
    return Color.parseColor("#91000000");
  }

  public static int get_colorBlack() {
    return Color.parseColor("#91000000");
  }

  public static int get_colorGray() {
    return Color.parseColor("#91000000");
  }

  public static int get_colorHeader() {
    return Color.parseColor("#91000000");
  }

  public static int colorMain() {
    return Color.parseColor("#101010");
  }

  public static int colorHeader() {
    return Color.parseColor("#9E000000");
  }

  public static int colorBody() {
    return Color.parseColor("#141414");
  }

  public static int colorGrayLight() {
    return Color.parseColor("#462c50");
  }

  public static int colorOrange() {
    return Color.parseColor("#CE04F2");
  }

  public static int colorRad() {
    return Color.parseColor("#ff0000");
  }

  public static int colorBLACKPON() {
    return Color.parseColor("#000000");
  }

  public static int colorBlue() {
    return Color.parseColor("#001aff");
  }

  public static int colorGreen() {
    return Color.parseColor("#04ff00");
  }
}

public class Menu {

  protected int WIDTH, HEIGHT;

  public Typeface google(Context yes) {
    return Typeface.createFromAsset(yes.getAssets(), "Font.ttf");
  }

  protected Context context;
  protected FrameLayout _parentBox;
  ImageView _icon;
  protected ScrollView __scroll;
  protected LinearLayout __page;

  public ArrayList<LinearLayout> __pages = new ArrayList<>();

  boolean _isShow = false;

  public LinearLayout menulayout, l1, scrl, l2, pgs;
  public TextView text;

  public LinearLayout neon;

  protected WindowManager wmManager;
  protected WindowManager.LayoutParams wmParams;

  protected void init(Context context) {

    this.context = context;

    _parentBox = new FrameLayout(context);

    _parentBox.setOnTouchListener(handleMotionTouch);
    wmManager = ((Activity) context).getWindowManager();
    int aditionalFlags = 0;
    if (Build.VERSION.SDK_INT >= 11) aditionalFlags = WindowManager.LayoutParams.FLAG_SPLIT_TOUCH;
    if (Build.VERSION.SDK_INT >= 3)
      aditionalFlags = aditionalFlags | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM;
    wmParams =
        new WindowManager.LayoutParams(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT,
            0, // initialX
            0, // initialy
            WindowManager.LayoutParams.TYPE_APPLICATION,
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                | WindowManager.LayoutParams.FLAG_LAYOUT_IN_OVERSCAN
                | WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
                | WindowManager.LayoutParams.FLAG_FULLSCREEN
                | aditionalFlags,
            PixelFormat.TRANSPARENT);
    wmParams.gravity = Gravity.CENTER; //
  }

  public int dpi(float dp) {
    float scale = context.getResources().getDisplayMetrics().density;
    return (int) (dp * scale + 0.5f);
  }

  public void showMenu() {
    _isShow = true;
    _parentBox.removeAllViews();
    _parentBox.addView(menulayout);
  }

  public void hideMenu() {
    _isShow = false;
    new Handler()
        .postDelayed(
            new Runnable() {
              public void run() {
                _parentBox.removeAllViews();
                _parentBox.addView(_icon, dpi(50), dpi(50));
              }
            },
            0);
  }

  public Menu(Context context) {
    init(context);

    _icon = new ImageView(context);
    {
      Utils.SetAssets(context, _icon, "icon.png");
    }

    menulayout = new LinearLayout(context);
    {
      menulayout.setOrientation(LinearLayout.VERTICAL);
      menulayout.setPadding(15, 15, 15, 15);
      menulayout.setGravity(51);

      GradientDrawable design = new GradientDrawable();
      design.setColor(Color.parseColor("#000000"));
      design.setCornerRadius(10f);
      design.setStroke(0, -16777216);
      menulayout.setBackgroundDrawable(design);

      LayoutParams lp = new LayoutParams(dpi(450), dpi(350), 0);
      lp.leftMargin = 0;
      lp.topMargin = 0;
      lp.rightMargin = 0;
      lp.bottomMargin = 0;
      menulayout.setLayoutParams(lp);
    }

    l1 = new LinearLayout(context);
    {
      l1.setOrientation(LinearLayout.HORIZONTAL);
      l1.setPadding(0, 0, 0, 0);
      l1.setGravity(17);

      GradientDrawable design = new GradientDrawable();
      design.setColor(-15658735);
      design.setCornerRadius(10f);
      design.setStroke(0, -16777216);
      l1.setBackgroundDrawable(design);

      LayoutParams lp = new LayoutParams(-1, dpi(28), 0);
      lp.leftMargin = 0;
      lp.topMargin = 0;
      lp.rightMargin = 0;
      lp.bottomMargin = 15;
      l1.setLayoutParams(lp);
    }
    menulayout.addView(l1);

    text = new TextView(context);
    {
      text.setText("SFG2 | 4.21 | 32bit | ImGui | Modder by tojik_proof_93");
      text.setTextColor(Color.parseColor("#00ffff"));
      text.setShadowLayer(7, 0, 0, Color.parseColor("#00ffff"));
      text.setTextSize(13.0f);
      text.setTypeface(Utils.font(context));
      text.setOnClickListener(
          new OnClickListener() {
            @Override
            public void onClick(View p1) {
              hideMenu();
            }
          });
    }
    l1.addView(text);

    scrl = new LinearLayout(context);
    {
      scrl.setOrientation(LinearLayout.VERTICAL);
      scrl.setPadding(0, 0, 0, 0);
      scrl.setGravity(51);

      GradientDrawable design = new GradientDrawable();
      design.setColor(0);
      design.setCornerRadius(10f);
      design.setStroke(0, -16777216);
      scrl.setBackgroundDrawable(design);

      LayoutParams lp = new LayoutParams(-1, -1, 1);
      lp.leftMargin = 0;
      lp.topMargin = 0;
      lp.rightMargin = 0;
      lp.bottomMargin = 15;
      scrl.setLayoutParams(lp);
    }
    menulayout.addView(scrl);

    l2 = new LinearLayout(context);
    {
      l2.setOrientation(LinearLayout.HORIZONTAL);
      l2.setPadding(0, 0, 0, 0);
      l2.setGravity(17);

      GradientDrawable design = new GradientDrawable();
      design.setColor(-15658735);
      design.setCornerRadius(10f);
      design.setStroke(0, -16777216);
      l2.setBackgroundDrawable(design);

      LayoutParams lp = new LayoutParams(-1, dpi(28), 0);
      lp.leftMargin = 0;
      lp.topMargin = 0;
      lp.rightMargin = 0;
      lp.bottomMargin = 0;
      l2.setLayoutParams(lp);
    }
    menulayout.addView(l2);

    text = new TextView(context);
    {
      text.setText("t.me/tojik_proof_93");
      text.setTextColor(Color.parseColor("#00ffff"));
      text.setShadowLayer(7, 0, 0, Color.parseColor("#00ffff"));
      text.setTextSize(13.0f);
      text.setTypeface(Utils.font(context));
      text.setOnClickListener(
          new OnClickListener() {
            @Override
            public void onClick(View p1) {
              hideMenu();
            }
          });
    }
    l2.addView(text);

    __scroll = new ScrollView(context);
    __scroll.setFillViewport(true);

    __page = new LinearLayout(context);
    __page.setOrientation(LinearLayout.VERTICAL);

    __scroll.addView(__page, -1, -1);
    scrl.addView(__scroll, -1, -1);

    __pages.add(__page);

    hideMenu();

    wmManager.addView(_parentBox, wmParams);
  }

  View.OnTouchListener handleMotionTouch =
      new View.OnTouchListener() {
        private float initX;
        private float initY;
        private float touchX;
        private float touchY;

        double clock = 0;

        @Override
        public boolean onTouch(View vw, MotionEvent ev) {

          switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
              initX = wmParams.x;
              initY = wmParams.y;
              touchX = ev.getRawX();
              touchY = ev.getRawY();
              clock = System.currentTimeMillis();
              break;

            case MotionEvent.ACTION_MOVE:
              wmParams.x = (int) initX + (int) (ev.getRawX() - touchX);

              wmParams.y = (int) initY + (int) (ev.getRawY() - touchY);

              wmManager.updateViewLayout(vw, wmParams);
              break;

            case MotionEvent.ACTION_UP:
              if (!_isShow && (System.currentTimeMillis() < (clock + 200))) {
                showMenu();
              }
              break;
          }
          return true;
        }
      };
}
