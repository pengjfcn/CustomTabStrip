package com.github.sample;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.library.OkTabIndicator;

public class TriangleActivity
        extends AppCompatActivity
{

    private static final String TAG = "LineActivity";

    private String[] mDatas = new String[]{"奥巴马",
            "普京",
            "小鱼儿",
            "我是一只小小鸟",
            "飞呀",
            "飞到花丛中",
            "熊出没之熊大快跑",
            "喜欢你",
            "自由飞翔",
            "鸟叔"};
    private OkTabIndicator    mIndicator;
    private ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle);

        mPager = (ViewPager) findViewById(R.id.pager);
        mIndicator = (OkTabIndicator) findViewById(R.id.indicator);


        //设置adapter
        mPager.setAdapter(new MainPagerAdapter());

        //设置viewpager
        mIndicator.setViewPager(mPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_triangle, menu);

        MenuItem triangleMatchItem = menu.findItem(R.id.triangle_action_style_fill);
        MenuItem triangleWrapItem  = menu.findItem(R.id.triangle_action_style_stroke);
        int      triangleStyle     = mIndicator.getTriangleStyle();
        switch (triangleStyle)
        {
            case OkTabIndicator.TRIANGLE_STYLE_FILL:
                triangleMatchItem.setChecked(true);
                break;
            case OkTabIndicator.TRIANGLE_STYLE_STROKE:
                triangleWrapItem.setChecked(true);
                break;
            default:
                break;
        }

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.triangle_action_style_fill:
                item.setChecked(true);
                mIndicator.setTriangleStyle(OkTabIndicator.TRIANGLE_STYLE_FILL);
                break;
            case R.id.triangle_action_style_stroke:
                item.setChecked(true);
                mIndicator.setTriangleStyle(OkTabIndicator.TRIANGLE_STYLE_STROKE);
                break;
            case R.id.triangle_action_color:
                choiceColor();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void choiceColor()
    {
        ColorDialog dialog    = new ColorDialog(this);
        int         lineColor = mIndicator.getLineColor();
        dialog.setColor(lineColor);
        dialog.setOnColorChangedListener(new ColorDialog.OnColorChangedListener()
        {
            @Override
            public void onColorChanged(int color)
            {
                mIndicator.setTriangleColor(color);
            }
        });

        dialog.show();
    }


    private class MainPagerAdapter
            extends PagerAdapter
    {

        @Override
        public int getCount()
        {
            return mDatas.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object)
        {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position)
        {
            TextView tv = new TextView(TriangleActivity.this);
            tv.setText(mDatas[position]);
            tv.setGravity(Gravity.CENTER);
            tv.setTextSize(24);
            container.addView(tv);

            return tv;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object)
        {
            container.removeView((View) object);
        }

        @Override
        public CharSequence getPageTitle(int position)
        {
            return mDatas[position];
        }
    }


}
