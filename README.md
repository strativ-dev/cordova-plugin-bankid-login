<h1 align="center">Cordova plugin for Bankid login</h1>

Last version 1.0.0

# Install

> Install:

```
cordova plugin add https://github.com/strativ-dev/cordova-plugin-bankid-login.git

cordova prepare
```

> Delete:

```
cordova plugin rm cordova-plugin-bankid-login
```

_Example_

```javascript
window?.plugins?.bankidLogin(
  {
    token: token,
    redirectUrl: "null", // custom app url;
  },
  (response) => {
    console.log("bankidLogin:response", response);
  },
  (error) => {
    console.log("bankidLogin:error", error);
  }
);
```

Here `token` is Bankid `AUTO_STARTTOKEN`. If you provide `redirectUrl` Bankid app will redirect this link after authorization. If want to set custome url for any app you need to add custom URL scheme.

_You need to add this code in `*-info.plist`_

```
<key>CFBundleURLTypes</key>
<array>
  <dict>
    <key>CFBundleURLSchemes</key>
    <array>
      <string>URL_SCHEME</string>
    </array>
  </dict>
</array>
```

_Also you need to add this code in `AndroidManifest.xml` inside the `/manifest/application/activity`_

```
<intent-filter>
  <data android:scheme="URL_SCHEME"/>
  <action android:name="android.intent.action.VIEW" />
  <category android:name="android.intent.category.DEFAULT" />
  <category android:name="android.intent.category.BROWSABLE" />
</intent-filter>
```

If success, `response` contains success message.

> Note: Replace URL_SCHEME by a nice scheme you want to have your app listen to, like `mycoolapp`

## License

MIT
Copyright (c) 2023 Strativ AB
