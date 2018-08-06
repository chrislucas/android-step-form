package lib.view.stepform.views.viewpager;

import android.content.Context;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.Html;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import lib.view.stepform.R;

public class ViewPagerIndicatorWithTextDot extends LinearLayout implements IndicatorPageChangeListener {

    private static final String DOT_HTML = "\u2022";

    @ColorRes
    private static final int SELECTED_DOT = R.color.royal_blue;
    @ColorRes
    private static final int UNSELECTED_DOT = R.color.white;

    public ViewPagerIndicatorWithTextDot(Context context) {
        super(context);
        this.mContext = context;
    }

    public ViewPagerIndicatorWithTextDot(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    private Context mContext;
    private TextView[] mTextMarkers;
    private int mPages = 0;

    public void init(int mPages, int markers, int sizeOfFont) throws Exception {
        if (markers >= mPages)
            throw new Exception("Illegal Argument markes should be less than pages");
        this.mTextMarkers = new TextView[markers];
        this.mPages = mPages;
        addDotIndicator(this, markers, sizeOfFont);
    }

    private void addDotIndicator(ViewGroup rootLayout, int markers, int sizeOfFont) {
        LinearLayout linearLayout = new LinearLayout(mContext);
        LinearLayout.LayoutParams layoutParams =
                new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.setGravity(Gravity.CENTER);
        linearLayout.setBackgroundColor( ContextCompat.getColor(mContext, R.color.transparent) );
        for(int i=0; i<markers; i++) {
            TextView dot = new TextView(mContext);
            this.mTextMarkers[i] = dot;
            Spanned text;
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                text = Html.fromHtml(DOT_HTML, Html.FROM_HTML_MODE_LEGACY);
            }
            else {
                text = Html.fromHtml(DOT_HTML);
            }
            dot.setText(text);
            dot.setTextSize(sizeOfFont);
            dot.setTextColor(ContextCompat.getColor(mContext, UNSELECTED_DOT));
            linearLayout.addView(this.mTextMarkers[i]);
        }
        rootLayout.addView(linearLayout);
        setSelecteced(0);
    }

    private ViewPagerIndicatorWithTextDot setSelecteced(int position) {
        mTextMarkers[position].setTextColor(ContextCompat.getColor(mContext, SELECTED_DOT));
        return this;
    }

    private ViewPagerIndicatorWithTextDot setUnselecteced(int position) {
        mTextMarkers[position].setTextColor(ContextCompat.getColor(mContext, UNSELECTED_DOT));
        return this;
    }

    @Override
    public void selectMarker(int positionPage) {
        positionPage %= mTextMarkers.length;
        setSelecteced(positionPage);
        for(int i=0; i<mTextMarkers.length; i++) {
            if(i != positionPage)
                setUnselecteced(i);
        }
    }
}
