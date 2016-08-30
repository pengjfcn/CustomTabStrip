# Let's Enjoy!
[![Language](https://img.shields.io/badge/build-AndroidStudio%202.2-orange.svg)](https://developer.android.com/studio/index.html)
[![License](https://img.shields.io/badge/author-ArcticOcean-blue.svg)](https://github.com/pengjfcn)
[![License](https://img.shields.io/badge/city-Shenzhen-green.svg)]()


`CustomTabStrip` has been rewritten in `Java`. The `Project` version can be found in: https://github.com/pengjfcn


![image](https://assets-cdn.github.com/images/icons/emoji/unicode/1f1e8-1f1f3.png)[中文介绍](https://github.com/pengjfcn/CustomTabStrip/blob/master/README_CN.md)

# __Android OkTabIndicator__
It depends the most popular development kit `AndroidStudio` 

# What is it
[introduction](https://developer.android.com/studio/index.html "AndroidStudio") Android Studio provides the fastest tools for building apps on every type of Android device.

World-class code editing, debugging, performance tooling, a flexible build system, and an instant build/deploy system all allow you to focus on building unique and high quality apps.

_OkTabIndicator__ is an Open Source Android library.__

# Features
- [x] ok
- [x] tag
- [x] indicator
- [ ] Error handling
- [ ] Preferences panel
- [ ] JavaScript for text handling

## Usage
1. Install `AndroidStudio`
2. Build & Run
3. Choose `AndroidStudio` to debug
4. Open `Editor` menu to find extensions
5. Maybe you will like this [Android Session](https://developer.android.com/studio/index.html)
6. For a working implementation of this project see the __`sample/`__ folder.

* Include this widgets in your view. This should usually be placed adjacent to the __ViewPager__ it represents.
  
    ```
    <com.github.library.OkTabIndicator
        android:id="@+id/indicator"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        github:tiRectColor="#ff0000"
        github:tiRectRadius="15dp"
        github:tiRectStrokeColor="#0000ff"
        github:tiRectStrokeWidth="2dp"
        github:tiRectStyle="fill"
        github:tiTabMode="rect"
        />
    ```
    
* In your __onCreate__ method (or onCreateView for a fragment), bind the indicator to the __ViewPager__.
    
    ```
     //Set the pager with an adapter
     ViewPager pager = (ViewPager)findViewById(R.id.pager);
     pager.setAdapter(new TestAdapter());    
     //Bind the title indicator to the adapter
     OkTabIndicator indicator = (OkTabIndicator)findViewById(R.id.indicator);
     indicator.setViewPager(pager);
    ```

* (Optional) If you use an OnPageChangeListener with your view pager,

  > solution 1:
    ```
    indicator.setOnPageChangeListener(listener);
    ```

  > solution 2:
    ```
    indicator.addOnPageChangeListener(listener);
    ```
    
## Documentation

* __custom Attributions__
    ```xml
    <attr name="tiTabPaddingLeft" format="dimension"/>
    <attr name="tiTabPaddingRight" format="dimension"/>
    <attr name="tiTabPaddingTop" format="dimension"/>
    <attr name="tiTabPaddingBottom" format="dimension"/>

    <attr name="tiTabBackground" format="reference"/>
    <attr name="tiTabTextColor" format="reference|color"/>
    <attr name="tiTabTextSize" format="dimension"/>
    <attr name="tiTabTextBlod" format="boolean"/>

    <attr name="tiUnderLineHeight" format="dimension"/>
    <attr name="tiUnderLineColor" format="color"/>

    <!-- tab indicator mode -->
    <attr name="tiTabMode" format="enum">
        <enum name="line" value="0"/>
        <enum name="triangle" value="1"/>
        <enum name="rect" value="2"/>
    </attr>

    <!-- line mode attrs -->
    <attr name="tiLineHeight" format="dimension"/>
    <attr name="tiLineColor" format="color"/>
    <attr name="tiLineStyle" format="enum">
        <enum name="match" value="0"/>
        <enum name="wrap" value="1"/>
    </attr>

    <!-- triangle mode attrs -->
    <attr name="tiTriangleHeight" format="dimension"/>
    <attr name="tiTriangleWidth" format="dimension"/>
    <attr name="tiTriangleColor" format="color"/>
    <attr name="tiTriangleStyle" format="enum">
        <enum name="fill" value="0"/>
        <enum name="stroke" value="1"/>
    </attr>
    <attr name="tiTriangleStrokeWidth" format="dimension"/>

    <!-- rect mode attrs -->
    <attr name="tiRectPaddingLeft" format="dimension"/>
    <attr name="tiRectPaddingTop" format="dimension"/>
    <attr name="tiRectPaddingRight" format="dimension"/>
    <attr name="tiRectPaddingBottom" format="dimension"/>
    <attr name="tiRectColor" format="color"/>
    <attr name="tiRectRadius" format="dimension"/>
    <attr name="tiRectStyle" format="enum">
        <enum name="fill" value="0"/>
        <enum name="stroke" value="1"/>
    </attr>
    <attr name="tiRectStrokeWidth" format="dimension"/>
    <attr name="tiRectStrokeColor" format="color"/>
    ```

* __Tab Mode__
	```xml
	<!-- tab indicator mode -->
    <attr name="tiTabMode" format="enum">
        <enum name="line" value="0"/>
        <enum name="triangle" value="1"/>
        <enum name="rect" value="2"/>
    </attr>
	```
	
# Tips
Since `AndroidStudio 2.2 beta (8S162m)` is totally unstable now, you may see nothing after you build & run this project :(

# Contacts
[![Weibo](https://img.shields.io/badge/weibo-%20@ArcticOcean%20-red.svg)](http://weibo.com/2676705871/)
[![Twitter](https://img.shields.io/badge/csdn-@ArcticOcean-green.svg)](http://blog.csdn.net/sky_pjf/)
[![Email](https://img.shields.io/badge/email-ArcticRiver@163.com-blue.svg)](mailto:ArcticRiver@163.com)
