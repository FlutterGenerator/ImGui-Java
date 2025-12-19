package il2cpp;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Handler;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.Toast;
import il2cpp.typefaces.Menu;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import il2cpp.typefaces.CheckBox;
import il2cpp.typefaces.Slider;

public class Main {
  protected static Context context;

  public int dpi(float dp) {
    float scale = context.getResources().getDisplayMetrics().density;
    return (int) (dp * scale + 0.5f);
  }

  protected FrameLayout parentBox;

  public static interface callbackCheck {
    void onClickTap(int pageid, int feature, int checked);
  }

  boolean invis = false;

  public void Changes(
      int parseInt, boolean p1, int idx, float p3, String t, int p5, int p6, int p7) {}

  public static native void Changes(int feature, int value);

  public static native String[] getFeatures();

  public static void start(final Context context) {
    Main.context = context;
    if (Build.VERSION.SDK_INT >= 23) {
      if (context.checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
              == PackageManager.PERMISSION_DENIED
          || context.checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
              == PackageManager.PERMISSION_DENIED) {
        ((Activity) context)
            .requestPermissions(
                new String[] {
                  Manifest.permission.READ_EXTERNAL_STORAGE,
                  Manifest.permission.WRITE_EXTERNAL_STORAGE
                },
                1000);
        init(context);
      } else {
        init(context);
      }
    } else {
      init(context);
    }
  }

  public static void init(final Context context) {
    Handler handler = new Handler();
    handler.postDelayed(
        new Runnable() {
          @Override
          public void run() {
            System.loadLibrary("gvraudio");

            try {
              new Main().MenuMain(context);
            } catch (Exception e) {
              Toast.makeText(context, e.toString(), Toast.LENGTH_LONG).show();
            }
          }
        },
        3000);
  }

  public final void MenuMain(final Context context) {

    Main.context = context;
    final Menu menu = new Menu(context);

    String[] ft = getFeatures();
    for (String token : ft) {
      final String[] split = token.split("_");

      if (split[0].equals("slider")) {
        Slider slider =
            new Slider(context, split[3], Integer.parseInt(split[4]), Integer.parseInt(split[5]));
        slider.callback =
            new Slider.Callback() {
              public void onChange(int value) {
                Changes(Integer.parseInt(split[2]), value);
              }
            };
        menu.__pages.get(0).addView(slider);
      }

      switch (split[0]) {
        case "switch":
          CheckBox button = new CheckBox(context);
          button.setText(split[2]);
          button.setCallback(
              new CheckBox.Callback() {
                public void onChanged(boolean check) {
                  Changes(Integer.parseInt(split[1]), check ? 1 : 0);
                }
              });
          menu.__pages.get(0).addView(button);
          break;
      }
    }
  }

  private void split(String p0) {}
}
