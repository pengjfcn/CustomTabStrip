# Let's Enjoy Custom Views!
[![Language](https://img.shields.io/badge/build-AndroidStudio%202.2-orange.svg)](https://developer.android.com/studio/index.html)
[![License](https://img.shields.io/badge/author-ArcticOcean-blue.svg)](https://github.com/pengjfcn)
[![License](https://img.shields.io/badge/city-Shenzhen-green.svg)]()


`CustomViewDemo` has been rewritten in `Java`. The `Project` version can be found in: [https://github.com/pengjfcn](https://github.com/pengjfcn "pengjfcn")

![image](https://assets-cdn.github.com/images/icons/emoji/unicode/1f1e8-1f1f3.png)[中文介绍](https://github.com/pengjfcn/CustomViewDemo/blob/master/README_CN.md)

# CustomViewDemo
It depends the most popular development kit `AndroidStudio` 

# What is it
[https://developer.android.com/studio/index.html](https://developer.android.com/studio/index.html "AndroidStudio") Android Studio provides the fastest tools for building apps on every type of Android device.

World-class code editing, debugging, performance tooling, a flexible build system, and an instant build/deploy system all allow you to focus on building unique and high quality apps.

# Features
- [x] slidingmenu
- [x] spinner
- [x] sweep
- [x] switchtoggle
- [x] viewpager
- [x] youkumenu
- [ ] Error handling
- [ ] Preferences panel
- [ ] JavaScript for text handling


## slidingmenu
![image](https://raw.githubusercontent.com/cyanzhong/xTextHandler/master/GIFs/xRadix.gif)
- Hex
- Bin
- Oct
- Dec

## spinner
![image](https://raw.githubusercontent.com/cyanzhong/xTextHandler/master/GIFs/xColor.gif)
- Hex
- RGB
- Preview

## sweep
![image](https://raw.githubusercontent.com/cyanzhong/xTextHandler/master/GIFs/xSearch.gif)
- Google
- Translate
- Developer
- StackOverflow
- GitHub
- Dash
- Dictionary

## switchtoggle
![image](https://raw.githubusercontent.com/cyanzhong/xTextHandler/master/GIFs/xSearch.gif)
- Google
- Translate
- Developer
- StackOverflow
- GitHub
- Dash
- Dictionary

## youkumenu
![image](https://raw.githubusercontent.com/cyanzhong/xTextHandler/master/GIFs/xFormat.gif)
- JSON
- XML
- CSS
- SQL

Thanks to: [`vkBeautify`](https://github.com/vkiryukhin/vkBeautify)

# Usage
1. Install `AndroidStudio`
2. `sudo /usr/libexec/xpccachectl` in `ubuntu`
3. Build & Run
4. Choose `AndroidStudio` to debug
5. Select text
6. Open `Editor` menu to find extensions
7. You can set a shortcut (`Key-Binding`) for each extension
8. Maybe you will like this [Android Session](https://developer.android.com/studio/index.html)

# How to write a new Extension
### Add definition in `Plist`:
```xml
<dict>
    <key>XCSourceEditorCommandClassName</key>
    <string>aClassName</string>
    <key>XCSourceEditorCommandIdentifier</key>
    <string>test.extension</string>
    <key>XCSourceEditorCommandName</key>
    <string>Test Extension</string>
</dict>
```
### Map `handler` via `commandIdentifier` in class:
```java
// Implement your modify strategy using block (you can implement as singleton dict)
// [ "commandIdentifier": handler ]
override func handlers() -> Dictionary<String, xTextModifyHandler> {
    return [
        "test.extension": { text: String -> String in text }
    ]
}
```
### * Handle with `regex`:
```java
// Override performCommandWithInvocation like that
override func perform(with invocation: XCSourceEditorCommandInvocation, completionHandler: (NSError?) -> Void) {
    if let handler = self.handlers()[invocation.commandIdentifier] {
        xTextModifier.select(invocation: invocation, pattern: "regex", handler: handler)
    }
    completionHandler(nil)
}
```

# Tips
Since `AndroidStudio 2.2 beta (8S162m)` is totally unstable now, you may see nothing after you build & run this project :(

# Contacts
[![Weibo](https://img.shields.io/badge/weibo-%20@ArcticOcean%20-red.svg)](http://weibo.com/2676705871/)
[![Twitter](https://img.shields.io/badge/csdn-@ArcticOcean-green.svg)](http://blog.csdn.net/sky_pjf/)
[![Email](https://img.shields.io/badge/email-ArcticRiver@163.com-blue.svg)](mailto:ArcticRiver@163.com)