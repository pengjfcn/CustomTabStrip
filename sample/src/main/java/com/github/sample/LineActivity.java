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

public class LineActivity
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
    private OkTabIndicator mIndicator;
    private ViewPager      mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line);

        mPager = (ViewPager) findViewById(R.id.pager);
        mIndicator = (OkTabIndicator) findViewById(R.id.indicator);


        //设置adapter
        mPager.setAdapter(new MainPagerAdapter());

        //设置viewpager
        mIndicator.setViewPager(mPager);

        //设置Viewpager滑动监听监听(注意)
        mIndicator.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
            {

            }

            @Override
            public void onPageSelected(int position)
            {

            }

            @Override
            public void onPageScrollStateChanged(int state)
            {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_line, menu);

        MenuItem lineMatchItem = menu.findItem(R.id.line_action_style_match);
        MenuItem lineWrapItem  = menu.findItem(R.id.line_action_style_wrap);
        int      lineStyle     = mIndicator.getLineStyle();
        switch (lineStyle)
        {
            case OkTabIndicator.LINE_STYLE_MATCH:
                lineMatchItem.setChecked(true);
                break;
            case OkTabIndicator.LINE_STYLE_WRAP:
                lineWrapItem.setChecked(true);
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
            case R.id.line_action_style_match:
                item.setChecked(true);
                mIndicator.setLineStyle(OkTabIndicator.LINE_STYLE_MATCH);
                break;
            case R.id.line_action_style_wrap:
                item.setChecked(true);
                mIndicator.setLineStyle(OkTabIndicator.LINE_STYLE_WRAP);
                break;
            case R.id.line_action_color:
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
                mIndicator.setLineColor(color);
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
            TextView tv = new TextView(LineActivity.this);
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
