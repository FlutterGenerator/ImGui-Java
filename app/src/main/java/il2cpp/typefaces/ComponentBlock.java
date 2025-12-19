package il2cpp.typefaces;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import il2cpp.Utils;

public class ComponentBlock extends LinearLayout {
  Context context;

  public LinearLayout main, neon, header;
  public ScrollView scrl;
  public TextView title;

  public float corner = 1;

  public ComponentBlock(Context ctx, String name) {
    super(ctx);
    context = ctx;

    header = new LinearLayout(context);
    { // Header Layout
      GradientDrawable head = new GradientDrawable();
      head.setCornerRadius(10f);
      head.setColor(-15329511);
      header.setBackgroundDrawable(head);

      LayoutParams lp = new LayoutParams(-1, Utils.dp(context, 18), 0);
      lp.leftMargin = 0;
      lp.topMargin = 0;
      lp.rightMargin = 0;
      lp.bottomMargin = 8;
      header.setLayoutParams(lp);

      title = new TextView(context);
      { // Header title
        title.setText(name);
        title.setTextSize(9f);
        title.setTypeface(Utils.font(context));
        title.setTextColor(-1);
        title.setGravity(Gravity.CENTER);
        title.setPadding(0, 0, 0, 0);
      }

      header.addView(title, new LayoutParams(-1, -1));
    }

    setOrientation(LinearLayout.VERTICAL);

    main = new LinearLayout(context);
    main.setOrientation(LinearLayout.VERTICAL);
    { // Main content view
      GradientDrawable menu = new GradientDrawable();
      menu.setCornerRadius(10f);
      menu.setColor(-15658735);
      main.setBackgroundDrawable(menu);

      main.setPadding(0, 0, 0, 0);

      main.setMinimumHeight(Utils.dp(context, 20));
    }

    neon = new LinearLayout(context);
    {
      GradientDrawable design =
          new GradientDrawable(
              GradientDrawable.Orientation.LEFT_RIGHT,
              new int[] {Color.TRANSPARENT, -8996237, Color.TRANSPARENT});
      neon.setBackgroundDrawable(design);
      LayoutParams lp = new LayoutParams(-1, Utils.dp(context, 1), 0);
      neon.setLayoutParams(lp);
    }
    main.addView(neon);

    scrl = new ScrollView(context);
    addView(header);
    scrl.addView(main, -1, -1);
    scrl.setFillViewport(true);

    addView(scrl, new LinearLayout.LayoutParams(-1, -1));
  }
}
